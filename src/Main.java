import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/clase";
        String user="root";
        String pass="123456";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String querry = "Update estudiantes set b1 =? where cedula =?";
            ps = con.prepareStatement(querry);
            ps.setDouble(1,18.4);
            ps.setString(2,"0022342650");
            int a = ps.executeUpdate();
            System.out.println("Se modificaron: "+a+" Lineas");
            System.out.println("Se han ingresado los datos del estudiante");
            con.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            //cerramos la conexión
            try {
            if(ps!=null){
                ps.close();
            } if(con!=null){
                con.close();
            }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}