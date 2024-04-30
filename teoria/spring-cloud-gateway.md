# Spring cloud gateway

Si tratta di un modulo di Spring, che permtte di implemnentare un sisteam nella nostra architettura a micro servizi, dove chiunque voglia passare dai nostri micro servizi, dovrà prima passare attraverso lo spring cloud gateway. Perché si mette una porta unica del gateway? 

- Per centralizzare l'autenticazione, in modo da verificare la veridicità degli utenti che si loggano

Come si crea uno spring cloud gateway?

Usando il modulo Spring Cloud Gateway, in collaborazione con Eureka server.

Per usarlo dobbiamo aggiungere al nostro la seguente dipendeza:

        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-gateway -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
            <version>4.1.3</version>
        </dependency>

## Spring cloud gateway API


