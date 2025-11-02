package p000;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class FileUtils {

    public static final Pattern FILENAME_NUMBERED_PATTERN = Pattern.compile("([^/\\\\]+)_([0-9]{1,3})(\\.\\w{1,5})?$");

    public static final Map<String, String> FILE_SIGNATURES = Map.ofEntries(
            Map.entry("FFD8FFE0", "image/jpeg"),
            Map.entry("89504E47", "image/png"),
            Map.entry("47494638", "image/gif"),
            Map.entry("49492A00", "image/tif"),
            Map.entry("424D", "image/bmp"),
            Map.entry("255044462D312E", "application/pdf"),
            Map.entry("52617221", "application/x-rar-compressed"),
            Map.entry("57415645", "audio/x-wav"),
            Map.entry("41564920", "video/x-msvideo"),
            Map.entry("1F8B08", "application/x-gzip"),
            Map.entry("", "")
    );
    private static final Set<String> VIDEO_EXTENSIONS = new HashSet<>(Arrays.asList(
            ".flv", ".mp4", ".rmvb", ".rm", ".avi", ".webm", ".mov", ".3gp"
    ));

    private static final Set<String> AUDIO_EXTENSIONS = new HashSet<>(Arrays.asList(
            ".mp3", ".ogg", ".wav", ".aac", ".wma", ".m4a"
    ));

    private static final Set<String> IMAGE_EXTENSIONS = new HashSet<>(Arrays.asList(
            ".png", ".gif", ".jpg", ".jpeg", ".bmp", ".webp"
    ));

    private static final Set<String> HTML_EXTENSIONS = new HashSet<>(Arrays.asList(
            ".html", ".htm"
    ));

    private static final Set<String> TEXT_EXTENSIONS = new HashSet<>(Arrays.asList(
            ".txt", ".word", ".js", ".css"
    ));

    private static final Set<String> ARCHIVE_EXTENSIONS = new HashSet<>(Arrays.asList(
            ".zip", ".rar", ".gz"
    ));

    public static boolean writeBytesToFile(byte[] data, File file) {
        if (data == null || file == null) return false;

        // Delete existing file
        if (file.exists()) {
            file.delete();
        }

        // Ensure parent directories exist
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
            fos.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean writeBytesToFile(byte[] bArr, String path) {
        if (bArr == null || path == null) return false;
        return writeBytesToFile(bArr, new File(path));
    }

    public static void writeIntArrayToFile(int[] array, String filePath) {
        if (array == null || filePath == null) return;
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String sanitizeFileName(String input) {
        if (TextUtils.isEmpty(input)) {
            return input;
        }

        // Replace unsafe characters with underscores
        String sanitized = input.replaceAll("[ \\/*?]", "_");

        if (sanitized.isEmpty()) {
            return sanitized;
        }

        // Remove leading +, ., or - if present
        char firstChar = sanitized.charAt(0);
        if (firstChar == '+' || firstChar == '.' || firstChar == '-') {
            sanitized = sanitized.length() > 1 ? sanitized.substring(1) : "";
        }

        return sanitized;
    }

    public static void writeStringToFile(String filePath, String content) {
        writeBytesToFile(content.getBytes(StandardCharsets.UTF_8), new File(filePath));
    }

    public static String bytesToHex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    public static void ensureParentDirsExist(String filePath) {
        File file = new File(filePath);
        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
    }

    public static boolean copyFile(File source, File dest) {
        if (source.isDirectory() || dest.isDirectory()) {
            return false;
        }

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream) {
        byte[] buffer = new byte[1024];
        try (InputStream in = inputStream; OutputStream out = outputStream) {
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean copyDirectory(File sourceDir, File targetDir) {
        if (!sourceDir.isDirectory()) {
            return false;
        }

        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        File[] files = sourceDir.listFiles();
        if (files == null) {
            return false;
        }

        for (File file : files) {
            File targetFile = new File(targetDir, file.getName());
            if (file.isFile()) {
                copyFile(file, targetFile);
            } else if (file.isDirectory()) {
                copyDirectory(file, targetFile);
            }
        }
        return true;
    }

    public static Intent createViewFileIntent(Context context, String filePath) {
        File file = new File(filePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);

        // Get MIME type
        String mimeType = NetworkUtils.getMimeType(filePath);

        // Set flags and data
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setDataAndType(
                FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file),
                mimeType
        );

        return intent;
    }

    public static Intent createShareFileIntent(@NonNull Context context, @NonNull String filePath) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);

        if (!TextUtils.isEmpty(filePath)) {
            File file = new File(filePath);

            if (!file.exists()) {
                Log.w("ShareUtil", "File not found: " + filePath);
                return null;
            }

            // Determine MIME type using utility method
            String mimeType = NetworkUtils.getMimeType(filePath);
            if (mimeType == null) {
                mimeType = "*/*";
            }

            Uri uri = FileProvider.getUriForFile(
                    context,
                    context.getPackageName() + ".fileProvider",
                    file
            );

            shareIntent.setType(mimeType);
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }

        return shareIntent;
    }

    public static boolean deleteRecursively(File file) {
        if (file == null || !file.exists()) {
            return false;
        }

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteRecursively(f);
                } else {
                    f.delete();
                }
            }
        }

        return file.delete();
    }

    public static void deleteFile(String path) {
        if (path == null) return;
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    /**
     * Returns the parent path of a given path string, or empty if no '/' exists.
     */
    public static String getParentPath(String path) {
        if (path == null) return "";
        int lastSlash = path.lastIndexOf('/');
        return lastSlash >= 0 ? path.substring(0, lastSlash) : "";
    }

    /**
     * Returns the file name (last segment) of a given path string.
     */
    public static String getFileName(String path) {
        if (path == null) return "";
        int lastSlash = path.lastIndexOf('/');
        return lastSlash >= 0 ? path.substring(lastSlash + 1) : path;
    }

    /**
     * Checks if a file exists at the given path.
     */
    public static boolean fileExists(String path) {
        return path != null && new File(path).getAbsoluteFile().exists();
    }

    /**
     * Returns a type code for a given file path based on its extension.
     */
    public static int getFileType(String filePath) {
        if (TextUtils.isEmpty(filePath) || !filePath.contains(".")) return 0;

        String ext = filePath.substring(filePath.lastIndexOf(".")).toLowerCase(Locale.ROOT);

        switch (ext) {
            case ".apk":
                return 6;
            case ".mht":
                return 4;
            case ".pdf":
                return 9;
        }

        if (VIDEO_EXTENSIONS.contains(ext)) return 2;
        if (AUDIO_EXTENSIONS.contains(ext)) return 3;
        if (IMAGE_EXTENSIONS.contains(ext)) return 7;
        if (HTML_EXTENSIONS.contains(ext)) return 5;
        if (TEXT_EXTENSIONS.contains(ext)) return 8;
        if (ARCHIVE_EXTENSIONS.contains(ext)) return 10;

        return 0; // unknown type
    }

    /**
     * Returns the filename without its extension.
     * Example: "video.mp4" -> "video"
     */
    public static String getFileNameWithoutExtension(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return fileName;
        }
        int lastDot = fileName.lastIndexOf('.');
        return lastDot >= 0 ? fileName.substring(0, lastDot) : fileName;
    }

    /**
     * Moves or renames a file from sourcePath to destPath, creating parent directories if needed.
     *
     * @param sourcePath The original file path
     * @param destPath   The target file path
     * @return true if the operation succeeded, false otherwise
     */
    public static boolean moveOrRenameFile(String sourcePath, String destPath) {
        if (TextUtils.isEmpty(sourcePath) || TextUtils.isEmpty(destPath)) {
            return false;
        }

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            return false;
        }

        File parentDir = destFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                return false; // Failed to create parent directories
            }
        }

        return sourceFile.renameTo(destFile);
    }

    /**
     * Returns the size of a file in bytes.
     *
     * @param filePath The path to the file
     * @return The file size in bytes, or 0 if the path is null, empty, or the file does not exist
     */
    public static long getFileSize(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return 0L;
        }

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return 0L;
        }

        return file.length();
    }

    /**
     * Checks if the first line of a file starts with the given prefix.
     *
     * @param filePath The path to the file
     * @param prefix   The prefix string to check
     * @return true if the first line starts with the prefix, false otherwise
     * @throws IOException If an I/O error occurs
     */
    public static boolean doesFirstLineStartWith(String filePath, String prefix) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String firstLine = reader.readLine();
            return firstLine != null && firstLine.startsWith(prefix);
        }
    }

    /**
     * Returns the next available file path by incrementing a numeric suffix.
     * <p>
     * Examples:
     * "file.txt" → "file_1.txt" (if file_1.txt doesn't exist)
     * "file_1.txt" → "file_2.txt" (if file_2.txt doesn't exist)
     *
     * @param filePath Original file path
     * @return Next available file path
     */
    public static String getNextAvailableFilePath(String filePath) {
        Matcher matcher = FILENAME_NUMBERED_PATTERN.matcher(filePath);

        if (!matcher.find()) {
            String candidate = appendSuffix(filePath, "1");
            return fileExists(candidate) ? getNextAvailableFilePath(candidate) : candidate;
        }

        String baseName = matcher.group(1);
        int number = Integer.parseInt(matcher.group(2)) + 1;
        String extension = matcher.group(3) != null ? matcher.group(3) : "";

        String candidate = getParentPath(filePath) + "/" + baseName + "_" + number + extension;
        return fileExists(candidate) ? getNextAvailableFilePath(candidate) : candidate;
    }

    /**
     * Returns the MIME type based on the file signature (magic numbers).
     *
     * @param fileBytes The first few bytes of the file
     * @return The MIME type if found, otherwise null
     */
    public static String getMimeTypeFromBytes(byte[] fileBytes) {
        if (fileBytes == null || fileBytes.length == 0) {
            return null;
        }
        return FILE_SIGNATURES.get(bytesToHex(fileBytes));
    }

    /**
     * Checks if a file is likely a text file by sampling its first 100 bytes.
     *
     * @param filePath The path to the file
     * @return true if more than 90% of the sampled characters are printable, false otherwise
     * @throws IOException If an I/O error occurs
     */
    public static boolean isMostlyTextFile(String filePath) throws IOException {
        byte[] buffer = new byte[100];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            int bytesRead = bis.read(buffer, 0, buffer.length);
            if (bytesRead <= 0) return false;

            String sample = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
            int printableCount = 0;
            for (char c : sample.toCharArray()) {
                if (Character.isDefined(c) && !Character.isISOControl(c)) {
                    printableCount++;
                }
            }

            return ((double) printableCount / sample.length()) >= 0.9;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if a file is a ZIP archive by reading its magic number.
     *
     * @param file The file to check
     * @return true if the file starts with the ZIP signature (0x50 0x4B 0x03 0x04), false otherwise
     * @throws IOException If an I/O error occurs
     */
    public static boolean isZipFile(File file) throws IOException {
        if (file == null || !file.exists() || !file.isFile()) {
            return false;
        }

        byte[] signature = new byte[4];
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            if (raf.read(signature) != 4) {
                return false;
            }
            // ZIP file magic number: 0x50 0x4B 0x03 0x04
            return Arrays.equals(signature, new byte[]{0x50, 0x4B, 0x03, 0x04});
        }
    }

    /**
     * Appends a numeric suffix to a file name before the extension.
     * <p>
     * For example:
     * "file.txt" + "1" → "file_1.txt"
     * "file" + "1"     → "file_1"
     *
     * @param filePath Original file path
     * @param suffix   Numeric or string suffix to append
     * @return File path with suffix appended
     */
    public static String appendSuffix(String filePath, String suffix) {
        int lastDot = filePath.lastIndexOf(".");
        if (lastDot > 0) {
            String namePart = filePath.substring(0, lastDot);
            String extension = filePath.substring(lastDot);
            return namePart + "_" + suffix + extension;
        } else {
            return filePath + "_" + suffix;
        }
    }

    /**
     * Reads the entire contents of a file as a String, preserving line breaks.
     *
     * @param file The file to read
     * @return The file contents as a String, or null if an error occurs
     * @throws IOException If an I/O error occurs
     */
    public static String readFileToString(File file) throws IOException {
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String readFileToString(String filePath) {
        File file = new File(filePath);
        try {
            return readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] readFileToByteArray(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             ByteArrayOutputStream baos = new ByteArrayOutputStream((int) file.length())) {

            byte[] buffer = new byte[1024];
            int read;
            while ((read = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, read);
            }

            return baos.toByteArray();
        }
    }

    public static int[] readIntArrayFromFile(String filePath) {
        int[] result = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            result = (int[]) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
