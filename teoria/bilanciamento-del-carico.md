# Bilanciamento del carico

Se abbiamo necessità di avviare più istanze di un nostro micro servizio allora dobbiamo bialanciare le richieste inserendo un componente nuovo chiamato **load balancer** in grado di bialsnciare le richieste tra le due istanze del nostro micro servizio. In base al carico, al traffico istanzia le richieste o su una porta o su un altra in maniera equa.

Spring cloud mette a disposizione **spring cloud load balancer** e anche una sua anotation **@LoadBalanced**.