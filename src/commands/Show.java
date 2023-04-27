package commands;

import java.util.LinkedList;

import collectionClasses.SpaceMarine;

public class Show extends Command {
    public static void show(LinkedList<SpaceMarine> spaceMarines) {
        if (spaceMarines.size() == 0) {
            System.out.println("Коллекция пустая");
            return;
        }
        for (SpaceMarine spaceMarine : spaceMarines) {
            System.out.println(spaceMarine);
        }
    }
}
