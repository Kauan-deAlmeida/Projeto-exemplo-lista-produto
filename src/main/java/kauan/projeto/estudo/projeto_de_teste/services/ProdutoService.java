package kauan.projeto.estudo.projeto_de_teste.services;

import kauan.projeto.estudo.projeto_de_teste.entities.Produto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    public List<Produto> listarProdutos(List<Produto> produtos) {
        return produtos.get(0).getDataCadastro().after(new Date()) ? Collections.emptyList() : produtos;
    }
}
