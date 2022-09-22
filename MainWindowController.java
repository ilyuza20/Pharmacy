
package apteka;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {

    @FXML
    private Button searchButton;
    
    @FXML
    private Button orderButton;
    
    @FXML
    private Button exitButton;
    
    @FXML
    private ImageView searchImage;
    
    @FXML
    private ImageView orderImage;
    
    @FXML
    private void searchButtonAction(ActionEvent event) throws IOException {
        Stage scene = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Catalog.fxml"));
        scene.setTitle("Каталог");
        scene.setScene(new Scene(root));
        scene.show();
    }
    
    @FXML
    private void orderButtonAction(ActionEvent event) throws IOException {
        Stage scene = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Order.fxml"));
        scene.setTitle("Оформить заказ");
        scene.setScene(new Scene(root));
        scene.showAndWait();
    }
    
    @FXML
    private void exitButtonAction(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) exitButton.getScene().getWindow();
        stage1.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\search.png");
        Image image = new Image(file.toURI().toString());
        searchImage.setImage(image);
        
        file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\order.png");
        image = new Image(file.toURI().toString());
        orderImage.setImage(image);
    }    
    
}
