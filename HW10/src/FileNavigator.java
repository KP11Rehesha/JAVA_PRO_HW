import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> filesMap;

    public FileNavigator() {
        this.filesMap = new HashMap<>();
    }

    public void add(String path, FileData file) {
        if (!filesMap.containsKey(path)) {
            filesMap.put(path, new ArrayList<>());
        }
        filesMap.get(path).add(file);
    }

    public List<FileData> find(String path) {
        return filesMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> filteredFiles = new ArrayList<>();
        for (List<FileData> files : filesMap.values()) {
            for (FileData file : files) {
                if (file.getSize() <= maxSize) {
                    filteredFiles.add(file);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path) {
        filesMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> files : filesMap.values()) {
            allFiles.addAll(files);
        }
        Collections.sort(allFiles, Comparator.comparingLong(FileData::getSize));
        return allFiles;
    }

    // Method to check consistency while adding file
    public boolean isConsistent(String path, FileData file) {
        String key = null;
        for (String storedPath : filesMap.keySet()) {
            if (file.getPath().startsWith(storedPath)) {
                if (key == null || storedPath.length() > key.length()) {
                    key = storedPath;
                }
            }
        }
        return key != null && key.equals(path);
    }
}