package javaio.taskstrategy;

import javaio.DirectoryFromFileBuilder;
import javaio.taskstrategy.TaskWorker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static javaio.DirectoryFromFileBuilder.ROOT_FOLDER_NAME;

public class FileStructureTaskWorker implements TaskWorker {

    private static final String PATH_TO_TESTDIR = "src/main/resources";
    private static final int ROOT_FOLDER_INDEX = 1;

    public FileStructureTaskWorker(String pathToTxt) {
        DirectoryFromFileBuilder directoryFromFileBuilder = new DirectoryFromFileBuilder();
        try {
            directoryFromFileBuilder.parseFileAndCreateDirectories(PATH_TO_TESTDIR, pathToTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int countFolders() {
        try {
            return (int) Files.walk(Paths.get(PATH_TO_TESTDIR + File.separator + ROOT_FOLDER_NAME))
                    .map(Path::toFile)
                    .skip(ROOT_FOLDER_INDEX)
                    .filter(File::isDirectory)
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int countFiles() {
        try {
            return (int) Files.walk(Paths.get(PATH_TO_TESTDIR + File.separator + ROOT_FOLDER_NAME))
                    .map(Path::toFile)
                    .skip(ROOT_FOLDER_INDEX)
                    .filter(File::isDirectory)
                    .map(e -> Arrays.stream(e.listFiles()).collect(Collectors.toList()))
                    .flatMap(Collection::stream)
                    .filter(e -> !e.isDirectory())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double countAverageFilesInFolder() {
        try {
            return Files.walk(Paths.get(PATH_TO_TESTDIR + File.separator + ROOT_FOLDER_NAME))
                    .map(Path::toFile)
                    .skip(ROOT_FOLDER_INDEX)
                    .filter(File::isDirectory)
                    .mapToDouble(e -> Arrays.stream(e.listFiles()).filter(c -> !c.isDirectory()).count())
                    .average()
                    .getAsDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    @Override
    public double countAverageFileNameLength() {
        try {
            return Files.walk(Paths.get(PATH_TO_TESTDIR + File.separator + ROOT_FOLDER_NAME))
                    .map(Path::toFile)
                    .skip(ROOT_FOLDER_INDEX)
                    .filter(File::isDirectory)
                    .map(e -> Arrays.stream(e.listFiles()).collect(Collectors.toList()))
                    .flatMap(Collection::stream)
                    .filter(e -> !e.isDirectory())
                    .mapToDouble(file -> file.getName().length())
                    .average()
                    .getAsDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
