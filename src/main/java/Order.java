import javafx.beans.property.*;


public class Order {
    private IntegerProperty id;
    private StringProperty id_kwiat;
    private StringProperty liczba_sztuk;
    private IntegerProperty id_ulozenie;
    private StringProperty id_dodatek;
    private StringProperty data_dostarczenia;
    private StringProperty pora_dostarczenia;
    private IntegerProperty id_klient;
    private IntegerProperty id_adresat;
    private DoubleProperty cena;
    private StringProperty sposob_zaplaty;
    private IntegerProperty id_kurier;
    private StringProperty status_zamowienia;

    public Order() {
        id = new SimpleIntegerProperty();
        id_kwiat = new SimpleStringProperty();
        liczba_sztuk = new SimpleStringProperty();
        id_ulozenie = new SimpleIntegerProperty();
        id_dodatek = new SimpleStringProperty();
        data_dostarczenia =new SimpleStringProperty();
        pora_dostarczenia =new SimpleStringProperty();
        id_klient = new SimpleIntegerProperty();
        id_adresat = new SimpleIntegerProperty();
        cena = new SimpleDoubleProperty();
        sposob_zaplaty = new SimpleStringProperty();
        id_kurier = new SimpleIntegerProperty();
        status_zamowienia = new SimpleStringProperty();
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

    public String getId_kwiat() {
        return id_kwiat.get();
    }

    public StringProperty id_kwiatProperty() {
        return id_kwiat;
    }

    public void setId_kwiat(String id_kwiat) {
        this.id_kwiat.set(id_kwiat);
    }

    public String getLiczba_sztuk() {
        return liczba_sztuk.get();
    }

    public StringProperty liczba_sztukProperty() {
        return liczba_sztuk;
    }

    public void setLiczba_sztuk(String liczba_sztuk) {
        this.liczba_sztuk.set(liczba_sztuk);
    }

    public int getId_ulozenie() {
        return id_ulozenie.get();
    }

    public IntegerProperty id_ulozenieProperty() {
        return id_ulozenie;
    }

    public void setId_ulozenie(int id_ulozenie) {
        this.id_ulozenie.set(id_ulozenie);
    }

    public String getId_dodatek() {
        return id_dodatek.get();
    }

    public StringProperty id_dodatekProperty() {
        return id_dodatek;
    }

    public void setId_dodatek(String id_dodatek) {
        this.id_dodatek.set(id_dodatek);
    }

    public String getData_dostarczenia() {
        return data_dostarczenia.get();
    }

    public StringProperty data_dostarczeniaProperty() {
        return data_dostarczenia;
    }

    public void setData_dostarczenia(String data_dostarczenia) {
        this.data_dostarczenia.set(data_dostarczenia);
    }

    public String getPora_dostarczenia() {
        return pora_dostarczenia.get();
    }

    public StringProperty pora_dostarczeniaProperty() {
        return pora_dostarczenia;
    }

    public void setPora_dostarczenia(String pora_dostarczenia) {
        this.pora_dostarczenia.set(pora_dostarczenia);
    }

    public int getId_klient() {
        return id_klient.get();
    }

    public IntegerProperty id_klientProperty() {
        return id_klient;
    }

    public void setId_klient(int id_klient) {
        this.id_klient.set(id_klient);
    }

    public int getId_adresat() {
        return id_adresat.get();
    }

    public IntegerProperty id_adresatProperty() {
        return id_adresat;
    }

    public void setId_adresat(int id_adresat) {
        this.id_adresat.set(id_adresat);
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

    public String getSposob_zaplaty() {
        return sposob_zaplaty.get();
    }

    public StringProperty sposob_zaplatyProperty() {
        return sposob_zaplaty;
    }

    public void setSposob_zaplaty(String sposob_zaplaty) {
        this.sposob_zaplaty.set(sposob_zaplaty);
    }

    public int getId_kurier() {
        return id_kurier.get();
    }

    public IntegerProperty id_kurierProperty() {
        return id_kurier;
    }

    public void setId_kurier(int id_kurier) {
        this.id_kurier.set(id_kurier);
    }

    public String getStatus_zamowienia() {
        return status_zamowienia.get();
    }

    public StringProperty status_zamowieniaProperty() {
        return status_zamowienia;
    }

    public void setStatus_zamowienia(String status_zamowienia) {
        this.status_zamowienia.set(status_zamowienia);
    }
}//end of order
