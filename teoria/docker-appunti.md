# Docker Appunti

## Introduzione

Prima che esistesse Docker esistevano le varie tecnologie di Virtualizzazione, però le VM erano pesanti, perché ogni macchina aveva un sistema operativo sopra il sistema operativo esistente. Docker ha reso più semplice tutto questo discorso. Docker si basa sui container, non installa un sistema operativo vero e proprio, è di fatto un concetto differente rispetto alla virtualizzazione. Ad esempio io ho bisogno di avere MySql per lavorare, allora mi scarico l'immagine docker di Mysql e lo faccio partire in locale e voilà ho a diposizione un MySql che posso usare per il mio sviluppo e non ho più bisogno di tirarmi su un sistema operativo da zero con dentro configurato tutto il MySql. Il rapporto tra una immagine e il suo container si può pensare come il rapporto che esiste tra una classe e la sua istanza. Quindi la classe è l'immagine e la variabile è il suo container. Tutto ciò è molto comodo. Scaricop l'immagine e mando in esecuzione il suo container.

## Installare Docker

Bisogna andare qui: https://docs.docker.com/desktop/install/windows-install/

Per le immgini docker basta recarsi sul Docker HUB --> https://hub.docker.com/

Ovviamente quando si lavorai in azienda, ogni azienda usa il proprio docker hub di immagini di proprietà dell'azienda.

Docker è a pagamento in parte. Per un uso non professionale/studio è al momento libero.

## Docker - Concetti di base

