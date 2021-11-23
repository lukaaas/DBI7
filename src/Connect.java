import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect
{
    public static java.sql.Connection dbConnection() throws SQLException
    {   //Wird verwendet um eine Verbindung zu einer MySQL-Datenbank herzustellen
        //Datenbank URL, Datenbank user und passwort werden hinterlegt
        java.sql.Connection conn = null;
        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/DBI?rewriteBatchedStatements=true";
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

    public static void dbDisconnect(java.sql.Connection conn) throws SQLException
    {
        conn.close();
    }
}
