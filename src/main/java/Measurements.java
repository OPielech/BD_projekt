import javafx.beans.property.*;

public class Measurements {
    private IntegerProperty id;
    private StringProperty typ;
    private DoubleProperty cena;

    public Measurements() {
        id = new SimpleIntegerProperty();
        typ = new SimpleStringProperty();
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
