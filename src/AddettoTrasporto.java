public class AddettoTrasporto extends Bodyguard{
    private double quantitaDenaro;
    private String destinazione;
    private Tavolo tavolo;
    private Caveau caveau;

    public AddettoTrasporto(String nome, String cognome, int matricola, double stipendio, String ruolo, Caveau caveau) {
        super(nome, cognome, matricola, stipendio, "Addetto Trasporto");
        this.tavolo = null;
        this.caveau = caveau;
    }

    public void trasportoSoldi(Tavolo partenza, String destinazione, double quantitaDenaro) {
        System.out.println("Trasporto soldi in corso...");
        System.out.println("Destinazione: " + destinazione);
        System.out.println("Quantità denaro: " + quantitaDenaro);
        if (destinazione.equals("Cassaforte") || destinazione.equals("Caveau")) {
            caveau.deposita(quantitaDenaro, matricola);
        }
    }

    public void cambiaDestinazione(String nuovaDestinazione) {
        this.destinazione = nuovaDestinazione;
        System.out.println("La nuova destinazione è: " + nuovaDestinazione);
    }

    public void cambiaQuantitaDenaro(double nuovaQuantita) {
        this.quantitaDenaro = nuovaQuantita;
        System.out.println("La nuova quantità di denaro è: " + nuovaQuantita);
    }

    public void assegnaNuovoConducente(String nuovoConducente) {
        this.nome = nuovoConducente;
        System.out.println("Il nuovo conducente è: " + nuovoConducente);
    }

    @Override
    public double calcolaStipendio() {
        return stipendio;
    }

    @Override
    public void assegnaTurno() {
        System.out.println("Turno assegnato.");
    }
}
