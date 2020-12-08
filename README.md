# Miinanraivaaja OhTe harjoitustyö

Sovellus on legendaarinen Minesweeper-peli. Sovellusta on mahdollista käyttää Linux-ympäristössä Java 11 versiolla. 

Miinakentän avaamattomat ruudut on merkitty numerolla -1. Miinakentän pommittomat ruudut ovat numerolla 0-8 sen mukaan montako pomia ruudun ympärillä on. Joudut vielä muistamaan missä miinat ovat. Jatkossa epäillyt miinat voi merkitä lipulla (-2). Peliin lisätään pari suurempaa kenttää ja ajanotto. 

[Viikon 6 Release](https://github.com/Ri-mode/ot_harkka/releases/tag/viikko6)

[Viikon 5 Release](https://github.com/Ri-mode/ot_harkka/releases/tag/viikko5)

[Sovelluksen koodi](https://github.com/Ri-mode/ot_harkka/tree/master/Miinanraivaaja)

[Sovelluksen Vaatimusmäärittely](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/vaatimusmaarittely.md)

[Sovelluksen käyttöohje](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/kayttoohje.md)

[Sovelluksen arkkitehtuuri](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/Ri-mode/ot_harkka/blob/master/dokumentointi/tuntikirjanpito.md)

## Ohjeet
Seuraavat /Miinanraivaaja -hakemistossa:

Ohjelman ajaminen:

mvn compile exec:java -Dexec.mainClass=miinanraivaaja.ui.Miinanraivaaja

Jar-tiedoston generointi hakemistoon /target/

mvn package

Ohjelman testaus:

mvn test

Jacoco -testiraportin luonti hakemistoon /target/site/jacoco/

mvn test jacoco:report

Checkstyle -testiraportin luonti hakemistoon /target/site/

mvn test checkstyle:checkstyle

Javadoc-ohjeen luonti:

mvn javadoc:javadoc
