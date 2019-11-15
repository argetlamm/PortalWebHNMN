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
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemMenu() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaTpus;
	}
	
	public ArrayList<Tbl_publicaciones> titulosFtr()
	{
		ArrayList<Tbl_publicaciones> listaFtr = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'footerT'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaFtr.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en titulosFtr() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaFtr;
	}
	
	public ArrayList<Tbl_publicaciones> itemsFtr()
	{
		ArrayList<Tbl_publicaciones> listaItemsF = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemf'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaItemsF.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en titulosFtr() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaItemsF;
	}
	
	public ArrayList<Tbl_publicaciones> imagenesBanner()
	{
		ArrayList<Tbl_publicaciones> listaBanner = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'bannerI'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaBanner.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en titulosFtr() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaBanner;
	}
	
	public ArrayList<Tbl_publicaciones> itemsQuienesSomos()
	{
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsQuienesSomos'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			System.out.println("PASA POR AQUI 1");
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaBdy.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemMenu() "+ e.getMessage());
			e.printStackTrace();
		}
		return listaBdy;
	}
	
	public ArrayList<Tbl_publicaciones> itemsHistoria()
	{
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsHistoria'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			System.out.println("PASA POR AQUI 1");
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaBdy.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemMenu() "+ e.getMessage());
			e.printStackTrace();
		}
		return listaBdy;
	}
	
	public ArrayList<Tbl_publicaciones> itemsMision()
	{
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsMision'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			System.out.println("PASA POR AQUI 1");
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaBdy.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemMenu() "+ e.getMessage());
			e.printStackTrace();
		}
		return listaBdy;
	}
	
	public ArrayList<Tbl_publicaciones> itemsVision()
	{
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsVision'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			System.out.println("PASA POR AQUI 1");
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaBdy.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemMenu() "+ e.getMessage());
			e.printStackTrace();
		}
		return listaBdy;
	}
	
	public ArrayList<Tbl_publicaciones> titulosQuienesSomos()
	{
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'tituloQuienesSomos'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			System.out.println("PASA POR AQUI 1");
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaBdy.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemMenu() "+ e.getMessage());
			e.printStackTrace();
		}
		return listaBdy;
	}
}
