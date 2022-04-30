package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, String>{

	public Usuarios findById(int id);
	
}
