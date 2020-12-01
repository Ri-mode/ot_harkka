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
        assertTrue(small.cell(2, 2) == 2);
    }
    
    @Test
    public void sameAmmountOfMines() {
        Minefield m1 = new Minefield(10, 10, 10);
        Minefield m2 = new Minefield(10, 10, 10);
        assertTrue(m1.equals(m2));
    }

    
}
