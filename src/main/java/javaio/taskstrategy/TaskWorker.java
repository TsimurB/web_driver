package javaio.taskstrategy;

public interface TaskWorker {

    int countFolders();
    int countFiles();
    double countAverageFilesInFolder();
    double countAverageFileNameLength();
}
