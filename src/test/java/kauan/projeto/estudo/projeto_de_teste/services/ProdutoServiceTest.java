package kauan.projeto.estudo.projeto_de_teste.services;

import kauan.projeto.estudo.projeto_de_teste.entities.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    List<Produto> expectedList;

    @BeforeEach
    void before() {
         expectedList = List.of(
                new Produto(1L, "Produto 1", 10.0, "Descrição do Produto 1", new Date()),
                new Produto(2L, "Produto 2", 20.0, "Descrição do Produto 2", new Date()),
                new Produto(3L, "Produto 3", 30.0, "Descrição do Produto 3", new Date()),
                new Produto(4L, "Produto 4", 40.0, "Descrição do Produto 4", new Date())
        );
    }

    @Test
    void deveRetornarTodosDaLista() {
        List<Produto> result = produtoService.listarProdutos(expectedList);

        assertEquals(expectedList.size(), result.size());
    }

    @Test
    void deveRetornarNullQuandoBuscarTodosProdutos() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

        expectedList.get(0).setDataCadastro(sdf.parse("2025-06-26T00:00:00Z"));

        List<Produto> result = produtoService.listarProdutos(expectedList);
        assertTrue(result.isEmpty());
    }
}