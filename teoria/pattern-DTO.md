# Appunti sul Pattern DTO

DTO --> Non è buona cosa rendere visibile all'esterno come è composto il nostro database, attraverso le classi entity.
Il DTO supplisce a questa problematica. Permette di comporre dei dati. DTO sta per **data trasfer object**, che ci permette di 
far passare i nostri oggetti dallinterno allesterno della nostra applicazione.

Il DTO contiene tutte le informazioni delle entità.

Per prima cosa creiamo un nuovo package, chiamato DTO. Poi dobbiamo creare dalla entity di riferimento una classe DTO che avrà, per il momento gli stessi campi della entity. Però poi con il tempo il DTO rispetto alla entity contiene delle informazioni differenti.

Ad esempio: passiamo dal DAO al DTO. 

Convertiamo il DAO in un DTO, quindi per questa operazione usiamo dei metodi setter!

Esempio di traformazione dal Model DAO a DTO:

        Corsi ---> CorsiDTO

        CorsiDTO corsiDto = new CorsiDTO();

        Corsi corsi = dao.findById(1111);

        // esempio di trasformazione dal Model al DTO
        corsiDto.setId(corsi.getId());
        corsiDto.setName(corsi.getName());
        ...

Il Dao riconosce solamente l'entità Corsi, non conosce il DTO e viceversa, quindi ogni volta bisogna fare questo giochetto.

## Applicare il pattern DTO tramite la libreria ModelMapper

Documentazione qui: https://modelmapper.org/getting-started/

Si tratta di vedere come applicare il pattern DTO ai servizi rest tramite la libreria ModelMapper di Spring. Come prima cosa dobbiamo aggiungere al nostro progetto la dipendenza:

                <!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
		<dependency>
    		        <groupId>org.modelmapper</groupId>
    		        <artifactId>modelmapper</artifactId>
    		        <version>3.2.0</version>
		</dependency>

Tra l'altro per aplicare il pattern DTO dovremmo ogni volta andare a mappare le entity/model in maniera manuale con gli oggetti DTO.
Model Mapper ci permette di evitare questo lavoro fastidioso.

Esempio di utilizzo:

                private ModelMapper mapper;

                ...

                private StudenteDTO convertToDtoWithModelMapper(Studente studente) {
		        return mapper.map(studente, StudenteDTO.class);
	        }

Con una semplice riga di codice  trasforma una classe nel suo relativo DTO e non c'è più bisogno di fare un mapping manuale.

**Importante**

Per poter usare ModelMapper nella nostra applicazione, dobbiamo definirne il Bean, altrimenti non possiamo usarlo e la compilazione va in errore, dobbiamo inserire questo codice nell'entry point della nostra application Spring:


                @Bean
                public ModelMapper modelMapper() {
                        return new ModelMapper();
                }

Questo bean ci permette di poter scrivere:

                @Autowired
                private ModelMapper mapper;

Quindi indefinitiva il metodo **map** di ModelMapper prende in gresso 2 argomenti:
- l'istanza da trasformare
- il tipo di classe in cui trasformare quell'istanza

