import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        GraphicsInterface graphicsInterface = new GraphicsInterface();
        Connection c = null;
        Statement stmt = null;
        PostgresqlHandler postgresqlHandler = new PostgresqlHandler();
        postgresqlHandler.openDatebase("5434","postgres","Ni3znane");


        postgresqlHandler.closeDatebase();


    }
}

/*
- Main Thread
- Command Loop
- Regex on Command Loop
- File support
- MySQL

*/
