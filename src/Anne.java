import com.mysql.cj.xdevapi.Result;

import java.sql.*;

public class Anne
{
    public static void main(String[] args) throws SQLException
    {

        Connection conn = DriverManager.getConnection("jdbc:mysql://10.1.31.206:3306/DBI","dbi","root");

        Statement st = conn.createStatement();
        long start = System.currentTimeMillis();
        datenbank(1000,conn);
        long ende= System.currentTimeMillis();

        System.out.println("Dauer der Anwendung  "+(ende-start));

        conn.close();
        st.close();

    }

    static void datenbank (int n, Connection conn) {
        for (int i = 1; i <= n; i++) {
            int test = i;

            try {
                PreparedStatement queryStatement = conn.prepareStatement("INSERT INTO dbi.branches VALUES (" + test + ", 'abababababababababab', 0, 'abcdefghijklmnopqrstuvwxyzabababababababababababababababababababababab');");

                queryStatement.executeUpdate(); //Executes the query
                queryStatement.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }}