package javaio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DirectoryReader {

    public static final String FOLDER_SEPARATOR_PATTERN = "    |-----";
    public static final String FILE_SEPARATOR_PATTERN = "    |       ";
    public static final String TXT_WITH_STRUCTURE_NAME = "src/main/resources/structure.txt";

    public static void writeDirectoryTreeIntoFile(File folder) throws IOException {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Not a directory, provide path to directory");
        }
        int indent = 0;
        FileWriter fileWriter = new FileWriter(TXT_WITH_STRUCTURE_NAME);
        PrintWriter pw = new PrintWriter(fileWriter);
        writeDirectoryTreeIntoFile(folder, indent, pw);
        System.out.println("FILE WITH STRUCTURE ==>: " + TXT_WITH_STRUCTURE_NAME);
        pw.close();
    }

    private static void writeDirectoryTreeIntoFile(File folder, int indent, PrintWriter pw) {
        pw.printf(getIndentString(folder, indent));
        pw.printf(folder.getName());
        pw.printf("\n");
        for (File file : Arrays.stream(folder.listFiles()).sorted().collect(Collectors.toList())) {
            if (file.isDirectory()) {
                writeDirectoryTreeIntoFile(file, indent + 1, pw);
            } else {
                writeFile(file, pw);
            }
        }
    }

    private static void writeFile(File file, PrintWriter pw) {
        pw.printf(FILE_SEPARATOR_PATTERN);
        pw.printf(file.getName());
        pw.printf("\n");
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
