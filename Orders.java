
package apteka;

public class Orders {
    
    String surname;
    String name;
    String tovar;
    int kol;
    long num;
    String punkt;
    
    public Orders(String surname, String name, String tovar, int kol, long num, String punkt) {
        this.surname=surname;
        this.name=name;
        this.tovar=tovar;
        this.kol=kol;
        this.num=num;
        this.punkt=punkt;
    }

    
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    
    public String getTovar(){
        return tovar;
    }
    public void setTovar(String tovar){
        this.tovar=tovar;
    }
    
    public Integer getKol(){
        return kol;
    }
    public void setKol(int kol){
        this.kol=kol;
    }
    
    public Long getNum(){
        return num;
    }
    public void setNum(long num){
        this.num=num;
    }
    
    public String getPunkt(){
        return punkt;
    }
    public void setPunkt(String punkt){
        this.punkt=punkt;
    }
    
}
