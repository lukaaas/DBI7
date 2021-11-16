import java.sql.*;

public class TableValue
{
    static PreparedStatement stmt;

    public void fillBranches(int n, Connection conn) throws SQLException, Exception
    {
        String branch = "INSERT INTO branches (branchname, balance, address) values (?, 0, ?)";
        stmt = conn.prepareStatement(branch);
        String branchname= RandomStringGenerator.generateString(20, RandomStringGenerator.Mode.ALPHA);
        String address= RandomStringGenerator.generateString(72, RandomStringGenerator.Mode.ALPHA);
        for(int i = 0; i < n; i++)
        {
            stmt.setString(1, branchname);
            stmt.setString(2, address);
            stmt.addBatch();
        }
        stmt.executeUpdate();
        conn.commit();
        System.out.println("Tabelle branches wurde gefüllt!");
    }

    public void fillAccounts(int n, Connection conn) throws SQLException, Exception
    {
        String accounts = "INSERT INTO accounts (name, balance, branchid, address) values (?, 0, ?, ?)";
        stmt = conn.prepareStatement(accounts);


        String name = RandomStringGenerator.generateString(20, RandomStringGenerator.Mode.ALPHA);
        String address = RandomStringGenerator.generateString(68, RandomStringGenerator.Mode.ALPHA);
        for (int i = 0; i <= n * 100000; i++)
        {
            stmt.setString(1, name);
            stmt.setInt(2, (int) Math.abs(Math.random() * n) + 1);
            stmt.setString(3, address);
         stmt.executeUpdate();
         conn.commit();
        }
        System.out.println("Tabelle accounts wurde gefüllt!");
    }
        public void fillTellers(int n, Connection conn) throws SQLException, Exception
        {
            String tellers ="INSERT INTO tellers (tellername, balance, branchid, address) values (?, 0, ?, ?)";
            stmt = conn.prepareStatement(tellers);
            String tellername = RandomStringGenerator.generateString(20, RandomStringGenerator.Mode.ALPHA);
            String address = RandomStringGenerator.generateString(68, RandomStringGenerator.Mode.ALPHA);
            for(int i = 0; i < n * 10; i++)
            {
                stmt.setString(1, tellername);
                stmt.setInt(2, (int) Math.abs(Math.random() * n) + 1);
                stmt.setString(3, address);
            }
            stmt.executeUpdate();
            conn.commit();
            System.out.println("Tabelle tellers wurde gefüllt!");
        }
    }

