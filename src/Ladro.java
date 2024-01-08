public class Ladro {
    private String nome;
    private String cognome;
    private int matricola;
    private double stipendio;
    private int gradoPericolosita;

    public Ladro(String nome, String cognome, int matricola, double stipendio, int gradoPericolosita) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.gradoPericolosita = gradoPericolosita;
    }

    public double calcolaStipendio() {
        //base + bonus per grado di pericolosità
        return stipendio + (gradoPericolosita * 100.0);
    }

    public void assegnaGradoPericolosita(int nuovoGrado) {
        this.gradoPericolosita = nuovoGrado;
        System.out.println("Il grado di pericolosità è stato cambiato a: " + nuovoGrado);
    }
}