package javaio;

import javaio.taskstrategy.TaskWorker;
import javaio.taskstrategy.TxtParserTaskWorker;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//import static javaio.DirectoryFileReader.createDirectoryStructureFromFile;

public class Runner {


    private static final String DEFAULT_DIRECTORY_ROOT = "src/main/resources";
    private static final String PATH_TO_TXT = "src/main/resources/fileToParse.txt";
    private static final String PATH_TO_STRUCTURE = "src/main/resources/Amon Amarth";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        TaskWorker taskWorker;

        // creating default directories from txt
        new DirectoryFromFileBuilder().parseFileAndCreateDirectories(DEFAULT_DIRECTORY_ROOT, PATH_TO_TXT);

        if (new File(path).isDirectory()) {
            DirectoryReader.writeDirectoryTreeIntoFile(new File(path));
        } else {
            taskWorker = new TxtParserTaskWorker(path);
            var numberOfFolders = taskWorker.countFolders();

            var numberOfFiles = taskWorker.countFiles();

            var avgNumberOfFiles = taskWorker.countAverageFilesInFolder();

            var avgFileNames = taskWorker.countAverageFileNameLength();

            System.out.println("Number of folders - " + numberOfFolders);
            System.out.println("Number of files - " + numberOfFiles);
            System.out.println("Average number of files inside folders - " + avgNumberOfFiles);
            System.out.println("Average length of file names - " + avgFileNames);

        }
    }
}
