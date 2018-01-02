/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ExamenBean1;
import BEAN.ProfesorBean;
import BEAN.camionbean;
import BEAN.horariobean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class prototipodao {
    camionbean obj1=null;
    horariobean obj2=null;
    ArrayList<camionbean>lista1;
    ArrayList<horariobean>lista2;
    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement pt = null;
    public ArrayList<camionbean>ListarCamiones(){
        try {
            cn=ConexionBD.getConexion();
           // pt=cn.prepareStatement("select * from preguntas ex inner join PROFESOR pr on pr.idporfesor=ex.PROFESOR_idporfesor where ex.codexamen=ex.codexamen and pr.idporfesor= "+obj.getCodigoprofesor());
            pt=cn.prepareStatement("select * from camiones");
            rs=pt.executeQuery();
            lista1=new ArrayList<camionbean>();
            while(rs.next()){
                obj1=new camionbean();
                
                obj1.setIdcamiones(rs.getInt(1));
                obj1.setMarca(rs.getString(2));
                obj1.setModelo(rs.getString(3));
                obj1.setMatricula(rs.getString(4));

                
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
    public ArrayList<horariobean>ListarHorario(){
        try {
            cn=ConexionBD.getConexion();
           // pt=cn.prepareStatement("select * from preguntas ex inner join PROFESOR pr on pr.idporfesor=ex.PROFESOR_idporfesor where ex.codexamen=ex.codexamen and pr.idporfesor= "+obj.getCodigoprofesor());
            pt=cn.prepareStatement("SELECT * FROM horario");
            rs=pt.executeQuery();
            lista2=new ArrayList<horariobean>();
            while(rs.next()){
                obj2=new horariobean();
                
                obj2.setCodhorario(rs.getInt(1));
                obj2.setFecha(rs.getString(2));
                obj2.setLugar(rs.getString(3));
                
                
                lista2.add(obj2);
            }
            cn.close();
            pt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista2;
    }
    
    
    public int GenerarCodigocamion()
    {
        int cod=0;
        try
        {
            cn=ConexionBD.getConexion();
            pt=cn.prepareStatement("SELECT MAX(idcamiones) FROM camiones");
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
    public int Generarcodigohorario()
    {
        int cod=0;
        try
        {
            cn=ConexionBD.getConexion();
            pt=cn.prepareStatement("SELECT MAX(codhorario) FROM horario");
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
