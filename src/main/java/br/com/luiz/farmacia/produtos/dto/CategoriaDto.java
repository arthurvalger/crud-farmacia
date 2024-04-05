package br.com.luiz.farmacia.produtos.dto;

import br.com.luiz.farmacia.produtos.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoriaDto {
    private Long id;
    private String nome;
    private String descricao;
    private List<Produto> produtos ;
}
