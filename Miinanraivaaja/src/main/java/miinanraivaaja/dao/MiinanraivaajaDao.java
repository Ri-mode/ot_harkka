
package miinanraivaaja.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miinanraivaaja.domain.Gamedata;

/**
 * Luokka huippuaikojen pysyväistallennukseen.
 */
public class MiinanraivaajaDao {
    
    String filePath = "./Highscores";
    Gson gson = new Gson();
    List<Gamedata> highscores;
    File newFile;
    Scanner scanner;
    
    public void saveToFile(Gamedata gData) {
        if (newFile == null) {
            createFile();
        }
        if (readFromFile() == null) {
            highscores = new ArrayList<Gamedata>();
            highscores.add(gData);
        } else {
            highscores = readFromFile();
            highscores.add(gData);
        }
        String output = gson.toJson(highscores);
        writeToFile(output);
    }
    
    public List<Gamedata> readFromFile() {
        String text = "";
        List<Gamedata> fileContent = new ArrayList<>();
        
        try {
            FileInputStream input = new FileInputStream(filePath + ".txt");
            scanner = new Scanner(input);
            
            if (!scanner.hasNextLine()) {
                return fileContent;
            }
            while (scanner.hasNextLine()) {
                String more = scanner.nextLine();
                text = text + more;
            }
            scanner.close();
            
            fileContent = gson.fromJson(text, new TypeToken<List<Gamedata>>() {
            }.getType());
            
            input.close();
        } catch (FileNotFoundException e) {
            fileContent = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        return fileContent;
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
