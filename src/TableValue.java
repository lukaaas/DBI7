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
        stmt.executeBatch();
        conn.commit();
        System.out.println("Tabelle branches wurde gefüllt!");
    }
}
