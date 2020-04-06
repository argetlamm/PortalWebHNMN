package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_publicaciones;

public class DT_publicaciones {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	private ResultSet rsPublicaciones;
	
	public ArrayList<Tbl_publicaciones> itemMenu() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}*/
		return listaTpus;
	}
	
	public boolean modificarMenu(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String titulo = "";
		try
		{
			this.itemMenu();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					titulo = tpubl.getPublic_titulo();
					if(rsPublicaciones.getInt(1)==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_titulo", titulo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
			/*
			for (Tbl_publicaciones tpubl : tbp)
			{
				titulo = tpubl.getPublic_titulo();
				System.out.println("titulo: "+titulo);
				while(rsPublicaciones.next())
				{
					System.out.println("orden: "+rsPublicaciones.getInt(1));
					System.out.println("orden del objeto: "+tpubl.getMenu_order());
					if(rsPublicaciones.getInt(1)==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_titulo", titulo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}*/
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarMenu() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	
	public ArrayList<Tbl_publicaciones> itemsInicio() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} finally {
			c.close();
		}
		return listaBdy;
	}
	
	public boolean modificarInicio(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String parrafo = "";
		try
		{
			this.itemsInicio();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(rsPublicaciones.getInt("menu_order")==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarQuienesSomos() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> titulosFtr() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} finally {
			c.close();
		}		
		return listaFtr;
	}
	
	public ArrayList<Tbl_publicaciones> itemsFtr() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}*/		
		return listaItemsF;
	}
	
	public ArrayList<Tbl_publicaciones> itemsDonaciones() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsDonaciones'", 
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
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public int obtenerMenuOrder() throws SQLException
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
	
	public boolean guardarBanner(Tbl_publicaciones tpub) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
			rsPublicaciones.updateString("public_titulo", tpub.getPublic_titulo().replace("\\", "/"));	
			rsPublicaciones.insertRow();
			rsPublicaciones.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR guardarUser(): "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return guardado;
	}
	
	public ArrayList<Tbl_publicaciones> imagenesBanner() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}	*/	
		return listaBanner;
	}
		
	public ArrayList<Tbl_publicaciones> itemsQuienesSomos() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public boolean modificarDonaciones(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String parrafo = "";
		try
		{
			this.itemsDonaciones();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(rsPublicaciones.getInt("menu_order")==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarDonaciones() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> tituloDonacion() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'tituloDonaciones'", 
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
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public boolean modificarQuienesSomos(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String parrafo = "";
		try
		{
			this.itemsQuienesSomos();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(rsPublicaciones.getInt("menu_order")==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarQuienesSomos() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> itemsHistoria() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public boolean modificarHistoria(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String parrafo = "";
		try
		{
			this.itemsHistoria();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(rsPublicaciones.getInt("menu_order")==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarHistoria() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> itemsMision() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public boolean modificarMision(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String parrafo = "";
		try
		{
			this.itemsMision();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(rsPublicaciones.getInt("menu_order")==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarMision() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> itemsVision() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public boolean modificarVision(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String parrafo = "";
		try
		{
			this.itemsVision();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					parrafo = tpubl.getPublic_content();
					if(rsPublicaciones.getInt("menu_order")==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_content", parrafo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarVision() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> titulosQuienesSomos() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public ArrayList<Tbl_publicaciones> imagenesColeccion() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} /*finally {
			c.close();
		}*/		
		return listaColeccion;
	}
	
	public ArrayList<Tbl_publicaciones> informacionColeccion(int id) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
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
		} finally {
			c.close();
		}
		
		return informacionColeccion;
	}
}
