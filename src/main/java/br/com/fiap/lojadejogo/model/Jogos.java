package br.com.fiap.lojadejogo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Random;
import lombok.Data;

@Data
@Entity
public class Jogos{
        @Id
        private Long id;
        private String nome;
        private String icone;
    
 
}
