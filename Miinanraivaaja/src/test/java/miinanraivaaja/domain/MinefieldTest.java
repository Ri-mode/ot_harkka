/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class MinefieldTest {

    public MinefieldTest() {
    }

    @Test
    public void countNearByMinesGivesRightAmmount() {
        int[][] yx = {{0, 0, 0, 0}, {0, 0, 9, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Minefield small = new Minefield(yx, 1);

        int nearBy11 = small.countNearByMines(1, 1);
        assertTrue(nearBy11 == 1);
    }

    @Test
    public void prepareFieldCorrectly() {
        int[][] yx = {{0, 0, 0, 0}, {0, 9, 9, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Minefield small = new Minefield(yx, 1);

        small.prepareField();
        assertTrue(small.mineCell(2, 2) == 2);
    }

    @Test
    public void checkFieldToHaveEmptyZerosAround() {
        Minefield m1 = new Minefield(10, 10, 10);
        m1.scatterMines();
        assertTrue(m1.mineCell(0, 0) == 0);
    }

    @Test
    public void checkRightAmmountOfMines() {
        Minefield m1 = new Minefield(10, 10, 10);
        m1.scatterMines();
        int minesFound = 0;
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 12; i++) {
                if (m1.mineCell(j, i) == 9) {
                    minesFound++;
                }
            }
        }
        assertTrue(m1.getAmmount() == minesFound);
    }
}
