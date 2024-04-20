import java.util.Random;

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
    public void iniziaPartita() {
        // da fare: implementare 'inizio partita' per il Croupier
        for (Giocatore giocatore : tavolo.getGiocatori()) {
            System.out.println("Croupier) Carte distribuite a: " + giocatore.getNome() + " " + giocatore.getCognome() + " (" + giocatore.getMatricola() + ")");
        }
        System.out.println("Croupier) Inizio gioco al tavolo: " + tavolo.getNumero());
        System.out.println("Croupier) descrizione del gioco");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Croupier) Partita in corso");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
            System.out.println();
        }
        System.out.println("Croupier) Il vincitore è il giocatore: " + tavolo.getGiocatori().get(0).getNome() + " " + tavolo.getGiocatori().get(0).getCognome());
        System.out.println("Croupier) Partita terminata per il tavolo: " + tavolo.getNumero());
        int valoreVittoria = (int)(Math.random()*2000)+15000;
        boolean eseguito = false;
        while (!eseguito) {
            for(Impiegato impiegato : gestorePersonale.getListaImpiegati()) {
                if(impiegato instanceof AddettoTrasporto && !((AddettoTrasporto) impiegato).isOccupato() && !eseguito) {
                    ((AddettoTrasporto) impiegato).setInformazioni(tavolo, "Caveau", valoreVittoria);
                    ((AddettoTrasporto) impiegato).setOccupato(true);
                    eseguito = true;
                }
            }
        }
        tavolo.finepartita();
        partiteGestite++;
    }

    public void controllaTavolo() {
        if (tavolo.getValore() > 100000) {
            //gestorePersonale.trasportoSoldi(tavolo, "Cassaforte", 50000);
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

    public void terminaLavoro(){
        setContinua(false);
    }
    public void run() {
        System.out.println("Croupier) Il Croupier " + nome + " " + cognome + " ha iniziato a lavorare");
        while(continua) {
            if(inGioco) {
                System.out.println("Croupier) Il Croupier " + nome + " " + cognome + " ha iniziato la partita al tavolo: " + tavolo.getNumero());
                iniziaPartita();
                inGioco = false;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
