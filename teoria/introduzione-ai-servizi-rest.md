# Introduzione ai serivizi RST

## Cosa offre Spring per trattare correttamente i servizi REST

Usare l'annotations  **@RestController** in cima al nome della classe, invece che usare @Controller e automaticamente tutti i metodi della classe saranno trattati come servizi rest.

Esempio:

        @RestController
        public class EmployeeController {


            ....
        }

l'annotations **@RequestMapping** tratta l'url del serivzio rest in questo modo:

        @RequestMapping(value = "/prova", method = RequestMethod.GET, produces = ...)

C'è poi la possibilità di *passare dei parametri direttamente come parte dell'URL* che andiamo ad invocare.

Ad esempio: 

        @RequestMapping(value = "prova/{name}", .....)
        public Employee getEmployee(@PathVariable String name) {
            ....
            employee.setName(name);
            ....
        }

Quindi grazie all'annotations **@PathVariable** siamo in grado di passare parametri nelle nostre URL. 

**Importante**

Se la request method è di tipo **POST** esempio: method = RequestMethod.POST allora c'è bisogno di usare l'annotations **@RequestBody**, che va a prendere la request di input in formato JSON da passare alla nostra api post.