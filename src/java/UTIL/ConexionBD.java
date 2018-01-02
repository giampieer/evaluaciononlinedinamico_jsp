package UTIL;

import java.sql.*;

public class ConexionBD
{   
    public static Connection getConexion()
    {
        Connection cn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/evaluacionfinal", "root", "");
                // cn=DriverManager.getConnection("jdbc:mysql://mysql30772-proye.jl.serv.net.mx/evaluacionfinal","root","MDMhxv33547");

//cn=DriverManager.getConnection("jdbc:mysql://mysql30308-mariscal24.jl.serv.net.mx/evaluacionfinal","root","KKGxde78611");
            System.out.println("Se conecto!!!! ");
        } catch (Exception e)
        {
            System.out.println("No se conecto");
        }
        return cn;
    }
    
    public static void main(String[] args)
    {
        getConexion();
    }
}
