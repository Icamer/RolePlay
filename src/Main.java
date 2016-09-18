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
        String[] a = new String[2];
        a[0]="int";
        a[1]="String";
        String[] b = new String[2];
        b[0]="charid";
        b[1]="imie";
//        postgresqlHandler.selectHandler(a,b,"* FROM postacie");
        postgresqlHandler.selectHandler("* FROM postacie");

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
