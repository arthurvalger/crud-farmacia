package br.com.luiz.farmacia.produtos.service;

import br.com.luiz.farmacia.produtos.dto.ProdutoDto;
import br.com.luiz.farmacia.produtos.model.Produto;
import br.com.luiz.farmacia.produtos.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<ProdutoDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, ProdutoDto.class));
    }

    public ProdutoDto obterPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found product"));
        return modelMapper.map(produto, ProdutoDto.class);
    }

    public ProdutoDto criarProduto(ProdutoDto dto) {
        Produto produto = modelMapper.map(dto, Produto.class);
        repository.save(produto);

        return modelMapper.map(produto, ProdutoDto.class);
    }

    public ProdutoDto atualizarProduto(Long id, ProdutoDto dto) {
        Produto produto = modelMapper.map(dto, Produto.class);
        produto.setId(id);
        produto = repository.save(produto);
        return modelMapper.map(produto, ProdutoDto.class);
    }

    public void excluirProduto(Long id) {
        System.out.println(repository.findById(id));
        repository.deleteById(id);
    }
}
