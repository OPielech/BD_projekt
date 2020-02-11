import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeAppController {

    private String login;
    private String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private DataBase dataBase;
    private EmployeeDAO employeeDAO;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Order> tableOrders;

    @FXML
    private TableColumn<Order, String> colID;

    @FXML
    private TableColumn<Order, String> colIDKwiat;

    @FXML
    private TableColumn<Order, String> colLiczbaSztuk;

    @FXML
    private TableColumn<Order, String> colIDUlozenie;

    @FXML
    private TableColumn<Order, String> colIDDodatek;

    @FXML
    private TableColumn<Order, String> colDataDostarczenia;

    @FXML
    private TableColumn<Order, String> colPoraDostarczenia;

    @FXML
    private TableColumn<Order, String> colIDKlient;

    @FXML
    private TableColumn<Order, String> colIDAdresat;

    @FXML
    private TableColumn<Order, String> colCena;

    @FXML
    private TableColumn<Order, String> colSposobZaplaty;

    @FXML
    private TableColumn<Order, String> colIDKurier;

    @FXML
    private TableColumn<Order, String> colStatusZamowienia;

    @FXML
    private TableView<Flower> tableFlowers;

    @FXML
    private TableColumn<Flower, String> colFlowersID;

    @FXML
    private TableColumn<Flower, String> colFlowersType;

    @FXML
    private TableColumn<Flower, String> colFlowerColor;

    @FXML
    private TableColumn<Flower, String> colFlowersPrice;

    @FXML
    private TableView<Couriers> tableCouriers;

    @FXML
    private TableColumn<Couriers, String> colCouriersID;

    @FXML
    private TableColumn<Couriers, String> colCouriersCity;

    @FXML
    private TableView<Measurements> tableArragements;

    @FXML
    private TableColumn<Measurements, String> colArrID;

    @FXML
    private TableColumn<Measurements, String> colArrType;

    @FXML
    private TableColumn<Measurements, String> colArrPrice;

    @FXML
    private TableView<Additions> tableAdditions;

    @FXML
    private TableColumn<Additions, String> colAddID;

    @FXML
    private TableColumn<Additions, String> colAddType;

    @FXML
    private TableColumn<Additions, String> colAddPrice;

    @FXML
    private TableView<Customer> tableClients;

    @FXML
    private TableColumn<Customer, String> colCliID;

    @FXML
    private TableColumn<Customer, String> colCliName;

    @FXML
    private TableColumn<Customer, String> colCliSurname;

    @FXML
    private TableColumn<Customer, String> colCliStreet;

    @FXML
    private TableColumn<Customer, String> colCliNumber;

    @FXML
    private TableColumn<Customer, String> colCliPost;

    @FXML
    private TableColumn<Customer, String> colCliCity;

    @FXML
    private TableView<Recipient> tableRecipients;

    @FXML
    private TableColumn<Recipient, String> colRecID;

    @FXML
    private TableColumn<Recipient, String> colRecName;

    @FXML
    private TableColumn<Recipient, String> colRecSurname;

    @FXML
    private TableColumn<Recipient, String> colRecStreet;

    @FXML
    private TableColumn<Recipient, String> colRecNumber;

    @FXML
    private TableColumn<Recipient, String> colRecPost;

    @FXML
    private TableColumn<Recipient, String> colRecCity;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCouriers;

    @FXML
    private Button btnFlowers;

    @FXML
    private Button btnArr;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCli;

    @FXML
    private Button btnRec;

    @FXML
    private Button btnSum;

    @FXML
    private TextField textFieldSum;

    @FXML
    void btnAddClicked(ActionEvent event) {

    }

    @FXML
    void btnArrClicked(ActionEvent event) {

    }

    @FXML
    void btnCliClicked(ActionEvent event) {

    }

    @FXML
    void btnCouriersClicked(ActionEvent event) {

    }

    @FXML
    void btnFlowersClicked(ActionEvent event) throws SQLException {
        try{
            dataBase = new DataBase(login, password);
            employeeDAO = new EmployeeDAO(dataBase);
            dataBase.dbConnect();
            tableFlowers.getItems().clear();
            ObservableList<Flower> flowerData = employeeDAO.showAllFlowers();
            populateFlowers(flowerData);

        } catch (SQLException e) {
            throw e;
        }

    }

    @FXML
    void btnOrdersClicked(ActionEvent event) throws SQLException {
        try{
            dataBase = new DataBase(login, password);
            employeeDAO = new EmployeeDAO(dataBase);
            dataBase.dbConnect();
            tableOrders.getItems().clear();
            ObservableList<Order> orderData = employeeDAO.showAllOrders();
            populateOrders(orderData);

        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    void btnRecClicked(ActionEvent event) {

    }

    @FXML
    void btnSumClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tableOrders != null : "fx:id=\"tableOrders\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colID != null : "fx:id=\"colID\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colIDKwiat != null : "fx:id=\"colIDKwiat\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colLiczbaSztuk != null : "fx:id=\"colLiczbaSztuk\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colIDUlozenie != null : "fx:id=\"colIDUlozenie\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colIDDodatek != null : "fx:id=\"colIDDodatek\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colDataDostarczenia != null : "fx:id=\"colDataDostarczenia\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colPoraDostarczenia != null : "fx:id=\"colPoraDostarczenia\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colIDKlient != null : "fx:id=\"colIDKlient\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colIDAdresat != null : "fx:id=\"colIDAdresat\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCena != null : "fx:id=\"colCena\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colSposobZaplaty != null : "fx:id=\"colSposobZaplaty\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colIDKurier != null : "fx:id=\"colIDKurier\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colStatusZamowienia != null : "fx:id=\"colStatusZamowienia\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert tableFlowers != null : "fx:id=\"tableFlowers\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colFlowersID != null : "fx:id=\"colFlowersID\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colFlowersType != null : "fx:id=\"colFlowersType\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colFlowerColor != null : "fx:id=\"colFlowerColor\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colFlowersPrice != null : "fx:id=\"colFlowersPrice\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert tableCouriers != null : "fx:id=\"tableCouriers\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCouriersID != null : "fx:id=\"colCouriersID\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCouriersCity != null : "fx:id=\"colCouriersCity\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert tableArragements != null : "fx:id=\"tableArragements\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colArrID != null : "fx:id=\"colArrID\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colArrType != null : "fx:id=\"colArrType\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colArrPrice != null : "fx:id=\"colArrPrice\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert tableAdditions != null : "fx:id=\"tableAdditions\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colAddID != null : "fx:id=\"colAddID\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colAddType != null : "fx:id=\"colAddType\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colAddPrice != null : "fx:id=\"colAddPrice\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert tableClients != null : "fx:id=\"tableClients\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCliID != null : "fx:id=\"colCliID\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCliName != null : "fx:id=\"colCliName\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCliSurname != null : "fx:id=\"colCliSurname\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCliStreet != null : "fx:id=\"colCliStreet\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCliNumber != null : "fx:id=\"colCliNumber\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCliPost != null : "fx:id=\"colCliPost\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colCliCity != null : "fx:id=\"colCliCity\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert tableRecipients != null : "fx:id=\"tableRecipients\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colRecID != null : "fx:id=\"colRecID\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colRecName != null : "fx:id=\"colRecName\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colRecSurname != null : "fx:id=\"colRecSurname\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colRecStreet != null : "fx:id=\"colRecStreet\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colRecNumber != null : "fx:id=\"colRecNumber\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colRecPost != null : "fx:id=\"colRecPost\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert colRecCity != null : "fx:id=\"colRecCity\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert btnOrders != null : "fx:id=\"btnOrders\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert btnCouriers != null : "fx:id=\"btnCouriers\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert btnFlowers != null : "fx:id=\"btnFlowers\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert btnArr != null : "fx:id=\"btnArr\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert btnCli != null : "fx:id=\"btnCli\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert btnRec != null : "fx:id=\"btnRec\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert btnSum != null : "fx:id=\"btnSum\" was not injected: check your FXML file 'EmployeeApp.fxml'.";
        assert textFieldSum != null : "fx:id=\"textFieldSum\" was not injected: check your FXML file 'EmployeeApp.fxml'.";

    }

    private void populateOrders(ObservableList<Order> orderData){
        tableOrders.setItems(orderData);
    }

    private void populateFlowers(ObservableList<Flower> flowerData){
        tableFlowers.setItems(flowerData);
    }

}
