public class TrasportoDenaro {
    private AddettoTrasporto Addetto;
    private double quantitaDenaro;

    public TrasportoDenaro(AddettoTrasporto Addetto, double quantitaDenaro) {
        this.Addetto = Addetto;
        this.quantitaDenaro = quantitaDenaro;
    }

    public void assegnaNuovoAddetto(AddettoTrasporto Addetto) {
        this.Addetto = Addetto;
        System.out.println("Il nuovo addetto è: " + Addetto.nome);
    }

    public void cambiaQuantitaDenaro(double nuovaQuantita) {
        this.quantitaDenaro = nuovaQuantita;
        System.out.println("La nuova quantità di denaro è: " + nuovaQuantita);
    }
}