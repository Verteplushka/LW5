package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.GetSpaceMarineFromFile;
import mainProgramms.ReadException;
import mainProgramms.Sort;

import java.util.LinkedList;
import java.util.Scanner;

public class UpdateIdFile extends Command {
    public static LinkedList<SpaceMarine> update(LinkedList<SpaceMarine> spaceMarines, int id, Scanner scanner) throws ReadException {

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

        SpaceMarine newSpaceMarine = GetSpaceMarineFromFile.getSpaceMarineFromFile(new Scanner(scanner.next()));

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
