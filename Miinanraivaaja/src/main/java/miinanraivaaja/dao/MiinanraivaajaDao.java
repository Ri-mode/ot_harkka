
package miinanraivaaja.dao;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import miinanraivaaja.domain.Gamedata;

/**
 * Luokka huippuaikojen pysyväistallennukseen.
 */
public class MiinanraivaajaDao {
    
    String filePath = "./Highscores";
    Gson gson = new Gson();
    List<Gamedata> highscores;
    File newFile;
    
    public void saveToFile(Gamedata gData) {
        if (newFile == null) {
            createFile();
        }
        if (true) { //readFromFile() == null) {
            highscores = new ArrayList<Gamedata>();
            highscores.add(gData);
        } else {
//            highscores = readFromFile();
            highscores.add(gData);
        }
        String output = gson.toJson(highscores);
        writeToFile(output);
    }
    
    public void writeToFile(String text) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(newFile);
            fileWriter.write(text + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    
    public void createFile() {
        newFile = new File(filePath + ".txt");
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
}
