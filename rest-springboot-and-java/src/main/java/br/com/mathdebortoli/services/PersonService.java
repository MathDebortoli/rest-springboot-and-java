package br.com.mathdebortoli.services;


import br.com.mathdebortoli.controllers.exception.ResourceNotFoundException;
import br.com.mathdebortoli.models.PersonModel;
import br.com.mathdebortoli.repository.PersonRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepositoy repositoy;

    public List<PersonModel> findAll() {
        logger.info("Findind all Person!");
        return repositoy.findAll();
    }

    public PersonModel create(PersonModel person){
        logger.info("Creating one Person!");
        return repositoy.save(person);
    }

    public PersonModel update(PersonModel person){
        logger.info("Updating one Person!");

        PersonModel entity = repositoy.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Sem resultados para esse recurso!"));
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());

        return repositoy.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");
        PersonModel entity = repositoy.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sem resultados para esse recurso!"));
        repositoy.delete(entity);
    }

    public PersonModel findById(Long id) {
        logger.info("Findind by Id!");
        return repositoy.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sem resultados para esse recurso!"));
    }
}
