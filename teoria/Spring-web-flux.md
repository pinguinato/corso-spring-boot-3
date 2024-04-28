# Spring Web Flux

## Richiesta Sincrona

è ciò che avviene nelle applicazioni Spring MVC classiche dove ad una request viene associato un servlet threads e tale rimane. Il server può avere un numero limitato di servlet threads. Il suo funzionamento è quindi sincrono, cioè **per ogni request viene creato un servlet threads**.

## Richiesta Asincrona

In questo caso non c'è nessun threads in attesa, ma ce ne sta solamente uno. Questo delega le richieste ad un pool di threads per occuparsene, quando la richiesta viene soddisfatta, allora si esegue una callback execution e viene richiamato indietro.

## Importante

Nella request sincrona tutto viene bloccato in attesa che venga soddisfatta appieno la richiesta. Nelle richieste asincrone il processo non si interrompe e quando la request viene soddisfatta, si viene richiamati per comunicare i dati.

## Lo stile reattivo

La reactive programming è una **reazione ai cambiamenti**. Nello stile reattivo facciamo una richiesta di risorse, ma nel mentre facciamo altre cose. Siamo in un flusso non bloccante. La programmazione web reattiva è molto uitle per applicazioni che funzionano con un flusso dati in stream. In java esistono tutta una serie di librerie per la programmazione reattiva e lo stream reattivo. 

## Reactive Stream API

Si compone di 4 interfacce:
- publisher (chi pubblica i dati)
- subscriber (i vari abbonati a ricevere questi dati pubblicati)
- subscription (definisce la relazione tra un publisher e un subscriber)
- processor (può fungere sia da publisher che da subscriber)

## Spring web flux

è una sorta di versione parallela di Spring MVC, che però supporta stream reattivi non bloccanti. Quindi asincroni. In spring web flux abbiamo 2 tipologie di publisher:
- MONO che implementa un solo publisher
- FLUX che implementa infiniti publisher
Un controller può quindi usufruire di un Mono o di un Flux.



