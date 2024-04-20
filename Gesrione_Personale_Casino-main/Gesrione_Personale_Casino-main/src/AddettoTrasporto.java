import java.util.LinkedList;
import java.util.List;

public class AddettoTrasporto extends Bodyguard{
    private double quantitaDenaro;
    private String destinazione;
    private Tavolo tavolo;
    private Caveau caveau;
    private boolean occupato;
    private boolean continua;

    public AddettoTrasporto(String nome, String cognome, int matricola, double stipendio, String ruolo, Cassaforte cassaforte, int[] orari, List<Ladro> ls, Caveau caveau) {
        super(nome, cognome, matricola, stipendio, "Addetto Trasporto", orari, cassaforte, ls);
        this.tavolo = null;
        this.caveau = caveau;
        this.occupato = false;
        this.continua = true;
    }
    public void setInformazioni(Tavolo partenza, String destinazione, double quantitaDenaro) {
        this.tavolo = partenza;
        this.destinazione = destinazione;
        this.quantitaDenaro = quantitaDenaro;
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
    public void terminaLavoro(){
        continua = false;
    }
    @Override
    public void assegnaTurno() {
        System.out.println("Turno assegnato.");
    }
    public boolean isOccupato() {
        return occupato;
    }
    public void setOccupato(boolean value) {
        occupato = value;
    }
    public void run() {
        System.out.println("Trasporto) L'addetto al trasporto " + nome + " " + cognome + " ha iniziato a lavorare");
        while (continua) {
            if(occupato) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Trasporto) Trasporto in corso");
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(".");
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(".");
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(".");
                    System.out.println();
                }
                System.out.println("Trasporto) L'addetto al trasporto " + nome + " " + cognome + " è giunto a destinazione: " + destinazione);
                System.out.println("Trasporto) Quantità denaro: " + quantitaDenaro);
                if (destinazione.equals("Cassaforte") || destinazione.equals("Caveau")) {
                    caveau.deposita(quantitaDenaro, matricola);
                }
                occupato = false;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
