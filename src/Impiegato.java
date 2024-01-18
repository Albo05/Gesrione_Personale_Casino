// Classe astratta Impiegato
public abstract class Impiegato {
    protected String nome;
    protected String cognome;
    protected int matricola;
    protected double stipendio;
    protected String ruolo;

    public Impiegato(String nome, String cognome, int matricola, double stipendio, String ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.ruolo = ruolo;
    }

    public abstract double calcolaStipendio();

    public abstract void assegnaTurno();

    public void visualizzaDati() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Matricola: " + matricola);
        System.out.println("Stipendio: " + stipendio);
        System.out.println("Ruolo: " + ruolo);
    }

    public static int generaCodiceMatricola() {
        int codice = (int) (Math.random() * 1000000);
        return codice;
    }
}


