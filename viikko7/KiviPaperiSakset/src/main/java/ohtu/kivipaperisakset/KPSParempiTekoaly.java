package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {
    private static final Scanner scanner = new Scanner(System.in);

    TekoalyParannettu tekoaly = new TekoalyParannettu(20);
    String tokanSiirto;

    @Override
    protected String toisenSiirto() {
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }

    @Override
    protected void asetaSiirto (String siirto){
        tekoaly.asetaSiirto(siirto);
    }
}
