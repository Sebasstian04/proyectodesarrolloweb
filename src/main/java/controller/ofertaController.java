package controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import model.Empresa;
import model.Oferta;
import model.Usuarios;
import repository.EmpresaRepository;
import repository.OfertaRepository;
import repository.UsuariosRepository;


	@RestController
	@RequestMapping("/aplicativo/v1")
	public class ofertaController {
		
		@Autowired
		private EmpresaRepository empresaRepository;
		
		@Autowired
		private UsuariosRepository usuariosRepository;

		@Autowired
		private OfertaRepository ofertaRepository;
		
		@GetMapping("/oferta")
		public List<Oferta> getOferta() {
			return ofertaRepository.findAll();
		}

		@GetMapping("/ofertas/{id}")
		public Oferta getOferta(@PathVariable Integer id) {
			Oferta a = ofertaRepository.getById(id);
			return a;
		}
		
		@PostMapping("/oferta")
		public Oferta saveOferta(@RequestBody Oferta oferta) {
			ofertaRepository.save(oferta);	
			return oferta;
		}
		
		@PostMapping("/tarjetas")
		public String saveOfertas (@RequestBody List<Oferta> list) {
			ofertaRepository.saveAll(list);	
			return "done";
		}
		
		@PutMapping("/Oferta/{id}")
		public Oferta putOferta(@PathVariable Integer id, @RequestBody Oferta oferta){
			
			Oferta a = ofertaRepository.getById(id);
			
			a.setCargo(oferta.getCargo());
			a.setDescripcion(oferta.getDescripcion());
			a.setVacantes(oferta.getVacantes());
			a.setExperiencia(oferta.getExperiencia());
			a.setSalario(oferta.getSalario());
			
			ofertaRepository.save(a);
			return a;
		}
		
		@DeleteMapping("/Oferta/{id}")
		public Oferta deleteOferta(@PathVariable Integer id){
			Oferta a = ofertaRepository.getById(id);
			ofertaRepository.deleteById(id);
			return a;
		}
		
		
		@PutMapping("/ofertas/{idoferta}/{idEmpresa}/{idUsuario}")
		public Oferta associate(@PathVariable Integer idoferta, @PathVariable Integer idEmpresa, @PathVariable Integer idUsuario) {
			
			Oferta oferta = ofertaRepository.findById(idoferta).get();
			Empresa empresa = empresaRepository.findById(idEmpresa).get();
			Long usuarios =  usuariosRepository.findById(idUsuario).getId();
			
			usuarios.getOferta().add(oferta);
	        oferta.setUsuario(usuarios);
	       
	        empresa.getOferta().add(oferta);
	        oferta.setEmpresa(empresa);
			
			ofertaRepository.save(oferta);
			return oferta;
		}

}
