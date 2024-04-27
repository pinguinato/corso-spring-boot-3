# Caratteristiche degli ambienti di sviluppo

In genere sono macchine Linux con i servizi che l'applicazione richiede.

Sull'ambiente di sviluppo lavorano un sacco di persone.

Una volta che ho testato la mia applicazione nello sviluppo la posso rilasciare nell'ambiente di test in modo che il gruppo delle persone che sono incaricate di fare i test possano testare il mio sviluppo.

Alla fine se funziona anche nell'ambiente di test a questo punto viene passato nell'ambiente di pre-produzione. Di norma questo ambiente deve gestire dei dati reali. Deve essere del tutto simile all'ambiente di produzione, oppure molto similare. Se qui l'applicazione fallisce allora viene aperto un ticket e segnalato un malfunzionamento.

Se passa anche la pre-produzione a questo punto l'applicazione viene rilasciata in produzione.

Quindi ricapitolando i passaggi sono più o meno 4:

Development --> Test --> Preproduzione --> Produzione