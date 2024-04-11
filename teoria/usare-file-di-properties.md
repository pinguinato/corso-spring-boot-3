# Come usare i file di properties dentro Spring Boot

I file di properties vengono usati per poter dichiarare le proprietà di una applicazione. Quando creo una applicazione Spring Boot io ho un solo file di properties --> **application.properties**

Le properties in Spring Boot si definiscono con la sintassi:

nomeproperties = valore

esistono già in Spring Boot tantissime properties bellee e pronte che possiamo richiamare e usare ad esempio:

spring.application.name=MioNomeApplicazione

Per avere una panoramica di tante properties che possiamo usare in SpringBoot andiamo qui: https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties

Dentro questo file posso definire un sacco di properties che si possono richiamare dentro il mio progetto.

I file di properties vanno tutti inseriti dentro il percorso **src/main/resources**, ma volendo posso definire anche dei nuovi percorsi ad-hoc.

Vantaggi:
- tutte le proprietà dentro un solo file
- si possono modificare i file di properties senza riavviare l'applicazione

Spring Boot supporta anche configurazioni di tipo **YAML**, che è solo un altro formato per definire delle properties.Sempre dentro il percorso **/src/main/resources**.

Esempio:

		spring:
			application:
				name: MioNomeApplicazione

Esempio di uso delle nostre properties:

Definizione in application.properties:

		mia.properties.nome=Roberto
		mia.properties.cognome=Gianotto	

Uso in un controller:

		@Value("${mia.properties.nome:nome}")
		private String myName;
	
		@Value("${mia.properties.cognome:cognome}")
		private String mySurname;
	
		@GetMapping("/mie-properties")
		public String myProperties() {
			System.out.println("dentro mie properties");
		
			return "Il tuo nome completo è " + myName + " " + mySurname;
		}


Con la sintassi dei due punti imponiamo un valore di default in modo che spring non vada in eccezione se non esiste la properties o non viene trovata nel file.

Altro vantaggio dei file di properties sta nel poter creare i **profili**.

## Profili

Spring mi dà la possibilità di associare i files di properties a vari profili (tipo sviluppo, produzione, testing ecc..).

Esempio: definisco 2 nuovi files di properties

-application-prod.properties

-application-dev.properties

Per far leggere a Spring il file di properties corretto bisogna soltanto specificarglielo all'avvio.

Spring boot di default usa il file **application.properties** per uasarne uno diverso, quando avviamo da linea di comando ad esempio:

		java -jar DemoDue-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod

Oppure lo dichiariamo all'ide che usiamo così prate con quello giusto.








