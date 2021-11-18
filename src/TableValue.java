import java.sql.*;

public class TableValue
{
    static PreparedStatement stmt;

    public void fillBranchesL(int n, Connection conn) throws SQLException, Exception
    {
        PreparedStatement stmt =  conn.prepareStatement("INSERT INTO branches VALUES (?, 'abababababababababab', 0, 'abcdefghijklmnopqrstuvwxyzabababababababababababababababababababababab');");
        stmt.close();
        for (int i = 1; i <= n; i++)
        {
            int branchId = i;
            try
            {
                System.out.println(i);
                stmt.setInt(1,i);
                stmt.executeUpdate(); //Executes the query
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        conn.commit();
        System.out.println("Tabelle branches wurde gefuellt");
    }

    public void fillBranches(int n, Connection conn) throws SQLException, Exception
    {
        String branch = "INSERT INTO branches (branchname, balance, address) values (?, 0, ?)";
        stmt = conn.prepareStatement(branch);
        String branchname= RandomStringGenerator.generateString(20, RandomStringGenerator.Mode.ALPHA);
        String address= RandomStringGenerator.generateString(72, RandomStringGenerator.Mode.ALPHA);
        for(int i = 1; i <= n; i++)
        {
            stmt.setString(1, branchname);
            stmt.setString(2, address);
            stmt.executeUpdate();
        }
        stmt.executeUpdate();
        conn.commit();
        System.out.println("Tabelle branches wurde gefüllt!");
    }
/*
    public void fillAccounts(int n, Connection conn) throws SQLException, Exception
    {
        String accounts = "INSERT INTO accounts(name, balance, branchid, address) values(?,0,?,?)";
        stmt = conn.prepareStatement(accounts);

        for(int i = 0; i <= n * 1000; i++)
        {
            stmt.setString(1,RandomStringGenerator.generateString(20, RandomStringGenerator.Mode.ALPHA));
            stmt.setInt(2,(int) Math.abs(Math.random() * n) +1);
            stmt.setString(3,RandomStringGenerator.generateString(68, RandomStringGenerator.Mode.ALPHA));
            stmt.executeUpdate();
        }
        conn.commit();
        System.out.println("Tabelle accounts wurde gef�llt!");
    }
    public void fillTellers(int n, Connection conn) throws SQLException, Exception
    {
        String tellers ="INSERT INTO tellers (tellername, balance, branchid, address) values (?, 0, ?, ?)";
        stmt = conn.prepareStatement(tellers);
        for(int i = 0; i <= n * 10; i++)
        {
            stmt.setString(1, RandomStringGenerator.generateString(20, RandomStringGenerator.Mode.ALPHA));
            stmt.setInt(2, (int) Math.abs(Math.random() * n) + 1);
            stmt.setString(3, RandomStringGenerator.generateString(68, RandomStringGenerator.Mode.ALPHA));
            stmt.executeUpdate();
        }
        conn.commit();
        System.out.println("Tabelle tellers wurde gef�llt!");
    }
*/

}

