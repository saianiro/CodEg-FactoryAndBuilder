# Design Patterns - Creazione di un personaggio in stile D&D utilizzando il pattern Factory e il pattern Builder

## Factory Design Pattern

Il pattern Factory è un design pattern creazionale che prevede l'implementazione di una classe con il compito di provvedere alla creazione dei singoli oggetti senza che vi sia bisogno di specificare a quale classe essi appartengano.

In questo esempio, la classe `PlayerFactory` gestisce la creazione di oggetti di tipo `Player` attraverso il metodo `createPlayer`, che si occupa di richiamare il costruttore di una delle sottoclassi di Player - `Wizard`, `Paladin`, `Rogue` - in base alla scelta dell'utente.

* La classe astratta `Player` permette di sfruttare il polimorfismo: ogni oggetto di tipo `Player` verrà istanziato dal costruttore di una delle classi concrete che la implementano: `Wizard`, `Paladin`, `Rogue`.

* La classe `PlayerFactory` riceve l'input fornito dall'utente e restituisce un oggetto di tipo `Player` che rappresenta il personaggio richiesto.

* Le classi `Wizard`, `Paladin` e `Rogue` rappresentano le diverse opzioni tra cui l'utente può scegliere per la creazione del proprio personaggio.

NB: in D&D, wizard, paladin, rogue e gli altri "tipi" di giocatori vengono chiamati "classi". In questo esempio ho scelto di non utilizzare questa denominazione per evitare di creare confusione tra le classi del gioco e le classi della programmazione ad oggetti. 
Ho quindi sostituito il concetto di "classe" in D&D con quello di "qualifica": molto più triste ma molto meno fuorviante.