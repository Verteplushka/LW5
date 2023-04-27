package commands;

public class Help extends Command {
    public static void help() {
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("remove_first : удалить первый элемент из коллекции");
        System.out.println("head : вывести первый элемент коллекции");
        System.out.println("remove_greater {element} : удалить из коллекции все элементы, превышающие заданный");
        System.out.println("remove_all_by_weapon_type weaponType : удалить из коллекции все элементы, значение поля weaponType которого эквивалентно заданному");
        System.out.println("count_by_melee_weapon meleeWeapon : вывести количество элементов, значение поля meleeWeapon которых равно заданному");
        System.out.println("print_ascending : вывести элементы коллекции в порядке возрастания");

    }
}
