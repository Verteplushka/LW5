package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.FileRights;
import mainProgramms.ReadCommadsFromFile;
import mainProgramms.ReadException;

import java.io.IOException;
import java.util.LinkedList;

public class ExecuteScript extends Command {
    private static int recursionCounter = 0;

    public static LinkedList<SpaceMarine> executeScript(LinkedList<SpaceMarine> spaceMarines, String fileName) throws IOException, ReadException {
//        if (FileRights.canRead(fileName)) {
//            throw new ReadException("Нет прав для чтения файла или файл не существует");
//        }
        if (getRecursionCounter() > 10) {
            resetRecursionCounter();
            throw new ReadException("Недопустимая глубина рекурсии");
        }
        incRecursionCounter();
        spaceMarines = ReadCommadsFromFile.readCommandsFromFile(spaceMarines, fileName);
        return spaceMarines;
    }

    private static int getRecursionCounter() {
        return recursionCounter;
    }

    private static void incRecursionCounter() {
        ExecuteScript.recursionCounter++;
    }

    public static void resetRecursionCounter() {
        ExecuteScript.recursionCounter = 0;
    }
}
