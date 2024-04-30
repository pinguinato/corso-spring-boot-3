# Kubernetes

Sviluppato da Google nel 2014, che ci permette di gestire architetture basate sui Container. Già Docker compose permtte di avviare una rete di Container, ma se si vuole alzare l'asticella conviene passare a Kuberntes. Molti oggi implementano il supporto a Kubernentes:
- Amazon Web Services
- Google Cloud Platform
- Microsoft Azure

Come è composta una applicazione Kubernetes?

Si basa sul concetto di **cluster** e **nodi**. Il cluster è un insieme di nodi. I nodi sono di due tipologie:
- master (ce ne uno per ogni cluster, coordina i nodi slave)
- slave (dove stà la nostra applicazione)

Quindi un cluster K8s si compone di 1 master e N slave. Il nodo lo possiamo vedere come la macchina su cui gira tutto quanto, dove avvieremo la nostra applicazione.

## Google cloud platform

Per prima cosa bisogna creare un account su Google Cloud Platform. I prodotti cloud platform si pagano e sono costosi, non sono servizi gratuiti.

## Pods

Kubernetes è un oirchestratore di container, quindi il suo obiettivo è quello di distribuire i container sui nodi dei Cluster, incapsulandoli all'interno di oggetti chiamati pods. Il pod è il concetto più piccolo che si incontra su kubernetes. Ad esempio si ipotizzi 1 pod 1 container. Usiamo i pods per scalare. Il pod è un contenitore di container, quando vogliamo aumentare le repliche aumentiamo il numero dei pod e non dei container.
- init container (sono container speciali eseguiti prima che vengano avviati i pod con i container, di solito contengono degli script di configurazione)
- sidecar container (sono container eseguiti contemporaneamente al container principale di un pod e supporta il container principale, tipo raccoglie metriche, logs ecc...)
Quindi gli init vengono progettati per eseguire operazioni prima, i sidecar invece sono a supporto.

## ReplicaSet

ReplicaSet è un oggetto che permette l'avvio e la gestione di più pod in replica. ReplicaSet ci garantisce che il numero dei pod scelti sarà sempre eseguito.

## Tipi di nodi in Kubernetes

### Master Node

Si componen di 5 componenti principali:
- api server (comunicare all'interno del server)
- scheduler (schedulare i vari tipi di pod)
- controller manager kube (ci indica la saluta dell'intero cluster)
- controller manager cloud
- etcd (base di dati chiave, valori dove stanno le varie informazioni)

### Worker Node

Dove girano i vari container (docker o no l'importante che siano compatibili). I processi presenti nel worker node sono:
- kubelet e CRI
- proxy (gestisce le regole di rete del node)

