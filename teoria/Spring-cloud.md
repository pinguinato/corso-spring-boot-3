# Spring Cloud

E' complicato rendere scalabili le applicazioni monolitiche. Se l'appplicazione non è stata progettata bene diventa complicato. Quindi nel tempo hanno preso il sopravvento le applicazioni a micro servizi. Avere tutti i micro servizi comporta una serie di problematiche di gestione. Ad esempio problemi come il bilnciamento del carico, il registro dei micro servizi possono essere problemi complessi. Per risolvere questi problemi quelli di Spring hanno introdotto **Spring Cloud**. Ci permette di avere applicazioni pronte per il cloud e ci mette a disposizione tantissimi strumenti per gestire reti di micro servizi. Spring Cloud, quindi, è stato creato per gestire tutte le operazioni di configurazioni di stack a micro servizi.

Sito del progetto: https://spring.io/projects/spring-cloud

Come si usa Spring Cloud? 

Spring cloud si integra perfettamente con Spring Boot e basta portare le dipendenze che ci servono nel progetto.

## Spring Cloud Config

Nelle applicazioni distribuite la configurazione va gestita in forma centralizzata. Spring Cloud COnfiguration si occupa di questi aspetti. C'è da impazzire se pensiamo di gestire la configurazione di ogni singolo microservizio in maniera isolata e indipendente. Spring cloud config è quindi un modulo di Spring per gestire applicazioni distribuite e ci permette di configurare ed esternalizzare queste applicazioni anche attraverso Git. Abbiamo quindi questa situazione:

- un repository centrale (GIT) e tanti client (di questi micro servizi), che si collegano al repository per ottenere le varie configurazioni (ad esempio il config-repo)

- caratteristica importante e degna di nota di queste configurazioni è il meccanismo del refresh automatico.

### Esempio di creazione di una applicazione che funziona da server per i vari clients

#### 1 

Per prima cosa creareu n nuovo progetto spring e scegliere la voce **config** per poter selezionare Spring Cloud Config, la parte server. Avviare così il progetto.

Caricare anche questa dipedenza nel pom in quanto le nuove versioni di Spring Cloud non leggono pù il file **boostrap.yml**

        <dependency>
    		<groupId>org.springframework.cloud</groupId>
    		<artifactId>spring-cloud-starter-bootstrap</artifactId>
		</dependency>

#### 2

Nel file di entry point dell'applicazione mettere questa annotations per attivare il server: @EnableConfigServer

            @SpringBootApplication
            @EnableConfigServer
            public class HelloWorldSpringCloudConfigServerApplication {
	            public static void main(String[] args) {
		            SpringApplication.run(HelloWorldSpringCloudConfigServerApplication.class, args);
	            }
            }

#### 3

Nel file **bootstrap.yml** 

            server:
                port: 8888
  
            # ==============================================================
            # = Profilo Attivo
            # ==============================================================  
            spring:
                cloud:
                    config:
                        server:
                            native:
                                search-locations:
                                    file:///C:/Prova/
                profiles:
                    active:
                        - native

#### 4

Creare una cartella sotto c: chiamata **Prova** in cui inserire un file di **application.properties**

#### 5 

Avviare il config server e portarsi a questa URL di esempio: http://localhost:8888/HelloWorldSpringCloudConfigServer/default/master

e si vedrà visualizzato l'accesso al file di properties dichiarato sopra e in questo modo creiamo un repository di files cui i nostri micro servizi possono accedere per leggerne la configurazione.

**Importante**

Tutti i micro servizi che hanno bisogno delle properties presenti nel file sotto c: non avranno altro da fare che puntare a queste properties attraverso il loro client.

### Esempio di creazione di una applicazione Client

