public class TrasportoDenaro {
    private String nomeConducente;
    private String targaVeicolo;
    private double quantitaDenaro;
    private String destinazione;

    public TrasportoDenaro(String nomeConducente, String targaVeicolo, double quantitaDenaro, String destinazione) {
        this.nomeConducente = nomeConducente;
        this.targaVeicolo = targaVeicolo;
        this.quantitaDenaro = quantitaDenaro;
        this.destinazione = destinazione;
    }

    public void assegnaNuovoConducente(String nuovoConducente) {
        this.nomeConducente = nuovoConducente;
        System.out.println("Il nuovo conducente è: " + nuovoConducente);
    }

    public void cambiaQuantitaDenaro(double nuovaQuantita) {
        this.quantitaDenaro = nuovaQuantita;
        System.out.println("La nuova quantità di denaro è: " + nuovaQuantita);
    }

    public void cambiaDestinazione(String nuovaDestinazione) {
        this.destinazione = nuovaDestinazione;
        System.out.println("La nuova destinazione è: " + nuovaDestinazione);
    }
}