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
	
	public ArrayList<Tbl_publicaciones> itemMenu()
	{
		ArrayList<Tbl_publicaciones> listaTpus = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'nav_menu_item'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			System.out.println("PASA POR AQUI 1");
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaTpus.add(tpub);
				System.out.println("PASA POR AQUI 2");
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemMenu() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaTpus;
	}
	
	/*
	 * public Tbl_publicaciones itemMenu() { Tbl_publicaciones tpus = new
	 * Tbl_publicaciones();
	 * 
	 * try { PreparedStatement ps = c.
	 * prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'nav_menu_item'"
	 * , ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
	 * ResultSet.HOLD_CURSORS_OVER_COMMIT); rsPublicaciones = ps.executeQuery();
	 * while(rsPublicaciones.next()) {
	 * tpus.setMenu_order(rsPublicaciones.getInt("menu_order"));
	 * tpus.setPublic_estado(rsPublicaciones.getString("public_estado"));
	 * tpus.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
	 * tpus.setPublic_name(rsPublicaciones.getString("public_name"));
	 * tpus.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
	 * tpus.setPublic_titulo(rsPublicaciones.getString("public_titulo")); } } catch
	 * (Exception e) { System.out.println("DATOS: ERROR en itemMenu() "+
	 * e.getMessage()); e.printStackTrace(); }
	 * 
	 * return tpus; }
	 */

}
