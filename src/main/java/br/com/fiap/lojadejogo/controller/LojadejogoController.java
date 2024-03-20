package br.com.fiap.lojadejogo.controller;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import br.com.fiap.lojadejogo.model.Jogos;
import br.com.fiap.lojadejogo.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/categoria")
@Slf4j

@RestController
public class LojadejogoController {

       @Autowired // CDI - Injeção de Dependência
    CategoriaRepository repository;

    @GetMapping
    public List<Jogos> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Jogos create(@RequestBody Jogos jogos) {
        log.info("cadastrando jogos: {}", jogos);
        return repository.save(jogos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Jogos> get(@PathVariable Long id) {
        log.info("buscando jogos com id {}", id);

        return repository
                    .findById(id)
                    .map(ResponseEntity::ok) //reference method
                    .orElse(ResponseEntity.notFound().build());

    }



    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando jogos {}", id);
        verificarSeExisteCategoria(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(OK)
    public Jogos update(@PathVariable Long id, @RequestBody Jogos jogos){
        log.info("atualizando Jogos com id {} para {}", id, jogos);

        verificarSeExisteCategoria(id);
        
        jogos.setId(id);
        return repository.save(jogos);

    }

    private void verificarSeExisteCategoria(Long id) {
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                                    NOT_FOUND, 
                                    "id da categoria não encontrado"
                                ));
    }



    
}
