package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Receta;


public interface RecetaRepository extends JpaRepository<Receta, Integer> {

}
