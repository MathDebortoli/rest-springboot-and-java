package br.com.mathdebortoli.services;


import br.com.mathdebortoli.controllers.TestLogController;
import br.com.mathdebortoli.controllers.exception.ResourceNotFoundException;
import br.com.mathdebortoli.dto.v1.PersonDto;
import static br.com.mathdebortoli.mapper.ObjectMapper.parseListObjects;
import static br.com.mathdebortoli.mapper.ObjectMapper.parseObject;

import br.com.mathdebortoli.dto.v2.PersonDtoV2;
import br.com.mathdebortoli.mapper.custom.PersonMapper;
import br.com.mathdebortoli.models.PersonModel;
import br.com.mathdebortoli.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @Autowired
    PersonRepository repositoy;

    @Autowired
    PersonMapper converter;

    public List<PersonDto> findAll() {
        logger.info("Findind all Person!");
        return parseListObjects(repositoy.findAll(),PersonDto.class);
    }

    public PersonDto create(PersonDto person){
        logger.info("Creating one Person!");

        var entity = parseObject(person, PersonModel.class);
        return parseObject(repositoy.save(entity),PersonDto.class);
    }

    public PersonDtoV2 createV2(PersonDtoV2 person){
        logger.info("Creating one Person V2!");

        var entity = converter.parseDtotoEntity(person);
        return converter.parseEntityToDto(repositoy.save(entity));
    }

    public PersonDto update(PersonDto person){
        logger.info("Updating one Person!");

        PersonModel entity = repositoy.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Sem resultados para esse recurso!"));
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setEndereco(person.getEndereco());
        entity.setGenero(person.getGenero());

        return parseObject(repositoy.save(entity),PersonDto.class);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");
        PersonModel entity = repositoy.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sem resultados para esse recurso!"));
        repositoy.delete(entity);
    }

    public PersonDto findById(Long id) {
        logger.info("Findind by Id!");
        var entity = repositoy.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sem resultados para esse recurso!"));
        var dto = parseObject(entity, PersonDto.class);
        dto.setNascimento(new Date());
        return dto;
        //return parseObject(entity, PersonDto.class);
    }
}
