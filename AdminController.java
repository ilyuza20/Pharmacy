/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apteka;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class AdminController implements Initializable {

    @FXML
    private Tab catalogtab;
    
    @FXML
    private Tab orderstab;
    
    @FXML
    private Tab rastab;
    
    @FXML
    private TabPane tabPane;
    
    @FXML
    private MenuItem posItem;
    
    @FXML
    private MenuItem zakazItem1;
   
    
    @FXML
    private void selectCatalogTab(ActionEvent event) {
        tabPane.getSelectionModel().select(catalogtab);
    }
    
    @FXML
    private void selectOrdersTab(ActionEvent event) {
        tabPane.getSelectionModel().select(orderstab);
    }
    
    @FXML
    private void selectRashodTab(ActionEvent event) {
        tabPane.getSelectionModel().select(rastab);
    }
    
    @FXML
    private void selectNewTovar(ActionEvent event) throws IOException {
        Stage scene = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("NewTovar.fxml"));
        scene.setTitle("Поступление товара");
        scene.setScene(new Scene(root));
        scene.show();
    }
    
    @FXML
    private void selectDeleteProduct (ActionEvent event) throws IOException {
        Stage scene = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("DeleteTovar.fxml"));
        scene.setTitle("Списание товара");
        scene.setScene(new Scene(root));
        scene.show();
    }
    
    @FXML
    private void selectAnaliz (ActionEvent event) {
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Catalog.fxml"));
                catalogtab.setContent(loader.load());
                
                
            } catch (IOException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("CatalogOrders.fxml"));
                orderstab.setContent(loader.load());
                
                
            } catch (IOException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Rashod.fxml"));
                rastab.setContent(loader.load());
                
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }       
    
}