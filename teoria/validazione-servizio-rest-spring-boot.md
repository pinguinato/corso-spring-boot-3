# Esempio di validazione dei servizi rest con Spring Boot

Per prima cosa si deve aggiungere la dipendenza:

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
            <version>3.2.4</version>
        </dependency>

In automatico questa dipendenza ci aggiunge anche Hibernate validator.

Esempio di annotation per la validazione: @NotBlank, @NotNull, @Valid

**Importante** L'annotation @Valid va aggiunta nelle parti del controller in modo che le annotations sui campi oggetto (@NotBlank, @NotNull) possano funzionare. Se l'annotation valid è presente quando viene effettuata la chiamata viene emessa una eccezione con una risposta 400 Bad request. Il consiglio è poi di usare un metodo opportuno per gestire l'eccezione che viene scatenata e non lasciare che SpringBoot emetta il contenuto dello stacktrace.

Quindi le tappe da tenere in considerazione per validare i servizi rest in spring boot sono:
- portarsi la dipendenza sopra indicata
- mettere le opportune annotations nei capi oggetto che si vuole validare (es. @NotBlank(message = "Name is mandatory"))
- mettere l'annotations @Valid dentro la firma del controller in modo da attivare le validazioni sui campi degli oggetti che si vuole validare
- gestire l'eccezione con un opportuno exception handler in modo da evitare che si stampi l'intero stacktrace.



