package org.demo.services;

import org.demo.controllers.AnimeController;
import org.demo.controllers.UsuarioController;
import org.demo.data.vo.v1.AnimeVO;
import org.demo.exceptions.RecordsNotFoundException;
import org.demo.mapper.DozerMapper;
import org.demo.models.Anime;
import org.demo.models.Usuario;
import org.demo.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class AnimeService {

    @Autowired
    AnimeRepository repository;

    public List<AnimeVO> findAll(){

        var entitys = DozerMapper.parseListObjects(repository.findAll(), AnimeVO.class);

        entitys
                .stream()
                .forEach(p -> p.add(linkTo(methodOn(AnimeController.class).findById(p.getKey())).withSelfRel()));


        try {
            return entitys;
        }catch (RecordsNotFoundException e) {
            throw new RuntimeException(e.getMessage("No Records Found"));
        }

    }

    public AnimeVO findById(long id){
        var entity = repository.findById(id)
                .orElseThrow(() -> new RecordsNotFoundException("No Records Found"));

        var vo = DozerMapper.parseObject(entity, AnimeVO.class);
        vo.add(linkTo(methodOn(AnimeController.class).findById(id)).withSelfRel());
        return vo;
    }

    public AnimeVO create(AnimeVO anime){

       /* if(repository.existsById(anime.getId()) && anime.getId() != null) {
           throw new RecordsNotFoundException("Records already exists");
        }*/

        var entity = DozerMapper.parseObject(anime, Anime.class);
        var vo = DozerMapper.parseObject(repository.save(entity), AnimeVO.class);
        vo.add(linkTo(methodOn(AnimeController.class).findById(vo.getKey())).withSelfRel());

        return vo;
    }

    public AnimeVO update(AnimeVO anime){

        var entity = repository.findById(anime.getKey())
                .orElseThrow(() -> new RecordsNotFoundException("No Records Found"));

        entity.setName(anime.getName());
        entity.setImage(anime.getImage());
        entity.setEpisodes(anime.getEpisodes());
        entity.setStudio(anime.getStudio());
        entity.setRating(anime.getRating());

        var vo = DozerMapper.parseObject(repository.save(entity) , AnimeVO.class);
        return vo;
    }

    public void delete(long id){

        var entity = repository.findById(id)
                .orElseThrow(() -> new RecordsNotFoundException("No Records Found"));

        repository.delete(entity);
    }

}










