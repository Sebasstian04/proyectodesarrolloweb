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

import model.Receta;
import repository.RecetaRepository;


	@RestController
	@RequestMapping("/aplicativo/v1")
	public class recetaController {
		
		@Autowired
		private RecetaRepository recetaRepository;

		@GetMapping("/Recetas")
		public List<Receta> getRecetas() {
			return recetaRepository.findAll();
		}

		@GetMapping("/Receta/{id}")
		public Receta getRecetas(@PathVariable Integer id) {
			Receta a = recetaRepository.getById(id);
			return a;
		}

		@PostMapping("/Receta")
		public Receta saveReceta(@RequestBody Receta receta) {
			recetaRepository.save(receta);
			return receta;
		}

		@PostMapping("/Recetas")
		public String saveRecetas(@RequestBody List<Receta> List) {
		    recetaRepository.saveAll(List);
			return "done";
		}

		@PutMapping("/receta/{id}")
		public Receta putReceta(@PathVariable Integer id, @RequestBody Receta receta) {

			Receta atributo = recetaRepository.getById(id);

			atributo.setNombreReceta(receta.getNombreReceta());
			atributo.setCantidadPersonas(receta.getCantidadPersonas());
			atributo.setPreparacion(receta.getPreparacion());
			atributo.setAyudaDigital(receta.getAyudaDigital());

			recetaRepository.save(atributo);
			return atributo;
		}

		@DeleteMapping("/receta/{id}")
		public Receta deleteReceta(@PathVariable Integer id) {
			Receta a = recetaRepository.getById(id);
			recetaRepository.deleteById(id);
			return a;
		}


	
}
