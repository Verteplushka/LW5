package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.Sort;

import java.util.LinkedList;

public class RemoveGreater extends Command {
    public static LinkedList<SpaceMarine> removeGreater(LinkedList<SpaceMarine> spaceMarines, SpaceMarine comparableSpaceMarine) {
        int count = 0;
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            if (comparableSpaceMarine.compareTo(curSpaceMarine) < 0) {
                spaceMarines.remove(curSpaceMarine);
                count++;
            }
        }
        Sort.sort(spaceMarines);
        System.out.println("Успешно удалено объектов: " + count);
        return spaceMarines;
    }
}
