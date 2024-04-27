# Actuator

Sono una serie di endpoint che permettono di monitorare e gestire il micro servizio con Spring Boot.

Nelle applicazioni a micro servizi proprio perché non si ha più a che fare con una sola applicazione monolitica, allora hanno ideato il meccanismo degli attuatori per tenere la situazione sotto controllo.

Prima cosa da fare è portare nel proprio progetto la dipendenza dell'attuatore di Spring Boot:

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <version>3.2.4</version>
        </dependency>

Una volta che hjo messo la dipendenza gli devo dire al micro servizio quali endpoint voglio attivare, questo posso dirglielo nel mio file di proerties:

Gli dico di usarli tutti quanti:

        spring:
            application:
                name: DemoActuator


        management:
            endpoints:
                web:
                    exposure:
                        include: "*"

**Importante**

Ecco il link del primo attuatore che ci fornisce tutto l'elenco delle funzionalità disponibili: http://localhost:9100/actuator

Per avere una valutazione della **salute** del nostro micro servizio: http://localhost:9100/actuator/health

che ci risponde che il servizio è su:

        {
            "status": "UP"
        }

Un altro molto importante è quello per le metriche: http://localhost:9100/actuator/metrics

Esempio di uso: http://localhost:9100/actuator/metrics/jvm.info

mi ritorna i parametri della JVM che esegue il micro servizio...

        {
            "name": "jvm.info",
            "description": "JVM version info",
            "measurements": [
            {
                "statistic": "VALUE",
                "value": 1
            }
            ],
            "availableTags": [
            {
                "tag": "vendor",
                "values": [
                "Azul Systems, Inc."
            ]
            },
            {
                "tag": "runtime",
                "values": [
                    "OpenJDK Runtime Environment"
                ]
            },
            {
                "tag": "version",
                "values": [
                    "17.0.9+8-LTS"
                ]
            }
            ]
        }

Le metriche ci danno tutta una serie di endpoint aggiuntivi per capire le performance del nostro ms, ad esempio quanta CPU stiamo utilizzando: http://localhost:9100/actuator/metrics/process.cpu.usage

Oppure le http request che si sono dovute usare: http://localhost:9100/actuator/metrics/http.server.requests.active

Ecc...

Un altro sempre molto importante è l'actuator mapping: http://localhost:9100/actuator/mappings

Volendo possiamo personalizzare e fornire noi delle informazioni e lo possiamo fare grazie all'actuator info --> http://localhost:9100/actuator/info 

Dove posso impostare questa informazione? 

Con queste properties:

        management.info.env.enabled=true
        management.info.build.enabled=true
        management.info.git.enabled=true
        management.info.java.enabled=true
        management.info.os.enabled=true


        info:
            assistenza:
                nome: Roberto
                cognome: Gianotto
                email: gianottoroberto@gmail.com
    
        nome: 
            name-app: "Prova attuatore"


