package com.mycompany.unicafe;

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
public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(500);
    }

    @Test
    public void kassassaAluksiOikeaMaaraRahaa() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void aluksiMyytyjaLounaitaNolla() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisellaEdullinenRahaaRiittavasti() {
        assertEquals(160, kassa.syoEdullisesti(400));
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisellaEdullinenRahaEiRiitta() {
        assertEquals(200, kassa.syoEdullisesti(200));
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisellaMaukasRahaaRiittavasti() {
        assertEquals(100, kassa.syoMaukkaasti(500));
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisellaMaukasRahaEiRiitta() {
        assertEquals(200, kassa.syoMaukkaasti(200));
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kortillaEdullinenRahaaRiittavastiKortinSaldoMuuttuu() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
        assertEquals(260, kortti.saldo());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kortillaEdullinenRahaEiRiittaKortinSaldoEiMuuttuu() {
        kortti.otaRahaa(300);
        assertEquals(false, kassa.syoEdullisesti(kortti));
        assertEquals(200, kortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kortillaMaukasRahaaRiittavastiKortinSaldoMuuttuu() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
        assertEquals(100, kortti.saldo());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kortillaMaukasRahaEiRiittaKortinSaldoEiMuuttuu() {
        kortti.otaRahaa(300);
        assertEquals(false, kassa.syoMaukkaasti(kortti));
        assertEquals(200, kortti.saldo());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void ladataanRahaaKortilleSaldoMuuttuuKassaanRahaa() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(1000, kortti.saldo());
        assertEquals(100500, kassa.kassassaRahaa());
    }

    @Test
    public void ladataanKortilleNegatiivinenSumma() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(500, kortti.saldo());
    }

    @After
    public void tearDown() {
    }
}

