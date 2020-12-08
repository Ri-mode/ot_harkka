### Arkkitehtuurikuvaus
## Rakenne
Ohjelman rakenne noudattaa nelitasoista kerrosarkkitehtuuria. Pakkausrakenne on seuraava: miinanraivaaja.ui -> miinanraivaaja.logic -> miinanraivaaja.domain -> miinanraivaaja.dao. 

Pakkauksista miinanraivaaja.ui sisältää JavaFX graafisen käyttöliittymän, miinanraivaaja.logic sisältää pelilogiikan, miinanraivaaja.domain sisältää pelinaikana tarvittavat tietorakenteet sekä miinanraivaaja.dao sisältää. Alla pakkauskaavio kuvana.

### Pakkauskaavio
![Pakkauskaavio](/dokumentointi/OhTe_pakkauskaavio_02.jpg)

Pelaajanäkymän ruudun hiiren vasemman napin painalluksen sekvenssikaavio (mökkiversio).
![Sekvenssikaavio](/dokumentointi/Sekvenssikaavio.jpg)


Ensimmäinen hahmotelma luokkakaavioksi.
![Luokkakaavio](/dokumentointi/Luokkakaavio.jpg)
