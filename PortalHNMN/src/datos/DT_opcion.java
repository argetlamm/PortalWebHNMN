package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_opcion;

public class DT_opcion {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	private ResultSet rsOpcion;
	
	//Método para listar opciones
	public ArrayList<Tbl_opcion> listOpc() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_opcion> listaOpc = new ArrayList<Tbl_opcion>();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_opcion where estado<>3", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOpcion = ps.executeQuery();
			while(rsOpcion.next())
			{
				Tbl_opcion top  = new Tbl_opcion();
				top.setId_opcion(rsOpcion.getInt("id_opcion"));
				top.setOpcion(rsOpcion.getString("opcion"));
				top.setOpcion_desc(rsOpcion.getString("opcion_desc"));
				top.setEstado(rsOpcion.getInt("estado"));
				listaOpc.add(top);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listOpc() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaOpc;
	}
	
	//Método para guardar opciones
	public boolean guardarOpcion(Tbl_opcion top) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean guardado = false;
		try
		{
			this.listOpc();
			rsOpcion.moveToInsertRow();
			
			rsOpcion.updateString("opcion", top.getOpcion());
			rsOpcion.updateString("opcion_desc", top.getOpcion_desc());
			rsOpcion.updateInt("estado", 1);
			rsOpcion.insertRow();
			rsOpcion.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR guardarOpcion(): "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return guardado;
	}
	
	public Tbl_opcion obtenerOpcion(int idOpc) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		Tbl_opcion trl  = new Tbl_opcion();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_opcion where id_opcion = ? and estado<>3", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idOpc);
			rsOpcion = ps.executeQuery();
			if(rsOpcion.next())
			{
				trl.setId_opcion(rsOpcion.getInt("id_opcion"));
				trl.setOpcion(rsOpcion.getString("opcion"));
				trl.setOpcion_desc(rsOpcion.getString("opcion_desc"));
				trl.setEstado(rsOpcion.getInt("estado"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en obtenerOpcion() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return trl;
	}
	
	public boolean modificarOpcion(Tbl_opcion topc) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;	
		try
		{
			this.listOpc();
			rsOpcion.beforeFirst();
			while (rsOpcion.next())
			{
				if(rsOpcion.getInt(1)==topc.getId_opcion())
				{
					rsOpcion.updateString("opcion", topc.getOpcion());
					rsOpcion.updateString("opcion_desc", topc.getOpcion_desc());
					rsOpcion.updateInt("estado", 2);
					rsOpcion.updateRow();
					modificado=true;
					break;
				}
			}
			
		}
		catch (Exception e) 
		{
			System.err.println("ERROR modificarOpcion(): "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}			
		return modificado;
	}
	
	public boolean eliminarOpcion(Tbl_opcion topc) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean eliminado=false;	
		try
		{
			this.listOpc();
			rsOpcion.beforeFirst();
			while (rsOpcion.next())
			{
				if(rsOpcion.getInt(1)==topc.getId_opcion())
				{
					rsOpcion.updateInt("estado",3);
					rsOpcion.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("ERROR eliminarOpcion() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return eliminado;
	}
}
