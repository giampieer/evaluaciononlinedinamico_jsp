/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ExamenBean1;
import BEAN.ExamenReseultoBean1;
import BEAN.ProfesorBean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class ExamenResueltoDAO {
 Connection cn=null;
 ResultSet rs = null;
 PreparedStatement pt = null;

 ExamenReseultoBean1 objresbean1=null;
 ArrayList<ExamenReseultoBean1>lista1=null;
 ArrayList<ExamenBean1>lista2=null;
 ExamenBean1 obj1=null;

     //GRABAR UNA RESPUESTA DE Y¿UN EXAMEN HECHO POR EL ALUMNO
 public int GrabarExamenResuelto1(ExamenReseultoBean1 obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("insert into respuestas values (?,?,?)");
        pt.setInt(1, obj.getCodpreg());
        pt.setInt(2, obj.getCodalumno());
        pt.setString(3, obj.getRespuesta());
        
        
        
        estado=pt.executeUpdate();
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    
    return estado;
}

public int GenerarCodigo()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(idexamresuelto) FROM examenresuelto;");
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

   //MOSTRAR ALUMNOS QUE LE FALTA REVISAR SUS EXAMENS
public ArrayList<ExamenReseultoBean1>ListarExamenResueltosProfesor1(ProfesorBean obj){
    try {
        cn=ConexionBD.getConexion();
        //    pt=cn.prepareStatement("select * from EXAMENRESUELTO exres  inner join EXAMEN ex on ex.idexamen=exres.EXAMEN_idexamen inner join PROFESOR pr on pr.idporfesor=ex.PROFESOR_idporfesor where pr.idporfesor= "+obj.getCodigoprofesor());
        pt=cn.prepareStatement("select exres.codexamen,ex.nombexamen,al.nombalumno,al.codalumno from examenresuelto exres inner join alumno al on al.codalumno=exres.alumno_codalumno left join notaxexamen n on exres.idexamenresuelto=n.examenresuelto_idexamenresuelto inner join examen ex on ex.codexamen=exres.codexamen inner join profesor pr on pr.idporfesor=ex.profesor_idporfesor where n.examenresuelto_idexamenresuelto is null and pr.idporfesor ="+obj.getCodigoprofesor()+" group by al.codalumno");

        rs=pt.executeQuery();
        lista1=new ArrayList<ExamenReseultoBean1>();
        while(rs.next()){
            objresbean1=new ExamenReseultoBean1();
            objresbean1.setCodexamen(rs.getInt(1));
            objresbean1.setNombreexamen(rs.getString(2));
            objresbean1.setNombrealumno(rs.getString(3));
            objresbean1.setCodalumno(rs.getInt(4));
            
            
            
            
            
            lista1.add(objresbean1);
        }
        cn.close();
        pt.close();
        rs.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista1;
}
//MOSTRAR LOS EXAMENES QUE FALTA REVISAR A UN ALUMNO SELECCIONADO POR EL PROFESOR
public ArrayList<ExamenReseultoBean1>ListarExamenResueltosProfesor3(ProfesorBean obj){
    try {
        cn=ConexionBD.getConexion();
        //    pt=cn.prepareStatement("select * from EXAMENRESUELTO exres  inner join EXAMEN ex on ex.idexamen=exres.EXAMEN_idexamen inner join PROFESOR pr on pr.idporfesor=ex.PROFESOR_idporfesor where pr.idporfesor= "+obj.getCodigoprofesor());
         // pt=cn.prepareStatement("SELECT ex.codexamen,ex.nombexamen,al.nombalumno,al.codalumno from examen ex INNER join preguntas pre on pre.EXAMEN_codexamen=ex.codexamen inner join profesor pr on pr.idporfesor=ex.PROFESOR_idporfesor inner join respuestas res on res.preguntas_numpregunta=pre.numpregunta INNER join alumno al on al.codalumno=res.ALUMNO_codalumno LEFT JOIN nota n on res.preguntas_numpregunta=n.respuestas_preguntas_numpregunta where n.respuestas_preguntas_numpregunta is null and pr.idporfesor="+obj.getCodigoprofesor()+" and al.codalumno="+obj.getCodalumno()+" group by  ex.codexamen  ");
        pt=cn.prepareStatement("select ex.idexamenresuelto,ex.codexamen,ex.alumno_codalumno ,al.nombalumno,ex1.nombexamen   from  examenresuelto ex  inner join alumno al on al.codalumno=ex.alumno_codalumno inner  join examen ex1 on ex1.codexamen=ex.codexamen inner join profesor pr on pr.idporfesor=ex1.profesor_idporfesor left join notaxexamen n on ex.idexamenresuelto=n.examenresuelto_idexamenresuelto where n.examenresuelto_idexamenresuelto is null and ex.alumno_codalumno="+obj.getCodalumno()+" and pr.idporfesor="+obj.getCodigoprofesor());
        rs=pt.executeQuery();
        lista1=new ArrayList<ExamenReseultoBean1>();
        while(rs.next()){
            objresbean1=new ExamenReseultoBean1();
            objresbean1.setCodexamenresuelto(rs.getInt(1));
            objresbean1.setCodexamen(rs.getInt(2));
            
            objresbean1.setCodalumno(rs.getInt(3));
            objresbean1.setNombrealumno(rs.getString(4));
            objresbean1.setNombreexamen(rs.getString(5));
            
            
            
            
            
            lista1.add(objresbean1);
        }
        cn.close();
        pt.close();
        rs.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista1;
}

       //MOSTRAR LAS PREGUNTAS DE UN EXAMEN QUE ESTA RESOLVIENDO EL ALUMNO
public ArrayList<ExamenBean1> capturarExamenResuelto2(ExamenBean1 obj){
    
   try {
    cn=ConexionBD.getConexion();
           // pt=cn.prepareStatement("select * from preguntas ex inner join PROFESOR pr on pr.idporfesor=ex.PROFESOR_idporfesor where ex.codexamen=ex.codexamen and pr.idporfesor= "+obj.getCodigoprofesor());
    pt=cn.prepareStatement("SELECT  pre.numpregunta, ex.codexamen, pre.pregunta, pr.idporfesor,res.respuesta,res.alumno_codalumno FROM respuestas res inner join preguntas pre on pre.numpregunta=res.preguntas_numpregunta INNER join examen ex on ex.codexamen=pre.examen_codexamen inner join profesor pr on pr.idporfesor=ex.profesor_idporfesor  WHERE ex.codexamen="+obj.getCodexamen()+" and  res.alumno_codalumno="+obj.getCodalumno());
    
    rs=pt.executeQuery();
    lista2=new ArrayList<ExamenBean1>();
    while(rs.next()){
        obj1=new ExamenBean1();
        obj1.setNumerpregunta(rs.getInt(1));
        obj1.setCodexamen(rs.getInt(2));
        obj1.setPregunta(rs.getString(3));
        obj1.setCodprofesor(rs.getInt(4));
        obj1.setRespuesta(rs.getString(5));
        obj1.setCodalumno(rs.getInt(6));
        
        
        lista2.add(obj1);
    }
    cn.close();
    pt.close();
    rs.close();
} catch (Exception e) {
    e.printStackTrace();
}
return lista2;
}




}
