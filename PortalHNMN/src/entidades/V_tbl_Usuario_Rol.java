package entidades;


public class V_tbl_Usuario_Rol {
	
	//ATRIBUTOS
	private int id_user_rol;
	private int id_user;
	private String username;
	private String password;
	private int id_rol;
	private String rol_name;
	private int tipo_rol;
	private int user_estado;
	private int rol_estado;
	
	//METODOS
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getRol_name() {
		return rol_name;
	}
	public void setRol_name(String rol_name) {
		this.rol_name = rol_name;
	}
	public int getUser_estado() {
		return user_estado;
	}
	public void setUser_estado(int user_estado) {
		this.user_estado = user_estado;
	}
	public int getRol_estado() {
		return rol_estado;
	}
	public void setRol_estado(int rol_estado) {
		this.rol_estado = rol_estado;
	}
	public int getId_user_rol() {
		return id_user_rol;
	}
	public void setId_user_rol(int id_user_rol) {
		this.id_user_rol = id_user_rol;
	}
	public int getTipo_rol() {
		return tipo_rol;
	}
	public void setTipo_rol(int tipo_rol) {
		this.tipo_rol = tipo_rol;
	}
}