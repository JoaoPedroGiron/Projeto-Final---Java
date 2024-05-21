package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbContext {

    private String url = "jdbc:mysql://localhost:3306/crudjava";
    private String usuario = "root";
    private String senha = "java2090";

    public Connection connection = null;

    public DbContext() {

    }


    public void conectarBanco() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.usuario, this.senha);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void desconectarBanco() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResultSet executarQuerySql(String query) {
        try {
            Statement stmt = this.connection.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);
            return resultSet;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean executarUpdateSql(String query) {
        try {
            Statement stmt = this.connection.createStatement();

            stmt.executeUpdate(query);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}