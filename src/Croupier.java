// Sottoclasse Croupier
public class Croupier extends Impiegato {
    private String tavoloResponsabile;
    // tavolo di cui è responsabile il Croupier
    // numero di giocatori presenti nel tavolo
    // numero di giocatori in attesa di giocare al tavolo
    private int partiteGestite;

    public Croupier(String nome, String cognome, int matricola, double stipendio, String tavoloResponsabile) {
        super(nome, cognome, matricola, stipendio, "Croupier");
        this.tavoloResponsabile = tavoloResponsabile;
    }

    @Override
    public double calcolaStipendio() {
        //base + bonus per tavolo responsabile
        return stipendio + 100.0;
    }

    @Override
    public void assegnaTurno() {
        // da fare: implementare 'assegnazione del turno per il Croupier
        // Esempio di logica per l'assegnazione dei turni
        System.out.println("Turno assegnato per il tavolo: " + tavoloResponsabile);
    }

    public void cambiaTavoloResponsabile(String nuovoTavolo) {
    this.tavoloResponsabile = nuovoTavolo;
    System.out.println("Il tavolo responsabile è stato cambiato a: " + nuovoTavolo);
    }
    public void iniziaPartita(/* tavolo dove avviene il gioco, i giocatori presenti */){
        // da fare: implementare 'inizio partita' per il Croupier
        System.out.println("Partita iniziata per il tavolo: " + tavoloResponsabile);
        System.out.println("Gioco: descrizione del gioco");
        // descrizione dei giocatori presenti al tavolo
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // logica del gioco
        System.out.println("Il vincitore è il giocatore ...");
        System.out.println("Partita terminata per il tavolo: " + tavoloResponsabile);
        // controllo tempo impiegato per la partita
        if (true /* tempo impiegato per la partita è maggiore di tot tempo,
        deve essere sostituito, sempre se è presente un croupier in grado di poter
        gestire il tavolo*/) {
            System.out.println("Il croupier " + nome + " " + cognome + " è stato sostituito");
        }
        // deposito soldi nella cassaforte
        // richiama gli addetti al trasporto dei soldi
        // rilascia i vari giocatori
        partiteGestite++;
    }
    public void richiamaTrasporto(/*num soldi da trasportare, eventualmente può
    richiedere dei soldi per il tavolo*/) {
        // da fare: implementare 'richiamo trasporto' per il Croupier
        System.out.println("Richiamo trasporto per il tavolo: " + tavoloResponsabile);
    }
}
