package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.GetSpaceMarineFromKeyboard;
import mainProgramms.ReadException;
import mainProgramms.Sort;

import java.util.LinkedList;

public class UpdateIdKeyboard extends Command {
    public static LinkedList<SpaceMarine> update(LinkedList<SpaceMarine> spaceMarines, int id) throws ReadException {

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

        SpaceMarine newSpaceMarine = GetSpaceMarineFromKeyboard.getSpaceMarineFromKeyboard();

        if (newSpaceMarine != null) {
            newSpaceMarine.setId(id);
            spaceMarines.add(newSpaceMarine);
            Sort.sort(spaceMarines);
            System.out.println("Объект успешно обновлен");
            return spaceMarines;
        } else {
            throw new ReadException("Неверно задан объект");
        }

    }
}
