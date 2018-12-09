/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author oolli
 */
public class Summa implements Komento {

    private final Sovelluslogiikka sovellus;
    private final Button undo;
    private final TextField syotekentta;
    private final Button nollaa;
    private final TextField tuloskentta;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    @Override
    public void suorita() {
        this.sovellus.plus(Integer.parseInt(syotekentta.getText()));
        this.tuloskentta.setText("" + sovellus.tulos());
        nollaa.disableProperty().set(false);
        undo.disableProperty().set(false);

    }

    @Override
    public void peru() {
        this.sovellus.undo();
        this.tuloskentta.setText("" + sovellus.tulos());
        undo.disableProperty().set(true);
    }
}
