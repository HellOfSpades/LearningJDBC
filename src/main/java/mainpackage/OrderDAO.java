package mainpackage;

import mainpackage.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO extends DataAccessObject<Order> {

    private static String GET_ONE = "SELECT id, customerId, salesPersonId, dish FROM orders WHERE id = ?";

    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Order findById(long id) {
        Order order = new Order();

        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE)){

            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                order.setId(resultSet.getLong("id"));
                order.setCustomerId(resultSet.getLong("customerId"));
                order.setSalesPersonId(resultSet.getLong("salesPersonId"));
                order.setFood(resultSet.getString("dish"));
            }

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public Order create(Order dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
