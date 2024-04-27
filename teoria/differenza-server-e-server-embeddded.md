# La differenza tra un server e un server embedded

Il modo tradizionale di lavorare è avere un server su cui installare le proprie applicazioni in formato .WAR.

In un ambiente reale dobbiamo quindi prendere il nostro file WAR e copiarlo nel computer remoto dove sta ad esempio Tomcat.

Questa è la modalità standard classica in cui si lavorava con Java. Un server e tanti file WAR.

Oggi si lavora con i microservizi dove ognuno ha un suo server e tutto all'interno di un file .JAR. Quindi oggi è il server ad essere incluso dentro la nostra applicazioni. In questo modo si definisce **server embedded**. L'applicazione è quindi deployata in modo molto rapido. Quindi 1 server per ogni JAR pronto all'uso. Di norma questo tipo di architettura viene usata sempre nei micro servizi.

## Applicazione Monolitica

Tutta l'applicazione concentrata in un unico file, che poi viene deployata su di un server.

## Micro Servizi

Tante piccole applicazioni, dove ognuna è responsabile della sua parte dei dati. E' più complesso, soprattutto sulla gestione dei dati. Le nostre applicazioni contengono già un server autonomo. Esempio: se ho 4  micro servizi allora ho 4 server Tomcat. Ci sono pro e contro di queste architetture:

- Alta scalabilità (posso creare più istanze di un micro servizio)
- Problema di gestione delle configurazioni e delle transazioni
- Ogni micro servizio deve sapere dove sta l'altro, quindi ci vuole un registro

Quindi prima di scegliere bisogna sapere cosa si vuole:

se conosciamo la nostra utenza non ha senso introdurre la complessità e passare ai microservizi.

Il modo più semplice per realizzare micro servizi è farlo con Spring Boot.

Da Eclipse ad esempio posso installare tramite il marketplace lo **Spring Tools Suite** per poter creare progetti Spring Boot con Eclipse.