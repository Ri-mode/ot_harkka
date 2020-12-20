# Vaatimusmäärittely

## Sovelluksen tarkoitus

Luodaan sovelluksena muunnelma legendaarisesta Miinaharava-pelistä.
Sovelluksen on toimittava Linux-ympäristössä ja se ohjelmoidaan Javalla.

## Perusversion toiminnallisuudet

### Alkuvalikko

* Graafinen pelin aloitus

### Pelivalikko

* Aluksi 10x10 pelialue
  * Arvotaan pommit
    - Näkyvissä olevat pommit
    - Ruudun viereisten pommien lukumäärä laskettu valmiiksi
    - Pommien etsintä
    - Aluksi tyhjä alue 0 on klikkailtava itse auki
    - Algoritmi tyhjän alueen näyttämiseen

* Ajanmittaus ja tallennus

* Toinen pelialue

* Pelin voi sulkea sulkemalla ikkunan

### Huipputulosten tallennus ja muita laskureita

* High score tallennetaan tietokoneelle 

* Pommeja löytynyt/löytämättä -laskuri


## Jatkokehitysideoita

Perusversion toimiessa sovellusta täydennetään seuraavilla ominaisuuksilla.
* Pelaaja voi lisätä nimensä High score -listalle

* High score tallennetaan verkkoon

* Kustomoitava pelimoodi, jossa voi muuttaa pelialueen korkeutta ja leveyttä, sekä määritellä miinojen lukumäärän

* Pommien purkaminen

* Raivauspommi, jolla saa räjäytettyä 1x1, tai 3x3 alueen
 * Käytännöllinen tilanteissa, joissa joutuu arvaamaan
 * Raivauspommin käyttäminen lisää käytettyä aikaa X sekuntia

* Erilaisia pelitiloja
 * Edetään peliruudun reunalta toiselle reunalle

