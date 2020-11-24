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
    public void sameAmmountOfMines() {
        Minefield m1 = new Minefield(10, 10, 10);
        Minefield m2 = new Minefield(10, 10, 10);
        assertTrue(m1.equals(m2));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
