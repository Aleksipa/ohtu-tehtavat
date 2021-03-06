package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected int arvo;
    protected int edellinen = 0;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    public void suorita() {
        try {
            edellinen = Integer.parseInt(tuloskentta.getText());
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            arvo = 0;
        }
    }

    public void peru() {
        sovellus.aseta(edellinen);
        try {
            edellinen = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        nayta();
    }

    public void nayta() {
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
}
