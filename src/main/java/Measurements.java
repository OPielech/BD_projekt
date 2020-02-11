import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Measurements {
    private IntegerProperty id;
    private StringProperty typ;
    private DoubleProperty cena;

    public Measurements(IntegerProperty id, StringProperty typ, DoubleProperty cena) {
        this.id = id;
        this.typ = typ;
        this.cena = cena;
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
