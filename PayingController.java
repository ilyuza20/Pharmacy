
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PayingController implements Initializable {

    @FXML
    private TextField numcardTextField;
    
    @FXML
    private TextField myTextField;
    
    @FXML
    private TextField cvvTextField;
    
    @FXML
    private TextField nameTextField;
    
    @FXML
    private Button payButton;
    
    @FXML
    private Button otmenaButton;
    
    private Stage dialogStage;
    
    private boolean isInputValid(){
        String errorMessage = "";
        
        if(numcardTextField.getText() == null || numcardTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле Номер карты \n";
        }
        if(myTextField.getText() == null || myTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле ММ/ГГ \n";
        }
        if(cvvTextField.getText() == null || cvvTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле CVV \n";
        }
        if(nameTextField.getText() == null || nameTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле Имя владельца карты \n";
        }
        
        if(errorMessage.length() == 0) {
            return true;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Некорректные поля");
            alert.setHeaderText("Введите корректную информацию");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
   
    @FXML
    private void payButtonAction(ActionEvent event) throws IOException {
        if(isInputValid()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\payers.txt", true));
            String str = numcardTextField.getText()+"/"+myTextField.getText()+"/"+cvvTextField.getText()+"/"+nameTextField.getText()+"\n";
            writer.append(System.lineSeparator());
            writer.append(str);
            writer.close();
        
            Stage stage1 = (Stage) payButton.getScene().getWindow();
            stage1.close();
        }
    }
    
    @FXML
    private void otmenaButtonAction(ActionEvent event) {
        Stage stage1 = (Stage) otmenaButton.getScene().getWindow();
        stage1.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
