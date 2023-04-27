package commands;

import collectionClasses.SpaceMarine;

import java.util.LinkedList;

public class Head extends Command {
    public static void head(LinkedList<SpaceMarine> spaceMarines) {
        System.out.println(spaceMarines.getFirst());
    }
}
