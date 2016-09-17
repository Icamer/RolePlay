/**
 * Created by Icamer on 17.09.2016.
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class PostgresqlHandler {
    Connection c;
    Statement stmt;

    public PostgresqlHandler() {
    }

//    public PostgresqlHandler(Connection c, Statement stmt) {
//        this.c = c;
//        this.stmt = stmt;
//    }

    public void openDatebase(String port, String login, String password){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/postgres", login, password);
            c.setAutoCommit(false);
            stmt = c.createStatement();
            System.out.println("Opened database successfully");

        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

    public void closeDatebase(){
        try{
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Closed db successfully");
        } catch (SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }


    }

    public void insertHandler(Connection c, Statement stmt){
        try{
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);
        } catch (SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

    public void selectHandler(Connection c, Statement stmt){
        try{
            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "SALARY = " + salary );
                System.out.println();
            }
        }
        catch (SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

}
