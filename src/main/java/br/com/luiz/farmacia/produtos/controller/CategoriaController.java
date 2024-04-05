package br.com.luiz.farmacia.produtos.controller;

import br.com.luiz.farmacia.produtos.dto.CategoriaDto;
import br.com.luiz.farmacia.produtos.dto.ProdutoDto;
import br.com.luiz.farmacia.produtos.repository.CategoriaRepository;
import br.com.luiz.farmacia.produtos.service.CategoriaService;
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

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Autowired
    private CategoriaRepository repository;

    @Operation(description = "Busca todos as categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todos as categorias"),
    })
    @GetMapping
    public Page<CategoriaDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterCategorias(paginacao);
    }

    @Operation(description = "Busca a categoria por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria"),
            @ApiResponse(responseCode = "500", description = "Não encontrado categoria com id informado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> detalhar(@PathVariable @NotNull Long id) {
        CategoriaDto dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(description = "Cadastra uma categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria cadastrada"),
            @ApiResponse(responseCode = "400", description = "Error ao cadastrar categoria")
    })
    @PostMapping
    public ResponseEntity<CategoriaDto> criar(@RequestBody @Valid CategoriaDto dto) {
        CategoriaDto categoria = service.criarCategoria(dto);
        return ResponseEntity.ok().body(categoria);
    }

    @Operation(description = "Atualiza uma categoria por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria atualizada"),
            @ApiResponse(responseCode = "400", description = "Não existe categoria com id informado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid CategoriaDto dto) {
        CategoriaDto categoria = service.atualizarCategoria(id, dto);
        return ResponseEntity.ok(categoria);
    }

    @Operation(description = "Delete a categoria por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna nulo"),
            @ApiResponse(responseCode = "204", description = "Não existe categoria com id informado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaDto> remover(@PathVariable @NotNull Long id) {
        service.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
