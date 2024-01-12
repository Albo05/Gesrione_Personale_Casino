
// Classe GestorePersonale
import java.util.ArrayList;
import java.util.List;

public class GestorePersonale {
    private List<Impiegato> listaImpiegati;
    private List<Tavolo> tavoli;

    public GestorePersonale() {
        listaImpiegati = new ArrayList<>();
        tavoli = new ArrayList<>();
    }

    public void aggiungiImpiegato(Impiegato impiegato) {
        listaImpiegati.add(impiegato);
    }
    public void aggiungiTavolo(Tavolo tavolo) { tavoli.add(tavolo); }

    public void rimuoviImpiegato(int matricola) {
        listaImpiegati.removeIf(impiegato -> impiegato.matricola == matricola);
    }

    public Impiegato cercaImpiegato(int matricola) {
        for (Impiegato impiegato : listaImpiegati) {
            if (impiegato.matricola == matricola) {
                return impiegato;
            }
        }
        return null;
    }

    public void assegnaTavoloCroupier() {
        boolean eseguito = false;
        while(!eseguito) {
            for(Tavolo tavolo : tavoli) {
                if(!tavolo.isOccupato()) {
                    for(Impiegato impiegato : listaImpiegati) {
                        if(impiegato instanceof Croupier) {
                            if(!((Croupier) impiegato).isInGioco()) {
                                ((Croupier) impiegato).assegnaTavolo(tavolo);
                                tavolo.setProntoInizio();
                                System.out.println("Tavolo " + tavolo.getNumero() + "assegnato al Croupier " + impiegato.nome + " " + impiegato.cognome + ".");
                                ((Croupier) impiegato).setInGioco();
                                eseguito = true;
                                break;
                            }
                        }
                    }
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void trasportoSoldi(Tavolo partenza, String destinazione, double quantitaDenaro) {
        for(Impiegato impiegato : listaImpiegati) {
            if(impiegato instanceof AddettoTrasporto) {
                ((AddettoTrasporto) impiegato).trasportoSoldi(partenza, destinazione, quantitaDenaro);
            }
        }
    }
    // Altri metodi ??!?!?!?!?!
}