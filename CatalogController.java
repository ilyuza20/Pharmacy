
package apteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CatalogController implements Initializable {

    private final ObservableList <Product> productData = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Product> catalogTable;
    
    @FXML
    private TableColumn <Product, String> productID;
    
    @FXML
    private TableColumn <Product, String> productName;
    
    @FXML
    private TableColumn <Product, String> productCount;
        
    @FXML
    private TableColumn <Product, String> productSum;
    
    @FXML
    private TableColumn <Product, String> productDescription;
    
    @FXML
    private TextField searchTextField;
    
    @FXML
    private Button searchProductButton;
    
    @FXML
    private Label productIDLabel;
    
    @FXML
    private Label productNameLabel;
    
    @FXML
    private Label productCountLabel;
    
    @FXML
    private Label productSumLabel;
    
    @FXML
    private TextArea productDescriptionText;
    
    @FXML
    private RadioButton nameRadioButton;
    
    @FXML
    private RadioButton sumRadioButton;
    
    private void showProductDetails(Product product){
        if(product!=null){
            productIDLabel.setText(product.getID().toString());
            productNameLabel.setText(product.getName());
            productSumLabel.setText(product.getSum().toString());
            productCountLabel.setText(product.getCount().toString());
            productDescriptionText.setText(product.getDescription());
        }
        else{
            productIDLabel.setText("");
            productNameLabel.setText("");
            productSumLabel.setText("");
            productCountLabel.setText("");
            productDescriptionText.setText("");
        }
    }
    
    
    @FXML
    private void searchProductButtonAction(ActionEvent event) throws FileNotFoundException, IOException {
        BufferedReader objReader = null;
        if(nameRadioButton.isSelected()) {
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
            catalogTable.getItems().clear();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BufferedReader objReader = null;
        try {
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
        catch (IOException e){
        }
        finally {
            try{
                if (objReader != null)
                    objReader.close();
            }catch (IOException ex){
            }
        }
        showProductDetails(null);
        
        catalogTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            showProductDetails(newValue);
        });

    }    
    
}