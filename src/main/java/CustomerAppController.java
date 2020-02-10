import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerAppController {

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

    ObservableList<String> typeOfFlowers = FXCollections.observableArrayList("Rose", "Tulip", "Gillyflower", "Lily", "Eustoma");
    ObservableList<String> colorOfFlowers = FXCollections.observableArrayList("Red", "White", "Orange", "Yellow", "Pink");
    ObservableList<String> numberOfFlowers = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
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
    void btnApplyClicked(ActionEvent event) {
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
        date = textFieldDate.getText();

        System.out.println(typeOfFlower1);
        System.out.println(typeOfFlower2);
        System.out.println(typeOfFlower3);
        System.out.println(typeOfFlower4);
        System.out.println(colorOfFlower1);
        System.out.println(colorOfFlower2);
        System.out.println(colorOfFlower3);
        System.out.println(colorOfFlower4);
        System.out.println(numberOfFlower1);
        System.out.println(numberOfFlower2);
        System.out.println(numberOfFlower3);
        System.out.println(numberOfFlower4);
        System.out.println(addition1);
        System.out.println(addition2);
        System.out.println(addition3);
        System.out.println(arrangement);
        System.out.println(paymentMethod);
        System.out.println(time);
        System.out.println(date);
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
}
