
package apteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewTovarController implements Initializable {
    
    private final ObservableList <Product> productData = FXCollections.observableArrayList();

    @FXML
    private TextField tovar;
    
    @FXML
    private TextField count;
    
    @FXML
    private TextField sum;
    
    @FXML
    private TextField description;
    
    @FXML
    private Button add;
    
    @FXML
    private Button cancel;
    
    @FXML
    private void AddHandleAction(ActionEvent event) throws IOException {
        productData.forEach((product) -> { 
            if(product.name.equals(tovar.getText()) && product.sum==Double.parseDouble(sum.getText())) {
                product.count += Integer.parseInt(count.getText());
            }
            else {
                try {
                    Product product1 = new Product(0, "", 0, 0.0, "");
                    product1.id=product.getNewID();
                    product1.name=tovar.getText();
                    product1.count=Integer.parseInt(count.getText());
                    product1.sum=Double.parseDouble(sum.getText());
                    product1.description=description.getText();
                    productData.add(product1);
                } catch (IOException ex) {
                    Logger.getLogger(NewTovarController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        
        
        Product.changeFile(productData);
        
        Stage stage1 = (Stage) add.getScene().getWindow();
        stage1.close();
    }
        
    
    @FXML
    private void cancelHandleAction(ActionEvent event) {
        Stage stage1 = (Stage) cancel.getScene().getWindow();
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
