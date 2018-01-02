
package DAO;

import BEAN.AlumnoBean;
import BEAN.ExamenBean1;
import BEAN.ProfesorBean;
import BEAN.RespuestasProf;
import BEAN.notaprof;
import BEAN.notaxexamenbean;
import BEAN.preguntasbean;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ExamenDAO {
    
   Connection cn=null;
   ResultSet rs = null;
   PreparedStatement pt = null;
   ExamenBean1 obj1=null;
   ArrayList<ExamenBean1>lista1=null;
   ArrayList<ProfesorBean>lista2=null;
   ArrayList<preguntasbean>lista3=null;
   ArrayList<notaxexamenbean>lista4=null;
   preguntasbean ob=null;
   ProfesorBean obj=null;
   notaxexamenbean ob33=null;

   public ExamenDAO() {
   }

//MOSTRAR EXAMENES DEL PROFESOR LOGUEADO
   public ArrayList<ExamenBean1>ListarExamenProfesor11(ProfesorBean obj){
    try {
        cn=ConexionBD.getConexion();
           // pt=cn.prepareStatement("select * from preguntas ex inner join PROFESOR pr on pr.idporfesor=ex.PROFESOR_idporfesor where ex.codexamen=ex.codexamen and pr.idporfesor= "+obj.getCodigoprofesor());
        pt=cn.prepareStatement("SELECT * FROM examen ex INNER JOIN profesor pr on pr.idporfesor=ex.profesor_idporfesor  where pr.idporfesor="+obj.getCodigoprofesor());
        rs=pt.executeQuery();
        lista1=new ArrayList<ExamenBean1>();
        while(rs.next()){
            obj1=new ExamenBean1();
            
            obj1.setCodexamen(rs.getInt(1));
            obj1.setNombreexamen(rs.getString(2));
            obj1.setCodprofesor(rs.getInt(3));
            
            
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
   //MOSTRAR EXMAENNES AL ALUMNO ANTES DE RESOLVER
public ArrayList<ExamenBean1>ListarExamenEstudiante2(AlumnoBean obj){
 
 try {
    cn=ConexionBD.getConexion();
    pt=cn.prepareStatement("select * from examen ex left join (select * from examen ex1 INNER join preguntas pre1 on pre1.examen_codexamen=ex1.codexamen inner join respuestas res1 on res1.preguntas_numpregunta=pre1.numpregunta INNER join alumno al1 on al1.codalumno=res1.alumno_codalumno WHERE al1.codalumno="+obj.getCodalumno()+") n on ex.codexamen=n.codexamen where n.codexamen is null ");
    rs=pt.executeQuery();
    lista1=new ArrayList<ExamenBean1>();
    while(rs.next()){
      obj1=new ExamenBean1();
      
      obj1.setCodexamen(rs.getInt(1));
      obj1.setNombreexamen(rs.getString(2));
      obj1.setCodprofesor(rs.getInt(3));
      
      
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

public ArrayList<ExamenBean1>ListarExamenEstudiante3(AlumnoBean obj){
 
 try {
    cn=ConexionBD.getConexion();
    pt=cn.prepareStatement("select * from examen ex left join (select * from examen ex1 INNER join preguntas pre1 on pre1.examen_codexamen=ex1.codexamen inner join respuestas res1 on res1.preguntas_numpregunta=pre1.numpregunta INNER join alumno al1 on al1.codalumno=res1.alumno_codalumno WHERE al1.codalumno="+obj.getCodalumno()+") n on ex.codexamen=n.codexamen where n.codexamen is null  and  ex.codexamen="+obj.getCodexamen());
    rs=pt.executeQuery();
    lista1=new ArrayList<ExamenBean1>();
    while(rs.next()){
      obj1=new ExamenBean1();
      
      obj1.setCodexamen(rs.getInt(1));
      obj1.setNombreexamen(rs.getString(2));
      obj1.setCodprofesor(rs.getInt(3));
      
      
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

public int GenerarCodigoexamen()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(codexamen) FROM preguntas ");
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

public int GenerarCodigoexamenrespuestas()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(idrespuestasprof) FROM respuestasprof ");
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
public int GenerarCodigopregunta()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(numpregunta) FROM preguntas;");
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
public int GenerarCodigopreguntanotaprof()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(idnotaprof) FROM notaprof;");
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
public int GenerarCodigoExamenss()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(codexamen) FROM examen;");
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


public int GenerarCodigoExamenResuelto()
{
    int cod=0;
    try
    {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("SELECT MAX(idexamenresuelto) FROM examenresuelto;");
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

           //GRABAR EXMANES HECHO POR EL PROFESOR
public int GrabarExamenprof(ExamenBean1 obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("insert into examen values (?,?,?)");
        pt.setInt(1, obj.getCodexamenprof());
        pt.setString(2, obj.getNombreexamen());
        pt.setInt(3, obj.getCodprofesor());
        
        
        estado=pt.executeUpdate();
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    
    return estado;
}

    //GRABAR EXAMEN RESULTO DEL ALUMNO
public int GrabarExamenResueltoss(ExamenBean1 obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("insert into examenresuelto values (?,?,?)");
        pt.setInt(1, obj.getCodexamenprof());
        pt.setInt(2, obj.getCodexamen());
        pt.setInt(3, obj.getCodalumno());
        
        
        estado=pt.executeUpdate();
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    
    return estado;
}

       //GRABRA LAS PREGUNTAS DEL EXAMEN DEL PROFE
public int GrabarExamen1(ExamenBean1 obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("insert into preguntas values (?,?,?)");
        pt.setInt(1, obj.getNumerpregunta());
        pt.setString(2, obj.getPregunta());
        pt.setInt(3,obj.getCodexamenprof());


        
        
        estado=pt.executeUpdate();
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    
    return estado;
}


     //GRABARA LAS RESPUESTAS DE LAS PREGUNTAS HECHAS POR EL PROFESOR
public int GrabarRespuestaProf(RespuestasProf obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("insert into respuestasprof values (?,?,?)");
        pt.setInt(1, obj.getCodrepuestaprof());
        pt.setString(2,obj.getRespuesta());
        pt.setInt(3, obj.getCodnumpregunta());
        

        
        
        estado=pt.executeUpdate();
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    
    return estado;
}

        //GRABAR NOTA POR CADA PREGUNTA HECHA POR EL PROFESOR
public int GrabarNotaProf (notaprof obj){
    int estado=0;
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("insert into notaprof values (?,?,?)");
        pt.setInt(1, obj.getCodnota());
        pt.setDouble(2,obj.getPuntaje());
        pt.setInt(3, obj.getCodpregunta());
        

        
        
        estado=pt.executeUpdate();
        cn.close();
        pt.close();
    } catch (Exception e) {
        estado=0;
    }
    
    return estado;
}


     //MOSTRAR LAS PREGUNTAS DE UN EXAMEN SELCCIONADO POR EL ALUMNO
public ArrayList<ExamenBean1>capturarExamen1(ExamenBean1 obj){
 
 try {
    cn=ConexionBD.getConexion();
           // pt=cn.prepareStatement("select * from preguntas ex inner join PROFESOR pr on pr.idporfesor=ex.PROFESOR_idporfesor where ex.codexamen=ex.codexamen and pr.idporfesor= "+obj.getCodigoprofesor());
           //AAAAAAAAAAA pt=cn.prepareStatement("select * from preguntas pre left join respuestas res on pre.numpregunta=res.preguntas_numpregunta   where res.preguntas_numpregunta  is null and codexamen=?");
    
    pt=cn.prepareStatement("SELECT pre.numpregunta,pre.pregunta,pre.examen_codexamen,ex2.nombexamen FROM preguntas pre inner join examen ex2 on ex2.codexamen=pre.examen_codexamen left join (SELECT * from preguntas pre1 INNER join respuestas res on pre1.numpregunta=res.preguntas_numpregunta INNER join alumno al on al.codalumno=res.alumno_codalumno where al.codalumno="+obj.getCodalumno()+" )n on pre.numpregunta=n.numpregunta where n.numpregunta is null AND ex2.codexamen="+obj.getCodexamen()+"");
    rs=pt.executeQuery();
    lista1=new ArrayList<ExamenBean1>();
    while(rs.next()){
        obj1=new ExamenBean1();
        obj1.setNumerpregunta(rs.getInt(1));
        obj1.setPregunta(rs.getString(2));
        obj1.setCodexamen(rs.getInt(3));
        obj1.setNombreexamen(rs.getString(4));

        
        
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
     //CAPTURAR LAS POSIBLES RESPUESTAS POR UNA PREGUNTA SELECCIONADA POR EL ALUMNO
public ArrayList<preguntasbean>capturarposiblesrespuestas(preguntasbean obj){
 
 try {
    cn=ConexionBD.getConexion();
           // pt=cn.prepareStatement("select * from preguntas ex inner join PROFESOR pr on pr.idporfesor=ex.PROFESOR_idporfesor where ex.codexamen=ex.codexamen and pr.idporfesor= "+obj.getCodigoprofesor());
    pt=cn.prepareStatement("select n.puntaje,res.respuestasprofcol,pre.pregunta from preguntas pre inner join respuestasprof res on pre.numpregunta=res.preguntas_numpregunta inner join notaprof n on res.idrespuestasprof=n.respuestasprof_idrespuestasprof where pre.numpregunta="+obj.getCodpregunta());
    
    rs=pt.executeQuery();
    lista3=new ArrayList<preguntasbean>();
    while(rs.next()){
        ob=new preguntasbean();
        ob.setPuntaje(rs.getDouble(1));
        ob.setRespuesta(rs.getString(2));
        ob.setPregunta(rs.getString(3));
        
        
        
        
        lista3.add(ob);
    }
    cn.close();
    pt.close();
    rs.close();
} catch (Exception e) {
    e.printStackTrace();
}
return lista3;

}

//MOSTRAR LAS NOTAS DEL ALUMNO
public ArrayList<notaxexamenbean>ListarExamenALUMO1(AlumnoBean obj1){
    try {
        cn=ConexionBD.getConexion();
        pt=cn.prepareStatement("select exres.codexamen,n.puntaje,al.codalumno from notaxexamen n INNER join examenresuelto exres on exres.idexamenresuelto=n.examenresuelto_idexamenresuelto INNER JOIN alumno al on al.codalumno= exres.alumno_codalumno where al.codalumno="+obj1.getCodalumno());
        rs=pt.executeQuery();
        lista4=new ArrayList<notaxexamenbean>();
        while(rs.next()){
            ob33=new notaxexamenbean();
            ob33.setCodexamen(rs.getInt(1));
            ob33.setPuntaje(rs.getDouble(2));
            ob33.setCodalumno(rs.getInt(3));
            
            lista4.add(ob33);
        }
        cn.close();
        pt.close();
        rs.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista4;
}

}
