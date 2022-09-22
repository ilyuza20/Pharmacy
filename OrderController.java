
package apteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrderController implements Initializable {
    
    private final ObservableList <Product> productData = FXCollections.observableArrayList();
    
    @FXML
    private TextField surnameTextField;
    
    @FXML
    private TextField nameTextField;
    
    @FXML
    private TextField tovarTextField;
    
    @FXML
    private TextField kolTextField;
    
    @FXML
    private TextField numTextField;
    
    @FXML
    private TextField punktTextField;
    
    @FXML
    private RadioButton nowRadioButton;
    
    @FXML
    private RadioButton thenRadioButton;
    
    @FXML
    private Button orderButton;
    
    @FXML
    private Button exitButton;
    
    private Stage dialogStage;
    
    private boolean isInputValid(){
        String errorMessage = "";
        
        if(surnameTextField.getText() == null || surnameTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле Фамилия \n";
        }
        if(nameTextField.getText() == null || nameTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле Имя\n";
        }
        if(tovarTextField.getText() == null || tovarTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле Название товара\n";
        }
        if(kolTextField.getText() == null || kolTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле Количество\n";
        }
        if(numTextField.getText() == null || numTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле Телефон/e-mail \n";
        }
        if(punktTextField.getText() == null || punktTextField.getText().length() == 0) {
            errorMessage += "Не заполнено поле Пункт доставки \n";
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
    private void orderButtonAction(ActionEvent event) throws IOException{
        if(isInputValid()) {
            productData.forEach((product) -> { 
            if(product.name.equals(tovarTextField.getText())) {
                product.count -= Integer.parseInt(kolTextField.getText());
            }
        }); 
        Product.changeFile(productData);
        
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\orders.txt", true));
            BufferedWriter raswriter = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\rashod.txt", true));
            String str = surnameTextField.getText()+"/"+nameTextField.getText()+"/"+tovarTextField.getText()+"/"+kolTextField.getText()+"/"+
                    numTextField.getText()+"/"+punktTextField.getText();
            String rasstr = tovarTextField.getText()+"/"+kolTextField.getText();
            if(nowRadioButton.isSelected() || thenRadioButton.isSelected()) {
                if(nowRadioButton.isSelected()) {
                    Stage scene = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Paying.fxml"));
                    scene.setTitle("Оплата");
                    scene.setScene(new Scene(root));
                    scene.showAndWait();
                }
                    
                writer.append(System.lineSeparator());
                writer.append(str);
                writer.close();
                
                raswriter.append(System.lineSeparator());
                raswriter.append(rasstr);
                raswriter.close();
                
                Stage stage1 = (Stage) orderButton.getScene().getWindow();
                stage1.close();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Сообщение об ошибке");
                alert.setContentText("Не выбран способ оплаты");
                alert.showAndWait();
            }
        }
        
    }
    
    @FXML
    private void ExitHandleAction(ActionEvent event) {
        Stage stage1 = (Stage) exitButton.getScene().getWindow();
        stage1.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            BufferedReader objReader = null;
            String str;
            File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\catalog.txt");
            objReader = new BufferedReader(new FileReader(file));
            while ((str = objReader.readLine()) != null){
                String [] split= str.split("/");
                productData.add(new Product(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), split[4]));
            }   
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewTovarController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewTovarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
