package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Tbl_publicaciones;
import entidades.Tbl_user;

public class DT_publicaciones {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	private ResultSet rsPublicaciones;
	
	public Tbl_publicaciones itemMenu()
	{
		Tbl_publicaciones tpus = new Tbl_publicaciones();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'nav_menu_item'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				tpus.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpus.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpus.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpus.setPublic_name(rsPublicaciones.getString("public_name"));
				tpus.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpus.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemMenu() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return tpus;
	}

}
