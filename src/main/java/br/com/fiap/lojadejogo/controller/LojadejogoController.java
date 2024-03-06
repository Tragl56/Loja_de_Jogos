package br.com.fiap.lojadejogo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.fiap.lojadejogo.model.Jogos;

@Controller
public class LojadejogoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Jogos> repository = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET , path = "/categoria")
    @ResponseBody
    public List<Jogos> index(){
        return repository;
    } 

    @RequestMapping(method = RequestMethod.POST, path = "/categoria" )
    @ResponseBody
    // @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Jogos> create(@RequestBody Jogos jogos){
        log.info("cadastrando jogos: {}", jogos);
        repository.add(jogos);
        return ResponseEntity.status(201).body(jogos);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/jogos/{id}")
    @ResponseBody
    public ResponseEntity<Jogos> get(@PathVariable Long id){
        log.info("buscando jogos com id {}", id);

        var jogos = repository
                            .stream()
                            .filter(c -> c.id().equals(id))
                            .findFirst();

        if (jogos.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(jogos.get());

        
    }


    
}
