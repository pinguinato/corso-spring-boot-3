# Eureka

Chiamato Netflix Eureka Server. In una architettura a micro servizi io ho bisogno di informazioni in modo che i microservizi si possano gestire, altrimenti non si conoscono. Eureka è un **discovery service** e siccome in una rete di micro servizi indirizzi ip, e altri parametri possono cambiare, per questo motivo sono nati questi discovery service che aiutano a gestire queste informazioni in una architettura a micro servizi. Permettono per l'appunto di scoprire questi micro servizi.

Schema di ragionamento:

- service provider (è il nostro micro servizio che fornisce una api in ascolto su di una porta)
- service consumer (e un altro micro servizio che invoca il service provider)
- in mezzo ai 2 ci sta eureka e ad eureka server il service provider dichiara di essere in ascolto sulla porta N, quindi si può **registrare**, **rinnovare** e **cancellare**.

Quindi in questo schema ci sono almeno 2 attori principali:
- Eureka server
- almeno 1 servizio che si registra su Eureka

## Creazione di un eureka server

### 1 Creare un progetto Spring Boot da zero con questa dipendenza

        <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>

Netflix per il fatto che l'azienda che ha sviluppato per prima Spring Cloud, è stata appunto NETFLIX, quindi molte librerie portano ancora il suo nome.

### 2 Sul file di avvio della nostra applicazione

Aggiungiamo l'annotations @EnableEurekaServer

        @SpringBootApplication
        @EnableEurekaServer
        public class DemoEureka1Application {
            public static void main(String[] args) {
		        SpringApplication.run(DemoEureka1Application.class, args);
	        }
        }

### 3 Aggiungere le properties di base

        spring.application.name=DemoEureka1
        server.port = 9102
        eureka.client.serviceUrl.defaultZone = http://localhost:9102/eureka/
        eureka.client.register-with-eureka = false
        eureka.client.fetch-registry = false

Altrimenti il servizio si avvierà con degli errori.

In questo modo il nostro discovery server è terminato.

### 4 Non ci resta che preparare un micro servizio che si registri dentro l'Eureka Server

Al micro servizio oltre alle dipendeze che ci servono dobbiamo aggiungere anche l' **enable discovery client**, per potersi registrare su Eureka. Che sarebbe questa dipendenza nel pom.xml. Anche spring web devo mettere.

Poi dobbiamo nelle properties impostare il nome dell'applicazione in quanto chi ci dovrà chiamare chiederà ad Eureka Server il nostro nome e ci dovrà chiamare con esso.

E poi dobbiamo aggiungere queste due properties per dire al micro servizio dove si trova Eureka Server:

        eureka.client.service-url.defaultZone=${EUREKA_URI:http://localhost:8761/eureka}
        eureka.client.service-url.instance.preferIpAddress=true

In questo modo se avviamo il tutto e poi andiamo nella pagina di eureka dovremmo vedere il nostro micro servizio che si è registrato, in pratica in questo modo abbiamo imparato come creare un **service provider**, cioè un micro servizio che si registra su Eureka e fornisce una api da invocare, ora non ci resta che creare un micro servizio che chiamerà questo altro micro servizio passando da Eureka, quindi non ci resta che sviluppare la cosiddetta invocazione.

## Invocazione

Esempio del progetto:
- 1 eureka server HelloWorldSpringCloudEurekaServer2 che è l'eureka server
- 1 micro servizio che registra i suoi servizi sul server Eureka chiamato HelloWorldSpringCloudEurekaClient2
- 1 micro servizio che deve invocare i servizi di HelloWorldSpringCloudEurekaClient2 chiamato HelloWorldSpringCloudEurekaClient3

**Importante**

Per invocare da HelloWorldSpringCloudEurekaClient3 l'api su HelloWorldSpringCloudEurekaClient2 devo costruirmi una interfaccia feign client.

            @FeignClient("HelloWorldSpringCloudEurekaClient2")
            public interface HelloInvocationCtrClient {
	            
                @RequestMapping(value = "/api/v1/saluti", method = RequestMethod.GET)
	            public ResponseEntity<String> test1();
            }

Che richiamo così nel mio controller del ms:

            @RestController
            @RequestMapping("/api/v2/invocator")
            public class HelloInvocationController {
	
	            private final HelloInvocationCtrClient helloInvocationCtrClient;
	
	            public HelloInvocationController(HelloInvocationCtrClient helloInvocationCtrClient) {
		            this.helloInvocationCtrClient = helloInvocationCtrClient;
	            }
	
	            // verrà invocato l'api /api/v2/invocator/test --> /api/v1/saluti
	            @GetMapping("/test")
	            public ResponseEntity<String> test1() {
		            return helloInvocationCtrClient.test1();
	            }
            }

Inoltre devo prevedere di inserire l'annotations **@EnableDiscoveryClient** nel mio file application.

**Importante**

L'esempio riportato si serve di Open Feign per implementare il tutto, ma è possibile farlo anche con RestClient.