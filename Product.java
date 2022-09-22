
package apteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {
    int id;
    String name;
    int count;
    double sum;
    String description;
    
    public Product(int ID, String Name, int Count, double Sum, String Description){
        this.id=ID;
        this.name=Name;
        this.count=Count;
        this.sum=Sum;
        this.description=Description;
    }
    
    public Integer getID(){
        return id;
    }
    public void setID(int ID){
        this.id=ID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String Name){
        this.name=Name;
    }
    
    public Double getSum(){
        return sum;
    }
    public void setSum(double Sum){
        this.sum=Sum;
    }
    
    public Integer getCount(){
        return count;
    }
    public void setCount(int Count){
        this.count=Count;
    }
    
    public String getDescription(){
        return description;
    }
    public void setDescription(String Description){
        this.description=Description;
    }
    
    public static ObservableList<Product> SearchProduct (ObservableList<Product>products, String target, String SearchMark) {
        ObservableList<Product> SearchList = FXCollections.observableArrayList();
        if(target!=null) {
            products.forEach((product) -> {
                String info = "";
                if(SearchMark.equals("названию"))
                    info = info + product.getName() + " ";
                if(SearchMark.equals("цене"))
                    info = info + Double.toString(product.getSum()) + " ";
                if (info.contains(target)) {
                    SearchList.add(product);
                }
            });
        }
        return SearchList;
    }
    
    static void changeFile(ObservableList<Product> list) throws IOException{ 
        File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\catalog.txt"); 
        PrintWriter pw = new PrintWriter(file); 
        pw.close(); 

        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); 
        list.forEach((product) -> { 
            String str = product.getID()+"/"+product.getName()+"/"+product.getCount()+"/"+product.getSum()+"/"+product.getDescription(); 
            try { 
                writer.append(str); 
                writer.append(System.lineSeparator()); 
            } catch (IOException ex) { 
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex); 
            } 
        }); 
        writer.close(); 
    }
    
    public int getNewID() throws FileNotFoundException, IOException {
        BufferedReader objReader = null;
        String str;
        File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\catalog.txt");
        objReader = new BufferedReader(new FileReader(file));
        int ID = 1;
        while ((str = objReader.readLine()) != null) {
            String [] split= str.split("/");
            if(ID == (Integer.parseInt(split[0])))
                ID++;
            else
                this.id=ID;
        }
        return ID;
    }
}
