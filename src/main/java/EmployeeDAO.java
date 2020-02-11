import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    private DataBase dataBase;

    public EmployeeDAO(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public ObservableList<Couriers> showAllCouriers() throws SQLException {
        String selectStmt = "SELECT * FROM kurierzy_widok;";

        try{
            ResultSet resultSet = dataBase.dbExecuteQuery(selectStmt);
            ObservableList<Couriers> couriersObservableList = getCourierList(resultSet);

            return couriersObservableList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public ObservableList<Recipient> showAllRecipients() throws SQLException {
        String selectStmt = "SELECT * FROM adresaci_widok;";

        try{
            ResultSet resultSet = dataBase.dbExecuteQuery(selectStmt);
            ObservableList<Recipient> recipientObservableList = getRecipientList(resultSet);

            return recipientObservableList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public ObservableList<Customer> showAllCustomers() throws SQLException {
        String selectStmt = "SELECT * FROM klienci_widok;";

        try{
            ResultSet resultSet = dataBase.dbExecuteQuery(selectStmt);
            ObservableList<Customer> customerObservableList = getCustomerList(resultSet);

            return customerObservableList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public ObservableList<Measurements> showAllMeasurements() throws SQLException {
        String selectStmt = "SELECT * FROM ulozenia_widok;";

        try{
            ResultSet resultSet = dataBase.dbExecuteQuery(selectStmt);
            ObservableList<Measurements> measurementsObservableList = getMeasurementsList(resultSet);

            return measurementsObservableList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public ObservableList<Additions> showAllAdditions() throws SQLException {
        String selectStmt = "SELECT * FROM dodatki_widok;";

        try{
            ResultSet resultSet = dataBase.dbExecuteQuery(selectStmt);
            ObservableList<Additions> additionsObservableList = getAdditionsList(resultSet);

            return additionsObservableList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public ObservableList<Flower> showAllFlowers() throws SQLException {
        String selectStmt = "SELECT * FROM kwiaty_widok;";

        try{
            ResultSet resultSet = dataBase.dbExecuteQuery(selectStmt);
            ObservableList<Flower> flowerList = getFlowerList(resultSet);

            return flowerList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public ObservableList<Order> showAllOrders() throws SQLException {
        String selectStmt = "SELECT * FROM zamowienia;";

        try{
            ResultSet resultSet = dataBase.dbExecuteQuery(selectStmt);
            ObservableList<Order> orderList = getOrderList(resultSet);

            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

//    public ObservableList<Double> showSum() throws SQLException {
//
//
//    }

    private ObservableList<Recipient> getRecipientList(ResultSet rs) throws SQLException {

        ObservableList<Recipient> recipientObservableList = FXCollections.observableArrayList();

        while (rs.next()) {

            Recipient recipient = new Recipient();
            recipient.setId(rs.getInt("id"));
            recipient.setImie(rs.getString("imie"));
            recipient.setNazwisko(rs.getString("nazwisko"));
            recipient.setUlica(rs.getString("ulica"));
            recipient.setNr_domu(rs.getString("nr_domu"));
            recipient.setKod_pocztowy(rs.getString("kod_pocztowy"));
            recipient.setMiasto(rs.getString("miasto"));
            recipientObservableList.add(recipient);
        }


        return recipientObservableList;
    }

    private ObservableList<Customer> getCustomerList(ResultSet rs) throws SQLException {

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        while (rs.next()) {

            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setImie(rs.getString("imie"));
            customer.setNazwisko(rs.getString("nazwisko"));
            customer.setUlica(rs.getString("ulica"));
            customer.setNr_domu(rs.getString("nr_domu"));
            customer.setKod_pocztowy(rs.getString("kod_pocztowy"));
            customer.setMiasto(rs.getString("miasto"));
            customerObservableList.add(customer);
        }


        return customerObservableList;
    }

    private ObservableList<Couriers> getCourierList(ResultSet rs) throws SQLException {

        ObservableList<Couriers> couriersObservableList = FXCollections.observableArrayList();

        while (rs.next()) {

            Couriers couriers = new Couriers();
            couriers.setId(rs.getInt("id"));
            couriers.setObslugiwane_miasto(rs.getString("obslugiwane_miasto"));
            couriersObservableList.add(couriers);
        }
        return couriersObservableList;
    }

    private ObservableList<Measurements> getMeasurementsList(ResultSet rs) throws SQLException {

        ObservableList<Measurements> measurementsList = FXCollections.observableArrayList();

        while (rs.next()) {

            Measurements measurements = new Measurements();
            measurements.setId(rs.getInt("id"));
            measurements.setTyp(rs.getString("typ"));
            measurements.setCena(rs.getDouble("cena"));
            measurementsList.add(measurements);

        }


        return measurementsList;
    }

    private ObservableList<Additions> getAdditionsList(ResultSet rs) throws SQLException {

        ObservableList<Additions> additionsList = FXCollections.observableArrayList();

        while (rs.next()) {

            Additions additions = new Additions();
            additions.setId(rs.getInt("ID"));
            additions.setTyp(rs.getString("typ"));
            additions.setCena(rs.getDouble("cena"));
            additionsList.add(additions);

        }


        return additionsList;
    }

    private ObservableList<Flower> getFlowerList(ResultSet rs) throws SQLException {

        ObservableList<Flower> flowerList = FXCollections.observableArrayList();

        while (rs.next()) {

            Flower flower = new Flower();
            flower.setId(rs.getInt("id"));
            flower.setTyp(rs.getString("typ"));
            flower.setKolor(rs.getString("kolor"));
            flower.setCena(rs.getDouble("cena"));
            flowerList.add(flower);

        }


        return flowerList;
    }

    private ObservableList<Order> getOrderList(ResultSet rs) throws SQLException {

        ObservableList<Order> orderList = FXCollections.observableArrayList();

        while (rs.next()) {

            Order order = new Order();
            order.setId(rs.getInt("ID"));
            order.setId_kwiat(rs.getString("id_kwiat"));
            order.setLiczba_sztuk(rs.getString("liczba_sztuk"));
            order.setId_ulozenie(rs.getInt("id_ulozenie"));
            order.setId_dodatek(rs.getString("id_dodatek"));
            order.setData_dostarczenia(rs.getString("data_dostarczenia"));
            order.setPora_dostarczenia(rs.getString("pora_dostarczenia"));
            order.setId_klient(rs.getInt("id_klient"));
            order.setId_adresat(rs.getInt("id_adresat"));
            order.setCena(rs.getDouble("cena"));
            order.setSposob_zaplaty(rs.getString("sposob_zaplaty"));
            order.setId_kurier(rs.getInt("id_kurier"));
            order.setStatus_zamowienia(rs.getString("status_zamowienia"));

            orderList.add(order);

        }


        return orderList;
    }


}//end of class
