# Appunti su Open Feign

Si tratta di cercare di poter richiamare un micro servizio dentro un altro micro servizio. Nelle architetture a micro servizi, questi si evocano tra di loro per completare le informazioni.

## 1

Una dipendenza importante da avere per implementare la possibilità di chiamare altri microservizi è la seguente:

        <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

Quindi, per prima cosa creare un ms che integra questa dipendenza nel suo pom.xml

## 2

Poi dobbiamo aggiungere una nuova annotations:

nella nostra classe Application dobbiamo inserire @EnableFeignClients():

        @SpringBootApplication
        @EnableFeignClients()
        public class HelloWorldSpringBootOpenFeignApplication {
	        public static void main(String[] args) {
		        SpringApplication.run(HelloWorldSpringBootOpenFeignApplication.class, args);
	        }
        }

## 3 Ci creaiamo una qualunque classe  controller in grado di ritornare qualcosa

            @RestController
            public class ProvaController {
	
	            @GetMapping("api/v1/ciao")
	            public ResponseEntity<String> getCiaoMamma() {
		            return new ResponseEntity<>("Ciao mamma", HttpStatus.OK);
	            }
	
	            @GetMapping("api/v1/articoli")
	            public ResponseEntity<Articolo> getArticolo() {
		            Articolo articolo = new Articolo();
		            articolo.setCosto(10);
		            articolo.setId(12);
		            articolo.setNome("Coca Cola");
		
                    return new ResponseEntity<>(articolo, HttpStatus.OK);
	            }
            }

## 4 Interfaccia per Open Feign (il pezzo più importante)

Questo codice ci serve per poter richiamare i nostri microservizi, quindi dobbiamo creare una interfaccia fatta in questo modo:

Esempio:

        @FeignClient(name = "GestioneSpeseDiCasa", url = "localhost:9000")
        public interface TestClient {
		
	
	        @RequestMapping(value = "/api/v1/test2", method = RequestMethod.GET)
	        public ResponseEntity<SpesaDTO> testDTO();
        }

Usare l'annotation @FeignClient che come attributi deve:

- come nome avere esattamente il nome del micro servizio che voglio chiamare
- come url esattamente la porta dove ascolta il nostro microservizio da richiamare
- tutte le firme dei metodi dei controllers che voglio usare e richiamare, esattamente gli stessi

## 5 A questo punto in un nostro controller, per richiamare la risorsa...

Richiamiamo l'interfaccia di OpenFeign:

        @Autowired
	    private TestClient testClient;

E usiamola:

        @GetMapping("api/v1/testFeign")
	    public ResponseEntity<SpesaDTO> getTestFeign() {
		    return testClient.testDTO();
	    }

Così facendo se vado sul mio browser e digito l'url http://localhost:8080/api/v1/testFeign il risultato è la risorsa in ascolto sulla porta 9000 del microservizio che voglio invocare:

        {
            "id": 1111,
            "nome": "Spesa di prova",
            "descrizione": "Test di una spesa di prova",
            "autore": "Roberto Gianotto",
            "data": "2024-04-27T10:44:00",
            "importo": 145.34
        }

**Importante**

I micro servizi ovviamente vanno avviati entrambi altrimenti Open Feign non funziona e ritorna un errore di connessione.

