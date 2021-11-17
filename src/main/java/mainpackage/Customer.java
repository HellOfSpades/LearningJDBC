package mainpackage;

import mainpackage.util.DataTransferObject;

public class Customer implements DataTransferObject {
    private long id;
    private String name, country;

    Customer(){

    }
    public Customer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return getName()+" "+getCountry()+" "+getId();
    }
}
