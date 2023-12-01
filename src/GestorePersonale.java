
// Classe GestorePersonale
import java.util.ArrayList;
import java.util.List;

public class GestorePersonale {
    private List<Impiegato> listaImpiegati;

    public GestorePersonale() {
        listaImpiegati = new ArrayList<>();
    }

    public void aggiungiImpiegato(Impiegato impiegato) {
        listaImpiegati.add(impiegato);
    }

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

    // Altri metodi ??!?!?!?!?!
}