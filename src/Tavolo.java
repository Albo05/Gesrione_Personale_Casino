import java.util.List;

public class Tavolo {
    private int numero;
    private int posti;
    private List<Giocatore> giocatori;
    private List<Giocatore> attesa;
    private boolean occupato;
    private boolean prontoInizio;
    private int soldi;

    public Tavolo(int numero, int posti) {
        this.numero = numero;
        this.posti = posti;
        this.occupato = false;
        this.prontoInizio = false;
        this.soldi = 0;
    }

    public int getNumero() {
        return numero;
    }

    public int getPosti() {
        return posti;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void aggiungiGiocatore(Giocatore nuovoGiocatore) {
        if (giocatori.size() < posti) {
            giocatori.add(nuovoGiocatore);
            if(giocatori.size() == posti) {
                occupato = true;
            }
        }
        else {
            System.out.println("Tavolo pieno.");
        }
    }

    public void rimuoviSoldi(int importo) {
        this.soldi -= importo;
    }

    public void aggiungiSoldi(int importo) {
        this.soldi += importo;
    }

    public void finepartita() {
        occupato = false;
        giocatori.clear();
    }

    public void setProntoInizio() {
        prontoInizio = true;
    }

    public boolean isProntoInizio() {
        return prontoInizio;
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }
    public int getValore() {return this.soldi;}
}
