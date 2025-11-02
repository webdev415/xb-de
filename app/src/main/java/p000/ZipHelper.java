package p000;

import android.os.Build;
import android.util.Log;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public abstract class ZipHelper {

    /**
     * Ensures the directory path ends with a '/' and exists.
     */
    public static String ensureDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) dir.mkdirs();
        return dirPath.endsWith("/") ? dirPath : dirPath + '/';
    }

    /**
     * Creates parent directories for the given relative path inside the base directory.
     */
    public static void createParentDirs(String relativePath, String baseDir) {
        String[] parts = relativePath.split("/");
        if (parts.length <= 1) return;

        for (int i = 0; i < parts.length - 1; i++) {
            baseDir += parts[i] + "/";
            File dir = new File(baseDir);
            if (!dir.exists()) dir.mkdirs();
        }
    }

    /**
     * Recursively adds files/directories to the ZipOutputStream.
     */
    public static void zipFile(ZipOutputStream zipOut, File file, String baseDir) throws IOException {
        if (file.isDirectory()) {
            Log.i("ZipHelper", "Directory: " + file.getName() + ", BaseDir: " + baseDir);
            for (File child : file.listFiles()) {
                if (child != null) {
                    String newBaseDir = file.getName() + File.separator;
                    zipFile(zipOut, child, file.isDirectory() ? newBaseDir : baseDir);
                }
            }
            return;
        }

        Log.i("ZipHelper", "File: " + file.getName() + ", BaseDir: " + baseDir);
        byte[] buffer = new byte[2048];
        String entryName = baseDir + file.getName();
        ZipEntry zipEntry = new ZipEntry(entryName);

        // Preserve last modified time for SDK >= 26
        if (Build.VERSION.SDK_INT >= 26) {
            BasicFileAttributes attrs = Files.readAttributes(
                    Paths.get(file.getAbsolutePath()),
                    (Class<BasicFileAttributes>) BasicFileAttributes.class,
                    new LinkOption[0]
            );
            zipEntry.setTime(attrs.lastModifiedTime().toMillis());
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            zipOut.putNextEntry(zipEntry);
            int read;
            while ((read = bis.read(buffer)) != -1) {
                zipOut.write(buffer, 0, read);
            }
        }
    }

    /**
     * Extracts a zip file into a target directory.
     */
    public static boolean unzip(String targetDir, String zipFilePath) {
        targetDir = ensureDir(targetDir);
        boolean success = false;

        try (java.util.zip.ZipInputStream zipIn = new java.util.zip.ZipInputStream(
                new BufferedInputStream(new FileInputStream(zipFilePath)))) {

            byte[] buffer = new byte[2048];
            java.util.zip.ZipEntry entry;

            while ((entry = zipIn.getNextEntry()) != null) {
                String entryName = entry.getName();
                createParentDirs(entryName, targetDir);

                if (entry.isDirectory()) {
                    File dir = new File(targetDir + entryName);
                    if (!dir.getCanonicalPath().startsWith(targetDir)) continue;
                    dir.mkdirs();
                    continue;
                }

                try (BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream(targetDir + entryName))) {
                    int read;
                    while ((read = zipIn.read(buffer)) != -1) {
                        bos.write(buffer, 0, read);
                    }
                    bos.flush();
                }
            }
            success = true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return success;
    }

    /**
     * Compresses multiple files into a single zip file.
     */
    public static boolean zipFiles(File[] files, String zipFilePath) {
        if (files == null) throw new NullPointerException("files == null");

        boolean success = false;

        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFilePath)))) {
            for (File file : files) {
                if (file != null && file.exists()) {
                    zipFile(zipOut, file, file.isDirectory() ? file.getName() + File.separator : "");
                }
            }
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ZipHelper", "zip file failed: " + e.getMessage());
        }

        return success;
    }
}
