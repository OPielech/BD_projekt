import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.graalvm.compiler.phases.common.NodeCounterPhase;

public class MainWindowController {


    private String login;
    private String password;

    private Role role;
    private boolean isOpen;

    public Role getRole() {
        return role;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnEmployee;

    @FXML
    void btnCustomerClicked(ActionEvent event) {
        role = Role.CUSTOMER;

        if (!isOpen)
        openPasswordWindow();

        if(!isOpen)
            openCustomerApp();

    }

    @FXML
    void btnEmployeeClicked(ActionEvent event) {
        role = Role.EMPLOYEE;

        if (!isOpen)
        openPasswordWindow();

        if(!isOpen)
            openEmployeeApp();

    }

    @FXML
    void initialize() {
        assert btnCustomer != null : "fx:id=\"btnCustomer\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnEmployee != null : "fx:id=\"btnEmployee\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }

    public void openPasswordWindow() {
        try {

            isOpen = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/PasswordWindow.fxml"));
            Parent parent = fxmlLoader.load();

            PasswordWindowController passwordWindowController = fxmlLoader.getController();
            Scene scene = new Scene(parent);
//            scene.getStylesheets().add()
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Login and password");
            stage.initModality(Modality.WINDOW_MODAL);
            passwordWindowController.setRole(role);

            stage.showAndWait();
            isOpen = false;

            password = passwordWindowController.getPassword();
            login = passwordWindowController.getLogin();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }//end of openPasswordWindow

    public void openCustomerApp(){

        try {
            isOpen = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/CustomerApp.fxml"));
            Parent parent = fxmlLoader.load();

            CustomerAppController customerAppController = fxmlLoader.getController();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Customer application");
            stage.initModality(Modality.WINDOW_MODAL);
            customerAppController.setLogin(login);
            customerAppController.setPassword(password);

            stage.showAndWait();
            isOpen = false;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of openCustomerApp

    public void openEmployeeApp(){
        try {
            isOpen = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/EmployeeApp.fxml"));
            Parent parent = fxmlLoader.load();

            EmployeeAppController employeeAppController = fxmlLoader.getController();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Employee application");
            stage.initModality(Modality.WINDOW_MODAL);
            employeeAppController.setLogin(login);
            employeeAppController.setPassword(password);

            stage.showAndWait();
            isOpen = false;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of openEmployeeApp

}//end of class
