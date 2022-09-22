
package apteka;

import static apteka.Users.proverka;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label heading;
    
     @FXML
    private Label vhod;
    
    @FXML
    private TextField login;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Button vhodButton;
    
    @FXML
    private Button otmenaButton;
    
    @FXML
    private Hyperlink registr;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (proverka(login.getText(), password.getText())) {   //proverka(login.getText(), password.getText())
            Stage scene = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            scene.setTitle("Главное окно");
            scene.setScene(new Scene(root));
            scene.show();
        }
        else if("admin".equals(login.getText()) && "123".equals(password.getText())) {
            Stage scene = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            scene.setTitle("Администратор");
            scene.setScene(new Scene(root));
            scene.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Сообщение об ошибке");
            alert.setContentText("Проверьте введенные логин и пароль");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void registration(ActionEvent event) throws IOException {
        Stage scene = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        scene.setTitle("Регистрация");
        scene.setScene(new Scene(root));
        scene.show();
    }
    
    @FXML
    private void exitAction(ActionEvent event) {
        Stage stage1 = (Stage) otmenaButton.getScene().getWindow();
        stage1.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
