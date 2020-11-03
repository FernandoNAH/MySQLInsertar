package mysqlinsertar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Fer
 */
public class MySQLInsertar {

    Connection con;

    public MySQLInsertar() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreriadb;", "root", "");

        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
    }

    public static void main(String[] args) {
        MySQLInsertar cn = new MySQLInsertar();
        String autor = "Trygve Gulbranssen";
        String sql = "INSERT INTO Autores(Nombre) VALUES(?)";
        try {
            PreparedStatement pst;
            pst = cn.con.prepareStatement(sql);
            pst.setString(1, autor);
            pst.execute();

            System.out.println("Un nuevo autor a sido insertado");

            cn.con.close();
        } catch (Exception e) {
        }

    }

}
