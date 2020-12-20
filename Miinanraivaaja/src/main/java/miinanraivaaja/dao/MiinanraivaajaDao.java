package miinanraivaaja.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import miinanraivaaja.domain.Gamedata;

/**
 * Luokka huippuaikojen pysyväistallennukseen.
 */
public class MiinanraivaajaDao {

    private String filePath = "./Highscores";
    private Gson gson = new Gson();
    private List<Gamedata> highscores;
    private File newFile;
    private Scanner scanner;

    /**
     * Setteri testitiedoston nimeämiseen.
     */
    public void setTestfilePath() {
        this.filePath = "./Testscores";
    }

    /**
     * Metodi yhden pelin tietojen tiedostoon tallentamiseen.
     *
     * @param gData pelin tiedot
     */
    public void saveToFile(Gamedata gData) {
        if (newFile == null) {
            createFile();
        }
        if (readFromFile() == null) {
            highscores = new ArrayList<>();
            highscores.add(gData);
        } else {
            highscores = readFromFile();
            highscores.add(gData);
            Collections.sort(highscores);
        }
        String output = gson.toJson(highscores);
        writeToFile(output);
    }

    /**
     * Metodi lukee tiedostosta talletettujen pelien tulokset.
     *
     * @return lista aiempien pelien tuloksista
     */
    public List<Gamedata> readFromFile() {
        String text = "";
        List<Gamedata> fileContent = new ArrayList<>();
        try {
            FileInputStream input = new FileInputStream(filePath + ".txt");
            scanner = new Scanner(input);
//            if (!scanner.hasNextLine()) {
//                return fileContent;
//            }
            while (scanner.hasNextLine()) {
                text = text + scanner.nextLine();
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

    /**
     * Metodi huipputulosten tiedostoon kirjoittamiseen.
     *
     * @param text tulokset tekstinä
     */
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

    /**
     * Apumetodi puuttuvan tallennus tiedoston luomiseksi.
     */
    public void createFile() {
        newFile = new File(filePath + ".txt");
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }

    /**
     * Metodi parhaiden talletettujen tulosten palauttamiseen.
     *
     * @return tekstilista max 10 parhaan pelin tuloksesta
     */
    public List<String> listHighscores() {
        List<String> listTop10 = new ArrayList<>();
        highscores = this.readFromFile();
        if (highscores == null || highscores.size() == 0) {
            listTop10.add("Ei vielä huipputuloksia");
        } else {
            listTop10.add("Parhaat tulokset:");
            for (int i = 0; i < highscores.size() && i < 10; i++) {
                listTop10.add(Integer.toString(i + 1) + ": " + highscores.get(i).toString());
            }
        }
        return listTop10;
    }

}
