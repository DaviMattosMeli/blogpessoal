package com.generation.blogpessoal.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
    @Table (name="tb_temas")

public class Tema{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "O atributo descrição é obrigatório e não pode ser nulo")
        private String descricao;

        @OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
        @JsonIgnoreProperties("tema")
        private List<Postagem> postagem ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }
}
