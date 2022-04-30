package model;

	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="Recetas")
	public class Receta {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idEmpresa;
		
		private String nombreReceta;
		
		private Integer cantidadPersonas;
		
		private String preparacion;
		
		private String ayudaDigital;

		public Receta(Integer idEmpresa, String nombreReceta, Integer cantidadPersonas, String preparacion,
				String ayudaDigital) {
			super();
			this.idEmpresa = idEmpresa;
			this.nombreReceta = nombreReceta;
			this.cantidadPersonas = cantidadPersonas;
			this.preparacion = preparacion;
			this.ayudaDigital = ayudaDigital;
		}

		public Integer getIdEmpresa() {
			return idEmpresa;
		}

		public void setIdEmpresa(Integer idEmpresa) {
			this.idEmpresa = idEmpresa;
		}

		public String getNombreReceta() {
			return nombreReceta;
		}

		public void setNombreReceta(String nombreReceta) {
			this.nombreReceta = nombreReceta;
		}

		public Integer getCantidadPersonas() {
			return cantidadPersonas;
		}

		public void setCantidadPersonas(Integer cantidadPersonas) {
			this.cantidadPersonas = cantidadPersonas;
		}

		public String getPreparacion() {
			return preparacion;
		}

		public void setPreparacion(String preparacion) {
			this.preparacion = preparacion;
		}

		public String getAyudaDigital() {
			return ayudaDigital;
		}

		public void setAyudaDigital(String ayudaDigital) {
			this.ayudaDigital = ayudaDigital;
		}
		
		
	
}
