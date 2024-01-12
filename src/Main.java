import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Invio with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
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
        // Press Maiusc+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Maiusc+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }
}