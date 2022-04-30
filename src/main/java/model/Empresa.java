package model;


	import java.util.Set;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonIgnore;


	@Entity
	@Table(name="Empresas")
	public class Empresa {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idEmpresa;
		
		private String razonSocial;
		
		private Integer nit;
		
		private String nombreRepresentante;
		
		private String tipoDocumento;
		
		private Integer numeroIdentificacion;
		
		private String email;
		
		private String rol;
		
		@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
		@JsonIgnore
		private Set<Oferta> oferta;

		public Integer getIdEmpresa() {
			return idEmpresa;
		}

		public void setIdEmpresa(Integer idEmpresa) {
			this.idEmpresa = idEmpresa;
		}

		public String getRazonSocial() {
			return razonSocial;
		}

		public void setRazonSocial(String razonSocial) {
			this.razonSocial = razonSocial;
		}

		public Integer getNit() {
			return nit;
		}

		public void setNit(Integer nit) {
			this.nit = nit;
		}

		public String getNombreRepresentante() {
			return nombreRepresentante;
		}

		public void setNombreRepresentante(String nombreRepresentante) {
			this.nombreRepresentante = nombreRepresentante;
		}

		public String getTipoDocumento() {
			return tipoDocumento;
		}

		public void setTipoDocumento(String tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
		}

		public Integer getNumeroIdentificacion() {
			return numeroIdentificacion;
		}

		public void setNumeroIdentificacion(Integer numeroIdentificacion) {
			this.numeroIdentificacion = numeroIdentificacion;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		public Set<Oferta> getOferta() {
			return oferta;
		}

		public void setOferta(Set<Oferta> oferta) {
			this.oferta = oferta;
		}

		public Empresa(Integer idEmpresa, String razonSocial, Integer nit, String nombreRepresentante, String tipoDocumento,
				Integer numeroIdentificacion, String email, String rol) {
			super();
			this.idEmpresa = idEmpresa;
			this.razonSocial = razonSocial;
			this.nit = nit;
			this.nombreRepresentante = nombreRepresentante;
			this.tipoDocumento = tipoDocumento;
			this.numeroIdentificacion = numeroIdentificacion;
			this.email = email;
			this.rol = rol;
		}
	
}
