package commands;

import collectionClasses.MeleeWeapon;
import collectionClasses.SpaceMarine;
import collectionClasses.Weapon;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CountByMeleeWeapon extends Command {
    public static void countByMeleeWeapon(LinkedList<SpaceMarine> spaceMarines, MeleeWeapon comparableMeleeType) {
        int count = 0;
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            if (curSpaceMarine.getMeleeWeapon() == comparableMeleeType) {
                count++;
            }
        }
        System.out.println("Найдено объектов: " + count);
    }
}
