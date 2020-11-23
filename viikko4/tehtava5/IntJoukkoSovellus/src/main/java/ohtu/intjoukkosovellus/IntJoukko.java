
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        Arrays.fill(ljono, 0);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        Arrays.fill(ljono, 0);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }


    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei saa olla negatiivinen");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kasvatuskoko ei saa olla negatiivinen");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        Arrays.fill(ljono, 0);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public void lisaa(int luku) {

        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return;
        }
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % ljono.length == 0) {
                int[] taulukkoOld;
                taulukkoOld = ljono;
                kopioiTaulukko(ljono, taulukkoOld);
                ljono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, ljono);
            }
        }
    }

    public boolean kuuluu(int luku) {
        boolean kuuluuJoukkoon = false;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                kuuluuJoukkoon = true;
            }
        }
        return kuuluuJoukkoon;
    }

    public void poista(int luku) {
        int indeksi = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                indeksi = i; //siis luku löytyy tuosta kohdasta :D
                ljono[indeksi] = 0;
                break;
            }
        }
        if (indeksi != -1) {
            for (int j = indeksi; j < alkioidenLkm - 1; j++) {
                apu = ljono[j];
                ljono[j] = ljono[j + 1];
                ljono[j + 1] = apu;
            }
            alkioidenLkm--;
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            StringBuilder tuotos = new StringBuilder("{");
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos.append(ljono[i]);
                tuotos.append(", ");
            }
            tuotos.append(ljono[alkioidenLkm - 1]);
            tuotos.append("}");
            return tuotos.toString();
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        if (taulu.length >= 0) System.arraycopy(ljono, 0, taulu, 0, taulu.length);
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int j : aTaulu) {
            x.lisaa(j);
        }
        for (int j : bTaulu) {
            x.lisaa(j);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int k : aTaulu) {
            for (int i : bTaulu) {
                if (k == i) {
                    y.lisaa(i);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int j : aTaulu) {
            z.lisaa(j);
        }
        for (int j : bTaulu) {
            z.poista(j);
        }
 
        return z;
    }
        
}
