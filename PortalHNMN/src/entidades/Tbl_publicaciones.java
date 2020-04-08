package entidades;

public class Tbl_publicaciones implements Comparable<Tbl_publicaciones>{
	
	//ATRIBUTOS
	private int id_publicacion;
	private String guid;
	private int menu_order;
	private String public_content;
	private String public_estado;
	private String public_fecha;
	private String public_name;
	private String public_previa;
	private String public_tipo;
	private String public_tipo_img;
	private String public_titulo;
	
	//METODOS
	public int getId_publicacion() {
		return id_publicacion;
	}
	public void setId_publicacion(int id_publicacion) {
		this.id_publicacion = id_publicacion;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public int getMenu_order() {
		return menu_order;
	}
	public void setMenu_order(int menu_order) {
		this.menu_order = menu_order;
	}
	public String getPublic_content() {
		return public_content;
	}
	public void setPublic_content(String public_content) {
		this.public_content = public_content;
	}
	public String getPublic_estado() {
		return public_estado;
	}
	public void setPublic_estado(String public_estado) {
		this.public_estado = public_estado;
	}
	public String getPublic_fecha() {
		return public_fecha;
	}
	public void setPublic_fecha(String public_fecha) {
		this.public_fecha = public_fecha;
	}
	public String getPublic_name() {
		return public_name;
	}
	public void setPublic_name(String public_name) {
		this.public_name = public_name;
	}
	public String getPublic_previa() {
		return public_previa;
	}
	public void setPublic_previa(String public_previa) {
		this.public_previa = public_previa;
	}
	public String getPublic_tipo() {
		return public_tipo;
	}
	public void setPublic_tipo(String public_tipo) {
		this.public_tipo = public_tipo;
	}
	public String getPublic_tipo_img() {
		return public_tipo_img;
	}
	public void setPublic_tipo_img(String public_tipo_img) {
		this.public_tipo_img = public_tipo_img;
	}
	public String getPublic_titulo() {
		return public_titulo;
	}
	public void setPublic_titulo(String public_titulo) {
		this.public_titulo = public_titulo;
	}
	
	
	//METODOS
	
	@Override
	public int compareTo(Tbl_publicaciones tbl)
	{
		if(tbl.getMenu_order() > menu_order)
		{
			return -1;
		}
		else
		{
			if(tbl.getMenu_order() < menu_order )
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}

	}

}
