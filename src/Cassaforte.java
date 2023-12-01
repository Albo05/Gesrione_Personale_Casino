// Classe Cassaforte



public class Cassaforte {
    private boolean stato; // true: aperto, false: chiuso
    private boolean allarme; // true: attivo, false: disattivato
    private int ultimoOperatore; //ultimo operatore che ha avuto accesso alla cassaforte
    GestorePersonale operatoriAbilitati = new GestorePersonale(); //lista del personale che ha accesso alla cassaforte

    public Cassaforte() { // costruttore dell cassaforte
        this.stato = false;
        this.allarme = false;
    }

    public void apri(int numeroMatricola) {
        ultimoOperatore = numeroMatricola; // memorizzo l'ultimo operatore che ha avuto accesso alla cassaforte
        if (operatoriAbilitati.cercaImpiegato(numeroMatricola) != null) { //controllo se la combianzione inserita è corretta
            stato = true; // lo stato della cassaforte diventa aperto
            allarme = false; // viene disattivato l'allarme

            System.out.println("Cassaforte aperta correttamente.");
        } else {
            allarme = true;
            System.out.println("Combinazione errata. Cassaforte non aperta.");
        }
    }

    public void chiudi() {
        stato = false;
        allarme = false;
        System.out.println("Cassaforte chiusa.");
    }

    public void cambiaCombinazione(String nuovaCombinazione) {
        //combinazione = nuovaCombinazione;
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



