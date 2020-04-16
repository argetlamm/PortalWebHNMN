package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Tbl_user;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class DT_usuario 
{
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = PoolConexion.getConnection();
	private ResultSet rsUsuario;
	
	///////////////////////////// METODO PARA LISTAR USUARIOS /////////////////////////////
	public ArrayList<Tbl_user> listUser() throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		ArrayList<Tbl_user> listaUsuario = new ArrayList<Tbl_user>();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_user where estado<>3", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUsuario = ps.executeQuery();
			while(rsUsuario.next())
			{
				Tbl_user tus  = new Tbl_user();
				tus.setId_user(rsUsuario.getInt("id_user"));
				tus.setNombre1(rsUsuario.getString("nombre1"));
				tus.setNombre2(rsUsuario.getString("nombre2"));
				tus.setApellido1(rsUsuario.getString("apellido1"));
				tus.setApellido2(rsUsuario.getString("apellido2"));
				tus.setUsername(rsUsuario.getString("username"));
				tus.setPassword(rsUsuario.getString("password"));
				tus.setEmail(rsUsuario.getString("email"));
				tus.setPwd_tmp(rsUsuario.getString("pwd_tmp"));
				tus.setEstado(rsUsuario.getInt("estado"));
				listaUsuario.add(tus);
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en listUser() "+ e.getMessage());
			e.printStackTrace();
		} /*finally {
			c.close();
		}*/
		return listaUsuario;
	}
	
	///////////////////////////// METODO PARA OBTENER USER /////////////////////////////
	public Tbl_user obtenerUser(int idUser) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		Tbl_user tus  = new Tbl_user();
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * from tbl_user where id_user = ? and estado<>3", 
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idUser);
			rsUsuario = ps.executeQuery();
			if(rsUsuario.next())
			{
				tus.setId_user(rsUsuario.getInt("id_user"));
				tus.setNombre1(rsUsuario.getString("nombre1"));
				tus.setNombre2(rsUsuario.getString("nombre2"));
				tus.setApellido1(rsUsuario.getString("apellido1"));
				tus.setApellido2(rsUsuario.getString("apellido2"));
				tus.setUsername(rsUsuario.getString("username"));
				tus.setPassword(rsUsuario.getString("password"));
				tus.setEmail(rsUsuario.getString("email"));
				tus.setPwd_tmp(rsUsuario.getString("pwd_tmp"));
				tus.setEstado(rsUsuario.getInt("estado"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR en obtenerUser() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}		
		return tus;
	}
	
	///////////////////////////// METODO PARA GUARDAR USER /////////////////////////////
	public boolean guardarUser(Tbl_user tus) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean guardado = false;
		
		try
		{
			this.listUser();
			rsUsuario.moveToInsertRow();
			
			rsUsuario.updateString("username", tus.getUsername());
			rsUsuario.updateString("nombre1", tus.getNombre1());
			rsUsuario.updateString("nombre2", tus.getNombre2());
			rsUsuario.updateString("apellido1", tus.getApellido1());
			rsUsuario.updateString("apellido2", tus.getApellido2());
			rsUsuario.updateString("password", getMd5(tus.getPassword()));
			rsUsuario.updateString("email", tus.getEmail());
			rsUsuario.updateInt("estado", 1);
			rsUsuario.insertRow();
			rsUsuario.moveToCurrentRow();
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
	
	///////////////////////////// METODO PARA MODIFICAR USER /////////////////////////////
	public boolean modificarUser(Tbl_user tus) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean modificado=false;	
		try
		{
			this.listUser();
			rsUsuario.beforeFirst();
			while (rsUsuario.next())
			{
				if(rsUsuario.getInt(1)==tus.getId_user())
				{
					rsUsuario.updateString("nombre1", tus.getNombre1());
					rsUsuario.updateString("nombre2", tus.getNombre2());
					rsUsuario.updateString("apellido1", tus.getApellido1());
					rsUsuario.updateString("apellido2", tus.getApellido2());
					rsUsuario.updateString("password", tus.getPassword());
					rsUsuario.updateString("email", tus.getEmail());
					rsUsuario.updateInt("estado", 2);
					rsUsuario.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR modificarUser() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return modificado;
	}
	
	///////////////////////////// METODO PARA ELIMINAR USER /////////////////////////////
	public boolean eliminarUser(Tbl_user tus) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean eliminado=false;	
		try
		{
			this.listUser();
			rsUsuario.beforeFirst();
			while (rsUsuario.next())
			{
				if(rsUsuario.getInt(1)==tus.getId_user())
				{
					rsUsuario.updateInt("estado",3);
					rsUsuario.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("ERROR eliminarUser() "+e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}
		return eliminado;
	}
	
	///////////////////////////// METODO PARA VERIFICAR USER, ROL & PWD /////////////////////////////
	//public boolean dtverificarLogin(String user, String pwd, int idRol) throws SQLException
	public boolean dtverificarLogin(String user, String pwd) throws SQLException
	{
		Connection c = PoolConexion.getConnection();
		boolean existe=false;
		String SQL = ("SELECT * FROM public.\"V_tbl_Usuario_Rol\" where username=? and password=? and id_rol=1");
		try
		{
			PreparedStatement ps = c.prepareStatement(SQL);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ps.setString(2, getMd5(pwd).trim());
			//ps.setInt(3, idRol);
			ResultSet rs = null;
			rs = ps.executeQuery();
		
			if(rs.next())
			{
				existe=true;
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS: ERROR dtverificarLogin() "+ e.getMessage());
			e.printStackTrace();
		} finally {
			c.close();
		}	
		return existe;
	}
	
	public static String getMd5(String input) throws SQLException 
    { 
		//Connection c = PoolConexion.getConnection();
        try { 
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) 
            { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) 
        {
            throw new RuntimeException(e); 
        } /*finally {
        	c.close();
        } */
    } 
}
