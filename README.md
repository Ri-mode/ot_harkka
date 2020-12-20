# Miinanraivaaja OhTe harjoitustyö

Sovellus on legendaarinen Minesweeper-peli. Sovellusta on mahdollista käyttää Linux-ympäristössä Java 11 versiolla. 

Miinakentän avaamattomat ruudut on merkitty numerolla -1 ja ne on avattavissa hiiren vasemmalla napilla. Miinakentän miinattomat ruudut ovat numerolla 0-8 sen mukaan montako miinaa ruudun ympärillä on. Voit lisätä avaamattomaan ruutuun "lipun" -9 hiiren oikealla napilla ja poistaa lipun toistamiseen hiiren oikeaa nappia painamalla. Kilpapelissä on ajanotto ja huipputulokset kirjataan TOP 10 -listalle. Isossa kentässä ei ole ajanottoa. 

## Releaset
[Lppupalautus versio 1.0](https://github.com/Ri-mode/ot_harkka/releases/tag/Loppupalautus)

[Viikon 6 Release](https://github.com/Ri-mode/ot_harkka/releases/tag/viikko6)

[Viikon 5 Release](https://github.com/Ri-mode/ot_harkka/releases/tag/viikko5)

[Sovelluksen koodi](https://github.com/Ri-mode/ot_harkka/tree/master/Miinanraivaaja)

## Dokumentointi
[Sovelluksen Vaatimusmäärittely](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/vaatimusmaarittely.md)

[Sovelluksen käyttöohje](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/kayttoohje.md)

[Sovelluksen arkkitehtuuri](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/arkkitehtuuri.md)

[Sovelluksen testausraportti](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/testaus.md)

[Työaikakirjanpito](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/tuntikirjanpito.md)

## Ohjeet
### Seuraavat /Miinanraivaaja -hakemistossa:

### Ohjelman ajaminen:

```
mvn compile exec:java -Dexec.mainClass=miinanraivaaja.ui.Miinanraivaaja
```
### Jar-tiedoston generointi hakemistoon /target/

```
mvn package
```
### Ohjelman testaus:
```
mvn test
```
### Jacoco -testiraportin luonti hakemistoon /target/site/jacoco/
```
mvn test jacoco:report
```
### Checkstyle -testiraportin luonti hakemistoon /target/site/
```
mvn test checkstyle:checkstyle
```
### Javadoc-ohjeen luonti:
```
mvn javadoc:javadoc
```
