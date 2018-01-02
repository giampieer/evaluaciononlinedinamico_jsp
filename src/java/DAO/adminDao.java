
package DAO;

import BEAN.AdministradorBean;
import BEAN.AlumnoBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class adminDao {
   Connection cn = null;
   ResultSet rs = null;
   PreparedStatement pt = null;
   AlumnoBean objUsuarioBean=null;
   ArrayList<AdministradorBean>lista=null;
   public int ValidarAcceso(AdministradorBean obj)
   {
    int estado=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT COUNT(*) FROM administrador WHERE idadmin=? AND contraadmin=?;");
        pt.setString(1, obj.getIdadmin());
        pt.setString(2, obj.getContradmin());
        
        rs=pt.executeQuery();
        if(rs.next())
        {
            estado = rs.getInt(1);
        }
        rs.close();
        pt.close();
        cn.close();
    } catch (Exception e)
    {
        estado = 0;
    }
    return estado;
}
public AdministradorBean DatosUsuario(AdministradorBean obj){
    AdministradorBean  objeto=null;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT * FROM administrador WHERE idadmin=? AND contraadmin=? ;");
        pt.setString(1, obj.getIdadmin());
        pt.setString(2, obj.getContradmin());
        rs=pt.executeQuery();
        while(rs.next()){
            objeto=new AdministradorBean();
            objeto.setCodadmin(rs.getInt(1));
            objeto.setNomadmin(rs.getString(2));
            objeto.setIdadmin(rs.getString(3));
            objeto.setContradmin(rs.getString(4));
            
        }
        pt.close();
        rs.close();
        cn.close();
    } catch (Exception e) {
    }
    return objeto;
} 

}
