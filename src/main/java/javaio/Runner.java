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
    private static final String PATH_TO_TESTDIR = "src/main/resources/testdir";
    private static final String PATH_TO_TXT = "src/main/resources/folderStructure.txt";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        if (new File(path).isDirectory()) {
            System.out.println(DirectoryReader.printDirectoryTree(new File(path)));
        } else {
            createDirectoryStructureFromFile(PATH_TO_TESTDIR, path);
            System.out.println(DirectoryReader.printDirectoryTree(new File(PATH_TO_TESTDIR)));
           var numberOfFolders =  Files.walk(Paths.get(PATH_TO_TESTDIR + "/Amon Amarth"))
                    .map(Path::toFile)
                    .filter(File::isDirectory)
                    .count();

           var numberOfFiles =  Files.walk(Paths.get(PATH_TO_TESTDIR + "/Amon Amarth"))
                    .map(Path::toFile)
                    .filter(File::isDirectory)
                   .map(e-> Arrays.stream(e.listFiles()).collect(Collectors.toList()))
                   .flatMap(Collection::stream)
                   .filter(e -> !e.isDirectory())
                   .count();


            System.out.println(numberOfFolders);
            System.out.println(numberOfFiles);
        }
    }
}
