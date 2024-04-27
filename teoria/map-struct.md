# La libreria MapStruct

Mappa entity in dto e viceversa.

Documnentazione qui: https://mapstruct.org/

**Ricorda**: nel servizio rest è sempre buona norma non far ritornare una entity, bensì il suo DTO.

MapStruct è una libreria che fa lo stesso lavoro di ModelMapper.

Bisogna sempre creare un **mapper** per ogni entity, come in ModelMapper.

Portare la dipendenza:

        <!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
            <version>1.5.5.Final</version>
        </dependency>

Creare un MAPPER:


        import org.mapstruct.Mapper;

        @Mapper
        public interface StudenteMapper {

            StudenteMapper mapper = Mappers.getMapper(StudenteMapper.class);

	        StudenteDTO map(Studente studente);
	
        }

Uso del mapper:


        @GetMapping(value = "/esempio-mapstruct")
	    public ResponseEntity<StudenteDTO> esempioMapStruct() {
		
		    System.out.println("dentro esempioMapStruct()");
		
		    Studente studente = new Studente();
		    studente.setNome("Roberto");
		    studente.setCognome("Gianotto");
		
		    return new ResponseEntity<>(StudenteMapper.mapper.map(studente), HttpStatus.OK);
	    }


**Note**

ModelMapper è più facile da usare di MaStruct, ma è meno performante.
