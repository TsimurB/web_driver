package javaio.taskstrategy;

import javaio.taskstrategy.TaskWorker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static javaio.DirectoryReader.FILE_SEPARATOR_PATTERN;
import static javaio.DirectoryReader.FOLDER_SEPARATOR_PATTERN;

public class TxtParserTaskWorker implements TaskWorker {

    public final String pathToTxt;
    private static final String ROOT_FOLDER = "Amon Amarth";

    public TxtParserTaskWorker(String pathToTxt) {
        this.pathToTxt = pathToTxt;
    }

    @Override
    public int countFolders() {
        int countOfFolders = 0;
        try (Scanner scanner = new Scanner(new File(pathToTxt))) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (isFolder(data)) {
                    countOfFolders++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countOfFolders;
    }

    @Override
    public int countFiles() {
        int countOfFiles = 0;
        try (Scanner scanner = new Scanner(new File(pathToTxt))) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (!isFolder(data) && !data.equals(ROOT_FOLDER)) {
                    countOfFiles++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countOfFiles;
    }

    @Override
    public double countAverageFilesInFolder() {
        int countOfFiles = 0;
        try (Scanner scanner = new Scanner(new File(pathToTxt))) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (!isFolder(data)) {
                    countOfFiles++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countOfFiles / countFolders();
    }

    @Override
    public double countAverageFileNameLength() {
        List<String> listFiles = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathToTxt))) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (!isFolder(data) && !data.equals(ROOT_FOLDER)) {
                    listFiles.add(data);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return formatFileNames(listFiles).stream()
                .mapToInt(fileName -> fileName.length())
                .average()
                .getAsDouble();
    }

    private List<String> formatFileNames(List<String> rawFiles) {
        return rawFiles.stream()
                .map(rawName -> rawName.replace(FILE_SEPARATOR_PATTERN, ""))
                .collect(Collectors.toList());
    }

    private boolean isFolder(String string) {
        return string.startsWith(FOLDER_SEPARATOR_PATTERN);
    }
}
