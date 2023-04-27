package commands;

import collectionClasses.*;
import mainProgramms.ReadException;
import mainProgramms.Sort;

import java.util.LinkedList;

public class Add extends Command {
    public static LinkedList<SpaceMarine> add(LinkedList<SpaceMarine> spaceMarines, SpaceMarine newSpaceMarine) throws ReadException {
        for (SpaceMarine compSpaceMarine : spaceMarines) {
            if (newSpaceMarine.getId().equals(compSpaceMarine.getId())) {
                throw new ReadException("Объект с таким id уже есть в коллекции");
            }
        }
        spaceMarines.add(newSpaceMarine);
        Sort.sort(spaceMarines);
        System.out.println("Объект успешно добавлен");
        return spaceMarines;
    }
}
