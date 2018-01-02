/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.AlumnoBean;
import BEAN.ProfesorBean;
import BEAN.notaxexamenbean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class ProfesorDAO {
    
  Connection cn = null;
  ResultSet rs = null;
  PreparedStatement pt = null;
  ProfesorBean objbean=null;
  ArrayList<ProfesorBean>lista=null;
  ArrayList<notaxexamenbean>lista1=null;
  notaxexamenbean obj1=null;
  public int ValidarAcceso(ProfesorBean obj)
  {
    int estado=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT COUNT(*) FROM profesor WHERE idprofesor=? AND contraprofesor=?;");
        pt.setString(1, obj.getIdprofesor());
        pt.setString(2, obj.getContraprofesor());
        
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
public ProfesorBean DatosUsuario(ProfesorBean obj){
    ProfesorBean  objeto=null;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT * FROM profesor WHERE idprofesor=? AND contraprofesor=? ;");
        pt.setString(1, obj.getIdprofesor());
        pt.setString(2, obj.getContraprofesor());
        rs=pt.executeQuery();
        while(rs.next()){
            objeto=new ProfesorBean();
            objeto.setCodigoprofesor(rs.getInt(1));
            objeto.setNombprofesor(rs.getString(2));
            objeto.setIdprofesor(rs.getString(3));
            objeto.setContraprofesor(rs.getString(4));
            
        }
        pt.close();
        rs.close();
        cn.close();
    } catch (Exception e) {
    }
    return objeto;
} 

     //MOSTRAR TODOS LO EXAMENES REVISADOS POR EL PROFESOR
public ArrayList<notaxexamenbean>ListarExamenProfesor(ProfesorBean obj){
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("select exres.codexamen,n.puntaje,ex.profesor_idporfesor,al.codalumno,al.nombalumno from notaxexamen n INNER join examenresuelto exres on exres.idexamenresuelto=n.examenresuelto_idexamenresuelto INNER join alumno al on al.codalumno=exres.alumno_codalumno INNER JOIN examen ex on ex.codexamen=exres.codexamen where ex.profesor_idporfesor="+obj.getCodigoprofesor());
        rs=pt.executeQuery();
        lista1=new ArrayList<notaxexamenbean>();
        while(rs.next()){
            obj1=new notaxexamenbean();
            obj1.setCodexamen(rs.getInt(1));
            obj1.setPuntaje(rs.getDouble(2));
            obj1.setCodprof(rs.getInt(3));
            obj1.setCodalumno(rs.getInt(4));       
            obj1.setNombrealumno(rs.getString(5));
            lista1.add(obj1);
        }
        cn.close();
        pt.close();
        rs.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista1;
}
public ArrayList<ProfesorBean>ListarProfesor()
{
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT * FROM profesor");
        rs=pt.executeQuery();
        lista=new ArrayList<ProfesorBean>();
        while (rs.next()) {                
            objbean=new ProfesorBean();
            objbean.setCodigoprofesor(rs.getInt(1));
            objbean.setNombprofesor(rs.getString(2));
            objbean.setIdprofesor(rs.getString(3));
            objbean.setContraprofesor(rs.getString(4));
            lista.add(objbean);
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

public int ModificarUsuario(ProfesorBean obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("update profesor set  nombprofesor=?, idprofesor=?, contraprofesor=?, administrador_idadministrador=?  where idporfesor=?;");
        
        pt.setString(1, obj.getNombprofesor());
        pt.setString(2, obj.getIdprofesor());
        pt.setString(3, obj.getContraprofesor());
        pt.setInt(4, obj.getCodadmin());
        pt.setInt(5, obj.getCodigoprofesor());
        
        estado=pt.executeUpdate();
        
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    return estado;
}

public int GrabarProfesor(ProfesorBean obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("INSERT INTO profesor VALUES (?,?,?,?,?)");
        pt.setInt(1, obj.getCodigoprofesor());
        pt.setString(2, obj.getNombprofesor());
        pt.setString(3, obj.getIdprofesor());
        pt.setString(4, obj.getContraprofesor());
        pt.setInt(5, obj.getCodadmin());
        estado=pt.executeUpdate();
        pt.close();
        cn.close();
    } catch (Exception e) {
        estado=0;
    }
    return estado;
}
public int eliminarUsuario(ProfesorBean obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("delete from profesor where idporfesor=?");
        pt.setInt(1, obj.getCodigoprofesor());
        estado=pt.executeUpdate();
        cn.close();
        pt.close();     
        
    } catch (Exception e) {
        estado=0;
    }
    return estado;
}    

public ProfesorBean CapturarProfesor(ProfesorBean obj){
    ProfesorBean objeto=null;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT * FROM profesor WHERE idporfesor=?");
        pt.setInt(1, obj.getCodigoprofesor());
        rs=pt.executeQuery();
        while(rs.next())
        {
            objeto=new ProfesorBean();
            objeto.setCodigoprofesor(rs.getInt(1));
            objeto.setNombprofesor(rs.getString(2));
            objeto.setIdprofesor(rs.getString(3));
            objeto.setContraprofesor(rs.getString(4));
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
        pt=cn.prepareStatement("SELECT MAX(idporfesor) FROM profesor;");
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
