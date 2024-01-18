public class TrasportoDenaro {
    private String nomeAddetto;
    private double quantitaDenaro;

    public TrasportoDenaro(String nomeAddetto, double quantitaDenaro) {
        this.nomeAddetto = nomeAddetto;
        this.quantitaDenaro = quantitaDenaro;
    }

    public void assegnaNuovoAddetto(String nuovoAddetto) {
        this.nomeAddetto = nuovoAddetto;
        System.out.println("Il nuovo addetto è: " + nuovoAddetto);
    }

    public void cambiaQuantitaDenaro(double nuovaQuantita) {
        this.quantitaDenaro = nuovaQuantita;
        System.out.println("La nuova quantità di denaro è: " + nuovaQuantita);
    }
}