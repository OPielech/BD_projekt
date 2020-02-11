import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.graalvm.compiler.phases.common.NodeCounterPhase;

public class PasswordWindowController {

    private String login;
    private String password;
    private boolean isLoginOk;
    private boolean isPasswordOk;
    private Role role;
    MainWindowController mainWindowController;
    DataBase dataBase;

    public void setRole(Role role) {
        this.role = role;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnApply;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    void btnApplyClicked(ActionEvent event) throws SQLException {
        try {
            login = textFieldLogin.getText();
            if (login.isEmpty())
                throw new NullPointerException();
            else
                isLoginOk = true;

            password = textFieldPassword.getText();
            if (password.isEmpty()) {
                throw new NullPointerException();

            } else
                isPasswordOk = true;
        } catch (NullPointerException e) {
            textFieldPassword.setPromptText("Invalid login or password");
            textFieldLogin.setPromptText("Invalid login or password");
        }

        isLoginOk = false;
        isPasswordOk = false;

        dataBase = new DataBase(login, password);

        try {
            if (role.equals(Role.CUSTOMER) && login.equals("klient")) {
                dataBase.dbConnect();
                if(dataBase.isConnectionOk()) {
                    isLoginOk = true;
                    isPasswordOk = true;
                }else {
                    throw new IllegalArgumentException();
                }
            } else if (role.equals(Role.EMPLOYEE) && login.equals("pracownik")){
                dataBase.dbConnect();
                if(dataBase.isConnectionOk()) {
                    isLoginOk = true;
                    isPasswordOk = true;
                }else
                    throw new IllegalArgumentException();
            }else
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            textFieldLogin.clear();
            textFieldPassword.clear();
            textFieldPassword.setPromptText("Invalid login or password");
            textFieldLogin.setPromptText("Invalid login or password");
        }

        if (isPasswordOk && isLoginOk) {
            Stage stage = (Stage) btnApply.getScene().getWindow();
            stage.close();
        }
    }//end of btnApplyClicked

    @FXML
    void initialize() {
        assert btnApply != null : "fx:id=\"btnApply\" was not injected: check your FXML file 'PasswordWindow.fxml'.";
        assert textFieldLogin != null : "fx:id=\"textFieldLogin\" was not injected: check your FXML file 'PasswordWindow.fxml'.";
        assert textFieldPassword != null : "fx:id=\"textFieldPassword\" was not injected: check your FXML file 'PasswordWindow.fxml'.";
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
