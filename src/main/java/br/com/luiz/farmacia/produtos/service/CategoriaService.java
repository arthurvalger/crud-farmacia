package br.com.luiz.farmacia.produtos.service;

import br.com.luiz.farmacia.produtos.dto.CategoriaDto;
import br.com.luiz.farmacia.produtos.dto.ProdutoDto;
import br.com.luiz.farmacia.produtos.model.Categoria;
import br.com.luiz.farmacia.produtos.model.Produto;
import br.com.luiz.farmacia.produtos.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<CategoriaDto> obterCategorias(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, CategoriaDto.class));
    }

    public CategoriaDto obterPorId(Long id) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found category"));
        return modelMapper.map(categoria, CategoriaDto.class);
    }

    public CategoriaDto criarCategoria(CategoriaDto dto) {
        Categoria categoria = modelMapper.map(dto, Categoria.class);
        repository.save(categoria);
        return modelMapper.map(categoria, CategoriaDto.class);
    }

    public CategoriaDto atualizarCategoria(Long id, CategoriaDto dto) {
        Categoria categoria = modelMapper.map(dto, Categoria.class);
        categoria.setId(id);
        categoria = repository.save(categoria);
        return modelMapper.map(categoria, CategoriaDto.class);
    }

    public void excluirCategoria(Long id) {
        repository.deleteById(id);
    }

}
