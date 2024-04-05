package br.com.luiz.farmacia.produtos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String nome;
    @NotBlank
    @Size(max = 100)
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("categoria")
    private List<Produto> produtos ;

}
