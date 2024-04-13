# Appunti sull'uso di Spring Data JPA

Si tratta di Spring Boot con Srong Data JPA, quindi quando creiamo il nostro progetto con Spring starter project bisogna che selezioniamo anche "spring data jpa" come dipendenza nel progetto. Nel nostro progetto viene quindi inserita questa dipendenza:


## 1 portare la dipendenza per JPA

            <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-data-jpa</artifactId>
                    <version>3.2.4</version>
                </dependency>
                
Inoltre dobbiamo inserire ad esempio anche la dipendenza per Mysql qualora volessimo collegare un database al nostro progetto:

## 2 portare la dipendenza per il connettore del db che si vuole usare 


            <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.33</version>
                </dependency>

Una volta che abbiamo impostato la nostra dipendenza, per poter usufruire del database dobbiamo anche impostare dell properties:

## 3 Configurazione delle properties

andiamo quindi nel file **application.properties** per definire le proprietà per poterci collegare al DB.

        spring.datasource.url=jdbc:mysql://localhost:3306/esempio-jpa?useSSL=false
        spring.datasource.username=root
        spring.datasource.password=tiger
        spring.jpa.properties.hibernate.format_sql=true
        spring.jpa.properties.hibernate.show_sql=true

## 4 Configurazione delle varie Entity per tutte le tabelle coinvolte nell'applicazione (i modelli)

        @Entity
        @Table(name = "country")
        @Data
        public class CountryEntity {
	
	        @Id
	        @Column(name = "id")
	        @GeneratedValue(strategy = GenerationType.IDENTITY)
	        private int id;
	
	        @Column(name = "countryName")
	        private String countryName;
	
	        @Column(name = "population")
	        private long population;
        }

## 5 Configurazione dei vari repository per effettuare le query sul database

        @Repository
        public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
	
	
	            /* esempio di query in dialetto JPA */
	
	            List<CountryEntity> findByCountryName(String countryName);
	
	            /* esempio di query nativa */
	
	            @Query(value = "select * from `esempio-jpa`.country c where c.country_name like :cn", nativeQuery = true)
	            List<CountryEntity> selByDescrizioneLike(@Param("cn") String cn);
	
	            /* esempio di query JPQL */
	
	            @Query(value = "from CountryEntity where countryName like :cn")
	            List<CountryEntity> selByDescrizioneLikeJPQL(@Param("cn") String cn);
	
	            /* esempio di query di eliminazione */
	
	            @Transactional
	            @Modifying
	            @Query(value = "DELETE FROM `esempio-jpa`.country c WHERE c.country_name like :cn", nativeQuery = true)
	            void delRowCountryName(@Param("cn") String cn);
        }

