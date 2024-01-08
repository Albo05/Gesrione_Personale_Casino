public class Bodyguard extends Impiegato {
    private String areaResponsabilita;

    public Bodyguard(String nome, String cognome, int matricola, double stipendio, String areaResponsabilita) {
        super(nome, cognome, matricola, stipendio, "Bodyguard");
        this.areaResponsabilita = areaResponsabilita;
    }

    @Override
    public double calcolaStipendio() {
        //base + bonus per area di responsabilità
        return stipendio + 200.0;
    }

    @Override
    public void assegnaTurno() {
    }

    public void assegnaAreaResponsabilita(String nuovaArea) {
        this.areaResponsabilita = nuovaArea;
        System.out.println("L'area di responsabilità è stata cambiata a: " + nuovaArea);
    }
}