# Gestire le eccezioni in Spring Boot

Nei servizi Rest in linea di massima si ha l'abitudine di far ritornare gli HttpStatus che già esistono.

## Esempio di come gestire le eccezioni in Spring Boot 3.2.4

### 1 Creo la mia classe di eccezioni personalizzata

        @ResponseStatus(value = HttpStatus.CONFLICT)
        public class DuplicateException extends Exception {

	
	        private static final long serialVersionUID = 1L;
	        private String messaggio = "Risorsa duplicata";
	
	        public DuplicateException() {
		        super();
	        }
	
	        public DuplicateException(String messaggio) {
		        super(messaggio);
		        this.messaggio = messaggio;
	        }
	
	        public String getMessaggio() {
		        return this.messaggio;
	        }
	
	        public void setMessaggio(String m) {
		        this.messaggio = m;
	        }
        }

### 2 Definisco un ExceptionHandler generale per richiamere la mia eccezione


            @RestController
            @ControllerAdvice /* usiamo l'AOP per gestire le eccezioni */
            public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	            // questo è il controller che si occupa di gestire le nostre eccezioni
	            @ExceptionHandler({DuplicateException.class})
	            public final ResponseEntity<ErrorResponse> exceptionDuplicateHandler(Exception ex) {
		            ErrorResponse errore = new ErrorResponse();
		            errore.setCode(HttpStatus.CONFLICT.value());
		            errore.setMessaggio(((DuplicateException)ex).getMessaggio());
		
		            return new ResponseEntity<ErrorResponse>(errore, HttpStatus.CONFLICT);
	            }

                ...
            }

### 3 Uso l'eccezione nella mia API preferita

                @GetMapping(value = "/ciao")
	            public ResponseEntity<String> helloWorld() throws DuplicateException {
		        System.out.println("dentro il controller heeloWorld()");
		
		            if (1 == 1) {
			            throw new DuplicateException("Errore DuplicateException");
		            }
		
		            return new ResponseEntity<String>("ciao mamma", HttpStatus.OK);
		
	            }

