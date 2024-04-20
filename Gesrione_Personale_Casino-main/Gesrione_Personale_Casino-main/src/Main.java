import java.util.List;

// Version: 1.0
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inizio Casino!");
        // gestione caveau con cassaforte
        Cassaforte cassaforte = new Cassaforte();
        Caveau caveau = new Caveau(1000000, cassaforte);

        GestorePersonale gestorePersonale = new GestorePersonale();
        // gestione croupiers
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

        // gestione ladri
        Ladro l1 = new Ladro("L", "1", 123, cassaforte);
        Ladro l2 = new Ladro("L", "2", 124, cassaforte);
        Ladro l3 = new Ladro("L", "3", 125, cassaforte);
        List<Ladro> ladri = List.of(l1, l2, l3);
        l1.start();
        l2.start();
        l3.start();

        // gestione addetto trasporto
        AddettoTrasporto ad = new AddettoTrasporto("A", "T", 455, 1500, "Addetto Trasporto", cassaforte, new int[]{8, 20}, ladri, caveau);
        gestorePersonale.aggiungiImpiegato(ad);

        // gestione bodyguard
        Bodyguard b1 = new Bodyguard("B", "1", 451, 1500, "Area 1", new int[]{8, 20}, cassaforte, ladri);
        Bodyguard b2 = new Bodyguard("B", "2", 452, 1500, "Area 2", new int[]{20, 8}, cassaforte, ladri);
        Bodyguard b3 = new Bodyguard("B", "3", 453, 1500, "Area 3", new int[]{8, 20}, cassaforte, ladri);
        gestorePersonale.aggiungiImpiegato(b1);
        gestorePersonale.aggiungiImpiegato(b2);
        gestorePersonale.aggiungiImpiegato(b3);
        b1.assegnaAreaResponsabilita("bagni");
        b2.assegnaAreaResponsabilita("ingresso");
        b3.assegnaAreaResponsabilita("sale gioco");
        b1.start();
        b2.start();
        b3.start();
        b1.assegnaCompito(500);
        b3.assegnaCompito(1000);

        // gestione giocatori
        Giocatore g1 = new Giocatore("G", "1", 456, 100000);
        Giocatore g2 = new Giocatore("G", "2", 457, 100000);
        Giocatore g3 = new Giocatore("G", "3", 458, 100000);
        Giocatore g4 = new Giocatore("G", "4", 459, 100000);
        Giocatore g5 = new Giocatore("G", "5", 460, 100000);
        Giocatore g6 = new Giocatore("G", "6", 461, 100000);
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