import javafx.beans.property.DoubleProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    private DataBase dataBase;
    private boolean isInsertCustomerOk;
    private boolean isInsertRecipientOk;
    private boolean isInsertOrderOk;

    public boolean isInsertCustomerOk() {
        return isInsertCustomerOk;
    }

    public boolean isInsertRecipientOk() {
        return isInsertRecipientOk;
    }

    public boolean isInsertOrderOk() {
        return isInsertOrderOk;
    }

    public CustomerDAO(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void insertCustomer (String name, String surname, String street, String houseNumber, String postcode, String city){

        StringBuilder stringBuilder = new StringBuilder("INSERT INTO klienci(imie, nazwisko, ulica, nr_domu, kod_pocztowy, miasto) VALUES (");
        stringBuilder.append("\""+name+"\", ");
        stringBuilder.append("\""+surname+"\", ");
        stringBuilder.append("\""+street+"\", ");
        stringBuilder.append("\""+houseNumber+"\", ");
        stringBuilder.append("\""+postcode+"\", ");
        stringBuilder.append("\""+city+"\");");

        String insertStmt = stringBuilder.toString();

        try{
            dataBase.dbExecuteUpdate(insertStmt);
            isInsertCustomerOk = true;
        } catch (SQLException e) {
            isInsertCustomerOk = false;
            e.printStackTrace();
        }
    }//end of insertCustomer

    public void insertRecipient (String name, String surname, String street, String houseNumber, String postcode, String city){

        StringBuilder stringBuilder = new StringBuilder("INSERT INTO adresaci(imie, nazwisko, ulica, nr_domu, kod_pocztowy, miasto) VALUES (");
        stringBuilder.append("\""+name+"\", ");
        stringBuilder.append("\""+surname+"\", ");
        stringBuilder.append("\""+street+"\", ");
        stringBuilder.append("\""+houseNumber+"\", ");
        stringBuilder.append("\""+postcode+"\", ");
        stringBuilder.append("\""+city+"\");");

        String insertStmt = stringBuilder.toString();

        try{
            dataBase.dbExecuteUpdate(insertStmt);
            isInsertRecipientOk = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isInsertRecipientOk = false;
        }
    }//end of insertRecipient

    public void insertOrder (String idFlower, String number, int idArrangement, String idAddition,
                             String date, String time, int idCustomer, int idRecipient, double Price, String payment,
                             String status){

        StringBuilder stringBuilder = new StringBuilder("INSERT INTO zamowienia(id_kwiat, liczba_sztuk, id_ulozenie" +
                ", id_dodatek, data_dostarczenia, pora_dostarczenia, id_klient, id_adresat, cena, sposob_zaplaty, status_zamowienia) VALUES (");
        stringBuilder.append("\""+idFlower+"\", ");
        stringBuilder.append("\""+number+"\", ");
        stringBuilder.append(idArrangement+", ");
        stringBuilder.append(idAddition+", ");
        stringBuilder.append("\""+date+"\", ");
        stringBuilder.append("\""+time+"\", ");
        stringBuilder.append(idCustomer+", ");
        stringBuilder.append(idRecipient+", ");
        stringBuilder.append(Price+", ");
        stringBuilder.append("\""+payment+"\", ");
        stringBuilder.append("\""+status+"\");");

        String insertStmt = stringBuilder.toString();

        try{
            dataBase.dbExecuteUpdate(insertStmt);
            isInsertOrderOk = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isInsertOrderOk = false;
        }

    }//end of insertOrder

}//end of class
