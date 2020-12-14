package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {
    private static final Scanner scanner = new Scanner(System.in);

        Tekoaly tekoaly = new Tekoaly();
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
