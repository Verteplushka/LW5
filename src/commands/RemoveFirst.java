package commands;

import collectionClasses.SpaceMarine;

import java.util.LinkedList;

public class RemoveFirst extends Command {
    public static LinkedList<SpaceMarine> removeFirst(LinkedList<SpaceMarine> spaceMarines) {
        spaceMarines.removeFirst();
        System.out.println("Первый элемент коллекции успешно удален");
        return spaceMarines;
    }
}
