# Docker Appunti

## Introduzione

Prima che esistesse Docker esistevano le varie tecnologie di Virtualizzazione, però le VM erano pesanti, perché ogni macchina aveva un sistema operativo sopra il sistema operativo esistente. Docker ha reso più semplice tutto questo discorso. Docker si basa sui container, non installa un sistema operativo vero e proprio, è di fatto un concetto differente rispetto alla virtualizzazione. Ad esempio io ho bisogno di avere MySql per lavorare, allora mi scarico l'immagine docker di Mysql e lo faccio partire in locale e voilà ho a diposizione un MySql che posso usare per il mio sviluppo e non ho più bisogno di tirarmi su un sistema operativo da zero con dentro configurato tutto il MySql. Il rapporto tra una immagine e il suo container si può pensare come il rapporto che esiste tra una classe e la sua istanza. Quindi la classe è l'immagine e la variabile è il suo container. Tutto ciò è molto comodo. Scaricop l'immagine e mando in esecuzione il suo container.

## Installare Docker

Bisogna andare qui: https://docs.docker.com/desktop/install/windows-install/

Per le immgini docker basta recarsi sul Docker HUB --> https://hub.docker.com/

Ovviamente quando si lavorai in azienda, ogni azienda usa il proprio docker hub di immagini di proprietà dell'azienda.

Docker è a pagamento in parte. Per un uso non professionale/studio è al momento libero.

## Docker - Concetti di base

Con docker installato apriamo un promt dei comandi.

diamo il comando:

        docker run hello-world

Bisogna essere loggati sul docker hub per far funzionare questo comando, che scarica il container di hello world e lo esegue in locale, sul nostro docker.

Se docker non trova l'immagine all'interno del nostro computer locale, la va a scaricare dal suo HUB in remoto. Il docker hub è un docker registry che contiene un sacco di immagini.

Per sapere quali immagini sono installate sul nostro computer basta dare il seguente comando:

        docker images

Se no nspecifichiamo noi quale numero/tag di immagine vogliamo, lui ci scarica di default l'ultima immagine, la più recente, denominata **latest**.

**Importante**

        docker run -p 8081:8081 programmingacademydotit/docker-springboot-helloworld-2:0.0.1-SNAPSHOT

Se non lo avvio in questo modo, se provo l'rul tramite localhost sulla porta non funziona!! Questo perché Docker avvia sempre una sua rete per i fatti suoi e noi gli dobbiamo dire di parlare con la nostra rete, altrimenti lui rimane indipendente e isolato. Il comando -p 8081:8081 gli sta dicendo di collegareil container alla nostra rete sulla porta la nostra 8081 e la sua 8081. Dobbiamo in qualche modo mappare la nostra applicazione.

**Importante**

Per far si che il nostro container rimanga avviato diamo il comando in questo modo, con l'opzione **-d**:

        docker run -p 8081:8081 -d programmingacademydotit/docker-springboot-helloworld-2:0.0.1-SNAPSHOT

Non vedremo più i log, ma il container se premiamo CTRL+C rimane avviato.

Per poter vedere di nuovo i log del container diamo il comando:

        docker logs id_container

Mettendoci in tail (cioè vedendo il log in tempo reale) sui logs:

        docker logs -f id_container

Per listare i container running:

        docker container ls

ecc...

## Comandi principali Docker

        docker images // elenco delle immagini installate in locale

        docker pull nome_immagine  // scarica e installa l'immagine, l'ultima se non specifico quale

        docker image remove id_immagine // rimuove una immagine, la elimina dal computer

        docker container pause/unpause id_container // bloccare/sbloccare un container

        docker container ls // mostra l'elenco dei container in running al momento

        docker stop id_container // stoppa un container

        docker start id_container // avviaun container

        docker container kill id_container // fa la kill di un container

        ecc...

## Creare una propria immagine Docker con il microservizio

