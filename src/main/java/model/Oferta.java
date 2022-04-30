package model;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;


	@Entity
	@Table(name="Ofertas")
	public class Oferta {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idEmpresa;
		
		private String cargo;
		
		private String descripcion;
		
		private Integer vacantes;
		
		private String experiencia;
		
		private Float salario;
		
		@ManyToOne
		@JoinColumn(name = "empresa_id")
		private Empresa empresa;
		
		@ManyToOne
		@JoinColumn(name = "usuario_id")
		private Usuarios usuario;
		

		public Integer getIdEmpresa() {
			return idEmpresa;
		}

		public void setIdEmpresa(Integer idEmpresa) {
			this.idEmpresa = idEmpresa;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Integer getVacantes() {
			return vacantes;
		}

		public void setVacantes(Integer vacantes) {
			this.vacantes = vacantes;
		}

		public String getExperiencia() {
			return experiencia;
		}

		public void setExperiencia(String experiencia) {
			this.experiencia = experiencia;
		}

		public Float getSalario() {
			return salario;
		}

		public void setSalario(Float salario) {
			this.salario = salario;
		}

		public Empresa getEmpresa() {
			return empresa;
		}

		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}

		public Usuarios getUsuario() {
			return usuario;
		}

		public void setUsuario(Long usuarios) {
			this.usuario = usuarios;
		}

		public Oferta(Integer idEmpresa, String cargo, String descripcion, Integer vacantes, String experiencia,
				Float salario) {
			super();
			this.idEmpresa = idEmpresa;
			this.cargo = cargo;
			this.descripcion = descripcion;
			this.vacantes = vacantes;
			this.experiencia = experiencia;
			this.salario = salario;
		}

	
	
}
