package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Tbl_publicaciones;
import entidades.Tbl_user;

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
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
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
		String enlace = "";
		try
		{
			this.itemMenu();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					titulo = tpubl.getPublic_titulo();
					enlace = tpubl.getPublic_enlace();
					if(rsPublicaciones.getInt(3)==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_titulo", titulo);
						rsPublicaciones.updateString("public_enlace", enlace);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
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
				tpub.setPublic_tipo_img(rsPublicaciones.getString("public_tipo_img"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				listaBdy.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemsInicio() "+ e.getMessage());
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
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsInicio'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					
					if(rsPublicaciones.getInt(3)==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_content", tpubl.getPublic_content());
						rsPublicaciones.updateString("public_tipo_img", tpubl.getPublic_tipo_img());
						rsPublicaciones.updateString("public_titulo", tpubl.getPublic_titulo());
						rsPublicaciones.updateString("public_enlace", tpubl.getPublic_enlace());
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarInicio() "+e.getMessage());
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
				tpub.setGuid(rsPublicaciones.getString("guid"));
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
		} /*finally {
			c.close();
		}	*/	
		return listaFtr;
	}
	
	public boolean modificarTitulosFooter(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String titulo = "";
		try
		{
			this.titulosFtr();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					titulo = tpubl.getPublic_titulo();
					System.out.println("Titulo enviado: "+titulo);
					if(rsPublicaciones.getInt(3)==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_titulo", titulo);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarTitulosFooter() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
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
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				listaItemsF.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemsFtr() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/		
		return listaItemsF;
	}
	
	public boolean modificarItemsFooter(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String titulo = "";
		String contenido = "";
		String enlace = "";
		String guid = "";
		try
		{
			this.itemsFtr();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					guid = tpubl.getGuid();
					if(guid.trim().equals("parrafo"))
					{
						contenido = tpubl.getPublic_content();
						if(rsPublicaciones.getInt(3)==tpubl.getMenu_order())
						{
							rsPublicaciones.updateString("public_content", contenido);
							rsPublicaciones.updateRow();
							modificado=true;
							break;
						}
					}
					else
					{
						if(guid.trim().equals("enlace"))
						{
							titulo = tpubl.getPublic_titulo();
							enlace = tpubl.getPublic_enlace();
							if(rsPublicaciones.getInt(3)==tpubl.getMenu_order())
							{
								rsPublicaciones.updateString("public_titulo", titulo);
								rsPublicaciones.updateString("public_enlace", enlace);
								rsPublicaciones.updateRow();
								modificado=true;
								break;
							}
						}
						else
						{
							titulo = tpubl.getPublic_titulo();
							if(rsPublicaciones.getInt(3)==tpubl.getMenu_order())
							{
								rsPublicaciones.updateString("public_titulo", titulo);
								rsPublicaciones.updateRow();
								modificado=true;
								break;
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarItemFooter() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> donaciones() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'donaciones'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setGuid(rsPublicaciones.getString("guid"));
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
			System.out.println("DATOS: ERROR en donaciones() "+ e.getMessage());
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
			System.err.println("ERROR guardarBanner(): "+e.getMessage());
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
			System.out.println("DATOS: ERROR en imagenesBanner() "+ e.getMessage());
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
			System.out.println("DATOS: ERROR en itemsQuienesSomos() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public Tbl_publicaciones obtenerEnlacePublico() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		Tbl_publicaciones tpub  = new Tbl_publicaciones();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name='articulo' AND public_tipo <> 'Eventos' ORDER BY menu_order DESC;", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			if(rsPublicaciones.next())
			{
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en obtenerUsername() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/	
		return tpub;
	}
	
	public Tbl_publicaciones obtenerEnlacePublicoEventos() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		Tbl_publicaciones tpub  = new Tbl_publicaciones();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name='articulo' AND public_tipo = 'Eventos' ORDER BY menu_order DESC;", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			if(rsPublicaciones.next())
			{
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en obtenerUsername() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/	
		return tpub;
	}
	
	public boolean modificarDonaciones(Tbl_publicaciones tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String contenido = "";
		try
		{
			this.donaciones();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				if(rsPublicaciones.getString("guid").trim().equals(tbp.getGuid().trim()))
				{
					contenido = tbp.getPublic_content();
					rsPublicaciones.updateString("public_content", contenido);
					rsPublicaciones.updateRow();
					modificado=true;
					break;
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
			System.out.println("DATOS: ERROR en tituloDonacion() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public boolean modificarQuienesSomos(Tbl_publicaciones tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String contenido = "";
		try
		{
			this.quienesSomos();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				if(rsPublicaciones.getString("guid").trim().equals(tbp.getGuid().trim()))
				{
					contenido = tbp.getPublic_content();
					rsPublicaciones.updateString("public_content", contenido);
					rsPublicaciones.updateRow();
					modificado=true;
					break;
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
	
	public ArrayList<Tbl_publicaciones> quienesSomos() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'quienesSomos'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setGuid(rsPublicaciones.getString("guid"));
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
			System.out.println("DATOS: ERROR en quienesSomos() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaBdy;
	}
	
	public ArrayList<Tbl_publicaciones> imagenesQuienesSomos() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaBdy = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'imagenesQuienesSomos'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				listaBdy.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en ImagenesQuienesSomos() "+ e.getMessage());
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
			System.out.println("DATOS: ERROR en imagenesColeccion() "+ e.getMessage());
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
			System.out.println("DATOS: ERROR en informacionColeccion() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		
		return informacionColeccion;
	}
	
	public ArrayList<Tbl_publicaciones> eventosExistentes() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaArt = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' and public_tipo = 'Eventos' "
					+ "ORDER BY menu_order DESC", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_previa(rsPublicaciones.getString("public_previa"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				listaArt.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en articulosExistentes "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaArt;
	}
	
	public Tbl_publicaciones encontrarEvento(int idEve) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		Tbl_publicaciones evento = new Tbl_publicaciones();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_publicaciones where public_name = 'articulo' and public_tipo = 'Eventos'"
					+ " and menu_order = ?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idEve);
			rsPublicaciones = ps.executeQuery();
			if(rsPublicaciones.next())
			{
				evento.setMenu_order(rsPublicaciones.getInt("menu_order"));
				evento.setGuid(rsPublicaciones.getString("guid"));
				evento.setPublic_content(rsPublicaciones.getString("public_content"));
				evento.setPublic_previa(rsPublicaciones.getString("public_previa"));
				evento.setPublic_estado(rsPublicaciones.getString("public_estado"));
				evento.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				evento.setPublic_name(rsPublicaciones.getString("public_name"));
				evento.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				evento.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				evento.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				evento.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Datos: Error en la obtención de un evento "+ e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			c.close();
		}
		
		return evento;
	}
	
	public int cantidadEventos() throws SQLException
	{
		
		int cantidad = 0;
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' and public_tipo = 'Eventos'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				cantidad++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Datos: Error en el cálculo de la cantidad de eventos."+e.getMessage());
			e.printStackTrace();
		}
		
		return cantidad;
	}
	
	public ArrayList<Tbl_publicaciones> listarEventosPorPagina(int num) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaEventos = new ArrayList<Tbl_publicaciones>();

		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' and public_tipo = 'Eventos' "
					+ "ORDER BY menu_order DESC LIMIT 5 OFFSET ?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, num);
			rsPublicaciones = ps.executeQuery();

			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_previa(rsPublicaciones.getString("public_previa"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				listaEventos.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en eventos por página "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaEventos;
	}
	
	public boolean editarEvento(Tbl_publicaciones tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String contenido = "";
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		try
		{
			this.eventosExistentes();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				if(rsPublicaciones.getInt("menu_order")==tbp.getMenu_order())
				{
					rsPublicaciones.updateString("public_titulo", tbp.getPublic_titulo());
					rsPublicaciones.updateString("public_content", tbp.getPublic_content());
					rsPublicaciones.updateDate("public_fecha", sqlDate);
					rsPublicaciones.updateString("public_previa", tbp.getPublic_previa());
					rsPublicaciones.updateString("public_tipo", tbp.getPublic_tipo());
					rsPublicaciones.updateString("guid", tbp.getGuid());
					rsPublicaciones.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarEvento() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> articulosExistentes() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaArt = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' and public_tipo != 'Eventos' "
					+ "ORDER BY menu_order DESC", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_previa(rsPublicaciones.getString("public_previa"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				listaArt.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en articulosExistentes "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaArt;
	}
	
	public Tbl_publicaciones encontrarArticulo(int idArt) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		Tbl_publicaciones articulo = new Tbl_publicaciones();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_publicaciones where public_name = 'articulo'"
					+ " and menu_order = ?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idArt);
			rsPublicaciones = ps.executeQuery();
			if(rsPublicaciones.next())
			{
				articulo.setMenu_order(rsPublicaciones.getInt("menu_order"));
				articulo.setGuid(rsPublicaciones.getString("guid"));
				articulo.setPublic_content(rsPublicaciones.getString("public_content"));
				articulo.setPublic_previa(rsPublicaciones.getString("public_previa"));
				articulo.setPublic_estado(rsPublicaciones.getString("public_estado"));
				articulo.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				articulo.setPublic_name(rsPublicaciones.getString("public_name"));
				articulo.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				articulo.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				articulo.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				articulo.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Datos: Error en la obtención de un artículo "+ e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			c.close();
		}
		
		return articulo;
	}
	
	public int cantidadArticulos() throws SQLException
	{
		
		int cantidad = 0;
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' and public_tipo != 'Eventos'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				cantidad++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Datos: Error en el cálculo de la cantidad de artículos."+e.getMessage());
			e.printStackTrace();
		}
		
		return cantidad;
	}
	
	public ArrayList<Tbl_publicaciones> listarNoticiasPorPagina(int num) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaArt = new ArrayList<Tbl_publicaciones>();

		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo'"
					+ "ORDER BY menu_order DESC LIMIT 5 OFFSET ?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, num);
			rsPublicaciones = ps.executeQuery();

			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_previa(rsPublicaciones.getString("public_previa"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				listaArt.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listarNoticiasPorPagina "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaArt;
	}
	
	public ArrayList<Tbl_publicaciones> listarNoticiasPorPaginaCategoria(String cat, int num) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaArt = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' AND public_tipo = ? ORDER BY menu_order DESC LIMIT 5 OFFSET ?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setString(1, cat);
			ps.setInt(2, num);
			rsPublicaciones = ps.executeQuery();
			
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_previa(rsPublicaciones.getString("public_previa"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				listaArt.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listarNoticiasPorPaginaCategoria "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaArt;
	}
	
	public ArrayList<Tbl_publicaciones> noticiasExistentes() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaArt = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' "
					+ "ORDER BY menu_order DESC", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_previa(rsPublicaciones.getString("public_previa"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				listaArt.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en articulosExistentes "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaArt;
	}
	
	public ArrayList<Tbl_publicaciones> listarArticulosPorPagina(int num) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaArt = new ArrayList<Tbl_publicaciones>();

		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' and public_tipo != 'Eventos' "
					+ "ORDER BY menu_order DESC LIMIT 5 OFFSET ?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, num);
			rsPublicaciones = ps.executeQuery();

			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_previa(rsPublicaciones.getString("public_previa"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				listaArt.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en articulosExistentes "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaArt;
	}
	
	public ArrayList<Tbl_publicaciones> listarArticulosPorPaginaCategoria(String cat, int num) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaArt = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' AND public_tipo = ? ORDER BY menu_order DESC LIMIT 5 OFFSET ?", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setString(1, cat);
			ps.setInt(2, num);
			rsPublicaciones = ps.executeQuery();
			
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_previa(rsPublicaciones.getString("public_previa"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				listaArt.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en articulosExistentes "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaArt;
	}
	
	public ArrayList<Tbl_publicaciones> listarCategorias() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaCat = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' "
					+ "and public_tipo != 'Eventos'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				listaCat.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listarCategorías "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return listaCat;
	}
	
	public ArrayList<Tbl_publicaciones> listarCategoriasCompletas() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaCat = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				listaCat.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listarCategoríasCompletas "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return listaCat;
	}
		
	public int obtenerMenuOrderArt() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		int menu = 0;
		int contador = 1;
		String publicado = "publicado";
		ArrayList<Tbl_publicaciones> listaArticulos = new ArrayList<Tbl_publicaciones>();
		listaArticulos = this.articulosExistentes();
		for (Tbl_publicaciones tpublc : listaArticulos){
        	if(tpublc.getPublic_estado().trim().equals(publicado)){
        		contador++;
        	}
		}
		menu =  contador;
		return menu;
	}
	
	public boolean editarArticulo(Tbl_publicaciones tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String contenido = "";
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		
		try
		{
			this.articulosExistentes();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				if(rsPublicaciones.getInt("menu_order")==tbp.getMenu_order())
				{
					rsPublicaciones.updateString("public_titulo", tbp.getPublic_titulo());
					rsPublicaciones.updateString("public_content", tbp.getPublic_content());
					rsPublicaciones.updateDate("public_fecha", sqlDate);
					rsPublicaciones.updateString("public_previa", tbp.getPublic_previa());
					rsPublicaciones.updateString("public_tipo", tbp.getPublic_tipo());
					rsPublicaciones.updateString("guid", tbp.getGuid());
					rsPublicaciones.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarArticulo() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public boolean guardarArticuloTexto(Tbl_publicaciones tbpub) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean guardado = false;
		int menu = obtenerMenuOrderArt();
		String enlace = "http://localhost:8080/PortalHNMN/articulo-individual.jsp?ArticuloID="+menu;
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		
		try
		{
			this.articulosExistentes();
			rsPublicaciones.moveToInsertRow();
			
			rsPublicaciones.updateInt("menu_order", menu);
			rsPublicaciones.updateString("guid", tbpub.getGuid());
			rsPublicaciones.updateString("public_content", tbpub.getPublic_content());
			rsPublicaciones.updateString("public_estado", "publicado");
			rsPublicaciones.updateDate("public_fecha", sqlDate);
			rsPublicaciones.updateString("public_name","articulo");
			rsPublicaciones.updateString("public_previa", tbpub.getPublic_previa());
			rsPublicaciones.updateString("public_tipo", tbpub.getPublic_tipo());
			rsPublicaciones.updateString("public_titulo", tbpub.getPublic_titulo());
			rsPublicaciones.updateString("public_enlace", enlace);
			rsPublicaciones.updateString("public_imagen_art", "sin-imagen");
			rsPublicaciones.insertRow();
			rsPublicaciones.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR crearArtículoSóloTexto(): "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return guardado;
	}
	
	public boolean guardarArticuloImagen(Tbl_publicaciones tpub) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean guardado = false;
		int menu = obtenerMenuOrderArt();
		String enlace = "http://localhost:8080/PortalHNMN/articulo-individual.jsp?ArticuloID="+menu;
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		try
		{
			this.articulosExistentes();
			rsPublicaciones.moveToInsertRow();
			rsPublicaciones.updateInt("menu_order", menu);
			rsPublicaciones.updateString("guid", tpub.getGuid());
			rsPublicaciones.updateString("public_content", tpub.getPublic_content());
			rsPublicaciones.updateString("public_estado", "publicado");
			rsPublicaciones.updateDate("public_fecha", sqlDate);
			rsPublicaciones.updateString("public_name","articulo");
			rsPublicaciones.updateString("public_previa", tpub.getPublic_previa());
			rsPublicaciones.updateString("public_tipo", tpub.getPublic_tipo());
			rsPublicaciones.updateString("public_titulo", tpub.getPublic_titulo());
			rsPublicaciones.updateString("public_enlace", enlace);
			rsPublicaciones.updateString("public_imagen_art", tpub.getPublic_imagen_art().replace("\\", "/"));
			rsPublicaciones.insertRow();
			rsPublicaciones.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR guardarArticuloImagen(): "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return guardado;
	}
	
	public boolean guardarEventoTexto(Tbl_publicaciones tbpub) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean guardado = false;
		int menu = obtenerMenuOrderArt();
		String enlace = "http://localhost:8080/PortalHNMN/eventos.jsp";
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		
		try
		{
			this.noticiasExistentes();
			rsPublicaciones.moveToInsertRow();
			rsPublicaciones.updateInt("menu_order", menu);
			rsPublicaciones.updateString("guid", tbpub.getGuid());
			rsPublicaciones.updateString("public_content", tbpub.getPublic_content());
			rsPublicaciones.updateString("public_estado", "publicado");
			rsPublicaciones.updateDate("public_fecha", sqlDate);
			rsPublicaciones.updateString("public_name","articulo");
			rsPublicaciones.updateString("public_previa", tbpub.getPublic_previa());
			rsPublicaciones.updateString("public_tipo", "Eventos");
			rsPublicaciones.updateString("public_titulo", tbpub.getPublic_titulo());
			rsPublicaciones.updateString("public_enlace", enlace);
			rsPublicaciones.updateString("public_imagen_art", "sin-imagen");
			rsPublicaciones.insertRow();
			rsPublicaciones.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR crearArtículoSóloTexto(): "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return guardado;
	}
	
	public boolean guardarEventoImagen(Tbl_publicaciones tpub) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean guardado = false;
		int menu = obtenerMenuOrderArt();
		String enlace = "http://localhost:8080/PortalHNMN/articulo-individual.jsp?ArticuloID="+menu;
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
		try
		{
			this.articulosExistentes();
			rsPublicaciones.moveToInsertRow();
			rsPublicaciones.updateInt("menu_order", menu);
			rsPublicaciones.updateString("guid", tpub.getGuid());
			rsPublicaciones.updateString("public_content", tpub.getPublic_content());
			rsPublicaciones.updateString("public_estado", "publicado");
			rsPublicaciones.updateDate("public_fecha", sqlDate);
			rsPublicaciones.updateString("public_name","articulo");
			rsPublicaciones.updateString("public_previa", tpub.getPublic_previa());
			rsPublicaciones.updateString("public_tipo", "Eventos");
			rsPublicaciones.updateString("public_titulo", tpub.getPublic_titulo());
			rsPublicaciones.updateString("public_enlace", enlace);
			rsPublicaciones.updateString("public_imagen_art", tpub.getPublic_imagen_art().replace("\\", "/"));
			rsPublicaciones.insertRow();
			rsPublicaciones.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR guardarArticuloImagen(): "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return guardado;
	}
	
	public int obtenerMenuOrderImgArt() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		int menu = 0;
		int contador = 1;
		String publicado = "publicado";
		ArrayList<Tbl_publicaciones> listaArticulos = new ArrayList<Tbl_publicaciones>();
		listaArticulos = this.articulosExistentes();
		for (Tbl_publicaciones tpublc : listaArticulos){
        	if(tpublc.getPublic_estado().trim().equals(publicado)){
        		if(tpublc.getPublic_imagen_art().trim().equals("sin-imagen"))
        		{
        			
        		}
        		else
        		{
        			contador++;
        		}
        	}
		}
		menu =  contador;
		return menu;
	}
	
	public String obtenerEnlaceImgArtEdit(int id) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		String enlace = "";
		String publicado = "publicado";
		ArrayList<Tbl_publicaciones> listaArticulos = new ArrayList<Tbl_publicaciones>();
		listaArticulos = this.articulosExistentes();
		for (Tbl_publicaciones tpublc : listaArticulos){
        	if(tpublc.getPublic_estado().trim().equals(publicado)){
        		if(tpublc.getPublic_imagen_art().trim().equals("sin-imagen"))
        		{
        			
        		}
        		else
        		{
        			if(tpublc.getMenu_order()==id)
        			{
        				enlace = tpublc.getPublic_imagen_art();
        			}
        		}
        	}
		}
		return enlace;
	}
	
	public int obtenerMenuOrderImgEventos() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		int menu = 0;
		int contador = 1;
		String publicado = "publicado";
		ArrayList<Tbl_publicaciones> listaArticulos = new ArrayList<Tbl_publicaciones>();
		listaArticulos = this.eventosExistentes();
		for (Tbl_publicaciones tpublc : listaArticulos){
        	if(tpublc.getPublic_estado().trim().equals(publicado)){
        		if(tpublc.getPublic_imagen_art().trim().equals("sin-imagen"))
        		{
        			
        		}
        		else
        		{
        			contador++;
        		}
        	}
		}
		menu =  contador;
		return menu;
	}
	
	public String obtenerEnlaceImgEveEdit(int id) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		String enlace = "";
		String publicado = "publicado";
		ArrayList<Tbl_publicaciones> listaArticulos = new ArrayList<Tbl_publicaciones>();
		listaArticulos = this.eventosExistentes();
		for (Tbl_publicaciones tpublc : listaArticulos){
        	if(tpublc.getPublic_estado().trim().equals(publicado)){
        		if(tpublc.getPublic_imagen_art().trim().equals("sin-imagen"))
        		{
        			
        		}
        		else
        		{
        			if(tpublc.getMenu_order()==id)
        			{
        				enlace = tpublc.getPublic_imagen_art();
        			}
        		}
        	}
		}
		return enlace;
	}
	
	public int cantidadCategoria(String categoria) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		int cantidad = 0;
		
		ArrayList<Tbl_publicaciones> listaCategorias = new ArrayList<Tbl_publicaciones>();
		listaCategorias = this.listarCategorias();
		
		for(Tbl_publicaciones tpub : listaCategorias)
		{
			if(categoria.equals(tpub.getPublic_tipo()))
			{
				cantidad++;
			}
		}
		
		return cantidad;
	}
	
	public int cantidadCategoriaCompletas(String categoria) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		int cantidad = 0;
		
		ArrayList<Tbl_publicaciones> listaCategorias = new ArrayList<Tbl_publicaciones>();
		listaCategorias = this.listarCategoriasCompletas();
		
		for(Tbl_publicaciones tpub : listaCategorias)
		{
			if(categoria.equals(tpub.getPublic_tipo()))
			{
				cantidad++;
			}
		}
		
		return cantidad;
	}
	
	public ArrayList<Tbl_publicaciones> detallesArt(int id) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> detallesArticulos = new ArrayList<Tbl_publicaciones>();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_name = 'articulo' and menu_order="+id, 
			ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
			ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_imagen_art(rsPublicaciones.getString("public_imagen_art"));
				detallesArticulos.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en detallesArt() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return detallesArticulos;
	}
	
	public ArrayList<Tbl_publicaciones> recuperarAyudas() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> ayudas = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'ayudacms'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_content(rsPublicaciones.getString("public_content"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				ayudas.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en recuperarAyudas() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/		
		return ayudas;
	}
	
	public ArrayList<Tbl_publicaciones> itemsProductos() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaProd = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsProductos'", 
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
				listaProd.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemsProductos() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaProd;
	}

	public ArrayList<Tbl_publicaciones> tituloProductos() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaTitProd = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'tituloProductos'", 
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
				listaTitProd.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en tituloProductos() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaTitProd;
	}

	public ArrayList<Tbl_publicaciones> itemsParrafoColecciones() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaParrafColec = new ArrayList<Tbl_publicaciones>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'itemsParrafoColec'", 
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
				listaParrafColec.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemsParrafoColecciones() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaParrafColec;
	}
	
	public ArrayList<Tbl_publicaciones> titulosServicios() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaTpus = new ArrayList<Tbl_publicaciones>();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'servicios' AND guid = 'muestreoIndividualTitulo'"
					+ "OR guid = 'muestreoColectivoTitulo'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				listaTpus.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en titulosServicios() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return listaTpus;
	}
	
	public boolean modificarTitulosServicios(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String titulo = "";
		String name = "";
		String guid = "";
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'servicios' AND guid = 'muestreoIndividualTitulo'"
					+ "OR guid = 'muestreoColectivoTitulo'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					titulo = tpubl.getPublic_titulo();
					name = tpubl.getPublic_name();
					guid = tpubl.getGuid();
					if(rsPublicaciones.getInt(3)==tpubl.getMenu_order())
					{
						rsPublicaciones.updateString("public_titulo", titulo);
						rsPublicaciones.updateString("public_name", name);
						rsPublicaciones.updateString("guid", guid);
						rsPublicaciones.updateRow();
						modificado=true;
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarTitulosServicios() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
	public ArrayList<Tbl_publicaciones> itemsServicios() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_publicaciones> listaTpus = new ArrayList<Tbl_publicaciones>();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'servicios' AND guid = 'muestreoIndividual'"
					+ "OR guid = 'muestreoColectivo'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			while(rsPublicaciones.next())
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setGuid(rsPublicaciones.getString("guid"));
				tpub.setMenu_order(rsPublicaciones.getInt("menu_order"));
				tpub.setPublic_estado(rsPublicaciones.getString("public_estado"));
				tpub.setPublic_fecha(rsPublicaciones.getString("public_fecha"));
				tpub.setPublic_name(rsPublicaciones.getString("public_name"));
				tpub.setPublic_tipo(rsPublicaciones.getString("public_tipo"));
				tpub.setPublic_titulo(rsPublicaciones.getString("public_titulo"));
				tpub.setPublic_enlace(rsPublicaciones.getString("public_enlace"));
				listaTpus.add(tpub);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en itemsServicios() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return listaTpus;
	}
	
	public boolean modificarItemsServicios(ArrayList<Tbl_publicaciones> tbp) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;
		String titulo = "";
		String name = "";
		String guid = "";
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_publicaciones WHERE public_tipo = 'servicios' AND guid = 'muestreoIndividual'"
					+ "OR guid = 'muestreoColectivo'", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPublicaciones = ps.executeQuery();
			rsPublicaciones.beforeFirst();
			while(rsPublicaciones.next())
			{
				for(Tbl_publicaciones tpubl : tbp)
				{
					titulo = tpubl.getPublic_titulo();
					name = tpubl.getPublic_name();
					guid = tpubl.getGuid();
					
					if(rsPublicaciones.getString(7).trim().equals(name.trim()))
					{
						if(rsPublicaciones.getInt(3)==tpubl.getMenu_order())
						{
							rsPublicaciones.updateString("public_titulo", titulo);
							rsPublicaciones.updateString("public_name", name);
							rsPublicaciones.updateString("guid", guid);
							rsPublicaciones.updateRow();
							modificado=true;
							break;
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarItemServicios() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;	
	}
	
}
