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
	
	public boolean modificarMenu(ArrayList<Tbl_publicaciones> tbp)
	{
		boolean modificado=false;
		String titulo = "";
		int contador = 1;
		try
		{
			this.itemMenu();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					titulo = tpubl.getPublic_titulo();
					if(rsPublicaciones.getInt(1)==contador)
					{
						rsPublicaciones.updateString("public_titulo", titulo);
						rsPublicaciones.updateRow();
						modificado=true;
					}
					contador++;
				}
				contador = 1;
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarMenu() "+e.getMessage());
			e.printStackTrace();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> itemsInicio()
	{
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsInicio'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
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
	
	public boolean modificarInicio(ArrayList<Tbl_publicaciones> tbp)
	{
		boolean modificado=false;
		String parrafo = "";
		int contador = 1;
		int contador2 = 1;
		try
		{
			this.itemsInicio();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(contador2==contador)
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
					}
					contador++;
				}
				contador2++;
				contador = 1;
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarQuienesSomos() "+e.getMessage());
			e.printStackTrace();
		}
		return modificado;	
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
	
	public int obtenerMenuOrder()
	{
		int menu = 0;
		int contador = 1;
		String publicado = "publicado";
		ArrayList<Tbl_publicaciones> listaBanner = new ArrayList<Tbl_publicaciones>();
		listaBanner = this.imagenesBanner();
		for (Tbl_publicaciones tpublc : listaBanner){
        	if(tpublc.getPublic_estado().trim().equals(publicado)){
        		contador++;
        	}
		}
		menu =  contador;
		return menu;
	}
	
	public boolean guardarBanner(Tbl_publicaciones tpub)
	{
		boolean guardado = false;
		int menu = obtenerMenuOrder();
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		try
		{
			this.imagenesBanner();
			rsPublicaciones.moveToInsertRow();
			rsPublicaciones.updateInt("menu_order", menu);
			rsPublicaciones.updateString("public_estado", "publicado");
			rsPublicaciones.updateDate("public_fecha", sqlDate);
			rsPublicaciones.updateString("public_name","banner");
			rsPublicaciones.updateString("public_tipo", "bannerI");
			rsPublicaciones.updateString("public_titulo", tpub.getPublic_titulo());	
			rsPublicaciones.insertRow();
			rsPublicaciones.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR guardarUser(): "+e.getMessage());
			e.printStackTrace();
		}
		
		return guardado;
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
	
	public boolean modificarQuienesSomos(ArrayList<Tbl_publicaciones> tbp)
	{
		boolean modificado=false;
		String parrafo = "";
		int contador = 1;
		int contador2 = 1;
		try
		{
			this.itemsQuienesSomos();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(contador2==contador)
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
					}
					contador++;
				}
				contador2++;
				contador = 1;
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarQuienesSomos() "+e.getMessage());
			e.printStackTrace();
		}
		return modificado;	
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
	
	public boolean modificarHistoria(ArrayList<Tbl_publicaciones> tbp)
	{
		boolean modificado=false;
		String parrafo = "";
		int contador = 1;
		int contador2 = 1;
		try
		{
			this.itemsHistoria();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(contador2==contador)
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
					}
					contador++;
				}
				contador2++;
				contador = 1;
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarHistoria() "+e.getMessage());
			e.printStackTrace();
		}
		return modificado;	
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
	
	public boolean modificarMision(ArrayList<Tbl_publicaciones> tbp)
	{
		boolean modificado=false;
		String parrafo = "";
		int contador = 1;
		int contador2 = 1;
		try
		{
			this.itemsMision();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(contador2==contador)
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
					}
					contador++;
				}
				contador2++;
				contador = 1;
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarMision() "+e.getMessage());
			e.printStackTrace();
		}
		return modificado;	
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
	
	public boolean modificarVision(ArrayList<Tbl_publicaciones> tbp)
	{
		boolean modificado=false;
		String parrafo = "";
		int contador = 1;
		int contador2 = 1;
		try
		{
			this.itemsVision();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(contador2==contador)
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
					}
					contador++;
				}
				contador2++;
				contador = 1;
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarVision() "+e.getMessage());
			e.printStackTrace();
		}
		return modificado;	
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
	
	public ArrayList<Tbl_publicaciones> imagenesColeccion()
	{
		ArrayList<Tbl_publicaciones> listaColeccion = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'coleccionImagen'", 
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
				tpub.setPublic_tipo_img(rsPublicaciones.getString("public_tipo_img"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				listaColeccion.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en titulosFtr() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaColeccion;
	}
	
	public ArrayList<Tbl_publicaciones> informacionColeccion(int id)
	{
		ArrayList<Tbl_publicaciones> informacionColeccion = new ArrayList<Tbl_publicaciones>();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'coleccionInformacion' and menu_order="+id, 
			ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
			ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_tipo_img(rsPublicaciones.getString("public_tipo_img"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				informacionColeccion.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en titulosFtr() "+ e.getMessage());
			e.printStackTrace();
		}
		
		return informacionColeccion;
	}
}
