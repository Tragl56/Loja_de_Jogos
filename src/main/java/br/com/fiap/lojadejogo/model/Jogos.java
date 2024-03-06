package br.com.fiap.lojadejogo.model;

import java.util.Random;

public record Jogos(Long id, String nome, String icone) {

    public Jogos (Long id, String nome, String icone){
        var key = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = key;  
        this.nome = nome;  
        this.icone = icone;  
    }
 
}
