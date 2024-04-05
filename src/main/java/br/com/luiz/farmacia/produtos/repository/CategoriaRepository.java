package br.com.luiz.farmacia.produtos.repository;

import br.com.luiz.farmacia.produtos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
