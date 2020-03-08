package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_user;
import entidades.Tbl_user_rol;
import entidades.V_tbl_Rol_Opcion;
import entidades.V_tbl_Usuario_Rol;

public class DT_user_rol {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	
	private static final String SQL_SELECT_ALL_VISTA = "SELECT * FROM public.\"V_tbl_Usuario_Rol\"";
	private static final String SQL_SELECT_ALL = "SELECT * FROM tbl_user_rol";
	private ResultSet rsVUserRol;
///////////////////////////// METODO PARA LISTAR VISTA DE USUARIOS ROL/////////////////////////////
	public ArrayList<V_tbl_Usuario_Rol> vlistUserRol() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<V_tbl_Usuario_Rol> vlistaUserRol = new ArrayList<V_tbl_Usuario_Rol>();
		try
		{
			PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL_VISTA, ResultSet.TYPE_SCROLL_SENSITIVE, 
    				ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsVUserRol = ps.executeQuery();
			//System.out.println("auida");
			while(rsVUserRol.next())
			{
				//System.out.println("auida2");
				V_tbl_Usuario_Rol tur  = new V_tbl_Usuario_Rol();
				tur.setId_user_rol(rsVUserRol.getInt("id_user_rol"));
				tur.setId_user(rsVUserRol.getInt("id_user"));
				tur.setUsername(rsVUserRol.getString("username"));
				tur.setPassword(rsVUserRol.getString("password"));
				tur.setId_rol(rsVUserRol.getInt("id_rol"));
				tur.setRol_name(rsVUserRol.getString("rol_name"));
				vlistaUserRol.add(tur);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en vlistUserRol() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return vlistaUserRol;
	}
	
	private static final String SQL_ENCONTRAR = "SELECT id_user FROM tbl_user where username=?;";
	private ResultSet rsUserRol;
	
///////////////////////////// METODO PARA LISTAR TABLA USUARIOS ROL /////////////////////////////

	public ArrayList<Tbl_user_rol> listUserRol() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_user_rol> userRol = new ArrayList<Tbl_user_rol>();
		try
		{
			PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL, ResultSet.TYPE_SCROLL_SENSITIVE, 
    				ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUserRol = ps.executeQuery();
			while(rsUserRol.next())
			{
				Tbl_user_rol tur  = new Tbl_user_rol();
				tur.setId_user_rol(rsUserRol.getInt("id_user_rol"));
				tur.setId_user(rsUserRol.getInt("id_user"));
				tur.setId_rol(rsUserRol.getInt("id_rol"));
				userRol.add(tur);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listUserRol() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return userRol;
	}
	
	public V_tbl_Usuario_Rol obtenerUserRol(int idUserRol) throws SQLException{
		Connection c = PoolConexion.getConnection();
		V_tbl_Usuario_Rol vtur = new V_tbl_Usuario_Rol();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM public.\"V_tbl_Usuario_Rol\" WHERE id_user_rol=?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idUserRol);
			
			rsVUserRol = ps.executeQuery();
			if(rsVUserRol.next()) {				
				vtur.setId_user_rol(rsVUserRol.getInt("id_user_rol"));
				vtur.setId_user(rsVUserRol.getInt("id_user"));
				vtur.setUsername(rsVUserRol.getString("username"));
				vtur.setPassword(rsVUserRol.getString("password"));
				vtur.setId_rol(rsVUserRol.getInt("id_rol"));
				vtur.setRol_name(rsVUserRol.getString("rol_name"));
				vtur.setUser_estado(rsVUserRol.getInt("user_estado"));
				vtur.setRol_estado(rsVUserRol.getInt("rol_estado"));
			}
			System.out.println("idUserRol en DT_user_rol: "+idUserRol);
		}catch(Exception e) {
			System.out.println("DATOS: ERROR en obtenerUserRol() " + e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return vtur;
	}
///////////////////////////// METODO PARA GUARDAR USUARIOS ROL /////////////////////////////

	public boolean guardarUserRol (Tbl_user_rol tur) throws SQLException{
		Connection c = PoolConexion.getConnection();
		boolean guardado = false;
		System.out.println("Estoy entrando al dt_user_rol");
		try
		{
			this.listUserRol();
			rsUserRol.moveToInsertRow();
			rsUserRol.updateInt("id_user", tur.getId_user());
			rsUserRol.updateInt("id_rol", tur.getId_rol());
			rsUserRol.insertRow();
			rsUserRol.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR guardarUserRol(): "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return guardado;
	}
	
///////////////////////////// METODO PARA MODIFICAR USUARIOS ROL /////////////////////////////
	
	public boolean modificarUserRol(Tbl_user_rol tur) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;	
		try
		{
			this.listUserRol();
			rsUserRol.beforeFirst();
			System.out.println("edit id_user_rol: "+tur.getId_user_rol());
			System.out.println("edit id_user: "+tur.getId_user());
			System.out.println("edit id_rol: "+tur.getId_rol());
			while (rsUserRol.next())
			{
				if(rsUserRol.getInt(1)==tur.getId_user_rol())
				{
					System.out.println("entró hasta el modificar?");
					rsUserRol.updateInt("id_user", tur.getId_user());
					rsUserRol.updateInt("id_rol", tur.getId_rol());
					rsUserRol.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarUserRol() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;
	}
	
///////////////////////////// METODO PARA ELIMINAR USUARIOS ROL /////////////////////////////

public boolean eliminarUserRol(Tbl_user_rol tur) throws SQLException
{
	Connection c = PoolConexion.getConnection();
	boolean eliminado=false;	
	try
	{
	this.listUserRol();
	rsUserRol.beforeFirst();
	while (rsUserRol.next())
	{
	if(rsUserRol.getInt(1)==tur.getId_user_rol())
	{
	rsUserRol.deleteRow();
	eliminado=true;
	break;
	}
	}
	}
	catch(Exception e)
	{
	System.err.println("ERROR eliminarUserRol() "+e.getMessage());
	e.printStackTrace();
	} finally {
		c.close();
	}
	return eliminado;
}
///////////////////////////// METODO PARA OBTENER USUARIOS ROL /////////////////////////////

	/*public int capturarIdUserRol (Tbl_user_rol tur){
		int IDUSERROL = 0;
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT id_user_rol FROM tbl_user_rol where id_user= " + tur.getId_user() + " and "
					+ "id_rol <> 3",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			//ps.setInt(1, tus.getUsername());
			rsUserRol = ps.executeQuery();
			while(rsUserRol.next()) {
				tur.setId_user_rol(rsUserRol.getInt("id_user_rol"));
			}
			IDUSERROL = tur.getId_user_rol();
		}
		catch (Exception e) 
		{
			System.err.println("ERROR: capturarIdUser(): "+e.getMessage());
			e.printStackTrace();
		}
		return IDUSERROL;
	}*/

	

	
	

	
///////////////////////////// METODO PARA OBTENER USUARIOS ROL/////////////////////////////

	/*public Tbl_user_rol obtenerUserRol(int idUserRol)
	{
		Tbl_user_rol tur = new Tbl_user_rol();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_user_rol where id_user_rol = ?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idUserRol);
			rsUserRol = ps.executeQuery();
			if(rsUserRol.next())
			{
				tur.setId_user_rol(rsUserRol.getInt("id_user_rol"));
				tur.setId_user(rsUserRol.getInt("id_user"));
				tur.setId_rol(rsUserRol.getInt("id_rol"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en obtenerUserRol() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return tur;
	}*/
	
	

}

