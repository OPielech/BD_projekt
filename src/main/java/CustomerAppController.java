import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerAppController {

    private String login;
    private String password;
    DataBase dataBase;
    CustomerDAO customerDAO;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private double price;
    private String idFlower1;
    private String idFlower2;
    private String idFlower3;
    private String idFlower4;

    private String numberFlower1;
    private String numberFlower2;
    private String numberFlower3;
    private String numberFlower4;

    private int idArrangement;
    private int idAddition;
    private int id = 1;
    private String orderStatus = "oplacone";


    private String typeOfFlower1;
    private String typeOfFlower2;
    private String typeOfFlower3;
    private String typeOfFlower4;
    private String colorOfFlower1;
    private String colorOfFlower2;
    private String colorOfFlower3;
    private String colorOfFlower4;
    private String numberOfFlower1;
    private String numberOfFlower2;
    private String numberOfFlower3;
    private String numberOfFlower4;
    private String addition1;
    private String addition2;
    private String addition3;
    private String arrangement;
    private String paymentMethod;
    private String time;
    private String date;

    private String nameCu;
    private String surnameCu;
    private String streetCu;
    private String houseNumberCu;
    private String postcodeCu;
    private String cityCu;
    private String nameRe;
    private String surnameRe;
    private String streetRe;
    private String houseNumberRe;
    private String postcodeRe;
    private String cityRe;

    private boolean isNameCuOk;
    private boolean isSurnameCuOk;
    private boolean isStreetCuOk;
    private boolean isHouseNumberCuOk;
    private boolean isPostcodeCuOk;
    private boolean isCityCuOk;
    private boolean isNameReOk;
    private boolean isSurnameReOk;
    private boolean isStreetReOk;
    private boolean isHouseNumberReOk;
    private boolean isPostcodeReOk;
    private boolean isCityReOk;
    private boolean isDateOk;
    private boolean isItemOk;
    private boolean isApplied;

    ObservableList<String> typeOfFlowers = FXCollections.observableArrayList("Rose", "Tulip", "Gillyflower", "Lily", "Eustoma");
    ObservableList<String> colorOfFlowers = FXCollections.observableArrayList("Red", "White", "Orange", "Yellow", "Pink");
    ObservableList<String> numberOfFlowers = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    ObservableList<String> additions = FXCollections.observableArrayList(
            "Chocolates", "Red wine", "White wine", "Sparkling wine", "Teddy bear", "Balloon", "Coffee", "Name card",
            "Birthday card", "Wedding card");
    ObservableList<String> arrangements = FXCollections.observableArrayList("Round", "Gradation", "Basket", "Vase");
    ObservableList<String> paymentMethods = FXCollections.observableArrayList("Credit card", "Transfer", "PayPal", "Blik", "Voucher");
    ObservableList<String> times = FXCollections.observableArrayList("6 - 9", "9 - 12", "12 - 15", "15 - 18", "18 - 22");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private ChoiceBox<String> choiceBoxPayment;

    @FXML
    private ChoiceBox<String> choiceBoxType1;

    @FXML
    private ChoiceBox<String> choiceBoxColor1;

    @FXML
    private ChoiceBox<String> choiceBoxAmount1;

    @FXML
    private ChoiceBox<String> choiceBoxType2;

    @FXML
    private ChoiceBox<String> choiceBoxColor2;

    @FXML
    private ChoiceBox<String> choiceBoxAmount2;

    @FXML
    private ChoiceBox<String> choiceBoxType3;

    @FXML
    private ChoiceBox<String> choiceBoxColor3;

    @FXML
    private ChoiceBox<String> choiceBoxAmount3;

    @FXML
    private ChoiceBox<String> choiceBoxType4;

    @FXML
    private ChoiceBox<String> choiceBoxColor4;

    @FXML
    private ChoiceBox<String> choiceBoxAmount4;

    @FXML
    private ChoiceBox<String> choiceBoxArrangement;

    @FXML
    private ChoiceBox<String> choiceBoxAddition1;

    @FXML
    private ChoiceBox<String> choiceBoxAddition2;

    @FXML
    private ChoiceBox<String> choiceBoxAddition3;

    @FXML
    private TextField textFieldDate;

    @FXML
    private ChoiceBox<String> choiceBoxTime;

    @FXML
    private TextField textFieldPrize;

    @FXML
    private Button btnApply;

    @FXML
    private Button btnClose;

    @FXML
    private TextField textFieldNameCu;

    @FXML
    private TextField textFieldSurnameCu;

    @FXML
    private TextField textFieldStreetCu;

    @FXML
    private TextField textFieldHouseNumberCu;

    @FXML
    private TextField textFieldPostcodeCu;

    @FXML
    private TextField textFieldCityCu;

    @FXML
    private TextField textFieldNameRe;

    @FXML
    private TextField textFieldSurnameRe;

    @FXML
    private TextField textFieldStreetRe;

    @FXML
    private TextField textFieldHouseNumberRe;

    @FXML
    private TextField textFieldPostcodeRe;

    @FXML
    private TextField textFieldCityRe;

    @FXML
    private TextArea textArea;

    @FXML
    void btnApplyClicked(ActionEvent event) {
        if (!isApplied)
            getOrder();
    }

    @FXML
    void btnCloseClicked(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert choiceBoxType1 != null : "fx:id=\"choiceBoxType1\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxColor1 != null : "fx:id=\"choiceBoxColor1\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxAmount1 != null : "fx:id=\"choiceBoxAmount1\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxType2 != null : "fx:id=\"choiceBoxType2\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxColor2 != null : "fx:id=\"choiceBoxColor2\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxAmount2 != null : "fx:id=\"choiceBoxAmount2\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxType3 != null : "fx:id=\"choiceBoxType3\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxColor3 != null : "fx:id=\"choiceBoxColor3\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxAmount3 != null : "fx:id=\"choiceBoxAmount3\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxType4 != null : "fx:id=\"choiceBoxType4\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxColor4 != null : "fx:id=\"choiceBoxColor4\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxAmount4 != null : "fx:id=\"choiceBoxAmount4\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxArrangement != null : "fx:id=\"choiceBoxArrangement\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxAddition1 != null : "fx:id=\"choiceBoxAddition1\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxAddition2 != null : "fx:id=\"choiceBoxAddition2\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxAddition3 != null : "fx:id=\"choiceBoxAddition3\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldDate != null : "fx:id=\"textFieldDate\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxTime != null : "fx:id=\"choiceBoxTime\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldPrize != null : "fx:id=\"textFieldPrize\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert btnApply != null : "fx:id=\"btnApply\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert choiceBoxPayment != null : "fx:id=\"choiceBoxPayment\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldNameCu != null : "fx:id=\"textFieldNameCu\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldSurnameCu != null : "fx:id=\"textFieldSurnameCu\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldStreetCu != null : "fx:id=\"textFieldStreetCu\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldHouseNumberCu != null : "fx:id=\"textFieldHouseNumberCu\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldPostcodeCu != null : "fx:id=\"textFieldPostcodeCu\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldCityCu != null : "fx:id=\"textFieldCityCu\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldNameRe != null : "fx:id=\"textFieldNameRe\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldSurnameRe != null : "fx:id=\"textFieldSurnameRe\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldStreetRe != null : "fx:id=\"textFieldStreetRe\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldHouseNumberRe != null : "fx:id=\"textFieldHouseNumberRe\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldPostcodeRe != null : "fx:id=\"textFieldPostCodeRe\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textFieldCityRe != null : "fx:id=\"textFieldCityRe\" was not injected: check your FXML file 'CustomerApp.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'CustomerApp.fxml'.";

        choiceBoxAddition1.setItems(additions);
        choiceBoxAddition2.setItems(additions);
        choiceBoxAddition3.setItems(additions);
        choiceBoxAmount1.setItems(numberOfFlowers);
        choiceBoxAmount2.setItems(numberOfFlowers);
        choiceBoxAmount3.setItems(numberOfFlowers);
        choiceBoxAmount4.setItems(numberOfFlowers);
        choiceBoxArrangement.setItems(arrangements);
        choiceBoxColor1.setItems(colorOfFlowers);
        choiceBoxColor2.setItems(colorOfFlowers);
        choiceBoxColor3.setItems(colorOfFlowers);
        choiceBoxColor4.setItems(colorOfFlowers);
        choiceBoxPayment.setItems(paymentMethods);
        choiceBoxTime.setItems(times);
        choiceBoxType1.setItems(typeOfFlowers);
        choiceBoxType2.setItems(typeOfFlowers);
        choiceBoxType3.setItems(typeOfFlowers);
        choiceBoxType4.setItems(typeOfFlowers);

    }

    public void getOrder() {
        try {
            typeOfFlower1 = choiceBoxType1.getValue();
            typeOfFlower2 = choiceBoxType2.getValue();
            typeOfFlower3 = choiceBoxType3.getValue();
            typeOfFlower4 = choiceBoxType4.getValue();
            colorOfFlower1 = choiceBoxColor1.getValue();
            colorOfFlower2 = choiceBoxColor2.getValue();
            colorOfFlower3 = choiceBoxColor3.getValue();
            colorOfFlower4 = choiceBoxColor4.getValue();
            numberOfFlower1 = choiceBoxAmount1.getValue();
            numberOfFlower2 = choiceBoxAmount2.getValue();
            numberOfFlower3 = choiceBoxAmount3.getValue();
            numberOfFlower4 = choiceBoxAmount4.getValue();
            addition1 = choiceBoxAddition1.getValue();
            addition2 = choiceBoxAddition2.getValue();
            addition3 = choiceBoxAddition3.getValue();
            arrangement = choiceBoxArrangement.getValue();
            paymentMethod = choiceBoxPayment.getValue();
            time = choiceBoxTime.getValue();

            if (typeOfFlower1.isEmpty() || colorOfFlower1.isEmpty() || numberOfFlower1.isEmpty()
                    || arrangement.isEmpty() || time.isEmpty() || paymentMethod.isEmpty())
                throw new NullPointerException();
            else
                isItemOk = true;

        } catch (NullPointerException e) {
            textArea.appendText("Please choose values in following fields:\n-flower\n-arrangement\n-date\n-time\n-payment");
        }

        try {
            nameCu = textFieldNameCu.getText();
            if (nameCu.isEmpty())
                throw new NullPointerException();
            else
                isNameCuOk = true;

            surnameCu = textFieldSurnameCu.getText();
            if (surnameCu.isEmpty()) {
                throw new NullPointerException();
            } else
                isSurnameCuOk = true;

            streetCu = textFieldStreetCu.getText();
            if (streetCu.isEmpty()) {
                throw new NullPointerException();
            } else
                isStreetCuOk = true;

            houseNumberCu = textFieldHouseNumberCu.getText();
            if (houseNumberCu.isEmpty()) {
                throw new NullPointerException();
            } else
                isHouseNumberCuOk = true;

            postcodeCu = textFieldPostcodeCu.getText();
            if (postcodeCu.isEmpty()) {
                throw new NullPointerException();
            } else
                isPostcodeCuOk = true;

            cityCu = textFieldCityCu.getText();
            if (cityCu.isEmpty()) {
                throw new NullPointerException();
            } else
                isCityCuOk = true;

            nameRe = textFieldNameRe.getText();
            if (nameRe.isEmpty())
                throw new NullPointerException();
            else
                isNameReOk = true;

            surnameRe = textFieldSurnameRe.getText();
            if (surnameRe.isEmpty()) {
                throw new NullPointerException();
            } else
                isSurnameReOk = true;

            streetRe = textFieldStreetRe.getText();
            if (streetRe.isEmpty()) {
                throw new NullPointerException();
            } else
                isStreetReOk = true;

            houseNumberRe = textFieldHouseNumberRe.getText();
            if (houseNumberRe.isEmpty()) {
                throw new NullPointerException();
            } else
                isHouseNumberReOk = true;

            postcodeRe = textFieldPostcodeRe.getText();
            if (postcodeRe.isEmpty()) {
                throw new NullPointerException();
            } else
                isPostcodeReOk = true;

            cityRe = textFieldCityRe.getText();
            if (cityRe.isEmpty()) {
                throw new NullPointerException();
            } else
                isCityReOk = true;

            date = textFieldDate.getText();
            if (date.isEmpty()) {
                throw new NullPointerException();
            } else
                isDateOk = true;

        } catch (NullPointerException e) {
            textFieldNameCu.setPromptText("Please enter value");
            textFieldSurnameCu.setPromptText("Please enter value");
            textFieldStreetCu.setPromptText("Please enter value");
            textFieldHouseNumberCu.setPromptText("Please enter value");
            textFieldPostcodeCu.setPromptText("Please enter value");
            textFieldCityCu.setPromptText("Please enter value");
            textFieldNameRe.setPromptText("Please enter value");
            textFieldSurnameRe.setPromptText("Please enter value");
            textFieldStreetRe.setPromptText("Please enter value");
            textFieldHouseNumberRe.setPromptText("Please enter value");
            textFieldPostcodeRe.setPromptText("Please enter value");
            textFieldCityRe.setPromptText("Please enter value");
            textFieldDate.setPromptText("Please enter value");
        }


        if (isNameCuOk && isSurnameCuOk && isStreetCuOk && isHouseNumberCuOk && isPostcodeCuOk && isCityCuOk &&
                isNameReOk && isSurnameReOk && isStreetReOk && isHouseNumberReOk && isPostcodeReOk &&
                isCityReOk && isDateOk && isItemOk) {

            try {
                isApplied = true;
                textArea.setText("Order successfully applied!!! \nPress close and make next order");
                textFieldPrize.setText(String.valueOf(getPrice()));
                dataBase = new DataBase(login, password);
                customerDAO = new CustomerDAO(dataBase);
                dataBase.dbConnect();
                customerDAO.insertCustomer(nameCu, surnameCu, streetCu, houseNumberCu, postcodeCu, cityCu);
                customerDAO.insertRecipient(nameRe,surnameRe,streetRe,houseNumberRe,postcodeRe,cityRe);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public double getPrice(){
        double price = 0;
        double[] prices = {5, 3, 2.5, 3, 2, 35, 30, 25, 20, 15, 10};

        if (typeOfFlower1.equals("Rose"))
            price+=prices[0]*Integer.parseInt(numberOfFlower1);
        else if(typeOfFlower1.equals("Tulip"))
            price+=prices[1]*Integer.parseInt(numberOfFlower1);
        else if(typeOfFlower1.equals("Gillyflower"))
            price+=prices[2]*Integer.parseInt(numberOfFlower1);
        else if(typeOfFlower1.equals("Lily"))
            price+=prices[3]*Integer.parseInt(numberOfFlower1);
        else
            price+=prices[4]*Integer.parseInt(numberOfFlower1);

        if (typeOfFlower2.equals("Rose"))
            price+=prices[0]*Integer.parseInt(numberOfFlower2);
        else if(typeOfFlower2.equals("Tulip"))
            price+=prices[1]*Integer.parseInt(numberOfFlower2);
        else if(typeOfFlower2.equals("Gillyflower"))
            price+=prices[2]*Integer.parseInt(numberOfFlower2);
        else if(typeOfFlower2.equals("Lily"))
            price+=prices[3]*Integer.parseInt(numberOfFlower2);
        else
            price+=prices[4]*Integer.parseInt(numberOfFlower2);

        if (typeOfFlower3.equals("Rose"))
            price+=prices[0]*Integer.parseInt(numberOfFlower3);
        else if(typeOfFlower3.equals("Tulip"))
            price+=prices[1]*Integer.parseInt(numberOfFlower3);
        else if(typeOfFlower3.equals("Gillyflower"))
            price+=prices[2]*Integer.parseInt(numberOfFlower3);
        else if(typeOfFlower3.equals("Lily"))
            price+=prices[3]*Integer.parseInt(numberOfFlower3);
        else
            price+=prices[4]*Integer.parseInt(numberOfFlower3);

        if (typeOfFlower4.equals("Rose"))
            price+=prices[0]*Integer.parseInt(numberOfFlower4);
        else if(typeOfFlower4.equals("Tulip"))
            price+=prices[1]*Integer.parseInt(numberOfFlower4);
        else if(typeOfFlower4.equals("Gillyflower"))
            price+=prices[2]*Integer.parseInt(numberOfFlower4);
        else if(typeOfFlower4.equals("Lily"))
            price+=prices[3]*Integer.parseInt(numberOfFlower4);
        else
            price+=prices[4]*Integer.parseInt(numberOfFlower4);

        if(arrangement.equals("Basket"))
            price+=prices[5];
        else if(arrangement.equals("Vase"))
            price+=prices[6];

        if (addition1.equals("Chocolates"))
            price+=prices[7];
        else if(addition1.equals("Red Wine"))
            price+=prices[8];
        else if(addition1.equals("White Wine"))
            price+=prices[8];
        else if(addition1.equals("Sparkling Wine"))
            price+=prices[8];
        else if(addition1.equals("Teddy bear"))
            price+=prices[7];
        else if(addition1.equals("Balloon"))
            price+=prices[9];
        else if(addition1.equals("Coffee"))
            price+=prices[7];
        else if(addition1.equals("Name card"))
            price+=prices[10];
        else if(addition1.equals("Birthday card"))
            price+=prices[10];
        else
            price+=prices[10];

        if(time.equals("18 - 22"))
            price+=prices[1];

        return price;
    }

    public String getIdFlower(){
        if (typeOfFlower1.equals("Rose") && colorOfFlower1.equals("Red"))
            idFlower1 = "1";
        else if (typeOfFlower1.equals("Rose") && colorOfFlower1.equals("White"))
            idFlower1 = "2";
        else if (typeOfFlower1.equals("Rose") && colorOfFlower1.equals("Orange"))
            idFlower1 = "3";
        else if (typeOfFlower1.equals("Rose") && colorOfFlower1.equals("Yellow"))
            idFlower1 = "4";
        else if (typeOfFlower1.equals("Rose") && colorOfFlower1.equals("Pink"))
            idFlower1 = "5";
        else if (typeOfFlower1.equals("Tulip") && colorOfFlower1.equals("Red"))
            idFlower1 = "6";
        else if (typeOfFlower1.equals("Tulip") && colorOfFlower1.equals("White"))
            idFlower1 = "7";
        else if (typeOfFlower1.equals("Tulip") && colorOfFlower1.equals("Orange"))
            idFlower1 = "8";
        else if (typeOfFlower1.equals("Tulip") && colorOfFlower1.equals("Yellow"))
            idFlower1 = "9";
        else if (typeOfFlower1.equals("Tulip") && colorOfFlower1.equals("Pink"))
            idFlower1 = "10";
        else if (typeOfFlower1.equals("Gillyflower") && colorOfFlower1.equals("Red"))
            idFlower1 = "11";
        else if (typeOfFlower1.equals("Gillyflower") && colorOfFlower1.equals("White"))
            idFlower1 = "12";
        else if (typeOfFlower1.equals("Gillyflower") && colorOfFlower1.equals("Orange"))
            idFlower1 = "13";
        else if (typeOfFlower1.equals("Gillyflower") && colorOfFlower1.equals("Yellow"))
            idFlower1 = "14";
        else if (typeOfFlower1.equals("Gillyflower") && colorOfFlower1.equals("Pink"))
            idFlower1 = "15";
        else if (typeOfFlower1.equals("Lily") && colorOfFlower1.equals("Red"))
            idFlower1 = "16";
        else if (typeOfFlower1.equals("Lily") && colorOfFlower1.equals("White"))
            idFlower1 = "17";
        else if (typeOfFlower1.equals("Lily") && colorOfFlower1.equals("Orange"))
            idFlower1 = "18";
        else if (typeOfFlower1.equals("Lily") && colorOfFlower1.equals("Yellow"))
            idFlower1 = "19";
        else if (typeOfFlower1.equals("Lily") && colorOfFlower1.equals("Pink"))
            idFlower1 = "20";
        else if (typeOfFlower1.equals("Eustoma") && colorOfFlower1.equals("Red"))
            idFlower1 = "21";
        else if (typeOfFlower1.equals("Eustoma") && colorOfFlower1.equals("White"))
            idFlower1 = "22";
        else if (typeOfFlower1.equals("Eustoma") && colorOfFlower1.equals("Orange"))
            idFlower1 = "23";
        else if (typeOfFlower1.equals("Eustoma") && colorOfFlower1.equals("Yellow"))
            idFlower1 = "24";
        else
            idFlower1 = "25";

        if (typeOfFlower2.equals("Rose") && colorOfFlower2.equals("Red"))
            idFlower2 = "1";
        else if (typeOfFlower2.equals("Rose") && colorOfFlower2.equals("White"))
            idFlower2 = "2";
        else if (typeOfFlower2.equals("Rose") && colorOfFlower2.equals("Orange"))
            idFlower2 = "3";
        else if (typeOfFlower2.equals("Rose") && colorOfFlower2.equals("Yellow"))
            idFlower2 = "4";
        else if (typeOfFlower2.equals("Rose") && colorOfFlower2.equals("Pink"))
            idFlower2 = "5";
        else if (typeOfFlower2.equals("Tulip") && colorOfFlower2.equals("Red"))
            idFlower2 = "6";
        else if (typeOfFlower2.equals("Tulip") && colorOfFlower2.equals("White"))
            idFlower2 = "7";
        else if (typeOfFlower2.equals("Tulip") && colorOfFlower2.equals("Orange"))
            idFlower2 = "8";
        else if (typeOfFlower2.equals("Tulip") && colorOfFlower2.equals("Yellow"))
            idFlower2 = "9";
        else if (typeOfFlower2.equals("Tulip") && colorOfFlower2.equals("Pink"))
            idFlower2 = "10";
        else if (typeOfFlower2.equals("Gillyflower") && colorOfFlower2.equals("Red"))
            idFlower2 = "11";
        else if (typeOfFlower2.equals("Gillyflower") && colorOfFlower2.equals("White"))
            idFlower2 = "12";
        else if (typeOfFlower2.equals("Gillyflower") && colorOfFlower2.equals("Orange"))
            idFlower2 = "13";
        else if (typeOfFlower2.equals("Gillyflower") && colorOfFlower2.equals("Yellow"))
            idFlower2 = "14";
        else if (typeOfFlower2.equals("Gillyflower") && colorOfFlower2.equals("Pink"))
            idFlower2 = "15";
        else if (typeOfFlower2.equals("Lily") && colorOfFlower2.equals("Red"))
            idFlower2 = "16";
        else if (typeOfFlower2.equals("Lily") && colorOfFlower2.equals("White"))
            idFlower2 = "17";
        else if (typeOfFlower2.equals("Lily") && colorOfFlower2.equals("Orange"))
            idFlower2 = "18";
        else if (typeOfFlower2.equals("Lily") && colorOfFlower2.equals("Yellow"))
            idFlower2 = "19";
        else if (typeOfFlower2.equals("Lily") && colorOfFlower2.equals("Pink"))
            idFlower2 = "20";
        else if (typeOfFlower2.equals("Eustoma") && colorOfFlower2.equals("Red"))
            idFlower2 = "21";
        else if (typeOfFlower2.equals("Eustoma") && colorOfFlower2.equals("White"))
            idFlower2 = "22";
        else if (typeOfFlower2.equals("Eustoma") && colorOfFlower2.equals("Orange"))
            idFlower2 = "23";
        else if (typeOfFlower2.equals("Eustoma") && colorOfFlower2.equals("Yellow"))
            idFlower2 = "24";
        else
            idFlower2 = "25";


        if (typeOfFlower3.equals("Rose") && colorOfFlower3.equals("Red"))
            idFlower3 = "1";
        else if (typeOfFlower3.equals("Rose") && colorOfFlower3.equals("White"))
            idFlower3 = "2";
        else if (typeOfFlower3.equals("Rose") && colorOfFlower3.equals("Orange"))
            idFlower3 = "3";
        else if (typeOfFlower3.equals("Rose") && colorOfFlower3.equals("Yellow"))
            idFlower3 = "4";
        else if (typeOfFlower3.equals("Rose") && colorOfFlower3.equals("Pink"))
            idFlower3 = "5";
        else if (typeOfFlower3.equals("Tulip") && colorOfFlower3.equals("Red"))
            idFlower3 = "6";
        else if (typeOfFlower3.equals("Tulip") && colorOfFlower3.equals("White"))
            idFlower3 = "7";
        else if (typeOfFlower3.equals("Tulip") && colorOfFlower3.equals("Orange"))
            idFlower3 = "8";
        else if (typeOfFlower3.equals("Tulip") && colorOfFlower3.equals("Yellow"))
            idFlower3 = "9";
        else if (typeOfFlower3.equals("Tulip") && colorOfFlower3.equals("Pink"))
            idFlower3 = "10";
        else if (typeOfFlower3.equals("Gillyflower") && colorOfFlower3.equals("Red"))
            idFlower3 = "11";
        else if (typeOfFlower3.equals("Gillyflower") && colorOfFlower3.equals("White"))
            idFlower3 = "12";
        else if (typeOfFlower3.equals("Gillyflower") && colorOfFlower3.equals("Orange"))
            idFlower3 = "13";
        else if (typeOfFlower3.equals("Gillyflower") && colorOfFlower3.equals("Yellow"))
            idFlower3 = "14";
        else if (typeOfFlower3.equals("Gillyflower") && colorOfFlower3.equals("Pink"))
            idFlower3 = "15";
        else if (typeOfFlower3.equals("Lily") && colorOfFlower3.equals("Red"))
            idFlower3 = "16";
        else if (typeOfFlower3.equals("Lily") && colorOfFlower3.equals("White"))
            idFlower3 = "17";
        else if (typeOfFlower3.equals("Lily") && colorOfFlower3.equals("Orange"))
            idFlower3 = "18";
        else if (typeOfFlower3.equals("Lily") && colorOfFlower3.equals("Yellow"))
            idFlower3 = "19";
        else if (typeOfFlower3.equals("Lily") && colorOfFlower3.equals("Pink"))
            idFlower3 = "20";
        else if (typeOfFlower3.equals("Eustoma") && colorOfFlower3.equals("Red"))
            idFlower3 = "21";
        else if (typeOfFlower3.equals("Eustoma") && colorOfFlower3.equals("White"))
            idFlower3 = "22";
        else if (typeOfFlower3.equals("Eustoma") && colorOfFlower3.equals("Orange"))
            idFlower3 = "23";
        else if (typeOfFlower3.equals("Eustoma") && colorOfFlower3.equals("Yellow"))
            idFlower3 = "24";
        else
            idFlower3 = "25";


        return null;
    }

}//end of class
