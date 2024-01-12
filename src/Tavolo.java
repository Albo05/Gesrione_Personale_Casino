import java.util.List;

public class Tavolo {
    private int numero;
    private int posti;
    private List<Giocatore> giocatori;
    private List<Giocatore> attesa;
    private boolean occupato;
    private boolean prontoInizio;

    public Tavolo(int numero, int posti) {
        this.numero = numero;
        this.posti = posti;
        this.occupato = false;
        this.prontoInizio = false;
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

    public void finepartita() {
        occupato = false;
        giocatori.clear();
    }

    public void setProntoInizio() {
        prontoInizio = true;
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }
}
