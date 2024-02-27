package org.demo.services;

import org.demo.controllers.UsuarioController;
import org.demo.data.vo.v1.UsuarioVO;
import org.demo.exceptions.RecordsNotFoundException;
import org.demo.mapper.DozerMapper;
import org.demo.models.Usuario;
import org.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<UsuarioVO> findAll(){

        var entitys = DozerMapper.parseListObjects(repository.findAll(), UsuarioVO.class);

        entitys
                .stream()
                .forEach(p -> p.add(linkTo(methodOn(UsuarioController.class).findById(p.getKey())).withSelfRel()));

        try {
            return entitys;
        } catch (RecordsNotFoundException e) {
            throw new RuntimeException(e.getMessage("No Records Found"));
        }
    }

    public UsuarioVO findById(long id){

        var entity =  repository.findById(id)
                .orElseThrow(() -> new RecordsNotFoundException("No Records Found"));

        var vo = DozerMapper.parseObject(entity, UsuarioVO.class);
        vo.add(linkTo(methodOn(UsuarioController.class).findById(id)).withSelfRel());

        return vo;
    }

    public UsuarioVO create(UsuarioVO usuario){

        //repository.existsById(usuario.getKey());

        var entity = DozerMapper.parseObject(usuario, Usuario.class);
        var vo = DozerMapper.parseObject(repository.save(entity), UsuarioVO.class);
        vo.add(linkTo(methodOn(UsuarioController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public UsuarioVO update(UsuarioVO usuario){


        var entity = repository.findById(usuario.getKey())
                .orElseThrow(() -> new RecordsNotFoundException("No Records Found"));

        entity.setUserName(usuario.getUserName());
        entity.setEmail(usuario.getEmail());
        //entity.setPassword(usuario.getPassword());

        var vo = DozerMapper.parseObject(repository.save(entity), UsuarioVO.class);
        vo.add(linkTo(methodOn(UsuarioController.class).findById(vo.getKey())).withSelfRel());

        return vo;

    }

    public void delete(long id){

        var entity = repository.findById(id)
                .orElseThrow(() -> new RecordsNotFoundException("No Records Found"));

        repository.delete(entity);
    }
}
