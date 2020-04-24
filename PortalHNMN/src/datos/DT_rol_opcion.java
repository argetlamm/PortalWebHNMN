package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_opcion;
import entidades.Tbl_rol_opcion;
import entidades.V_tbl_Rol_Opcion;

public class DT_rol_opcion {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
    private ResultSet rsVisRolOpc;

    
    /////////////////////Mostrar de la tabla vieja donde se muestra todo/////////////////////////
    public ArrayList<V_tbl_Rol_Opcion> listRolOpcionVista() throws SQLException{
    	Connection c = PoolConexion.getConnection();
    	ArrayList<V_tbl_Rol_Opcion> vRolOpc = new ArrayList<V_tbl_Rol_Opcion>();
    	try {
    		PreparedStatement ps = c.prepareStatement("SELECT * FROM public.\"V_tbl_Rol_Opcion\" where id_rol= 1",  
    				ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
    		
    		rsVisRolOpc = ps.executeQuery();
    		while(rsVisRolOpc.next()) {
    			V_tbl_Rol_Opcion vTblRolOpc = new V_tbl_Rol_Opcion();
    			vTblRolOpc.setRol_name(rsVisRolOpc.getString("rol_name"));
    			vTblRolOpc.setOpcion(rsVisRolOpc.getString("opcion"));
    			
    			vTblRolOpc.setId_rol_opcion(rsVisRolOpc.getInt("id_rol_opcion"));
    			vTblRolOpc.setId_rol(rsVisRolOpc.getInt("id_rol"));

    			vTblRolOpc.setId_opcion(rsVisRolOpc.getInt("id_opcion"));

    			vRolOpc.add(vTblRolOpc);
    		}
    	}catch (Exception e) {
            System.out.println("DATOS: ERROR en listarRolOpcionVista() " + e.getMessage());
            e.printStackTrace();
        } finally {
        	c.close();
        }    	
    	return vRolOpc;
    }
    
    ///////////////////////////////AQUI INICIA LOS NUEVOS METODOS////////////////////////////////////
    
 // Metodo para visualizar todas las opciones  y roles asignados

 	public ArrayList<V_tbl_Rol_Opcion> listarRolOpcion(int id_rol) throws SQLException{
    	Connection c = PoolConexion.getConnection();
    	ArrayList<V_tbl_Rol_Opcion> vRolOpc = new ArrayList<V_tbl_Rol_Opcion>();
    	try {
    		PreparedStatement ps = c.prepareStatement("SELECT * FROM public.\"V_tbl_Rol_Opcion\" where id_rol= ?",  
    				ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
    		ps.setInt(1, id_rol);
    		
    		rsVisRolOpc = ps.executeQuery();
    		while(rsVisRolOpc.next()) {
    			V_tbl_Rol_Opcion vTblRolOpc = new V_tbl_Rol_Opcion();
    			vTblRolOpc.setRol_name(rsVisRolOpc.getString("rol_name"));
    			vTblRolOpc.setOpcion(rsVisRolOpc.getString("opcion"));
    			
    			vTblRolOpc.setId_rol_opcion(rsVisRolOpc.getInt("id_rol_opcion"));
    			vTblRolOpc.setId_rol(rsVisRolOpc.getInt("id_rol"));

    			vTblRolOpc.setId_opcion(rsVisRolOpc.getInt("id_opcion"));

    			vRolOpc.add(vTblRolOpc);
    		}
    	}catch (Exception e) {
            System.out.println("DATOS: ERROR en listarRolOpcionVista() " + e.getMessage());
            e.printStackTrace();
        } /*finally {
        	c.close();
        }    */	
    	return vRolOpc;
    }
 	


 	// Metodo para listar todas las opciones que puede tener un rol
 	public ArrayList<Tbl_opcion> listarOpcionesDisponibles(int rol) throws SQLException{
    	Connection c = PoolConexion.getConnection();
    	ArrayList<Tbl_opcion> listaOpcion = new ArrayList<Tbl_opcion>();
 		//ya filtrado
 		ArrayList<Tbl_opcion> opcionesDisponibles = new ArrayList<Tbl_opcion>();
    	try {
    		//para listar todas las opciones posibles
 			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_opcion where estado<>3", 
 					ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
 			rsVisRolOpc = ps.executeQuery();
 			while(rsVisRolOpc.next())
 			{
 				Tbl_opcion top = new Tbl_opcion();
 				top.setId_opcion(rsVisRolOpc.getInt("id_opcion"));
 				top.setOpcion(rsVisRolOpc.getString("opcion"));
 				top.setOpcion_desc(rsVisRolOpc.getString("opcion_desc"));
 				listaOpcion.add(top);
 			}
 		
 			// para listar las opciones que tiene un rol
 		ArrayList<Tbl_rol_opcion> opcionesOcupadas = new ArrayList<Tbl_rol_opcion>();
 			
 		ps = c.prepareStatement("SELECT id_opcion from tbl_rol_opcion WHERE id_rol = ?", 
 				ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
 		ps.setInt(1, rol);
 		
 		rsVisRolOpc = ps.executeQuery();
 		while(rsVisRolOpc.next())
 		{
 			Tbl_rol_opcion trop  = new Tbl_rol_opcion();
 			trop.setId_opc(rsVisRolOpc.getInt("id_opcion"));
 			
 			opcionesOcupadas.add(trop);
 		}
 		
 		
 		//vamos a comparar los id de los dos arraylist para ver cuales opciones podemos cargar
 		boolean existe = false;
 		
 		for(Tbl_opcion top : listaOpcion ) {
 			
 			
 			for(Tbl_rol_opcion trop : opcionesOcupadas) {
 				//si encuentra el id de una opcion asignada 
 				if(top.getId_opcion() == trop.getId_opc()) {
 					existe = true;
 					break;
 				}
 				
 			}

 			if(existe == false) {
 				
 				opcionesDisponibles.add(top);
 			}
 			existe = false;
 		}
    		
    	}catch (Exception e) {
            System.out.println("DATOS: ERROR en listarOpcionesDisponibles() " + e.getMessage());
            e.printStackTrace();
        } finally {
        	c.close();
        }    	
    	return opcionesDisponibles;
    }
 	//-----------------------------------------------------------
 	
 	
 	public boolean asignarOpcionesARol(int id_rol, String StrId_opciones) throws SQLException
 	{
 		Connection c = PoolConexion.getConnection();
 		boolean guardado = false;
 		
 		try
 		{
 			
 			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_rol_opcion", 
 					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
 					ResultSet.HOLD_CURSORS_OVER_COMMIT);
 			//se separa la cadena que viene separada en cadenas de numeros
 			String[] array_ids_opciones = StrId_opciones.split(",");
 			
 			ArrayList<Integer> ids_opciones= new ArrayList<Integer>();
 			
 			//creamos un arraylist para guardar los id parseados
 			for(int i = 0; i < array_ids_opciones.length; i++) {
 				
 				ids_opciones.add(Integer.parseInt(array_ids_opciones[i]));
 				
 			}
 			
 			rsVisRolOpc = ps.executeQuery();
 			for(int id_opcion : ids_opciones) {
 				
 				rsVisRolOpc.moveToInsertRow();
 				rsVisRolOpc.updateInt("id_rol", id_rol);
 				rsVisRolOpc.updateInt("id_opcion", id_opcion);
 				rsVisRolOpc.insertRow();
 				rsVisRolOpc.moveToCurrentRow();
 			}

 			guardado = true;
 			
 			
 		}
 		catch (Exception e) 
 		{
 			System.err.println("ERROR asignarOpcionesARol(): "+e.getMessage());
 			e.printStackTrace();
 		} finally {
        	c.close();
        }    	
 		return guardado;
 	}
 //------------------------------------
 	

 	public boolean guardarRolOpcion(int id_rol, int id_opcion) throws SQLException
 	{
 		Connection c = PoolConexion.getConnection();
 		boolean guardado = false;
 		
 		try
 		{

 			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_rol_opcion", 
 					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
 					ResultSet.HOLD_CURSORS_OVER_COMMIT);
 			
 			rsVisRolOpc = ps.executeQuery();
 			
 			rsVisRolOpc.moveToInsertRow();
 			rsVisRolOpc.updateInt("id_rol", id_rol);
 			rsVisRolOpc.updateInt("id_opcion", id_opcion);
 			rsVisRolOpc.insertRow();
 			
 			rsVisRolOpc.moveToCurrentRow();
 			guardado = true;
 			
 			
 		}
 		catch (Exception e) 
 		{
 			System.err.println("ERROR guardarRolOpcion(): "+e.getMessage());
 			e.printStackTrace();
 		} finally {
        	c.close();
        }  
 		return guardado;
 	}

 	public boolean existeRolOpcion(int id_opcion, int id_rol) throws SQLException
 	{
 		Connection c = PoolConexion.getConnection();
 		boolean existe=false;
 		try
 		{

 			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_rol_opcion WHERE id_opcion = ? AND id_rol = ?", 
 					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
 					ResultSet.HOLD_CURSORS_OVER_COMMIT);
 			ps.setInt(1, id_opcion);
 			ps.setInt(2, id_rol);
 			
 			rsVisRolOpc = ps.executeQuery();
 			
 			rsVisRolOpc.beforeFirst();
 			if (rsVisRolOpc.next())
 			{
 				existe = true;
 			}
 			
 		}
 		catch(Exception e)
 		{
 			System.err.println("ERROR existeRolOpcion() "+e.getMessage());
 			e.printStackTrace();
 		} finally {
        	c.close();
        }  
 		return existe;
 	}
 	
 	
 		
 	public boolean eliminarRolOpcion(int id_opcion, int id_rol) throws SQLException {
    	Connection c = PoolConexion.getConnection();
    	boolean eliminado = false;
    	try {
    		PreparedStatement ps = c.prepareStatement("SELECT * from tbl_rol_opcion", 
 					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
 					ResultSet.HOLD_CURSORS_OVER_COMMIT);
 			rsVisRolOpc = ps.executeQuery();
 			
 			
 			rsVisRolOpc.beforeFirst();
 			while (rsVisRolOpc.next())
 			{
 				
 				if(rsVisRolOpc.getInt("id_rol") == id_rol)
 				{
 					if(rsVisRolOpc.getInt("id_opcion") == id_opcion) {
 						rsVisRolOpc.deleteRow();
 						eliminado=true;
 						
 						break;
 					}
 					
 				}
 			}
    	}catch (Exception e){
            System.err.println("ERROR eliminarRolOpcion(): "+e.getMessage());
            e.printStackTrace();
        }  /*finally {
		c.close();
	}		*/
    	return eliminado;
    }


 	@SuppressWarnings("unchecked")
 	public ArrayList<V_tbl_Rol_Opcion> getOpciones(Object opcs){
 		ArrayList<V_tbl_Rol_Opcion> opciones = new  ArrayList<V_tbl_Rol_Opcion>();
 		
 		try {
 			
 			if (opcs != null) {
 				opciones = (ArrayList<V_tbl_Rol_Opcion>) opcs;
 			}
 			
 			System.out.println("pasa por el cast de las opciones");
 			
 		}catch(Exception e) {
 			e.printStackTrace();
 			System.out.println(e.getMessage());
 		}
 		
 		return opciones;
 	}
 	
 }