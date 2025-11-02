package p000;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public abstract class NetworkUtils {

    public static final Pattern URI_SCHEME_PATTERN = Pattern.compile("(?i)((?:http|https|file|m|content|rl|ftp|tel):\\/\\/|(?:inline|data|about|magnet|javascript|x|rl|app|[0-9]{1,20}):|(?:.*:.*@))(.*)");

    public static final Pattern HTTP_URL_PATTERN = Pattern.compile("(https?)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");

    public static final Pattern FULL_URL_PATTERN = Pattern.compile("^((https?|ftp)://)?((([a-zA-Z0-9一-鿿]([a-zA-Z0-9一-鿿-]{0,61}[a-zA-Z0-9一-鿿])?\\.)+([a-zA-Z]{2,20}|[一-鿿]{2,20}))|(\\d{1,3}\\.){3}\\d{1,3}|([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4})(:\\d+)?(/[^\\s]*)?$");

    public static final Pattern SIMPLE_DOMAIN_PATTERN = Pattern.compile("[0-9a-zA-Z]+[0-9a-zA-Z\\.-]*\\.[0-9a-zA-Z]{2,4}");

    public static final Pattern FILENAME_PATTERN = Pattern.compile("filename=\"?([^\"';]*)\"?");

    public static Pattern FROM_PARAM_PATTERN = Pattern.compile("from=([a-z0-9]{1,20})");

    public static Pattern SOGOU_MOBB_PATTERN = Pattern.compile("(sogou-mobb-[a-z0-9]{1,20})");

    public static Pattern TRAFFIC_SOURCE_PATTERN = Pattern.compile("traffic_source=([A-Za-z0-9]{1,8})");

    public static Pattern SRC_PARAM_PATTERN = Pattern.compile("src=([A-Za-z0-9]{1,20})");

    public static Pattern SEARCH_QUERY_PATTERN = Pattern.compile("[?&](word=|q=|p=|keyword=|text=|wd=)([^&]*)");

    public static Pattern USERSCRIPT_AUTHOR_PATTERN = Pattern.compile("//[ \\t]{1,4}@([a-zA-Z\\-:]{1,20})[\\t ]{1,10}(.*)");

    public static final Pattern USERSCRIPT_META_PATTERN = Pattern.compile("// ==UserScript==[\\s\\S]*// ==/UserScript==");

    public static String stripHtmlTags(String input) {
        if (input == null) {
            return null;
        }

        // Remove all HTML tags
        String result = input.replaceAll("<[^>]+>", "");

        // Remove non-breaking spaces
        result = result.replace("&nbsp;", " ");

        return result.trim();
    }

    public static String sanitizeFileName(String name, String fallback, String suffix) {
        if (name == null) name = "";
        if (fallback == null) fallback = "";
        if (suffix == null) suffix = "";

        // Normalize and remove unwanted characters
        String sanitized = Normalizer.normalize(name, Normalizer.Form.NFKC)
                .replaceAll("[\\p{Cntrl}]", "")                  // control chars
                .replaceAll("[\\\\/:*?\"<>|]", "_")             // filesystem reserved
                .replaceAll("[\r\n\t]", "")                     // whitespace chars
                .replaceAll("[,;#%&{}$!`'@+=^]", "_")          // special chars
                .trim()
                .replaceAll("\\s+", "_")                        // spaces → underscore
                .replaceAll("_+", "_");                         // multiple underscores → single

        // Prevent starting with dot
        if (sanitized.startsWith(".")) {
            sanitized = sanitized.replaceFirst("^\\.+", "_");
        }

        // Use fallback or hash if empty
        if (sanitized.isEmpty()) {
            sanitized = !fallback.isEmpty() ? fallback : String.valueOf(Math.abs(name.hashCode()));
        }

        // Truncate to keep total length <= 200
        int maxLength = Math.max(1, 200 - (fallback.length() + 1 + suffix.length()));
        if (sanitized.length() > maxLength) {
            sanitized = sanitized.substring(0, maxLength);
        }

        // Combine and remove trailing dots/spaces
        String result = sanitized + "_" + fallback + suffix;
        return result.replaceAll("[ .]+$", "");
    }

    public static String getFaviconUrl(@Nullable String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }

        try {
            Uri uri = Uri.parse(url);
            String host = uri.getHost();
            if (host == null || host.isEmpty()) {
                return url;
            }
            return "http://" + host + "/favicon.png";
        } catch (Exception e) {
            e.printStackTrace();
            return url;
        }
    }

    public static String appendQueryParam(String url, String query) {
        if (url == null) url = "";
        if (query == null || query.isEmpty()) return url;

        char separator = url.contains("?") ? '&' : '?';
        return url + separator + query;
    }

    /**
     * Parses a Data URI string into its components: MIME type, encoding, and data.
     *
     * @param dataUri the Data URI string (e.g., "data:image/png;base64,AAA...")
     * @return a String array of length 3: [mimeType, encoding, data]
     */
    public static String[] parseDataUri(String dataUri) {
        String[] result = new String[3]; // [mimeType, encoding, data]

        if (dataUri == null || !dataUri.startsWith("data:")) {
            return result;
        }

        int commaIndex = dataUri.indexOf(',');
        if (commaIndex < 0) {
            return result; // invalid Data URI
        }

        int semicolonIndex = dataUri.indexOf(';');
        if (semicolonIndex > 0 && semicolonIndex < commaIndex) {
            result[0] = dataUri.substring(5, semicolonIndex); // MIME type
            result[1] = dataUri.substring(semicolonIndex + 1, commaIndex); // encoding (e.g., base64)
            result[2] = dataUri.substring(commaIndex + 1); // actual data
        } else {
            result[0] = dataUri.substring(5, commaIndex); // MIME type
            result[1] = ""; // no encoding
            result[2] = dataUri.substring(commaIndex + 1); // actual data
        }

        return result;
    }

    /**
     * Extracts the first matching group from a string using the given pattern.
     *
     * @param input   the string to search
     * @param pattern the regex pattern with at least one capturing group
     * @return the first group if matched, otherwise null
     */
    public static String extractFirstGroup(@Nullable String input, @NonNull Pattern pattern) {
        if (input == null) {
            return null;
        }

        Matcher matcher = pattern.matcher(input);
        return matcher.find() ? matcher.group(1) : null;
    }

    /**
     * Extracts the filename from a Content-Disposition header.
     * <p>
     * Supports both:
     * filename*=UTF-8''encodedName
     * filename="regularName"
     *
     * @param contentDisposition the Content-Disposition header
     * @return the extracted filename, or empty string if none found
     */
    public static String extractFileName(@Nullable String contentDisposition) {
        if (contentDisposition == null || contentDisposition.isEmpty()) {
            return "";
        }

        try {
            // Try RFC 5987 style: filename*=UTF-8''...
            Pattern utf8Pattern = Pattern.compile("filename\\*=UTF-8''(.+)");
            Matcher matcher = utf8Pattern.matcher(contentDisposition);
            if (matcher.find()) {
                return matcher.group(1);
            }

            // Fallback to regular filename="..."
            Pattern regularPattern = Pattern.compile("filename=\"?([^\";]*)\"?");
            matcher = regularPattern.matcher(contentDisposition);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Extracts the first URL found in the given text.
     *
     * @param text the input text
     * @return the first URL as a CharSequence if found, otherwise returns the original text
     */
    public static CharSequence extractFirstUrl(@NonNull CharSequence text) {
        if (text.length() == 0) {
            return text;
        }

        // Regex to match HTTP/HTTPS URLs or domains
        Pattern urlPattern = Pattern.compile(
                "(https?://(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}" +
                        "|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}" +
                        "|https?://(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}" +
                        "|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,}" +
                        "|(?:[a-zA-Z0-9][a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,})",
                Pattern.CASE_INSENSITIVE
        );

        Matcher matcher = urlPattern.matcher(text);
        return matcher.find() ? matcher.group() : text;
    }

    /**
     * Extracts the value of common search query parameters from a URL.
     * Supports parameters like: word=, q=, p=, keyword=, text=, wd=
     *
     * @param url the URL string
     * @return the search query value, or null if not found
     */
    public static String extractSearchQuery(@Nullable String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }

        Matcher matcher = SEARCH_QUERY_PATTERN.matcher(url);
        return matcher.find() ? matcher.group(2) : null;
    }

    /**
     * Parses a URL query string into a map of key-value pairs.
     * <p>
     * Example: "id=123&name=John+Doe" -> {"id":"123", "name":"John Doe"}
     *
     * @param query     the query string (after '?')
     * @param resultMap the map to populate with decoded key-value pairs
     */
    public static void parseQueryString(@Nullable String query, @NonNull Map<String, String> resultMap) {
        if (query == null || query.isEmpty()) {
            return;
        }

        // Split by '&' and decode each key-value pair
        String[] pairs = query.replace('+', ' ').split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf('=');
            String key;
            String value;

            try {
                if (idx < 0) {
                    key = URLDecoder.decode(pair, StandardCharsets.UTF_8.name());
                    value = "";
                } else {
                    key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8.name());
                    value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8.name());
                }
            } catch (UnsupportedEncodingException e) {
                // Fallback to raw strings if decoding fails
                key = pair;
                value = (idx < 0) ? "" : pair.substring(idx + 1);
            }

            resultMap.put(key, value);
        }
    }

    /**
     * Extracts the first UserScript metadata block from the given text.
     * <p>
     * Example:
     * // ==UserScript==
     * // @name Example
     * // ==/UserScript==
     *
     * @param text the input text
     * @return the matched metadata block, or empty string if none found
     */
    public static String extractUserScriptMeta(@Nullable String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        Matcher matcher = USERSCRIPT_META_PATTERN.matcher(text);
        return matcher.find() ? matcher.group(0) : "";
    }

    /**
     * Extracts the author name and email from a UserScript metadata block.
     * <p>
     * Example:
     * // @author John Doe <john@example.com>
     *
     * @param text the input UserScript metadata block
     * @return a String array [name, email] if found, otherwise null
     */
    @Nullable
    public static String[] extractUserScriptAuthor(@Nullable String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }

        Matcher matcher = USERSCRIPT_AUTHOR_PATTERN.matcher(text);
        if (matcher.find()) {
            return new String[]{matcher.group(1), matcher.group(2)};
        }
        return null;
    }

    /**
     * Extracts the file extension (including the dot) from a filename or path.
     * <p>
     * Example:
     * "example.tar.gz" -> ".gz"
     *
     * @param filename the input filename or path
     * @return the file extension including the dot (e.g., ".txt"), or empty string if none
     */
    @NonNull
    public static String extractFileExtension(@NonNull String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex >= 0 && lastDotIndex < filename.length() - 1) {
            String substring = filename.substring(lastDotIndex);
            Matcher matcher = Pattern.compile("(\\.[a-zA-Z0-9]{1,8})[^a-zA-Z0-9]*").matcher(substring);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "";
    }

    /**
     * Extracts the first HTTP or HTTPS URL from the given text.
     *
     * @param text the input string
     * @return the first matched URL, or null if none found
     */
    @Nullable
    public static String extractHttpUrl(@Nullable String text) {
        if (TextUtils.isEmpty(text)) {
            return null;
        }

        Matcher matcher = HTTP_URL_PATTERN.matcher(text);
        return matcher.find() ? matcher.group(0) : null;
    }

    public static String getMimeType(@NonNull String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return "application/octet-stream";
        }

        String extension = null;
        int lastDot = filePath.lastIndexOf('.');
        if (lastDot >= 0) {
            extension = filePath.substring(lastDot + 1).toLowerCase(Locale.ROOT);
            int queryIndex = extension.indexOf('?');
            if (queryIndex > 0) {
                extension = extension.substring(0, queryIndex);
            }
        }

        if (extension == null) {
            return "application/octet-stream";
        }

        // Try Android's built-in MIME type map first
        String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        if (mime != null) {
            return mime;
        }

        // Manual fallback for uncommon or special cases
        switch (extension) {
            case "apk":
                return "application/vnd.android.package-archive";
            case "epub":
                return "application/epub+zip";
            case "torrent":
                return "application/x-bittorrent";
            case "flv":
                return "video/x-flv";
            case "m3u8":
                return "application/vnd.apple.mpegurl";
            case "m3u":
                return "audio/x-mpegurl";
            case "woff":
                return "font/woff";
            case "woff2":
                return "font/woff2";
            case "ttf":
                return "font/ttf";
            case "otf":
                return "font/otf";
            case "eot":
                return "application/vnd.ms-fontobject";
            case "svg":
                return "image/svg+xml";
            default:
                return "application/octet-stream";
        }
    }

    public static String getFileExtension(String fileName) {
        if (fileName == null) {
            return null;
        }

        fileName = fileName.trim();
        int lastDot = fileName.lastIndexOf('.');
        int firstDot = fileName.indexOf('.');

        // No dots — return as is
        if (firstDot == -1) {
            return fileName;
        }

        // Only one dot — return the fileName as is
        if (firstDot == lastDot) {
            return fileName;
        }

        // Return substring after the first dot
        return fileName.substring(firstDot + 1).trim();
    }

    public static String stripUrlSchemeAndQuery(String url) {
        if (url == null) {
            return null;
        }

        // Remove query parameters (?key=value)
        int queryIndex = url.indexOf('?');
        if (queryIndex > 0) {
            url = url.substring(0, queryIndex);
        }

        // Remove URL scheme (e.g., "https://", "ftp://")
        int schemeIndex = url.indexOf("://");
        if (schemeIndex > 0) {
            url = url.substring(schemeIndex + 3);
        }

        return url;
    }

    public static String getQueryParam(@NonNull String key, @NonNull String url) {
        if (key.isEmpty() || url.isEmpty()) {
            return null;
        }

        try {
            Uri uri = Uri.parse(url);
            String query = uri.getQuery();
            if (query == null) {
                return null;
            }

            Map<String, String> params = new HashMap<>();
            parseQueryString(query, params);

            return params.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDomainFromUrl(String url) {
        if (url == null) {
            return null;
        }

        // Remove query parameters (?key=value)
        int queryIndex = url.indexOf('?');
        if (queryIndex > 0) {
            url = url.substring(0, queryIndex);
        }

        // Remove URL scheme (e.g., "http://", "https://", "ftp://")
        int schemeIndex = url.indexOf("://");
        if (schemeIndex > 0) {
            url = url.substring(schemeIndex + 3);
        }

        // Extract domain (before first '/')
        int pathIndex = url.indexOf('/');
        if (pathIndex > 0) {
            url = url.substring(0, pathIndex);
        }

        return url;
    }

    /**
     * Creates an OkHttpClient instance that trusts all SSL certificates and hostnames.
     * WARNING: Use only for testing or internal servers. Not safe for production.
     *
     * @return OkHttpClient instance
     */
    public static OkHttpClient createUnsafeOkHttpClient() {
        try {
            // Trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Build OkHttpClient
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(3, TimeUnit.SECONDS)
                    .readTimeout(3, TimeUnit.SECONDS)
                    .writeTimeout(3, TimeUnit.SECONDS)
                    .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier((hostname, session) -> true); // accept all hostnames

            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean areBracketsBalanced(String input) {
        if (input == null) return true;

        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                default:
                    // ignore other characters
            }
        }
        return stack.isEmpty();
    }

    /**
     * Checks if all single (') and double (") quotes in a string are balanced.
     *
     * @param text the input string
     * @return true if quotes are balanced, false otherwise
     */
    public static boolean areQuotesBalanced(@NonNull String text) {
        if (text.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            if (c == '\'' || c == '\"') {
                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * Determines if the input string is likely not a URL.
     * <p>
     * Returns true if:
     * - It does not start with a known URI/protocol scheme, and
     * - It starts with common package prefixes (com., org., java.), or
     * - It ends with common file extensions, or
     * - It does not match a full URL pattern.
     *
     * @param str the input string
     * @return true if the string is likely a non-URL
     */
    public static boolean isNonUrl(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        // If it starts with a known scheme, it is a URL
        if (startsWithKnownScheme(str)) {
            return false;
        }

        // Common package prefixes
        if (str.startsWith("com.") || str.startsWith("org.") || str.startsWith("java.")) {
            return true;
        }

        // Common file extensions
        String[] extensions = {
                ".png", ".zip", ".exe", ".rar", ".jpg", ".avi", ".dat",
                ".doc", ".mp4", ".apk", ".pdf", ".mp3", ".efi"
        };
        for (String ext : extensions) {
            if (str.endsWith(ext)) {
                return true;
            }
        }

        // If it does not match a full URL pattern
        return !FULL_URL_PATTERN.matcher(str).matches();
    }

    /**
     * Checks if the input text is a valid HTTP or HTTPS URL.
     *
     * @param text the input string or CharSequence
     * @return true if it matches the HTTP/HTTPS URL pattern
     */
    public static boolean isHttpUrl(@NonNull CharSequence text) {
        return HTTP_URL_PATTERN.matcher(text).matches();
    }

    /**
     * Checks if the input string starts with a recognized URI or protocol scheme.
     * <p>
     * Supported schemes include: http, https, tel, file, about, data, content, javascript, magnet, market, etc.
     *
     * @param text the input string
     * @return true if it starts with a known scheme, false otherwise
     */
    public static boolean startsWithKnownScheme(@Nullable String text) {
        if (TextUtils.isEmpty(text)) {
            return false;
        }

        String lower = text.toLowerCase(Locale.ROOT);
        String[] schemes = {
                "http:", "https:", "tel:", "file:", "about:", "data:", "content:",
                "x:", "magnet:", "javascript:", "inline:", "market:", "filefast:", "bilibli:"
        };

        for (String scheme : schemes) {
            if (lower.startsWith(scheme)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Generates a safe file name based on a URL, a suggested name, and a MIME type.
     *
     * @param url       the source URL
     * @param suggested a suggested file name (can be null)
     * @param mimeType  MIME type (can be null)
     * @return a safe file name with max length 200 characters
     */
    @NonNull
    public static String generateFileName(@NonNull String url, @Nullable String suggested, @Nullable String mimeType) {
        String baseName = null;
        String extension = null;

        // Step 1: Use suggested name if provided
        if (!TextUtils.isEmpty(suggested)) {
            String extracted = extractFileName(suggested);
            if (extracted == null || extracted.matches(".*\\.\\w{1,8}$")) {
                baseName = null;
            } else {
                baseName = extracted;
            }
        }

        // Step 2: Try extracting from URL's last path segment
        String lastSegment = Uri.parse(url).getLastPathSegment();
        if (lastSegment != null) {
            if (baseName == null) {
                int dotIndex = lastSegment.lastIndexOf('.');
                if (dotIndex > 0) {
                    baseName = lastSegment.substring(0, dotIndex);
                    extension = extractFileExtension(lastSegment);
                } else {
                    baseName = lastSegment;
                }
            }
            if (TextUtils.isEmpty(extension) && !TextUtils.isEmpty(mimeType)) {
                extension = getExtensionFromMime(mimeType);
            }
        }

        // Step 3: Fallback to MIME type
        if (TextUtils.isEmpty(extension) && !TextUtils.isEmpty(mimeType)) {
            extension = getExtensionFromMime(mimeType);
        }

        // Step 4: Construct final file name
        String fileName;
        if (!TextUtils.isEmpty(baseName)) {
            fileName = baseName + (extension != null ? extension : "");
        } else {
            fileName = Math.abs(url.hashCode()) + (extension != null ? extension : ".bin");
        }

        // Step 5: Limit file name length to 200
        return fileName.length() > 200 ? fileName.substring(0, 200) : fileName;
    }

    public static String getExtensionFromMime(String mimeType) {
        if (mimeType == null) return "";

        mimeType = mimeType.toLowerCase(Locale.ROOT);

        if (mimeType.contains("image/png")) return ".png";
        if (mimeType.contains("image/jpeg") || mimeType.contains("image/jpg")) return ".jpg";
        if (mimeType.contains("image/webp")) return ".webp";
        if (mimeType.contains("image/gif")) return ".gif";
        if (mimeType.contains("image/svg+xml")) return ".svg";

        if (mimeType.contains("/json")) return ".json";
        if (mimeType.contains("text/html")) return ".html";
        if (mimeType.contains("text/css")) return ".css";
        if (mimeType.contains("text/plain")) return ".txt";
        if (mimeType.contains("text/xml")) return ".xml";
        if (mimeType.contains("application/xhtml+xml")) return ".xhtml";
        if (mimeType.contains("application/x-www-form-urlencoded")) return ".url";
        if (mimeType.contains("application/x-bittorrent")) return ".torrent";
        if (mimeType.contains("text/vnd.wap.wml")) return ".wml";
        if (mimeType.contains("text/javascript") || mimeType.contains("application/x-javascript"))
            return ".js";

        if (mimeType.contains("application/vnd.android.package-archive")) return ".apk";
        if (mimeType.contains("application/octet-stream")) return ".bin";
        if (mimeType.contains("application/epub+zip") ||
                mimeType.contains("application/x-epub+zip") ||
                mimeType.contains("application/vnd.epub+zip")) return ".epub";

        if (mimeType.contains("video/x-flv")) return ".flv";
        if (mimeType.contains("video/mp4")) return ".mp4";
        if (mimeType.contains("audio/mp3")) return ".mp3";
        if (mimeType.contains("video/webm")) return ".webm";
        if (mimeType.contains("application/x-mpegurl")) return ".m3u8";
        if (mimeType.contains("audio/mpeg")) return ".mp3";
        if (mimeType.contains("/mp4a")) return ".m4a";
        if (mimeType.contains("/pdf")) return ".pdf";
        if (mimeType.contains("/zip")) return ".zip";

        return "";
    }

    /**
     * Parses a data URI into [MIME type, encoding, data].
     *
     * @param dataUri the input data URI
     * @return a String array of length 3:
     * [0] = MIME type (e.g., "image/png")
     * [1] = encoding (e.g., "base64") or null if none
     * [2] = actual data portion
     */
    @NonNull
    public static String[] parseDataUriLegacy(@NonNull String dataUri) {
        String[] result = new String[3]; // [mimeType, encoding, data]

        if (!dataUri.startsWith("data:")) {
            return result;
        }

        int colonIndex = dataUri.indexOf(':'); // should be 4
        int commaIndex = dataUri.indexOf(',');

        if (colonIndex >= 0 && commaIndex > colonIndex) {
            String meta = dataUri.substring(colonIndex + 1, commaIndex);
            int semiIndex = meta.indexOf(';');

            if (semiIndex > 0) {
                result[0] = meta.substring(0, semiIndex);   // MIME type
                result[1] = meta.substring(semiIndex + 1);  // encoding
            } else {
                result[0] = meta;   // MIME type
                result[1] = null;   // no encoding
            }

            result[2] = dataUri.substring(commaIndex + 1); // actual data
        }

        return result;
    }

    /**
     * Extracts the file extension from the host part of a URL.
     *
     * @param url the input URL string
     * @return the file extension including the dot (e.g., ".com"), or empty string if none
     */
    @NonNull
    public static String getHostFileExtension(@NonNull String url) {
        String host = Uri.parse(url).getHost();
        return host != null ? getFileExtension(host) : "";
    }
}
