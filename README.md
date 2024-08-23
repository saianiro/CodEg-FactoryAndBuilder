# Design Patterns - Creazione di un personaggio in stile D&D utilizzando il pattern Factory e il pattern Builder

## Factory Design Pattern

Il pattern **Factory** è un design pattern creazionale che prevede l'implementazione di una classe dedicata alla creazione dei singoli oggetti senza che vi sia bisogno di specificare a quale classe essi appartengano.

In questo esempio, la classe `PlayerFactory` gestisce la creazione di oggetti di tipo `Player` attraverso il metodo `createPlayer`.

Il metodo `createPlayer` richiama, in base alla scelta dell'utente, i metodi `createWizard`, `createPaladin` e `createRogue` i quali, sfruttando il pattern **Builder** per la valorizzazione degli attributi, invocano il costruttore di una delle sottoclassi di Player - `Wizard`, `Paladin`, `Rogue`.

* La classe astratta `Player` permette di sfruttare il polimorfismo: ogni oggetto di tipo `Player` verrà istanziato dal costruttore di una delle classi concrete che la implementano: `Wizard`, `Paladin`, `Rogue`.

* La classe `PlayerFactory` riceve l'input fornito dall'utente e restituisce un oggetto di tipo `Player` che rappresenta il personaggio richiesto. 

* Le classi `Wizard`, `Paladin` e `Rogue` rappresentano le diverse opzioni tra cui l'utente può scegliere per la creazione del proprio personaggio.

## Builder Design Pattern

Il pattern **Builder** è un design pattern creazionale utile nei casi in cui gli oggetti da istanziare abbiano un gran numero di attributi: invece di richiamare un costruttore con tanti parametri quanti sono gli attributi della classe, dovendo anche rispettare l'ordine in cui essi sono stati elencati nel codice, si utilizza un oggetto di supporto, detto builder, che permette la costruzione dell'oggetto passo per passo, un attributo alla volta.

In questo esempio, la classe la classe `PlayerFactory` non costruisce direttamente l'oggetto di tipo `Player`, al suo posto istanzia un oggetto di tipo `PlayerBuilder` al quale verrà demandata la valorizzazione dei singoli attributi della classe `Player`.

Terminato questo compito, l'oggetto `playerBuilder` verrà "trasformato" in un oggetto di tipo `Player` grazie all'invocazione dei metodi `buildWizard`, `buildPaladin` e `buildRogue`, che sono gli effettivi responsabili dell'invocazione del metodo costruttore delle classi `Wizard`, `Paladin` e `Rogue`.

I metodi costruttori delle classi `Wizard`, `Paladin` e `Rogue` infine, ricevono come parametro l'intero oggetto `playerBuilder`, che al suo interno contiene _i valori di tutti gli attributi_ che le classi `Wizard`, `Paladin` e `Rogue` ereditano dalla classe `Player` _tranne_ `qualification`.
Quest'ultimo attributo infatti, viene valorizzato dalle singole classi utilizzando una classe enum.

Dettaglio della classe `PlayerBuilder`:

* Possiede tutti gli attributi della classe `Player` tranne `qualification`, la cui valorizzazione viene demandata alle classi `Wizard`, `Paladin` e `Rogue`.

* In particolare, l'attributo `name` è di tipo `final` in quanto il suo valore viene scelto dall'utente all'inizio del programma e non è previsto che possa essere modificato in seguito.

* Il suo costruttore è definito `private`: nel rispetto delle regole dell'**incapsulamento**, poiché esso viene invocato da un altro metodo della stessa classe.

* Il suo costruttore valorizza unicamente l'attributo `name`, gli altri valori vengono aggiunti in un secondo momento utilizzando i metodi appositi.

* Il metodo `builder` è di tipo `static`: questo è fondamentale per il corretto funzionamento del pattern poiché si tratta del metodo che invoca il costruttore e pertanto deve essere utilizzabile _prima_ della creazione dell'oggetto `playerBuilder` - cfr metodo `createPlayer`della classe `PlayerFactory`.

* I metodi getter servono per garantire l'accesso ai valori degli attributi dell'oggetto `playerBuilder` all'interno della classe `Player`.

* I metodi `strength`, `dexerity`, `constitution`, `intelligence`, `wisdom` e `charisma` permettono di valorizzare ogni attributo di `playerBuilder` tranne `name`, che è stato valorizzato in precedenza nel metodo costruttore. Ciascuno di questi metodi restituisce l'oggetto `playerBuilder` stesso per consentire l'utilizzo della **method chaining** (concatenazione di metodi) ovvero la tecnica che permette di invocare più metodi in una singola istruzione - cfr metodi `createWizard`, `createPaladin` e `createRogue` della classe `PlayerFactory`.

* Infine, i metodi `buildWizard`, `buildPaladin` e `buildRogue` invocano i costruttori delle classi `Wizard`, `Paladin` e `Rogue` rispettivamente, passando come parametro l'oggetto `playerBuilder` e pertanto vengono richiamati _dopo_ la valorizzazione degli attributi di quest'ultimo - cfr metodi `createWizard`, `createPaladin` e `createRogue` della classe `PlayerFactory`.

NB: in D&D, wizard, paladin, rogue e gli altri "tipi" di giocatori vengono chiamati "classi". In questo esempio ho scelto di non utilizzare questa denominazione per evitare di creare confusione tra le classi del gioco e le classi della programmazione ad oggetti. 
Ho quindi sostituito il concetto di "classe" in D&D con quello di "qualifica": molto più triste ma molto meno fuorviante.