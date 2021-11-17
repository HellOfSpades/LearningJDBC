package mainpackage;

import mainpackage.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAO extends DataAccessObject<Customer> {

    //statements used
    private static final String INSERT = "INSERT INTO customer (name,country) VALUES(?,?)";
    private static final String GET_ONE = "SELECT id, name, country FROM customer WHERE id = ?";
    private static final String UPDATE = "UPDATE customer SET name=?, country=? WHERE id=?";
    private static final String DELETE = "DELETE FROM customer WHERE id=?";

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(long id) {
        Customer customer = new Customer();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setCountry(resultSet.getString("country"));
            }
            return customer;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer update(Customer dto) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, dto.getName());
            preparedStatement.setString(2, dto.getCountry());
            preparedStatement.setLong(3,dto.getId());
            preparedStatement.execute();
            Customer customer = this.findById(dto.getId());
            return customer;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public Customer create(Customer dto) {

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(INSERT)){

            preparedStatement.setString(1, dto.getName());
            preparedStatement.setString(2, dto.getCountry());
            preparedStatement.execute();
            long id = this.getLastVal(CUSTOMER_SEQUENCE);
            return this.findById(id);

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void delete(long id) {
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(DELETE)){
            preparedStatement.setLong(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
