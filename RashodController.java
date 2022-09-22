
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RashodController implements Initializable {

    private final ObservableList <Rashod> rashodData = FXCollections.observableArrayList();
    
    @FXML
    private TableView rashodTable;
    
    @FXML
    private TableColumn<Rashod,String>  rasname;
    
    @FXML
    private TableColumn<Rashod,String>  raskol;
    
    @FXML
    private TableColumn  rassum;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BufferedReader objReader = null;
        try {
            String str;
            File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\rashod.txt");
            objReader = new BufferedReader(new FileReader(file));
            while ((str = objReader.readLine()) != null){
                String [] split= str.split("/");
                rashodData.add(new Rashod(split[0],Integer.parseInt(split[1])));
                rasname.setCellValueFactory(new PropertyValueFactory<>("name"));
                raskol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                rashodTable.setItems(rashodData);
                
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
    }
    

}

