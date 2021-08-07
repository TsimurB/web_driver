package javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static javaio.DirectoryFileReader.createDirectoryStructureFromFile;

public class Runner {

    private static final String PATH_TO_ROOT = "src/main/resources/Amon Amarth";
    private static final int ROOT_FOLDER_INDEX = 1;
    private static final String PATH_TO_TESTDIR = "src/main/resources";
    private static final String PATH_TO_TXT = "src/main/resources/folderStructure.txt";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        if (new File(path).isDirectory()) {
            System.out.println(DirectoryReader.printDirectoryTree(new File(path)));
        } else {
            createDirectoryStructureFromFile(PATH_TO_TESTDIR, path);
            System.out.println(DirectoryReader.printDirectoryTree(new File(PATH_TO_TESTDIR + "/Amon Amarth_1")));
            var numberOfFolders = Files.walk(Paths.get(PATH_TO_TESTDIR + "/Amon Amarth_1"))
                    .map(Path::toFile)
                    .skip(ROOT_FOLDER_INDEX)
                    .filter(File::isDirectory)
                    .count();

            var numberOfFiles = Files.walk(Paths.get(PATH_TO_TESTDIR + "/Amon Amarth_1"))
                    .map(Path::toFile)
                    .skip(ROOT_FOLDER_INDEX)
                    .filter(File::isDirectory)
                    .map(e -> Arrays.stream(e.listFiles()).collect(Collectors.toList()))
                    .flatMap(Collection::stream)
                    .filter(e -> !e.isDirectory())
                    .count();

            var avgNumberOfFiles = Files.walk(Paths.get(PATH_TO_TESTDIR + "/Amon Amarth_1"))
                    .map(Path::toFile)
                    .skip(ROOT_FOLDER_INDEX)
                    .filter(File::isDirectory)
                    .mapToDouble(e -> Arrays.stream(e.listFiles()).filter(c -> !c.isDirectory()).count())
                    .average()
                    .getAsDouble();

            var avgFileNames = Files.walk(Paths.get(PATH_TO_TESTDIR + "/Amon Amarth_1"))
                    .map(Path::toFile)
                    .skip(ROOT_FOLDER_INDEX)
                    .filter(File::isDirectory)
                    .map(e -> Arrays.stream(e.listFiles()).collect(Collectors.toList()))
                    .flatMap(Collection::stream)
                    .filter(e -> !e.isDirectory())
                    .mapToDouble(file -> file.getName().length())
                    .average()
                    .getAsDouble();

            System.out.println("Number of folders - " + numberOfFolders);
            System.out.println("Number of files - " + numberOfFiles);
            System.out.println("Average number of files inside folders - " + avgNumberOfFiles);
            System.out.println("Average length of file names - " + avgFileNames);

        }
    }
}
