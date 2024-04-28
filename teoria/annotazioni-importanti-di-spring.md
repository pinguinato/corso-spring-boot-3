# Elenco delle annotazioni più importanti di Spring

## @Controller

Messa all'intestazione della classe ne indica che si tratta di una classe Controller.

## @RequestMapping

Viene usata per mappare le URL su una classe o un metodo di una classe. Posso usarla sia sul titolo della classe sia su un metodo della classe controller.

Esempio:


        @Controller
        @RequestMapping("/demo")
        public class HelloController {

                ...

                @RequestMapping("/welcome")
                public String printHello() {
                    return "hello";
                }

                ...
        }

Ogni volta che viene digitato l'url "/demo/welcome" verrà richiamato il nostro metodo printHello().

**Importante**

Tramite l'annotazione possiamo mappare anche il **tipo** (get, put, ...) di request HTTP, usando l'attributo **method**. Esempio:

        @RequestMapping(value = "/prova", method = RequestMethod.GET, produces = ...)...

## @PathVariable

Questa annotazione ci dice che una parte della nostra URL dovrà essere associata ad un qualche parametro specifico dichiarato, ad una variabile, per esempio:

        @RequestMapping(value = "/prova/{parametro}", method = RequestMethod.GET, produces = ...)
        public String test(@PathVariable("parametro") String parametro) {
            ...
        }

## @RequestParam

Questa annotations indica che la nostra request avrà un parametro di nome **id**, esempio:

        @RequestMapping("/api")
        public String getTest(@RequestParam String id) {
            .....
        }

Vuol dire che avrò in pratica il compito di invocare l'api in questo modo: .../api?id=40

Di request params posso averne quanti ne voglio.

Esempio: se devo invocare .../api?id=40&name=prova

devo scrivere a codice:

        @RequestMapping("/api")
        public String getTest(@RequestParam String id, @RequestParam String prova ) {
            .....
        }

## GetMapping

Si trova nelle ultime versioni di Spring, mappa direttamente una api HTTP di metodo GET. Invece che scrivere:

        @RequestMapping(value = "/prova/{parametro}", method = RequestMethod.GET....)

posso scrivere direttamente:

        @GetMapping("/prova/{parametro"})

Vale lo stesso discorso per:

        @PostMapping
        @PutMapping
        @DeleteMapping
        @PatchMapping

