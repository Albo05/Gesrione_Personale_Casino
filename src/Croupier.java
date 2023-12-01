// Sottoclasse Croupier
public class Croupier extends Impiegato {
    private String tavoloResponsabile;

    public Croupier(String nome, String cognome, int matricola, double stipendio, String tavoloResponsabile) {
        super(nome, cognome, matricola, stipendio, "Croupier");
        this.tavoloResponsabile = tavoloResponsabile;
    }

    @Override
    public double calcolaStipendio() {
        //base + bonus per tavolo responsabile
        return stipendio + 100.0;
    }

    @Override
    public void assegnaTurno() {
        // da fare: implementare 'assegnazione del turno per il Croupier
        // Esempio di logica per l'assegnazione dei turni
        System.out.println("Turno assegnato per il tavolo: " + tavoloResponsabile);
    }
}
