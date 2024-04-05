package br.com.luiz.farmacia.produtos.controller;

import br.com.luiz.farmacia.produtos.dto.CategoriaDto;
import br.com.luiz.farmacia.produtos.dto.ProdutoDto;
import br.com.luiz.farmacia.produtos.model.Produto;
import br.com.luiz.farmacia.produtos.repository.ProdutoRepository;
import br.com.luiz.farmacia.produtos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @Autowired
    private ProdutoRepository repository;

    @Operation(description = "Busca todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todos os produtos"),
    })
    @GetMapping
    public Page<ProdutoDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @Operation(description = "Busca o produto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto"),
            @ApiResponse(responseCode = "500", description = "Não encontrado produto com id informado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> detalhar(@PathVariable @NotNull Long id) {
        ProdutoDto dto = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @Operation(description = "Cadastra um produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto cadastrado"),
            @ApiResponse(responseCode = "400", description = "Error ao cadastrar produto")
    })
    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoDto dto, UriComponentsBuilder uriBuilder) {
        ProdutoDto produto = service.criarProduto(dto);
        URI endereco = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(endereco).body(produto);
    }

    @Operation(description = "Atualiza um produto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto atualizado"),
            @ApiResponse(responseCode = "400", description = "Não existe produto com id informado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid ProdutoDto dto) {
        ProdutoDto atualizado = service.atualizarProduto(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(description = "Delete o produto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna nulo"),
            @ApiResponse(responseCode = "204", description = "Não existe produto com id informado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDto> remover(@PathVariable @NotNull Long id) {
        service.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
