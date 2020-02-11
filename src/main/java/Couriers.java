import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Couriers {
    private IntegerProperty id;
    private StringProperty obslugiwane_miasto;

    public Couriers(IntegerProperty id, StringProperty obslugiwane_miasto) {
        this.id = id;
        this.obslugiwane_miasto = obslugiwane_miasto;
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

    public String getObslugiwane_miasto() {
        return obslugiwane_miasto.get();
    }

    public StringProperty obslugiwane_miastoProperty() {
        return obslugiwane_miasto;
    }

    public void setObslugiwane_miasto(String obslugiwane_miasto) {
        this.obslugiwane_miasto.set(obslugiwane_miasto);
    }
}
