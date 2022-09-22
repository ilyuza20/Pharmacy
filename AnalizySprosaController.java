
package apteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AnalizySprosaController implements Initializable {

    /*private final ObservableList <Product> productData = FXCollections.observableArrayList();
    private final ObservableList <Orders> ordersData = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Product> analizCatalog;
    
    @FXML
    private TableColumn <Product, String> idColumn;
    
    @FXML
    private TableColumn <Product, String> nameColumn;
    
    @FXML
    private TableColumn <Product, String> countColumn;
    
    @FXML
    private TableColumn <Product, String> sumColumn;
    
    @FXML
    private TableColumn <Product, String> dateColumn;
    
    @FXML
    private TextField sum1TextField;
    
    @FXML
    private TextField sum2TextField;
    
    @FXML
    private TextField myTextField;
    
    @FXML
    private Button ok;
    
    @FXML
    private RadioButton sum;
    
    @FXML
    private RadioButton year;
    
    @FXML
    private RadioButton month;
    
    @FXML
    private void OKHandleAction(ActionEvent event) {
        BufferedReader objReader = null;
        if(year.isSelected()) {
            ObservableList list = Product.SearchProduct(productData, searchTextField.getText(), nameRadioButton.getText());
            if(list!=null){
                catalogTable.getItems().clear();
                catalogTable.setItems(list);
            }
        }
        else if(sumRadioButton.isSelected()) {
            ObservableList list = Product.SearchProduct(productData, searchTextField.getText(), sumRadioButton.getText());
            if(list!=null){
                catalogTable.getItems().clear();
                catalogTable.setItems(list);
            }
        }
        else {
            String str;
            File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\catalog.txt");
            objReader = new BufferedReader(new FileReader(file));
            while ((str = objReader.readLine()) != null){
                String [] split= str.split("/");
                productData.add(new Product(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), split[4]));
                productID.setCellValueFactory(new PropertyValueFactory<>("id"));
                productName.setCellValueFactory(new PropertyValueFactory<>("name"));
                productSum.setCellValueFactory(new PropertyValueFactory<>("sum"));
                productCount.setCellValueFactory(new PropertyValueFactory<>("count"));
                productDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                catalogTable.setItems(productData);
            } 
        }
    }
    
    */@Override
    public void initialize(URL url, ResourceBundle rb) {
        /*BufferedReader objReader = null;
        try {
            String str;
            File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\catalog.txt");
            objReader = new BufferedReader(new FileReader(file));
            while ((str = objReader.readLine()) != null){
                String [] split= str.split("/");
                productData.add(new Product(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), split[4]));
            } 
        }
        catch (IOException e){
        }
        finally {
            try{
                if (objReader != null)
                    objReader.close();
            }catch (IOException ex){
            }
        }
        
        try {
            String str;
            File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\orders.txt");
            objReader = new BufferedReader(new FileReader(file));
            while ((str = objReader.readLine()) != null){
                String [] split= str.split("/");
                ordersData.add(new Orders(split[0], split[1], split[2], Integer.parseInt(split[3]), Long.parseLong(split[6]), split[7]));
            } 
        }
        catch (IOException e){
        }
        finally {
            try{
                if (objReader != null)
                    objReader.close();
            }catch (IOException ex){
            }
        }*/
    }    
    
}
