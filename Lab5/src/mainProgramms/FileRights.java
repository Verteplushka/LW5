package mainProgramms;

import java.io.File;

public class FileRights {
    public static boolean canRead(String fileName) {
        File file = new File(fileName);
        if (file.canRead()) {
            return true;
        }
        return false;

    }

    public static boolean canWrite(String fileName) {
        File file = new File(fileName);
        if (file.canWrite()) {
            return true;
        }
        return false;
    }
}
