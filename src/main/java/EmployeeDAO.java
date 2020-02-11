import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    private DataBase dataBase;

    public EmployeeDAO(DataBase dataBase) {
        this.dataBase = dataBase;
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

    private ObservableList<Flower> getFlowerList(ResultSet rs) throws SQLException {

        ObservableList<Flower> flowerList = FXCollections.observableArrayList();

        while (rs.next()) {

            Flower flower = new Flower();
            flower.setId(rs.getInt("ID"));
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
