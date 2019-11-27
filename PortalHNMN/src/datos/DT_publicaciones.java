package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import entidades.Tbl_publicaciones;
import entidades.Tbl_user;

public class DT_publicaciones {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	private ResultSet rsPublicaciones;

	///////////////////////////////////////Menú//////////////////////////////////////////////////////////////////
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
	
	///////////Guardar los datos para cambiar solo el título del menu//////////
	public boolean modificarMenu(ArrayList<Tbl_publicaciones> tbp)
	{
		boolean modificado=false;
		int contador = 1;
		String titulo = "";
		//Iterator<Tbl_publicaciones> objeto = tbp.iterator();
		try
		{
			this.itemMenu();
			rsPublicaciones.beforeFirst();
			//while(objeto.hasNext())
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
						contador++;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarMenu() "+e.getMessage());
			e.printStackTrace();
		}
		return modificado;
		
	}
	
	public int obtenerMenuOrder()
	{
		int menu = 0;
		String publicado = "publicado";
		ArrayList<Tbl_publicaciones> listaBanner = new ArrayList<Tbl_publicaciones>();
		listaBanner = this.imagenesBannerOrden();
		for (Tbl_publicaciones tpublc : listaBanner){
        	if(tpublc.getPublic_estado().trim().equals(publicado)){
        		menu = tpublc.getMenu_order();
        	}
		}
		menu =  menu+1;
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
	
	//////////////////////////////////////////////Titulos Footer///////////////////////////////////////////////////////
	
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
	
	public ArrayList<Tbl_publicaciones> imagenesBannerOrden()
	{
		ArrayList<Tbl_publicaciones> listaBanner = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT menu_order FROM tbl_publicaciones WHERE public_tipo = 'bannerI'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
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
	
	public String getFecha(){
	
	Calendar fecha = new GregorianCalendar();
	int año = fecha.get(Calendar.YEAR);
	int mes = fecha.get(Calendar.MONTH);
	int dia = fecha.get(Calendar.DAY_OF_MONTH);
	String anio = Integer.toString(año);
	String meses = Integer.toString(mes);
	String dias = Integer.toString(dia);
	String fechas = anio +"/"+ meses +"/"+dias;
	return fechas;
	}
}
