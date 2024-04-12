# Come abilitare il logging dentro Spring Boot

## Livelli di log in Spring Boot

- OFF i log sono disattivati
- FATAL errore molto importante
- ERROR errore durante l'esecuzione di una operazione
- WARN anomalia che non per forza causa degli errori
- INFO informazioni legate alla normale esecuzione
- DEBUG informazioni necessarie per il debug
- TRACE livello massimo dove tutte le informazioni vengono loggate


Un framework di logging ci serve per stampare meglio le situazioni che accadono nell'esecuzione del programma.

Esempio di utilizzo:


1) Definisco un log nel mio controller:


        @RestController
        @RequestMapping("/api")
        public class HelloWorldController {
	
	        public static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class.getName());
	
	        @GetMapping(value = "/ciao")
	        public ResponseEntity<String> helloWorld() {
		        System.out.println("dentro il controller heeloWorld()");
		        logger.info("Sono dentro helloWorld metodo");
		        return new ResponseEntity<String>("ciao mamma", HttpStatus.OK);
	        }
        }

2) Creo via properties del mio progetto il modo in cui avere un file per i log:


        server:
            port: 8082
  
        spring:
            application:
                name: DemoLogging
    
        logging:
            file:
                name: DemoLogging.log
                max-size: 1MB
            pattern:
                file: "%d{ dd-MM-yyyyy } [%thread] %-5level %logger{36} - %msg%n"
            level:
                root: INFO
                org.springframework.security: DEBUG
                org.hibernate: INFO
                org.springframework.web: INFO

In questo modo invece di usare la System.out (che non va bene...) per stampare i log per il debug, possiamo usare direttamente il nostro logger appena definito.


            logger.info("Sono dentro helloWorld metodo");
            logger.debug(...);
            logger.error(...);

            ecc...


