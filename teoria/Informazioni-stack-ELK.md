# Stack ELK appunti

In un sistema a micro servizi i file di log rivestono un ruolo fondamentale, ma spesso sono un problema, proprio per l'elevato numero dei log, quindi abbiamo bisogno di uno strumento dedicato alla sola gestione dei log, proprio per andare a vedere con precisione quale micro servizio ha un problema o ha loggato una informazione di nostro interesse. Una soluzione a questa problematica viene data dallo **stack ELK**.

## Lo Stack ELK

Si tratta dell'unione di 3 strumenti:
- Elastic search (server di ricerca e analisi con query di ricerca in tempo reale, molto popolare nei big data, che usa uno storage ad indici per immagazzinare i dati)
- Logstash (ha il compito di aggregare i vari dati provenienti da varie sorgenti, aggrega i dati e li raccoglie in indice, li filtra e li invia ad elastic search)
- Kibana (ci fornisce una GUI per visualizzare i nostri dati ricercati/indicizzati)

Questi software sono gratuiti, basta andare sul loro sito e scaricarli.

## Configurazione di Spring Boot con lo stack ELK (per l'invio dei log)

Immaginiamo di avere un micro servizio con Spring Boot che contien un controller con una api qualsiasi, per poter far si che i dati del log di questo micro servizio siano inviati a **logstash** è opportuno inserire nel file **pom.xml** questa dipendenza:

        <!-- https://mvnrepository.com/artifact/net.logstash.logback/logstash-logback-encoder -->
        <dependency>
            <groupId>net.logstash.logback</groupId>
            <artifactId>logstash-logback-encoder</artifactId>
            <version>7.4</version>
        </dependency>

Logstash è il componente che serve a raccogliere i dati e li spedisce dentro il nostro storage elastic search.

Poi dentro sempre il nostro micro servizio sotto il percorso delle **/resources** dobbiamo creare un apposito file chiamato **logback-spring.xml** dove dentro scriviamo la configurazione dei nostri log. In questo file gli diciamo a Spring di inviare direttamente al programma Logstash i nostri file di log.

Esempio (configurazione di base)

        <?xml version="1.0" encoding="UTF-8"?>
            <configuration>
                
                <springProperty scope="context" name="ElkSpringBoot" source="spring.application.name"/>
                
                <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
                    <destination>localhost:4560</destination>
                    <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
                </appender>

                <root level="INFO">
                    <appender-ref ref="LOGSTASH"/>
                </root>
    
            </configuration>

**Importante**

Diciamo di inviare i nostri log direttamente a Logstash tramite l'oggetto appender **LogstashTcpSocketAppender**. E poi gli diciamo di inviarli con il livello di log **INFO**.

In sintesi, per la configurazione lato Spring Boot basta:

- aggiungere la dipendenza
- creare il file logback-spring.xml con l'opportuna configurazione

## Configurare LOGSTASH

In pratica andiamo a configurare logstash allo stesso livello dove creeremo il file **docker-compose.yml** creando una cartella **/logstash** e dentro un suo file **logstash.conf** con le sue opportune ocnfigurazioni. Il file **.conf** si divide in 2 macro sezioni una di INPUT e un'altra di OUTPUT che rappresentano di fatto i dati che entrano e quelli che escono. I dati in uscita vanno inviati ad ElasticSearch.




