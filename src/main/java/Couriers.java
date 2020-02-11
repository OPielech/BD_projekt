import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Couriers {
    private IntegerProperty id;
    private StringProperty obslugiwane_miasto;

    public Couriers() {
        id = new SimpleIntegerProperty();
        obslugiwane_miasto = new SimpleStringProperty();
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
