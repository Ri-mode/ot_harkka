package miinanraivaaja.dao;

import miinanraivaaja.domain.Gamedata;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class MiinanraivaajaDaoTest {

    public MiinanraivaajaDaoTest() {
    }

   
    @Test
    public void constructorSetsPlayerNameCorrectly() {
        MiinanraivaajaDao testDao = new MiinanraivaajaDao();
        testDao.setTestfilePath();
        Gamedata g1 = new Gamedata();
        testDao.saveToFile(g1);
        String name = testDao.readFromFile().get(0).getPlayerName();
        assertTrue(name.equals("Anonymous"));
    }

    @Test
    public void afterTestscoresCreatedGivesRightFirstRow() {
        MiinanraivaajaDao testDao = new MiinanraivaajaDao();
        testDao.setTestfilePath();
        Gamedata g1 = new Gamedata();

        testDao.saveToFile(g1);

        String firstRow = testDao.listHighscores().get(0);
        assertTrue(firstRow.equals("Parhaat tulokset:"));
    }

    @Test
    public void afterTestscoresReturnFirstHighscoreCorrectly() {
        MiinanraivaajaDao testDao = new MiinanraivaajaDao();
        testDao.setTestfilePath();
        Gamedata g1 = new Gamedata();

        testDao.saveToFile(g1);

        String firstRow = testDao.listHighscores().get(1);
        assertTrue(firstRow.equals("1: Anonymous 0 s."));

    }

}
