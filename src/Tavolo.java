import java.util.ArrayList;
import java.util.List;

public class Tavolo {
    private int numero;
    private int posti;
    private List<Giocatore> giocatori;
    private List<Giocatore> attesa;
    private boolean occupato;
    private boolean prontoInizio;
    private int soldi;
    private boolean inGioco;

    public Tavolo(int numero, int posti) {
        this.numero = numero;
        this.posti = posti;
        this.occupato = false;
        this.prontoInizio = false;
        this.soldi = 0;
        giocatori = new ArrayList<Giocatore>();
        attesa = new ArrayList<Giocatore>();
        this.inGioco = false;
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
            System.out.println("Tavolo) Giocatore " + nuovoGiocatore.getNome() + " " + nuovoGiocatore.getCognome() + " è stato aggiunto al tavolo: " + this.numero);
            if(giocatori.size() == posti) {
                occupato = true;
                prontoInizio = true;
            }
        }
        else {
            attesa.add(nuovoGiocatore);
            System.out.println("Tavolo) Tavolo pieno");
            System.out.println("Tavolo) Giocatore " + nuovoGiocatore.getNome() + " " + nuovoGiocatore.getCognome() + " è stato aggiunto nella sala di attesa per il tavolo: " + this.numero);
        }
    }
    public boolean isInGioco() {
        return inGioco;
    }
    public void rimuoviSoldi(int importo) {
        this.soldi -= importo;
    }

    public void aggiungiSoldi(int importo) {
        this.soldi += importo;
    }

    public void finepartita() {
        inGioco = false;
        occupato = false;
        giocatori = new ArrayList<Giocatore>();
        for (int i = 0; i < attesa.size(); i++) {
            if (i < posti) {
                System.out.println("Tavolo) Giocatore " + attesa.get(i).getNome() + " " + attesa.get(i).getCognome() + " è passato dalla sala di attesa al tavolo: " + this.numero);
                giocatori.add(attesa.get(i));
            }
        }
        if(giocatori.size() == posti) {
            System.out.println("Tavolo) Tavolo pieno");
            occupato = true;
            prontoInizio = true;
        }
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

    public void setInGioco(boolean valore) {
        inGioco = valore;
    }
}
