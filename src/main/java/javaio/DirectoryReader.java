package javaio;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DirectoryReader {

    public static final String ROOT_FOLDER = "Amon Amarth";
    public static final String FOLDER_SEPARATOR_PATTERN = " | - - - -";
    public static final String FILE_SEPARATOR_PATTERN = " |        ";

    public static String printDirectoryTree(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Not a directory, provide path to directory");
        }
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);
        return sb.toString();
    }

    private static void printDirectoryTree(File folder, int indent, StringBuilder sb) {
        if (!folder.isHidden()) {
            sb.append(getIndentString(folder, indent));
            sb.append(folder.getName());
            sb.append("\n");
            for (File file : Arrays.stream(folder.listFiles()).sorted().collect(Collectors.toList())) {
                if (file.isDirectory()) {
                    printDirectoryTree(file, indent + 1, sb);
                } else {
                    printFile(file, sb);
                }
            }
        }
    }

    private static void printFile(File file, StringBuilder sb) {
        if (!file.isHidden()) {
            sb.append(FILE_SEPARATOR_PATTERN);
            sb.append(file.getName());
            sb.append("\n");
        }
    }

    private static String getIndentString(File file, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            if (file.isDirectory()) {
                sb.append(FOLDER_SEPARATOR_PATTERN);
            }
        }
        return sb.toString();
    }
}
