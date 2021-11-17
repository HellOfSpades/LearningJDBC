package mainpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.JarException;

public class JDBCExecuter {
    public static void main (String []args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager
                ("localhost","hplsport", "postgres","password");

        try{
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1);
            System.out.println(order);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
