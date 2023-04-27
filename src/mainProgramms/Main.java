package mainProgramms;

import collectionClasses.SpaceMarine;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        String fileName = System.getenv("File");
        LinkedList<SpaceMarine> spaceMarines = FileReader.readFile(fileName);

        spaceMarines = ReadCommandsFromKeyboard.readCommandsFromKeyboard(spaceMarines);

    }
}