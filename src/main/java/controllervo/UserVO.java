package controllervo;

import javax.persistence.Column;
@Data
public class UserVO {

	private String nombre;
	private String apellidos;
	private String Tipodoc;
	@Column(unique = true , length = 14)
	private String numerodoc;
	@Column(name="mail", nullable=false , length = 50, unique = true)
	private String email;
	private String direccion;
	private String telefono;
	private String rol;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipodoc() {
		return Tipodoc;
	}
	public void setTipodoc(String tipodoc) {
		Tipodoc = tipodoc;
	}
	public String getNumerodoc() {
		return numerodoc;
	}
	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
}
