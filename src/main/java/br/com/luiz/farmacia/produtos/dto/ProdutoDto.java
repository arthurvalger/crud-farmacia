package br.com.luiz.farmacia.produtos.dto;

import br.com.luiz.farmacia.produtos.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDto {
    private Long id;
    private String nome;
    private BigDecimal valor;
    private String descricao;
    private String fabricante;
    private int quantidade;
    private Long categoriaId;

}
