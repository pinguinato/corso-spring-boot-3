# Differenze tra Spring, Spring MVC e Spring Boot

## Spring

Il framework spring è incentrato sulla dependency injection. Definisce le dipendenze e ne fa l'autowire (@AutoWired). Queste dipendenze vanno identificate e lo si fa attraverso la @ComponentScan. Quindi questo è il core principale del framework, ma da solo non è sufficiente e c'è bisogno di altri moduli per creare applicazioni più complesse. Per questo motivo esiste un modulo molto importante chiamato **spring mvc**.

## Spring MVC

Prima di Spring MVC esisteva un framework chiamato Struts, ma era un pò troppo complesso. Spring MVC ha semplificato Struts, con questo modulo si possono usare annotations quali @Controller, @RestController e @RequestMapping ... che aiutano nel creare dei controller.

Quindi Spring è il core che ci aiuta a lavorare con la dependency injection, mentre invece Spring MVC ci aiuta a lavorare in modo intuitivo su Spring, però ancora c'è bisogno di lavorare sulla configurazione del framework ed è proprio qui che interviene il modulo che accelera questo passo ed è **Spring Boot**.

## Spring Boot

Spring Boot contiene strumenti già pronti per facilitare la creazioni di applicazioni:

- actuator
- server embedded
- logging e gestione degli errori
- profili e configurazioni

Spring boot non è un concorrente dei primi due, ma una specie di wrapper che ci semplifica la vita nell'uso di spring e di spring mvc.