import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        Caveau caveau = new Caveau(100000, new Cassaforte());
        GestorePersonale gestorePersonale = new GestorePersonale();
        List<Croupier> Croupiers = new ArrayList<>();
        AddettoTrasporto ad = new AddettoTrasporto("Mario", "verdi", 123, 1500, "Addetto Trasporto", caveau);
        Croupier c1 = new Croupier("Mario", "Rossi", 123, 1500, "Croupier", null, gestorePersonale);
        gestorePersonale.aggiungiImpiegato(c1);
        Tavolo t1 = new Tavolo(1, 5);
        gestorePersonale.aggiungiTavolo(t1);
        gestorePersonale.assegnaTavoloCroupier();
    }
}