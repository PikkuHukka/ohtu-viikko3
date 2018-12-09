package laskin;

public class Sovelluslogiikka {

    private int tulos;
    private int edellinenTulos;

    public void plus(int luku) {
        this.edellinenTulos = this.tulos;
        tulos += luku;
    }

    public void miinus(int luku) {
        this.edellinenTulos = this.tulos;

        tulos -= luku;
    }

    public void nollaa() {
        this.edellinenTulos = this.tulos;

        tulos = 0;
    }

    public int tulos() {
        return tulos;
    }

    public int edellinenTulos() {
        return edellinenTulos;
    }
    public void undo(){
        this.tulos = this.edellinenTulos;
    }
}
