public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();


        FileData file1 = new FileData("files.txt", 100, "/path/to/file");
        FileData file2 = new FileData("firstApp.java", 200, "/path/to/file");
        FileData file3 = new FileData("example.txt", 150, "/another/path");
        FileData file4 = new FileData("image.jpg", 500, "/another/path");

        fileNavigator.add("/path/to/file", file1);
        fileNavigator.add("/path/to/file", file2);
        fileNavigator.add("/another/path", file3);
        fileNavigator.add("/another/path", file4);


        System.out.println("Files at /path/to/file: " + fileNavigator.find("/path/to/file"));
        System.out.println("Files at /another/path: " + fileNavigator.find("/another/path"));


        System.out.println("Files with size <= 200 bytes: " + fileNavigator.filterBySize(200));


        //fileNavigator.remove("/path/to/file");
    }
}