/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import BEAN.NotaBean1;
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
public class NotaDAO {
 Connection cn=null;
 ResultSet rs = null;
 PreparedStatement pt = null;
 public int GenerarCodigo()
 {
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(idnota) FROM nota;");
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
public int GenerarCodigoexamen()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(codexamen) FROM notaxexamen;");
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


        //GRABA NOTA A CADA  RESPUESTAS DEL ALUMNO
public int GrabarNota1(NotaBean1 obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("insert into nota values (?,?,?,?)");
        pt.setInt(1, obj.getCodnota());
        pt.setDouble(2, obj.getPuntaje());
        pt.setInt(3, obj.getCodpre());
        pt.setInt(4, obj.getCodalumno());
        estado=pt.executeUpdate();
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    
    return estado;
}

          //GRABAR PROMEDIO AL EXAMEN RESULTO POR EL ALUMNO
public int GrabarNotaExamen(notaxexamenbean obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("insert into notaxexamen values (?,?,?)");
        pt.setInt(1, obj.getCodexamen());
        pt.setDouble(2, obj.getPuntaje());
   //         pt.setInt(3, obj.getCodexamenprincipal());
        pt.setInt(3, obj.getCodexamenres());
        
        estado=pt.executeUpdate();
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    
    return estado;
}
}
