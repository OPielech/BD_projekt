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

    }

    @FXML
    void btnEmployeeClicked(ActionEvent event) {
        role = Role.EMPLOYEE;

        if (!isOpen)
        openPasswordWindow();

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


            stage.showAndWait();
            isOpen = false;

            login = passwordWindowController.getLogin();
            password = passwordWindowController.getPassword();

            System.out.println(login);
            System.out.println(password);

        }catch (IOException e) {
            e.printStackTrace();
        }

    }//end of openPasswordWindow

}//end of class
