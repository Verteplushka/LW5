package commands;

import collectionClasses.SpaceMarine;

import java.util.LinkedList;

public class Clear extends Command {
    public static LinkedList<SpaceMarine> clear(LinkedList<SpaceMarine> spaceMarines) {
        spaceMarines.clear();
        System.out.println("Коллекция успешно очищена");
        return spaceMarines;
    }
}
