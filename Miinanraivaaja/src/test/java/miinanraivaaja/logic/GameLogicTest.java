/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinanraivaaja.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import miinanraivaaja.domain.Minefield;
import miinanraivaaja.domain.Playerfield;

/**
 *
 * @author antti
 */
public class GameLogicTest {
    
    public GameLogicTest() {
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
    public void createRightAmmountOfMinesToNewGameLogic() {
        GameLogic gLogic10 = new GameLogic(10);
        assertTrue(gLogic10.getMineField().getAmmount() == 10);
    }
    
    @Test
    public void openPlayerCellCorrectly() {
        int[][] yx = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Minefield mSmall = new Minefield(yx, 1);
//        int[][] yxPlayer = {{0, 0, 0, 0}, {0, -1, -1, 0}, {0, -1, -1, 0}, {0, 0, 0, 0}};
        Playerfield pSmall = new Playerfield(2, 2);
        pSmall.preparePlayerField();
        GameLogic gLogic2 = new GameLogic(mSmall, pSmall, 0);
        assertTrue(gLogic2.openPlayerCell(1, 1) == 0);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
