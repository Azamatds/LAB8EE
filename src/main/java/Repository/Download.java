package Repository;



import javax.ejb.Stateful;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class Download {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/lab8ee";
    private static final String USER = "postgres";
    private static final String PASS = "12345";
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public Download() throws SQLException{
        try {
        Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found.");
            e.printStackTrace();
            return;
        }
        System.out.println("Connection to DataBase...");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Success!");
        statement = connection.createStatement();
        statement.executeUpdate(CreateDatabase.createDataBaseSql());

        connection.setAutoCommit(false);
        Statement finalStatement = statement;
        CreateDatabase.LocalData().forEach(sql ->{
            try {
                finalStatement.executeUpdate(sql);
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
                });
        connection.commit();
    }

    public List<String> getAllDemoName() throws  SQLException{
        List<String> names = new ArrayList<>();
        String sql = "SELECT * FROM demo";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            System.out.println("ID " + id);
            String name = resultSet.getString("Name");

            String desc = resultSet.getString("Hint");
            names.add(String.valueOf(id));
            names.add(name);
            names.add(desc);
        }
        return names;
    }

}
