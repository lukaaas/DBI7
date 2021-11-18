import java.sql.*;
import java.util.Scanner;

public class Main
{
    static Scanner scan = new Scanner(System.in);

    public static void deleteTables(Connection conn) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("Drop TABLE IF EXISTS history");
        stmt.executeUpdate("DROP TABLE IF EXISTS accounts");
        stmt.executeUpdate("DROP TABLE IF EXISTS tellers");
        stmt.executeUpdate("DROP TABLE IF EXISTS branches");
        System.out.println("Alle Tabellen wurden geloescht");
    }

    public static void main(String[] args) throws Exception
    {
        //Aufbau der Verbindung
        Connection conn = Connect.dbConnection();

        //Loeschen der alten Tabellen branches, accounts, tellers und history
        deleteTables(conn);

        //Erstellen der Tabelle branches
        TablesAlt.createBranches(conn);

        //Erstellen der Tabelle accounts
        TablesAlt.createAccounts(conn);

        //Erstellen der Tabelle tellers
        TablesAlt.createTellers(conn);

        //Erstellen der Tabelle history
         TablesAlt.createHistory(conn);

        //Eingabe n
        System.out.println("Geben Sie n ein: ");
        int n = scan.nextInt();

        TableValue values = new TableValue();
        long start = System.currentTimeMillis();
        values.fillBranches(n, conn);
        values.fillAccounts(n, conn);
        values.fillTellers(n, conn);
        long ende = System.currentTimeMillis();
        System.out.println(ende - start);
    }
}
