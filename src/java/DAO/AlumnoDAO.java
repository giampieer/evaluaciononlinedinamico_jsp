/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.AlumnoBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class AlumnoDAO {
    
  Connection cn = null;
  ResultSet rs = null;
  PreparedStatement pt = null;
  AlumnoBean objUsuarioBean=null;
  ArrayList<AlumnoBean>lista=null;
  public int ValidarAcceso(AlumnoBean obj)
  {
    int estado=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT COUNT(*) FROM alumno WHERE idalumno=? AND contraalumno=?;");
        pt.setString(1, obj.getIdalumno());
        pt.setString(2, obj.getContraalumno());
        
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
public AlumnoBean DatosUsuario(AlumnoBean obj){
    AlumnoBean  objeto=null;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT * FROM alumno WHERE idalumno=? AND contraalumno=? ;");
        pt.setString(1, obj.getIdalumno());
        pt.setString(2, obj.getContraalumno());
        rs=pt.executeQuery();
        while(rs.next()){
            objeto=new AlumnoBean();
            objeto.setCodalumno(rs.getInt(1));
            objeto.setNomalumno(rs.getString(2));
            objeto.setIdalumno(rs.getString(3));
            objeto.setContraalumno(rs.getString(4));
            
        }
        pt.close();
        rs.close();
        cn.close();
    } catch (Exception e) {
    }
    return objeto;
} 
public ArrayList<AlumnoBean>ListarAlumno()
{
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT * FROM alumno");
        rs=pt.executeQuery();
        lista=new ArrayList<AlumnoBean>();
        while (rs.next()) {                
            objUsuarioBean=new AlumnoBean();
            objUsuarioBean.setCodalumno(rs.getInt(1));
            objUsuarioBean.setNomalumno(rs.getString(2));
            objUsuarioBean.setIdalumno(rs.getString(3));
            objUsuarioBean.setContraalumno(rs.getString(4));
            lista.add(objUsuarioBean);
        }
        cn.close();
        pt.close();
        rs.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
    return lista;
}

public int ModificarUsuario(AlumnoBean obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("update alumno set  nombalumno=?, idalumno=?, contraalumno=?, administrador_idadministrador=?  where codalumno=?;");
        
        pt.setString(1, obj.getNomalumno());
        pt.setString(2, obj.getIdalumno());
        pt.setString(3, obj.getContraalumno());
        pt.setInt(4, obj.getCodadmin());
        pt.setInt(5, obj.getCodalumno());
        
        estado=pt.executeUpdate();
        
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    return estado;
}

public int GrabarAlumno(AlumnoBean obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("INSERT INTO alumno VALUES (?,?,?,?,?)");
        pt.setInt(1, obj.getCodalumno());
        pt.setString(2, obj.getNomalumno());
        pt.setString(3, obj.getIdalumno());
        pt.setString(4, obj.getContraalumno());
        pt.setInt(5, obj.getCodadmin());
        estado=pt.executeUpdate();
        pt.close();
        cn.close();
    } catch (Exception e) {
        estado=0;
    }
    return estado;
}
public int eliminarUsuario(AlumnoBean obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("delete from alumno where codalumno=?");
        pt.setInt(1, obj.getCodalumno());
        estado=pt.executeUpdate();
        cn.close();
        pt.close();     
        
    } catch (Exception e) {
        estado=0;
    }
    return estado;
}    

public AlumnoBean CapturarAlumno(AlumnoBean obj){
    AlumnoBean objeto=null;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT * FROM alumno WHERE codalumno=?");
        pt.setInt(1, obj.getCodalumno());
        rs=pt.executeQuery();
        while(rs.next())
        {
            objeto=new AlumnoBean();
            objeto.setCodalumno(rs.getInt(1));
            objeto.setNomalumno(rs.getString(2));
            objeto.setIdalumno(rs.getString(3));
            objeto.setContraalumno(rs.getString(4));
        }
    } catch (Exception e)
    {
    }
    return objeto;
}


public int GenerarCodigo()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(codalumno) FROM alumno;");
        rs=pt.executeQuery();
        rs.next();
        cod=Integer.parseInt(rs.getString(1));
        cod=cod+1;
        pt.close();
        rs.close();
        cn.close();
    } catch (Exception e)
    {
    }
    return cod;
}
}
