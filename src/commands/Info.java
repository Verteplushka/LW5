package commands;

import collectionClasses.SpaceMarine;

import java.util.LinkedList;

public class Info extends Command {
    public static void info(LinkedList<SpaceMarine> spaceMarines) {
        System.out.println("Тип: LinkedList");
        System.out.println("Дата инициализации: " + java.time.ZonedDateTime.now());
        System.out.println("Количество элементов: " + spaceMarines.size());
    }
}
