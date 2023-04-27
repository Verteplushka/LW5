package commands;

import collectionClasses.SpaceMarine;
import mainProgramms.FileRights;
import mainProgramms.ReadException;

import java.io.*;
import java.util.LinkedList;

public class Save extends Command {
    public static void save(LinkedList<SpaceMarine> spaceMarines) throws IOException, ReadException {
//        if (FileRights.canWrite(System.getenv("File"))) {
//            throw new ReadException("Нет прав для записи в файл или файл не существует");
//        }
        OutputStream os = new FileOutputStream(System.getenv("File"));
        Writer out = new OutputStreamWriter(os);
        for (SpaceMarine curSpaceMarine : spaceMarines) {
            int count = 0;
            for (String curStr : curSpaceMarine.getList()) {
                out.write(curStr);
                count++;
                if (count != 12) {
                    out.write(";");
                }

            }

            out.write("\n");
        }
        out.close();
        System.out.println("Коллекция успешно записана в файл");
    }
}
