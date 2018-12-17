package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OUTER:
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
            String vastaus = scanner.nextLine();
            String v = vastaus.substring(vastaus.length() - 1);
            switch (v) {
                case "a":
                    System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                    KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja(scanner);
                    kaksinpeli.pelaa();
                    break;
                case "b":
                    System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                    KPSTekoaly yksinpeli = new KPSTekoaly(scanner);
                    yksinpeli.pelaa();
                    break;
                case "c":
                    System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                    KPSTekoaly pahaYksinpeli = new KPSTekoaly(scanner, new TekoalyParannettu(20));
                    pahaYksinpeli.pelaa();
                    break;
                default:
                    break OUTER;
            }
        }

    }
}
