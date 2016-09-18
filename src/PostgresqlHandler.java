/**
 * Created by Icamer on 17.09.2016.
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;


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
            c = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/RolePlayBase", login, password);
            c.setAutoCommit(false);
            stmt = c.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
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

    public void insertHandler(String tablica, String typyDanych, String listaDanych){
        try{
            String sql = "INSERT INTO "+ tablica +"("+typyDanych+")" + "VALUES ("+listaDanych+");";
            stmt.executeUpdate(sql);
        } catch (SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

//    public void selectHandler(String[] typesOfSelect, String[] nameOfField, String whatToSelect){
//        try{
//            ResultSet rs = stmt.executeQuery( "SELECT " + whatToSelect + ";" );
//            ResultSetMetaData resultSetMetaData = rs.getMetaData();
//            int columnCount = resultSetMetaData.getColumnCount();
////            rs.last();
////            System.out.println(rs.getRow());      ustalenie ilosci rzędów jest obecnie niepotrzebne
////            rs.beforeFirst();
//            while ( rs.next() ) {
//
//                System.out.println("Kappa");
//                for(int whichType=1; whichType<=columnCount;whichType++){
//                    try{
//                        Object o = rs.getObject(whichType);
//                        Class klasa = o.getClass();
//                        System.out.println("wartosc obiektu: " + o + "\t\tobiekt typu: " + klasa);
//
//                    }catch(NullPointerException e){
//                        System.out.println("kolumna " + whichType + " \t\t\t\tnie posiada wartosci");
//                    }
//                }
//            }
//        }
//        catch (SQLException e){
//            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//            System.exit(0);
//        }
//    }
    public void selectHandler(String whatToSelect){
        try{
            ResultSet rs = stmt.executeQuery( "SELECT " + whatToSelect + ";" );
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
//            rs.last();
//            System.out.println(rs.getRow());      ustalenie ilosci rzędów jest obecnie niepotrzebne
//            rs.beforeFirst();
            while ( rs.next() ) {

                System.out.println("Kappa");
                for(int whichType=1; whichType<=columnCount;whichType++){
                    try{
                        Object o = rs.getObject(whichType);
                        Class klasa = o.getClass();
                        System.out.println("wartosc obiektu: " + o + "\t\tobiekt typu: " + klasa);

                    }catch(NullPointerException e){
                        System.out.println("kolumna " + whichType + " \t\t\t\tnie posiada wartosci");
                    }
                }
            }
        }
        catch (SQLException e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }

}
