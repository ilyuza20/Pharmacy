
package apteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class CatalogOrdersController implements Initializable {

    private final ObservableList <Orders> ordersData = FXCollections.observableArrayList();
    
    @FXML
    private Tab catalogtab;
    
    @FXML
    private TableView catalogorders;
    
    @FXML
    private TableColumn <Orders, String> ordersurname;
    
    @FXML
    private TableColumn <Orders, String> ordername;  
    
    @FXML
    private Label ordernameLabel;
    
    @FXML
    private Label ordercountLabel;
    
    @FXML
    private Label ordernumLabel;
    
    @FXML
    private TextArea punktText;
    
    
    
    private void showOrderDetails(Orders order){
        if(order!=null){
            ordernameLabel.setText(order.getTovar());
            ordercountLabel.setText(order.getKol().toString());
            ordernumLabel.setText(order.getNum().toString());
            punktText.setText(order.getPunkt());
        }
        else{
            ordernameLabel.setText("");
            ordercountLabel.setText("");
            ordernumLabel.setText("");
            punktText.setText("");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BufferedReader objReader = null;
        try {
            String str;
            File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\orders.txt");
            objReader = new BufferedReader(new FileReader(file));
            while ((str = objReader.readLine()) != null){
                String [] split= str.split("/");
                ordersData.add(new Orders(split[0], split[1], split[2], Integer.parseInt(split[3]), Long.parseLong(split[4]), split[5]));
                ordersurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
                ordername.setCellValueFactory(new PropertyValueFactory<>("name"));
                catalogorders.setItems(ordersData);                
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
        showOrderDetails(null);
        
        catalogorders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            showOrderDetails((Orders) newValue);
        });
    }    
    
}
