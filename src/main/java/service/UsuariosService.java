package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Usuarios;
import repository.UsuariosRepository;

@Service
@Transactional(readOnly = true)
public class UsuariosService {
	
	
	private final UsuariosRepository usuariosRepository;
	
		public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
		
	}
    @Transactional
	public Usuarios create(Usuarios usuarios) {
		return this.usuariosRepository.save(usuarios);
	}
    @Transactional
	public Usuarios update(Usuarios usuarios) {
		return this.usuariosRepository.save(usuarios);
	}
    @Transactional	
	public void delete(Usuarios usuarios) {
	       this.usuariosRepository.delete(usuarios);
	}
	
    public Usuarios findById(int id) {
    	return this.usuariosRepository.findById(id);
	}
    
    
	public List<Usuarios> findAll(){
		return this.usuariosRepository.findAll();
	}
}
