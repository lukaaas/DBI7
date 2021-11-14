import java.sql.*;

public class Tables
{
    static PreparedStatement stmt;

    public static void createBranches(Connection conn)throws SQLException
    {
        stmt = conn.prepareStatement("CREATE TABLE branches (branchid int not null, branchname char(20) not null,"
                + "balance int not null, address char(72) not null, primary key(branchid));");
        stmt.executeUpdate();
        System.out.println("Tabelle branches wurde erstellt");
    }

    public static void createAccounts(Connection conn)throws SQLException
    {
        stmt = conn.prepareStatement("CREATE TABLE accounts(accid int not null, name char(20) not null,"
                + "balance int not null, branchid int not null, address char(68) not null, primary key(accid));");
        stmt.executeUpdate();
        System.out.println("Tabelle accounts wurde erstellt");
    }

    public static void createTellers(Connection conn)throws SQLException
    {
        stmt = conn.prepareStatement("CREATE TABLE tellers(tellerid int not null, tellername char(20) not null,"
                + "balance int not null, branchid int not null, address char(68)not null, primary key(tellerid));");
        stmt.executeUpdate();
        System.out.println("Tabelle tellers wurde erstellt");
    }

    public static void createHistory(Connection conn)throws SQLException
    {
        stmt = conn.prepareStatement("CREATE TABLE history(accid int not null, tellerid int not null, delta int not null,"
                + "branchid int not null, accbalance int not null, cmmnt char(30) not null, foreign key(accid) references accounts(accid),"
                + "foreign key(tellerid) references tellers(tellerid), foreign key (branchid) references branches(branchid));");
        stmt.executeUpdate();
        System.out.println("Tabelle history wurde erstellt");
    }
}
