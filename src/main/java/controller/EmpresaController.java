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
import repository.EmpresaRepository;



	@RestController
	@RequestMapping("/aplicativo/v1")
	public class EmpresaController {
		
		@Autowired
		private EmpresaRepository empresaRepository;

		@GetMapping("/Empresas")
		public List<Empresa> getEmpresas() {
			return empresaRepository.findAll();
		}

		@GetMapping("/Empresas/{id}")
		public Empresa getEmpresa(@PathVariable Integer id) {
			Empresa a = empresaRepository.getById(id);
			return a;
		}

		@PostMapping("/Empresa")
		public Empresa saveEmpresa(@RequestBody Empresa empresa) {
			empresaRepository.save(empresa);
			return empresa;
		}

		@PostMapping("/empresas")
		public String saveEmpresas(@RequestBody List<Empresa> List) {
		    empresaRepository.saveAll(List);
			return "done";
		}

		@PutMapping("/empresa/{id}")
		public Empresa putEmpresa(@PathVariable Integer id, @RequestBody Empresa empresa) {

			Empresa atributo = empresaRepository.getById(id);

			atributo.setRazonSocial(empresa.getRazonSocial());
			atributo.setNit(empresa.getNit());
			atributo.setNombreRepresentante(empresa.getNombreRepresentante());
			atributo.setTipoDocumento(empresa.getTipoDocumento());
			atributo.setNumeroIdentificacion(empresa.getNumeroIdentificacion());
			atributo.setEmail(empresa.getEmail());

			empresaRepository.save(atributo);
			return atributo;
		}

		@DeleteMapping("/empresa/{id}")
		public Empresa deleteEmpresa(@PathVariable Integer id) {
			Empresa a = empresaRepository.getById(id);
			empresaRepository.deleteById(id);
			return a;
		}

	
}
