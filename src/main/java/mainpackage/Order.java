package mainpackage;

import mainpackage.util.DataTransferObject;

public class Order  implements DataTransferObject {
    private long id,customerId, salesPersonId;
    private String food;

    public Order(){

    }

    public Order(long id, long customerId, long salesPersonId, String food) {
        this.id = id;
        this.customerId = customerId;
        this.salesPersonId = salesPersonId;
        this.food = food;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(long salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", salesPersonId=" + salesPersonId +
                ", food='" + food + '\'' +
                '}';
    }
}
