import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Verbindung
{
    public static Connection dbConnection() throws SQLException
    {   //Wird verwendet um eine Verbindung zu einer MySQL-Datenbank herzustellen
        //Datenbank URL, Datenbank user und passwort werden hinterlegt
        Connection conn = null;
        String connectionUrl = "jdbc:mysql://192.168.178.47:3306/DBI";
        String connectionUser = "dbi";
        String connectionPassword ="root";
        //URL, USER und PASSWORD werden übergeben
        try
        {
            conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            conn.setAutoCommit(false);
        }
        catch (Exception e)
        {
            System.err.println("Konnte keine Verbindung herstellen!");
            System.exit(0);
        }
        System.out.println("Datenbankverbindung hergestellt!");
        return conn;
    }

    public static void dbDisconnect(Connection conn) throws SQLException
    {
        conn.close();
    }
}
