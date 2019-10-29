package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Tbl_rol;
import entidades.Tbl_user;
import entidades.V_tbl_Rol_Opcion;

public class DT_rol 
{
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	private ResultSet rsRol;
	private ResultSet rsRolOpc;
	
	///////////////////////////// METODO PARA LISTAR ROLES /////////////////////////////
	public ArrayList<Tbl_rol> listRol()
	{
		ArrayList<Tbl_rol> listaRol = new ArrayList<Tbl_rol>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_rol where estado<>3", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsRol = ps.executeQuery();
			while(rsRol.next())
			{
				Tbl_rol tor  = new Tbl_rol();
				tor.setId_rol(rsRol.getInt("id_rol"));
				tor.setRol_name(rsRol.getString("rol_name"));
				tor.setRol_desc(rsRol.getString("rol_desc"));
				tor.setEstado(rsRol.getInt("estado"));
				listaRol.add(tor);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listRol() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaRol;
	}
	
	
	public Tbl_rol obtenerRol(int idRol)
	{
		Tbl_rol trl  = new Tbl_rol();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_rol where id_rol = ? and estado<>3", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idRol);
			rsRol = ps.executeQuery();
			if(rsRol.next())
			{
				trl.setId_rol(rsRol.getInt("id_rol"));
				trl.setRol_name(rsRol.getString("rol_name"));
				trl.setRol_desc(rsRol.getString("rol_desc"));
				trl.setEstado(rsRol.getInt("estado"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en obtenerRol() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return trl;
	}

	//Metodo para guardar rol
	public boolean guardarRol(Tbl_rol trl)
	{
		boolean guardado = false;
		
		try
		{
			this.listRol();
			rsRol.moveToInsertRow();
			
			rsRol.updateString("rol_name", trl.getRol_name());
			rsRol.updateString("rol_desc", trl.getRol_desc());
			rsRol.updateInt("estado", 1);
			rsRol.insertRow();
			rsRol.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR guardarRol(): "+e.getMessage());
			e.printStackTrace();
		}
		
		return guardado;
	}
	
	public boolean modificarRol(Tbl_rol trl)
	{
		boolean modificado=false;	
		try
		{
			this.listRol();
			rsRol.beforeFirst();
			while (rsRol.next())
			{
				if(rsRol.getInt(1)==trl.getId_rol())
				{
					rsRol.updateString("rol_name", trl.getRol_name());
					rsRol.updateString("rol_desc", trl.getRol_desc());
					rsRol.updateInt("estado", 2);
					rsRol.updateRow();
					modificado=true;
					break;
				}
			}
			
		}
		catch (Exception e) 
		{
			System.err.println("ERROR modificarRol(): "+e.getMessage());
			e.printStackTrace();
		}
			
		return modificado;
	}
	
	
	public boolean eliminarRol(Tbl_rol trl)
	{
		boolean eliminado=false;	
		try
		{
			this.listRol();
			rsRol.beforeFirst();
			while (rsRol.next())
			{
				if(rsRol.getInt(1)==trl.getId_rol())
				{
					rsRol.updateInt("estado",3);
					rsRol.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("ERROR eliminarRol() "+e.getMessage());
			e.printStackTrace();
		}
		return eliminado;
	}
	
	///////////////////////////// METODO PARA LISTAR ROL & OPCIONES /////////////////////////////
	public ArrayList<V_tbl_Rol_Opcion> listRolOpc(int idRol)
	{
		ArrayList<V_tbl_Rol_Opcion> listRolOpc = new ArrayList<V_tbl_Rol_Opcion>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM public.\"V_tbl_Rol_Opcion\" where id_rol=?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idRol);
			rsRolOpc = ps.executeQuery();
			while(rsRolOpc.next())
			{
				V_tbl_Rol_Opcion vtrop = new V_tbl_Rol_Opcion();
				vtrop.setId_rol(rsRolOpc.getInt("id_rol"));
				vtrop.setRol_name(rsRolOpc.getString("rol_name"));
				vtrop.setId_opcion(rsRolOpc.getInt("id_opcion"));
				vtrop.setOpcion(rsRolOpc.getString("opcion"));
				listRolOpc.add(vtrop);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listRolOpc() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listRolOpc;
	}
}
