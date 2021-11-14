import java.sql.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        //Aufbau der Verbindung
        Connection conn = Verbindung.dbConnection();

        //Loeschen der alten Tabellen branches, accounts, tellers und history
        DeleteTables.deleteTables(conn);

        //Erstellen der Tabelle branches
        Tables.createBranches(conn);

        //Erstellen der Tabelle accounts
        Tables.createAccounts(conn);

        //Erstellen der Tabelle tellers
        Tables.createTellers(conn);

        //Erstellen der Tabelle history
        Tables.createHistory(conn);
    }
}
