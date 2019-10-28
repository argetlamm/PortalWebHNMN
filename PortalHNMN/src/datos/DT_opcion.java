package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Tbl_opcion;
import entidades.Tbl_rol;

public class DT_opcion {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	private ResultSet rsOpcion;
	
	//Método para listar opciones
	public ArrayList<Tbl_opcion> listOpc()
	{
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
		}
		
		return listaOpc;
	}
	
	
	//Método para guardar opciones
	public boolean guardarOpcion(Tbl_opcion top)
	{
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
		}
		
		return guardado;
	}
}
