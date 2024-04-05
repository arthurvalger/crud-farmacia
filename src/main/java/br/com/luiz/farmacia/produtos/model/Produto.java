package br.com.luiz.farmacia.produtos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("categoria")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String nome;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotBlank
    private String descricao;
    @NotBlank
    @Size(max = 100)
    private String fabricante;
    @NotNull
    @Positive
    private int quantidade;

//    @ManyToOne(cascade = CascadeType.REMOVE)
    @ManyToOne()

    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("produto")
//    PARA FAZER O CATEGORIA_ID SER OBRIGATORIO
    @NotNull
    private Categoria categoria;
}
