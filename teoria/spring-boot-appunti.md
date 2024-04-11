# Spring Boot

Progetto di Spring molto diffuso, che ha aumentato la popolarità di Java verso Spring. Ci permette di creare applicazioni complesse in modo veloce e semplice occupandosi lui della configurazione. Rende l'uso di spring molto più semplice.

Possiamo fare:
- applicazioni Java stand-alone
- applicazioni web
- applicazioni con server inglobato all'interno dell'applicazione (novità introdotta da Spring boot, che permette di inglobare il server stesso dentro l'applicazione, prima eravamo abituati a pensare a parte client e parte server)

Sito ufficiale della documentazione: https://spring.io/spring-boot

Vantaggi di Spring:
- buona documentazione

## Creare una applicazione Spring Boot

- **Spring initializr**: sito dove posso creare lo scheletro di una applicazione Spring boot da zero, scegliendomi cosa voglio installare. Sito qui: https://start.spring.io/

- **Usare Eclipse**: selezionando Spring Starter Project (che si collega al sito Spring Inizializr).

## Note Importanti


### 1

Se importiamo nei nostri progetti Spring Data JPA dobbiamo definire delle properties di base nel file application.properties di configurazione del database per l'applicazione altrimenti il progetto non si avvia e restituisce un errore.

Esempio di properties per Mysql 8 funzionanti:

		spring.datasource.url=jdbc:mysql://localhost:3306/demo-due?useSSL=false
		spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
		spring.datasource.username=root
		spring.datasource.password=tiger
		spring.jpa.database=mysql
		spring.jpa.show-sql=true
		spring.jpa.hibernate.ddl-auto=none
		spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
		spring.data.jpa.repositories.enabled=true
		spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
		spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
		spring.jpa.properties.hibernate.dialect.storage_engine=innodb
		spring.jpa.properties.hibernate.format_sql=true

Esempio di properties per Mysql 5 funzionanti

		spring.datasource.url=jdbc:mysql://localhost:3306/demo-due?useSSL=false
		spring.datasource.driverClassName=com.mysql.jdbc.Driver
		spring.datasource.username=root
		spring.datasource.password=tiger
		spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect

### 2

Entry point di una applicazione Spring Boot:

		@SpringBootApplication
		public class DemoDueApplication {
			public static void main(String[] args) {
				SpringApplication.run(DemoDueApplication.class, args);
			}
		}

### 3 Spring boot dev tools

Dipendenza molto utile e molto usata, ci permette di prendere le modifiche a caldo senza riavviare per forza il server.

		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
		<dependency>
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-devtools</artifactId>
    		<version>3.2.4</version>
		</dependency>



