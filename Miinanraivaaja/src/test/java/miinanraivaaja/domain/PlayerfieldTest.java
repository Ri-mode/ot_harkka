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
public class PlayerfieldTest {
    
    public PlayerfieldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void playerFieldPreparedCorrectlyInPlayArea() {
        Playerfield pField = new Playerfield(10, 10);
        pField.preparePlayerField();
        assertTrue(pField.checkCell(1, 1) == -1);
    }
    
    @Test
    public void playerFieldPreparedHaveAllCellsUnOpened() {
        Playerfield pField = new Playerfield(5, 5);
        pField.preparePlayerField();
        assertTrue(pField.unOpenedCells() == 25);
    }
    
    @Test
    public void unPreparedPlayerFieldHaveNonUnOpenedCells() {
        Playerfield pField = new Playerfield(8, 8);
        assertTrue(pField.unOpenedCells() == 0);
    }
    
    @Test
    public void flaggedCellsAreUnopened() {
        Playerfield pField = new Playerfield(7, 7);
        pField.preparePlayerField();
        pField.flagCellMine(1, 1);
        assertTrue(pField.unOpenedCells() == 49);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
