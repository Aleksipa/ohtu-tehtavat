package ohtu.kivipaperisakset;

public class Pelit {

    public static void KPSPelaajaVsPelaaja() {
        KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
        kaksinpeli.pelaa();
    }

    public static void KPSTekoaly() {
        KPSTekoaly yksinpeli = new KPSTekoaly();
        yksinpeli.pelaa();
    }

    public static void KPSParempiTekoaly() {
        KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
        pahaYksinpeli.pelaa();
    }
}



