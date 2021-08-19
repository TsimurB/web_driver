package javaio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static javaio.DirectoryReader.FILE_SEPARATOR_PATTERN;
import static javaio.DirectoryReader.FOLDER_SEPARATOR_PATTERN;

public class DirectoryFromFileBuilder {

    public static final String ROOT_FOLDER_NAME = "Amon Amarth";

    public void parseFileAndCreateDirectories(String rootToWriteTo, String pathToFile) throws IOException {
        try {
            File file = new File(pathToFile);
            Scanner scanner = new Scanner(file);

            String lastFolder = "";
//            String lastFile = "";

            String root = rootToWriteTo + File.separator + scanner.nextLine() + File.separator;

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                StringBuilder sb = new StringBuilder();

                if (!data.equals(ROOT_FOLDER_NAME) && isFolder(data)) {
                    lastFolder = sb.append(data).toString().replace(FOLDER_SEPARATOR_PATTERN, "");
                    new File(root + lastFolder).mkdirs();
                } else if (!isFolder(data)) {
                    sb.append(root + lastFolder);
                    sb.append(File.separator);
                    sb.append(data);
                    new File(sb.toString().replace(FILE_SEPARATOR_PATTERN, "")).createNewFile();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFolder(String line) {
        return line.startsWith(FOLDER_SEPARATOR_PATTERN) || line.startsWith(ROOT_FOLDER_NAME);
    }
}
