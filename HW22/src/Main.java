import com.mathlibrary.MathLibrary;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

enum LoggingLevel {
    INFO,
    DEBUG
}

class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxSize;
    private String format;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, long maxSize, String format) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.maxSize = maxSize;
        this.format = format;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFormat() {
        return format;
    }
}

class FileLogger {
    private FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void debug(String message) {
        if (config.getLoggingLevel() == LoggingLevel.DEBUG) {
            log("[DEBUG] " + message);
        }
    }

    public void info(String message) {
        if (config.getLoggingLevel() == LoggingLevel.DEBUG || config.getLoggingLevel() == LoggingLevel.INFO) {
            log("[INFO] " + message);
        }
    }

    private void log(String message) {
        String formattedMessage = getCurrentTime() + message;
        try {
            File logFile = new File(config.getFilePath());
            long currentSize = logFile.length();
            long maxSize = config.getMaxSize();
            if (currentSize >= maxSize) {
                throw new FileMaxSizeReachedException(maxSize, currentSize, logFile.getAbsolutePath());
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(formattedMessage);
            writer.newLine();
            writer.close();
        } catch (IOException | FileMaxSizeReachedException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + now.format(formatter) + "]";
    }
}

class FileMaxSizeReachedException extends Exception {
    private long maxSize;
    private long currentSize;
    private String filePath;

    public FileMaxSizeReachedException(long maxSize, long currentSize, String filePath) {
        super("File max size reached. Max size: " + maxSize + " bytes, Current size: " + currentSize + " bytes, File: " + filePath);
        this.maxSize = maxSize;
        this.currentSize = currentSize;
        this.filePath = filePath;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public long getCurrentSize() {
        return currentSize;
    }

    public String getFilePath() {
        return filePath;
    }
}

class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String fileLine;
        String logFilePath = null;
        LoggingLevel loggingLevel = null;
        long maxSize = 0;
        String format = null;

        while ((fileLine = reader.readLine()) != null) {
            String[] parts = fileLine.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "FILE":
                        logFilePath = value;
                        break;
                    case "LEVEL":
                        loggingLevel = LoggingLevel.valueOf(value);
                        break;
                    case "MAX-SIZE":
                        maxSize = Long.parseLong(value);
                        break;
                    case "FORMAT":
                        format = value;
                        break;
                }
            }
        }

        reader.close();
        return new FileLoggerConfiguration(logFilePath, loggingLevel, maxSize, format);
    }
}
public class Main {
    public static void main(String[] args) {

        MathLibrary mathLibrary = new MathLibrary();

        double result = mathLibrary.add(2.0, 3.0);
        System.out.println("Result: " + result);


        try {
            FileLoggerConfiguration config = FileLoggerConfigurationLoader.load("config.txt");
            FileLogger logger = new FileLogger(config);
            logger.debug("Debug message");
            logger.info("Info message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mathUsage(){

    }
}