
package apteka;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController implements Initializable {
    
    @FXML
    private TextField login;
    
    @FXML
    private TextField password;
    
    @FXML
    private Button registr;
    
    @FXML
    private Button otmena;
    
    @FXML
    private void registr(ActionEvent event) throws IOException {
        if(Users.proverka(login.getText(), password.getText()) == false) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\users.txt", true));
            String str = login.getText() + " " + password.getText() + "\n";
            writer.append(System.lineSeparator());
            writer.append(str);
            writer.close();
        
            Stage stage1 = (Stage) registr.getScene().getWindow();
            stage1.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Сообщение об ошибке");
            alert.setContentText("Введенные логин и пароль уже существуют");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void otmenaAction(ActionEvent event) {
        Stage stage1 = (Stage) registr.getScene().getWindow();
        stage1.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
