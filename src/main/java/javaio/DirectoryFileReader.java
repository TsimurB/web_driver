package javaio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static javaio.DirectoryReader.*;

public class DirectoryFileReader {

    private static boolean isFolder(String line) {
        return line.startsWith(FOLDER_SEPARATOR_PATTERN) || line.startsWith(ROOT_FOLDER);
    }

    public static void createDirectoryStructureFromFile(String rootToWriteTo, String pathToFile) throws IOException {
        try {
            File file = new File(pathToFile);
            Scanner myReader = new Scanner(file);

            String lastFolder = "";

            String root = rootToWriteTo + "/" + myReader.nextLine() + "/";

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                StringBuilder sb = new StringBuilder();

                if (!data.equals(ROOT_FOLDER) && isFolder(data)) {
                    lastFolder = sb.append(data).toString().replace(FOLDER_SEPARATOR_PATTERN, "");
                    new File(root + lastFolder).mkdirs();
                } else if (!isFolder(data)) {
                    sb.append(root + lastFolder);
                    sb.append(File.separator);
                    sb.append(data);
                    new File(sb.toString().replace(FILE_SEPARATOR_PATTERN, "")).createNewFile();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
