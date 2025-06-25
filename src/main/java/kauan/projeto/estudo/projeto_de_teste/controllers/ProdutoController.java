package kauan.projeto.estudo.projeto_de_teste.controllers;

import kauan.projeto.estudo.projeto_de_teste.entities.Produto;
import kauan.projeto.estudo.projeto_de_teste.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<Produto>> listarTodosProdutos() {
        List<Produto> expectedList = List.of(
                new Produto(1L, "Produto 1", 10.0, "Descrição do Produto 1", new Date()),
                new Produto(2L, "Produto 2", 20.0, "Descrição do Produto 2", new Date()),
                new Produto(3L, "Produto 3", 30.0, "Descrição do Produto 3", new Date()),
                new Produto(4L, "Produto 4", 40.0, "Descrição do Produto 4", new Date())
        );

        List<Produto> produtos = produtoService.listarProdutos(expectedList);

        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(produtos);
    }
}
