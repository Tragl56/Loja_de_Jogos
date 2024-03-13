package br.com.fiap.lojadejogo.repository;
import br.com.fiap.lojadejogo.model.Jogos;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Jogos, Long> {


}
