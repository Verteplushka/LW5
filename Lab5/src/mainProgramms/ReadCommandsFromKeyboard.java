package mainProgramms;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import collectionClasses.MeleeWeapon;
import collectionClasses.SpaceMarine;
import collectionClasses.Weapon;
import commands.*;

public class ReadCommandsFromKeyboard {
    public static LinkedList<SpaceMarine> readCommandsFromKeyboard(LinkedList<SpaceMarine> spaceMarines) {
        Scanner scanner = new Scanner(System.in);
        String firstPart = null;
        String line;
        try {
            while (true) {
                if (firstPart == null) {
                    System.out.println("Введите команду:");
                }
                line = scanner.next();
                try {
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
                        case "head":
                            Head.head(spaceMarines);
                            break;
                        case "add":
                            SpaceMarine addingSpaceMarine = GetSpaceMarineFromKeyboard.getSpaceMarineFromKeyboard();
                            spaceMarines = Add.add(spaceMarines, addingSpaceMarine);
                            break;
                        case "remove_greater":
                            spaceMarines = RemoveGreater.removeGreater(spaceMarines, GetSpaceMarineFromKeyboard.getSpaceMarineFromKeyboard());
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
                                        spaceMarines = UpdateIdKeyboard.update(spaceMarines, id);
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
                                        ExecuteScript.resetRecursionCounter();
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
                } catch (ReadException exception) {
                    System.out.println(exception.getMessage());
                    firstPart = null;
                } catch (DateTimeParseException exception) {
                    System.out.println("Неверное поле creationDate");
                } catch (java.lang.IndexOutOfBoundsException exception) {
                    System.out.println("В коллекции нет объекта с таким индексом");
                    firstPart = null;
                } catch (IllegalArgumentException exception) {
                    System.out.println("Неверно введено поле/команда");
                    firstPart = null;
                } catch (IOException exception) {
                    System.out.println("Ошибка работы с файлом");
                    firstPart = null;
                } catch (NullPointerException exception) {
                    System.out.println("Ошибка");
                }
            }
        } catch (NoSuchElementException exception) {
            //System.out.println("Ошибка");
        }
        return spaceMarines;
    }
}
