// Classe Cassaforte
public class Cassaforte {
    private String combinazione;
    private boolean stato; // true: aperto, false: chiuso
    private boolean allarme; // true: attivo, false: disattivato
    private int soldi;

    public Cassaforte(String combinazione) {
        this.combinazione = combinazione;
        this.stato = false;
        this.allarme = false;
        this.soldi = 1000000;
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

    // Metodo per prelevare soldi dalla cassaforte
    public void preleva(int soldiDaPrelevare) {
        if (stato) {
            if (allarme) {
                System.out.println("Non è possibile prelevare soldi con l'allarme attivo.");
            } else {
                if (soldiDaPrelevare < soldi) {
                    soldi -= soldiDaPrelevare;
                } else {
                    soldiDaPrelevare = soldi;
                    soldi = 0;
                }
                System.out.println("Hai prelevato " + soldiDaPrelevare + " euro.");
            }
        } else {
            System.out.println("Non si possono prelevare soldi. La cassaforte è chiusa.");
        }
    }
    // Metodo per depositare soldi nella cassaforte
    public void deposita(int soldiDaDepositare) {
        if (stato) {
            if (allarme) {
                System.out.println("Non è possibile depositare soldi con l'allarme attivo.");
            } else {
                soldi += soldiDaDepositare;
                System.out.println("Hai depositato " + soldiDaDepositare + " euro.");
            }
        } else {
            System.out.println("Non si possono depositare soldi. La cassaforte è chiusa.");
        }
    }
}



