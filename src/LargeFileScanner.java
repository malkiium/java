import java.io.File;

public class LargeFileScanner {
    private static final long SIZE_LIMIT = 30L * 1024 * 1024 * 1024; // 50GB in bytes

    public static void main(String[] args) {
        String startPath = "C:\\"; // Change this to your starting directory
        File root = new File(startPath);
        
        if (root.exists() && root.isDirectory()) {
            scanDirectory(root);
        } else {
            System.out.println("Invalid directory: " + startPath);
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) return;
        
        for (File file : files) {
            if (file.isFile() && file.length() > SIZE_LIMIT) {
                System.out.println("Large file: " + file.getAbsolutePath() + " (" + file.length() / (1024 * 1024 * 1024) + " GB)");
            } else if (file.isDirectory()) {
                long folderSize = getFolderSize(file);
                if (folderSize > SIZE_LIMIT) {
                    System.out.println("Large folder: " + file.getAbsolutePath() + " (" + folderSize / (1024 * 1024 * 1024) + " GB)");
                    scanDirectory(file); // Recurse into the folder
                }
            }
        }
    }

    private static long getFolderSize(File folder) {
        File[] files = folder.listFiles();
        if (files == null) return 0;

        long totalSize = 0;
        for (File file : files) {
            if (file.isFile()) {
                totalSize += file.length();
            } else if (file.isDirectory()) {
                totalSize += getFolderSize(file);
            }
        }
        return totalSize;
    }
}
