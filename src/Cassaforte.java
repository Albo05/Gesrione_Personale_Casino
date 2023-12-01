// Classe Cassaforte
public class Cassaforte {
    private String combinazione;
    private boolean stato; // true: aperto, false: chiuso
    private boolean allarme; // true: attivo, false: disattivato

    public Cassaforte(String combinazione) {
        this.combinazione = combinazione;
        this.stato = false;
        this.allarme = false;
    }

    public void apri(String combinazioneInserita) {
        if (combinazioneInserita.equals(combinazione)) {
            stato = true;
            System.out.println("Cassaforte aperta.");
        } else {
            System.out.println("Combinazione errata. Cassaforte non aperta.");
        }
    }

    public void chiudi() {
        stato = false;
        System.out.println("Cassaforte chiusa.");
    }

    public void cambiaCombinazione(String nuovaCombinazione) {
        combinazione = nuovaCombinazione;
        System.out.println("Combinazione cambiata.");
    }

    public void attivaAllarme() {
        allarme = true;
        System.out.println("Allarme attivato.");
    }

    public void disattivaAllarme() {
        allarme = false;
        System.out.println("Allarme disattivato.");
    }
}



