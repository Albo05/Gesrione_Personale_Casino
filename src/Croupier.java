// Sottoclasse Croupier
public class Croupier extends Impiegato {
    private Tavolo tavolo;
    private int partiteGestite;
    private boolean inGioco;
    private GestorePersonale gestorePersonale;
    public Croupier(String nome, String cognome, int matricola, double stipendio, String ruolo, Tavolo tavolo, GestorePersonale gestorePersonale) {
        super(nome, cognome, matricola, stipendio, "Croupier");
        this.tavolo = tavolo;
        this.inGioco = false;
        this.gestorePersonale = gestorePersonale;
    }

    @Override
    public double calcolaStipendio() {
        //base + bonus per tavolo responsabile
        return stipendio + 100.0;
    }

    @Override
    public void assegnaTurno() {

    }

    public void cambiaTavoloResponsabile(Tavolo nuovoTavolo) {
        this.tavolo = nuovoTavolo;
        System.out.println("Il tavolo responsabile è stato cambiato a: " + nuovoTavolo);
    }
    public void iniziaPartita(){
        // da fare: implementare 'inizio partita' per il Croupier
        for (Giocatore giocatore : tavolo.getGiocatori()) {
            System.out.println("Il croupier ha distribuito le carte al giocatore: " + giocatore.getNome() + " " + giocatore.getCognome() + "(" + giocatore.getMatricola() + ").");
        }
        System.out.println("Partita iniziata per il tavolo: " + tavolo.getNumero());
        System.out.println("Gioco: descrizione del gioco");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // logica del gioco
        System.out.println("Il vincitore è il giocatore ...");
        System.out.println("Partita terminata per il tavolo: " + tavolo.getNumero());
        int valoreVittoria = 100;
        gestorePersonale.trasportoSoldi(tavolo, "Cassaforte", valoreVittoria);
        tavolo.finepartita();
        partiteGestite++;
    }

    public void controllaTavolo() {
        if (tavolo.getValore() > 100000) {
            gestorePersonale.trasportoSoldi(tavolo, "Cassaforte", 50000);
            tavolo.rimuoviSoldi(50000);
            System.out.println("Il croupier ha chiamato un addetto al trasporto e gli ha consegnato 50000.");
        }
    }

    public void assegnaTavolo(Tavolo tavolo){
        this.tavolo = tavolo;
    }
    public boolean isInGioco() {
        return inGioco;
    }
    public void setInGioco() {
        this.inGioco = true;
    }
}
