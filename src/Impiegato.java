// Classe astratta Impiegato
public abstract class Impiegato extends Thread{
    protected String nome;
    protected String cognome;
    protected int matricola;
    protected double stipendio;
    protected String ruolo;
    protected boolean continua;

    public Impiegato(String nome, String cognome, int matricola, double stipendio, String ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.ruolo = ruolo;
        this.continua = true;
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

    public void setContinua(boolean valore) {
        continua = valore;
    }

    public void run() {
        while(continua) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Impiegato) controllo");
        }
    }
}


