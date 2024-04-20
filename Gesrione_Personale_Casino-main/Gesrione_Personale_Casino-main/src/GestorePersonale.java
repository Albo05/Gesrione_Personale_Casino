
// Classe GestorePersonale
import java.util.ArrayList;
import java.util.List;

public class GestorePersonale extends Thread{
    private List<Impiegato> listaImpiegati;
    private List<Tavolo> tavoli;
    private boolean continua;
    private List<Integer> matricole;

    public GestorePersonale() {
        listaImpiegati = new ArrayList<>();
        tavoli = new ArrayList<>();
        this.continua = true;
        matricole = new ArrayList<Integer>();
        matricole.add(455);matricole.add(456);matricole.add(457);matricole.add(458);
        matricole.add(459);matricole.add(460);matricole.add(461);
    }

    public void aggiungiImpiegato(Impiegato impiegato) {
        listaImpiegati.add(impiegato);
    }
    public List<Impiegato> getListaImpiegati() {
        return listaImpiegati;
    }
    public void aggiungiTavolo(Tavolo tavolo) { tavoli.add(tavolo); }

    public void rimuoviImpiegato(int matricola) {
        listaImpiegati.removeIf(impiegato -> impiegato.matricola == matricola);
    }

    public boolean cercaImpiegato(int matricola) {
        return matricole.contains(matricola);
    }

    public void run() {
        System.out.println("Gestore) Il gestore del personale ha iniziato a lavorare");
        while(continua) {
            assegnaTavoloCroupier();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("x");
        }
    }
    public void assegnaTavoloCroupier() {
        boolean eseguito = false;
        while(!eseguito) {
            for (Tavolo tavolo : tavoli) {
                if (tavolo.isProntoInizio() && !tavolo.isInGioco()) {
                    for (Impiegato impiegato : listaImpiegati) {
                        if (impiegato instanceof Croupier) {
                            if (!((Croupier) impiegato).isInGioco()) {
                                ((Croupier) impiegato).assegnaTavolo(tavolo);
                                System.out.println("Gestore Personale) Tavolo " + tavolo.getNumero() + "assegnato al Croupier " + impiegato.nome + " " + impiegato.cognome);
                                ((Croupier) impiegato).setInGioco();
                                tavolo.setInGioco(true);
                                eseguito = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}