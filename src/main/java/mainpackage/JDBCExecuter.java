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
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
