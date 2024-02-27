package org.demo.controllers;

import org.demo.config.util.MediaType;

import org.demo.data.vo.v1.UsuarioVO;
import org.demo.models.Usuario;
import org.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.demo.config.util.MediaType.*;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @CrossOrigin
    @GetMapping(value = "/{id}"
            , produces =  {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public UsuarioVO findById(@PathVariable(value = "id") long id){
        return service.findById(id);
    }

    @CrossOrigin
    @GetMapping(produces =  {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public List<UsuarioVO> findAll(){
        return service.findAll();
    }

    @CrossOrigin
    @PostMapping(produces =  {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML }
            , consumes =  {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public UsuarioVO create(@RequestBody UsuarioVO usuarioVO){
        return service.create(usuarioVO);
    }

    @CrossOrigin
    @PutMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML}
            , consumes =  {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public UsuarioVO update(@RequestBody UsuarioVO usuarioVO){
        return service.update(usuarioVO);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

