import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Recipient {
    private IntegerProperty id;
    private StringProperty imie;
    private StringProperty nazwisko;
    private StringProperty ulica;
    private StringProperty nr_domu;
    private StringProperty kod_pocztowy;
    private StringProperty miasto;

    public Recipient(IntegerProperty id, StringProperty imie, StringProperty nazwisko, StringProperty ulica, StringProperty nr_domu, StringProperty kod_pocztowy, StringProperty miasto) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.kod_pocztowy = kod_pocztowy;
        this.miasto = miasto;
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

    public String getImie() {
        return imie.get();
    }

    public StringProperty imieProperty() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public StringProperty nazwiskoProperty() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public String getUlica() {
        return ulica.get();
    }

    public StringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }

    public String getNr_domu() {
        return nr_domu.get();
    }

    public StringProperty nr_domuProperty() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu.set(nr_domu);
    }

    public String getKod_pocztowy() {
        return kod_pocztowy.get();
    }

    public StringProperty kod_pocztowyProperty() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy.set(kod_pocztowy);
    }

    public String getMiasto() {
        return miasto.get();
    }

    public StringProperty miastoProperty() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto.set(miasto);
    }

}
