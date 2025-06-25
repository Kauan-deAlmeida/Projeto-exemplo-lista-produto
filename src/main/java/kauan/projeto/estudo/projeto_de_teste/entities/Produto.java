package kauan.projeto.estudo.projeto_de_teste.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produto {

    private Long id;
    private String nome;
    private Double preco;
    private String descricao;
    private Date dataCadastro;
}
