package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Tbl_rol_opcion;
import entidades.V_tbl_Rol_Opcion;

public class DT_rol_opcion {
	PoolConexion pc = PoolConexion.getInstance();
    Connection c = PoolConexion.getConnection();
    private ResultSet rsVisRolOpc;
    private ResultSet rsRolOpc;
    private static final String SQL_SELECT_ALL_VISTA = "SELECT * FROM public.\"V_tbl_Rol_Opcion\"";
    private static final String SQL_SELECT_ALL = "SELECT * FROM tbl_rol_opcion";
    
    public ArrayList<V_tbl_Rol_Opcion> listarRolOpcionVista(){
    	ArrayList<V_tbl_Rol_Opcion> vRolOpc = new ArrayList<V_tbl_Rol_Opcion>();
    	
    	try {
    		PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL_VISTA, ResultSet.TYPE_SCROLL_SENSITIVE, 
    				ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
    		rsVisRolOpc = ps.executeQuery();
    		while(rsVisRolOpc.next()) {
    			V_tbl_Rol_Opcion vTblRolOpc = new V_tbl_Rol_Opcion();
    			vTblRolOpc.setId_rol_opcion(rsVisRolOpc.getInt("id_rol_opcion"));
    			vTblRolOpc.setId_rol(rsVisRolOpc.getInt("id_rol"));
    			vTblRolOpc.setRol_name(rsVisRolOpc.getString("rol_name"));
    			vTblRolOpc.setId_opcion(rsVisRolOpc.getInt("id_opcion"));
    			vTblRolOpc.setOpcion(rsVisRolOpc.getString("opcion"));
    			vRolOpc.add(vTblRolOpc);
    		}
    	}catch (Exception e) {
            System.out.println("DATOS: ERROR en listarRolOpcionVista() " + e.getMessage());
            e.printStackTrace();
        }
    	
    	return vRolOpc;
    }
    
    public ArrayList<Tbl_rol_opcion> listarRolOpcion(){
    	ArrayList<Tbl_rol_opcion> rolOpc = new ArrayList<Tbl_rol_opcion>();
    	try {
    		PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL, ResultSet.TYPE_SCROLL_SENSITIVE, 
    				ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
    		rsRolOpc = ps.executeQuery();
    		while(rsRolOpc.next()) {
    			Tbl_rol_opcion tblRolOpc = new Tbl_rol_opcion();
    			tblRolOpc.setId_rol_opcion(rsRolOpc.getInt("id_rol_opcion"));
    			tblRolOpc.setId_rol(rsRolOpc.getInt("id_rol"));
    			tblRolOpc.setId_opc(rsRolOpc.getInt("id_opcion"));
    			rolOpc.add(tblRolOpc);
    		}
    	}catch (Exception e) {
            System.out.println("DATOS: ERROR en listarRolOpcion() " + e.getMessage());
            e.printStackTrace();
        }
    	
    	return rolOpc;
    }
    
    public V_tbl_Rol_Opcion obtenerRolOpcion(int idRolOpc){
    	V_tbl_Rol_Opcion vtrop = new V_tbl_Rol_Opcion();
		
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM public.\"V_tbl_Rol_Opcion\" WHERE id_rol_opcion=?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idRolOpc);
			
			rsVisRolOpc = ps.executeQuery();
			if(rsVisRolOpc.next()) {				
				vtrop.setId_rol_opcion(rsVisRolOpc.getInt("id_rol_opcion"));
				vtrop.setId_rol(rsVisRolOpc.getInt("id_rol"));
				vtrop.setRol_name(rsVisRolOpc.getString("rol_name"));
				vtrop.setId_opcion(rsVisRolOpc.getInt("id_opcion"));
				vtrop.setOpcion(rsVisRolOpc.getString("opcion"));
			}
			System.out.println("idrolOpc en DT_rol_opc: "+idRolOpc);
		}catch(Exception e) {
			System.out.println("DATOS: ERROR en obtenerRolOpcion() " + e.getMessage());
			e.printStackTrace();
		}
		
		return vtrop;
	}
    
    public boolean existeRolOpcion(int idRol, int idOpc) {
    	boolean existe = false;
    	return existe;
    }
    
    public boolean guardarRolOpcion(Tbl_rol_opcion tropc) {
    	boolean guardado = false;
    	
    	try {
    		this.listarRolOpcion();
    		rsRolOpc.moveToInsertRow();
    		
    		rsRolOpc.updateInt("id_rol", tropc.getId_rol());
    		rsRolOpc.updateInt("id_opcion", tropc.getId_opc());
    		rsRolOpc.insertRow();
    		rsRolOpc.moveToCurrentRow();
    		guardado = true;
    	}catch (Exception e){
            System.err.println("ERROR guardarRolOpcion(): "+e.getMessage());
            e.printStackTrace();
        }
    	
    	return guardado;
    }
    
    public boolean editarRolOpcion(Tbl_rol_opcion tropc) {
    	boolean editado = false;
    	System.out.println("Estoy entrando al DT editar");  
    	try {
    		this.listarRolOpcion();
    		rsRolOpc.beforeFirst();
    		System.out.println("edit id_rol_opcion: "+tropc.getId_rol_opcion());
    		System.out.println("edit id_rol: "+tropc.getId_rol());
    		System.out.println("edit id_opcion: "+tropc.getId_opc());
    		while (rsRolOpc.next()) {
    			if (rsRolOpc.getInt(1) == tropc.getId_rol_opcion()) {
    				System.out.println("Entré al IF "+ tropc.getId_rol_opcion());
    	    		rsRolOpc.updateInt("id_rol", tropc.getId_rol());
    	    		rsRolOpc.updateInt("id_opcion", tropc.getId_opc());
    	    		rsRolOpc.updateRow();
    	    		editado = true;
    	    		break;
    			}
    		}    		
    	}catch (Exception e){
            System.err.println("ERROR editarRolOpcion(): "+e.getMessage());
            e.printStackTrace();
        }
    	
    	return editado;
    }
    
    public boolean eliminarRolOpcion(Tbl_rol_opcion tropc) {
    	boolean eliminado = false;
    	
    	try {
    		PreparedStatement ps = c.prepareStatement("DELETE FROM tbl_rol_opcion WHERE id_rol_opcion=?", 
    				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
    				ResultSet.HOLD_CURSORS_OVER_COMMIT);
    		ps.setInt(1, tropc.getId_rol_opcion());
    		int val = ps.executeUpdate();
    		eliminado = true;
    	}catch (Exception e){
            System.err.println("ERROR eliminarRolOpcion(): "+e.getMessage());
            e.printStackTrace();
        }
    	return eliminado;
    }
    
}
