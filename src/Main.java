import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inizio Casino!");
        // gestione caveau con cassaforte
        Cassaforte cassaforte = new Cassaforte();
        Caveau caveau = new Caveau(1000000, cassaforte);

        GestorePersonale gestorePersonale = new GestorePersonale();
        // gestione croupiers
        List<Croupier> Croupiers = new ArrayList<>();
        Croupier c1 = new Croupier("C", "1", 124, 1500, "Croupier", null, gestorePersonale);
        Croupier c2 = new Croupier("C", "2", 125, 1500, "Croupier", null, gestorePersonale);
        Croupier c3 = new Croupier("C", "3", 126, 1500, "Croupier", null, gestorePersonale);
        gestorePersonale.aggiungiImpiegato(c1);
        gestorePersonale.aggiungiImpiegato(c2);
        gestorePersonale.aggiungiImpiegato(c3);

        //gestione tavoli
        Tavolo t1 = new Tavolo(1, 3);
        Tavolo t2 = new Tavolo(2, 5);
        Tavolo t3 = new Tavolo(3, 5);
        gestorePersonale.aggiungiTavolo(t1);
        gestorePersonale.aggiungiTavolo(t2);
        gestorePersonale.aggiungiTavolo(t3);

        // gestione addetto trasporto
        AddettoTrasporto ad = new AddettoTrasporto("A", "T", 455, 1500, "Addetto Trasporto", caveau);
        gestorePersonale.aggiungiImpiegato(ad);

        // gestione giocatori
        Giocatore g1 = new Giocatore("G", "1", 456);
        Giocatore g2 = new Giocatore("G", "2", 457);
        Giocatore g3 = new Giocatore("G", "3", 458);
        Giocatore g4 = new Giocatore("G", "4", 459);
        Giocatore g5 = new Giocatore("G", "5", 460);
        Giocatore g6 = new Giocatore("G", "6", 461);
        t1.aggiungiGiocatore(g1);
        t1.aggiungiGiocatore(g2);
        t1.aggiungiGiocatore(g3);
        t1.aggiungiGiocatore(g4);
        t1.aggiungiGiocatore(g5);
        t1.aggiungiGiocatore(g6);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        c1.start();
        ad.start();
        gestorePersonale.start();
        c1.join();
    }
}