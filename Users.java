
package apteka;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Users {
    static Users user;
    public String login;
    public String password;
    
    public Users(String login, String password){
        this.login = login;
        this.password = password;
    }
    
    public String getLogin() {
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public static boolean proverka(String log, String pas){
        boolean result = false;
        try (FileReader reader = new FileReader("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Apteka\\src\\apteka\\users.txt")) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNext()) {
                String info = scan.nextLine();
                String[] words = info.split(" ");
                String login = words[0];
                String password = words[1];
                if(login.equals(log) && password.equals(pas)) {
                    Users.user = new Users(log, pas);
                    result = true;
                }
            }
            reader.close();
        }
        catch(IOException ex){
            ex.getMessage();
        }
        return result;
    }
}
