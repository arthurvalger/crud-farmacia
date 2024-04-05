package br.com.luiz.farmacia.produtos.repository;

import br.com.luiz.farmacia.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
