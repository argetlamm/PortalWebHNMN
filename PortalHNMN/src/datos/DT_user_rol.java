package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Tbl_user;
import entidades.Tbl_user_rol;
import entidades.V_tbl_Usuario_Rol;

public class DT_user_rol {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	private static final String SQL_ENCONTRAR = "SELECT id_user FROM tbl_user where username=?;";
	private ResultSet rsUserRol;
	
///////////////////////////// METODO PARA LISTAR VISTA DE USUARIOS ROL/////////////////////////////
	public ArrayList<V_tbl_Usuario_Rol> vlistUserRol()
	{
		ArrayList<V_tbl_Usuario_Rol> vlistaUserRol = new ArrayList<V_tbl_Usuario_Rol>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from V_tbl_Usuario_Rol", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUserRol = ps.executeQuery();
			while(rsUserRol.next())
			{
				V_tbl_Usuario_Rol tur  = new V_tbl_Usuario_Rol();
				tur.setId_user(rsUserRol.getInt("id_user"));
				tur.setUsername(rsUserRol.getString("username"));
				tur.setPassword(rsUserRol.getString("password"));
				tur.setId_rol(rsUserRol.getInt("id_rol"));
				tur.setRol_name(rsUserRol.getString("rol_name"));
				vlistaUserRol.add(tur);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en vlistUserRol() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return vlistaUserRol;
	}
	
///////////////////////////// METODO PARA LISTAR TABLA USUARIOS ROL /////////////////////////////

	public ArrayList<Tbl_user_rol> listUserRol()
	{
		ArrayList<Tbl_user_rol> listaUserRol = new ArrayList<Tbl_user_rol>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_user_rol", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUserRol = ps.executeQuery();
			while(rsUserRol.next())
			{
				Tbl_user_rol tur  = new Tbl_user_rol();
				tur.setId_user_rol(rsUserRol.getInt("id_user_rol"));
				tur.setId_user(rsUserRol.getInt("id_user"));
				tur.setId_rol(rsUserRol.getInt("id_rol"));
				listaUserRol.add(tur);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listUserRol() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaUserRol;
	}
	
///////////////////////////// METODO PARA GUARDAR USUARIOS ROL /////////////////////////////

	public boolean guardarUserRol (Tbl_user_rol tur){
		boolean guardado = false;
		
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
		}
		return guardado;
	}
	
//	public boolean guardarUserRolEstudiante (Tbl_user tus, Tbl_user_rol tur){
//		boolean guardado = false;
//		try
//		{
//			PreparedStatement ps = c.prepareStatement("SELECT id_user FROM tbl_user where username= '" + tus.getUsername() + "' and "
//					+ "estado <> 3;",
//                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
//                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
//			//ps.setInt(1, tus.getUsername());
//            rsUserRol = ps.executeQuery();
//            while(rsUserRol.next()) {
//            	tur.setUser_id(rsUserRol.getInt("id_user"));
//            }
//			this.listUserRol();
//			rsUserRol.moveToInsertRow();
//			rsUserRol.updateInt("user_id", tur.getUser_id());
//			rsUserRol.updateInt("rol_id", 3);
//			rsUserRol.insertRow();
//			rsUserRol.moveToCurrentRow();
//			guardado = true;
//		}
//		catch (Exception e) 
//		{
//			System.err.println("ERROR guardarUserRolEstudiante(): "+e.getMessage());
//			e.printStackTrace();
//		}
//		return guardado;
//	}
//	
//	public boolean guardarUserRolTutor (Tbl_user tus, Tbl_user_rol tur){
//		boolean guardado = false;
//		try
//		{
//			PreparedStatement ps = c.prepareStatement("SELECT id_user FROM tbl_user where username= '" + tus.getUsername() + "' and "
//					+ "estado <> 3;",
//					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
//					ResultSet.HOLD_CURSORS_OVER_COMMIT);
//			//ps.setInt(1, tus.getUsername());
//			rsUserRol = ps.executeQuery();
//			while(rsUserRol.next()) {
//				tur.setUser_id(rsUserRol.getInt("id_user"));
//			}
//			this.listUserRol();
//			rsUserRol.moveToInsertRow();
//			rsUserRol.updateInt("user_id", tur.getUser_id());
//			rsUserRol.updateInt("rol_id", 2);
//			rsUserRol.insertRow();
//			rsUserRol.moveToCurrentRow();
//			guardado = true;
//		}
//		catch (Exception e) 
//		{
//			System.err.println("ERROR guardarUserRolEstudiante(): "+e.getMessage());
//			e.printStackTrace();
//		}
//		return guardado;
//	}
	
	
///////////////////////////// METODO PARA OBTENER USUARIOS ROL /////////////////////////////

	public int capturarIdUserRol (Tbl_user_rol tur){
		int IDUSERROL = 0;
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT id_user_rol FROM tbl_user_rol where user_id= " + tur.getId_user() + " and "
					+ "rol_id = 3",
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
	}

//	public int capturarIdUserRolTutor (Tbl_user_rol tur){
//		int IDUSERROL = 0;
//		try
//		{
//			PreparedStatement ps = c.prepareStatement("SELECT id_user_rol FROM tbl_user_rol where user_id= " + tur.getUser_id() + " and "
//							+ "rol_id = 2",
//					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
//					ResultSet.HOLD_CURSORS_OVER_COMMIT);
//			//ps.setInt(1, tus.getUsername());
//			rsUserRol = ps.executeQuery();
//			while(rsUserRol.next()) {
//				tur.setId_user_rol(rsUserRol.getInt("id_user_rol"));
//			}
//			IDUSERROL = tur.getId_user_rol();
//		}
//		catch (Exception e)
//		{
//			System.err.println("ERROR: capturarIdUser(): "+e.getMessage());
//			e.printStackTrace();
//		}
//		return IDUSERROL;
//	}
	
///////////////////////////// METODO PARA MODIFICAR USUARIOS ROL /////////////////////////////

	public boolean modificarUserRol(Tbl_user_rol tur)
	{
		boolean modificado=false;	
		try
		{
			this.listUserRol();
			rsUserRol.beforeFirst();
			while (rsUserRol.next())
			{
				if(rsUserRol.getInt(1)==tur.getId_user_rol())
				{
					rsUserRol.updateInt("user_id", tur.getId_user());
					rsUserRol.updateInt("rol_id", tur.getId_rol());
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
		}
		return modificado;
	}
	
///////////////////////////// METODO PARA ELIMINAR USUARIOS ROL /////////////////////////////

	public boolean eliminarUserRol(Tbl_user_rol tur)
	{
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
		}
		return eliminado;
	}
	
///////////////////////////// METODO PARA OBTENER USUARIOS ROL/////////////////////////////

	public Tbl_user_rol obtenerUserRol(int idUserRol)
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
	}

}
