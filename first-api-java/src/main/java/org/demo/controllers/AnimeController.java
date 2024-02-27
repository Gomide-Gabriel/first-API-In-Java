package org.demo.controllers;

import org.demo.data.vo.v1.AnimeVO;
import org.demo.models.Anime;
import org.demo.models.Usuario;
import org.demo.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.demo.config.util.MediaType.*;

@RestController
@RequestMapping("/Anime")
public class AnimeController {

    @Autowired
    AnimeService service;

    @CrossOrigin
    @GetMapping(value = "/{id}"
            , produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public AnimeVO findById(@PathVariable(value = "id") long id){
        return service.findById(id);
    }

    @CrossOrigin
    @GetMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public List<AnimeVO> findAll(){
        return service.findAll();
    }

    @CrossOrigin
    @PostMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML}
            , consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public AnimeVO create(@RequestBody AnimeVO anime){
        return service.create(anime);
    }

    @CrossOrigin
    @PutMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML}
            , consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public AnimeVO update(@RequestBody AnimeVO anime){
        return service.update(anime);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "/{id}") long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
