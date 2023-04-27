package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.GetSpaceMarineFromKeyboard;
import mainProgramms.ReadException;

import java.util.LinkedList;

public class RemoveById extends Command {
    public static LinkedList<SpaceMarine> removeById(LinkedList<SpaceMarine> spaceMarines, int id) throws ReadException {
        boolean flag = false;
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            if (curSpaceMarine.getId() == id) {
                flag = true;
                spaceMarines.remove(curSpaceMarine);
                break;
            }
        }
        if (!flag) {
            throw new ReadException("В коллекции нет объекта с таким id");
        }
        System.out.println("Объект успешно удален");
        return spaceMarines;
    }
}
