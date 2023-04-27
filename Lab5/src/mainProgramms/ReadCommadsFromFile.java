package mainProgramms;

import collectionClasses.MeleeWeapon;
import collectionClasses.SpaceMarine;
import collectionClasses.Weapon;
import commands.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadCommadsFromFile {
    public static LinkedList<SpaceMarine> readCommandsFromFile(LinkedList<SpaceMarine> spaceMarines, String nameOfFile) throws IOException, ReadException {
        Path path = Paths.get(nameOfFile);
        String line;
        String firstPart = null;
        Scanner scanner = new Scanner(path);
        while (scanner.hasNext()) {
            line = scanner.next();
            switch (line) {
                case "help":
                    Help.help();
                    break;
                case "info":
                    Info.info(spaceMarines);
                    break;
                case "show":
                    Show.show(spaceMarines);
                    break;
                case "add":
                    SpaceMarine curSpaceMarine = GetSpaceMarineFromFileEnter.getSpaceMarineFromFileEnter(scanner);
                    if (curSpaceMarine != null) {
                        spaceMarines = Add.add(spaceMarines, curSpaceMarine);
                        break;
                    } else {
                        throw new ReadException("Неверно задан объект коллекции");
                    }
                case "remove_greater":
                    spaceMarines = RemoveGreater.removeGreater(spaceMarines, GetSpaceMarineFromFile.getSpaceMarineFromFile(scanner));
                    break;
                case "print_ascending":
                    PrintAscending.printAscending(spaceMarines);
                    break;
                case "save":
                    Save.save(spaceMarines);
                    break;
                case "remove_first":
                    spaceMarines = RemoveFirst.removeFirst(spaceMarines);
                    break;
                case "clear":
                    spaceMarines = Clear.clear(spaceMarines);
                    break;
                case "exit":
                    Exit.exit();
                default:
                    int id;
                    if (firstPart != null) {
                        switch (firstPart) {
                            case "update":
                                id = Integer.parseInt(line);
                                spaceMarines = UpdateIdFile.update(spaceMarines, id, scanner);
                                firstPart = null;
                                break;
                            case "remove_by_id":
                                id = Integer.parseInt(line);
                                spaceMarines = RemoveById.removeById(spaceMarines, id);
                                firstPart = null;
                                break;
                            case "execute_script":
                                String fileName = line;
                                spaceMarines = ExecuteScript.executeScript(spaceMarines, fileName);
                                firstPart = null;
                                break;
                            case "remove_all_by_weapon_type":
                                Weapon weaponType = Weapon.valueOf(line);
                                spaceMarines = RemoveAllByWeaponType.removeAllByWeaponType(spaceMarines, weaponType);
                                firstPart = null;
                                break;
                            case "count_by_melee_weapon":
                                MeleeWeapon meleeWeapon = MeleeWeapon.valueOf(line);
                                CountByMeleeWeapon.countByMeleeWeapon(spaceMarines, meleeWeapon);
                                firstPart = null;
                                break;
                        }
                    } else if (line.equals("update") | line.equals("remove_by_id") | line.equals("execute_script") | line.equals("remove_all_by_weapon_type") | line.equals("count_by_melee_weapon")) {
                        firstPart = line;
                    } else {
                        firstPart = null;
                        throw new ReadException("Неверно введена команда");
                    }
            }

        }
        return spaceMarines;
    }
}

