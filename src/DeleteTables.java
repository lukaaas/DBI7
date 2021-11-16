/*
import java.sql.*;

public class DeleteTables
{   //Entfernt alle Tabellen aus der Datenbank
    public static void deleteTables(Connection conn) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS history");
        stmt.executeUpdate("DROP TABLE IF EXISTS accounts");
        stmt.executeUpdate("DROP TABLE IF EXISTS tellers");
        stmt.executeUpdate("DROP TABLE IF EXISTS branches");
        System.out.println("Alle Tabellen wurden geloescht");
    }
}

*/