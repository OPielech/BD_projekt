import javafx.beans.property.*;

public class Flower {
    private IntegerProperty id;
    private StringProperty typ;
    private StringProperty kolor;
    private DoubleProperty cena;

    public Flower(){
        id = new SimpleIntegerProperty();
        typ = new SimpleStringProperty();
        kolor = new SimpleStringProperty();
        cena = new SimpleDoubleProperty();
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getTyp() {
        return typ.get();
    }

    public StringProperty typProperty() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ.set(typ);
    }

    public String getKolor() {
        return kolor.get();
    }

    public StringProperty kolorProperty() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor.set(kolor);
    }

    public double getCena() {
        return cena.get();
    }

    public DoubleProperty cenaProperty() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena.set(cena);
    }
}
