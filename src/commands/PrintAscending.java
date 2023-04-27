package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.Sort;

import java.util.LinkedList;
import java.util.Spliterator;

public class PrintAscending extends Command {
    public static void printAscending(LinkedList<SpaceMarine> spaceMarines) {
        Sort.sort(spaceMarines);
        Show.show(spaceMarines);
    }
}
