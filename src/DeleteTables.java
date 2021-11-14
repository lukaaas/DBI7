import java.sql.*;

public class DeleteTables
{
    public static void deleteTables(Connection conn) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS branches");
        stmt.executeUpdate("DROP TABLE IF EXISTS accounts");
        stmt.executeUpdate("DROP TABLE IF EXISTS tellers");
        stmt.executeUpdate("DROP TABLE IF EXISTS history");
        System.out.println("Alle Tabellen wurden geloescht");
    }
}

