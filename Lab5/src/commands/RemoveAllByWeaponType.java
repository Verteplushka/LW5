package commands;

import collectionClasses.SpaceMarine;
import collectionClasses.Weapon;

import java.util.LinkedList;

public class RemoveAllByWeaponType extends Command {
    public static LinkedList<SpaceMarine> removeAllByWeaponType(LinkedList<SpaceMarine> spaceMarines, Weapon comparableWeaponType) {
        int count = 0;
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            if (curSpaceMarine.getWeaponType() == comparableWeaponType) {
                spaceMarines.remove(curSpaceMarine);
                count++;
            }
        }
        System.out.println("Успешно удалено объектов: " + count);
        return spaceMarines;
    }
}
