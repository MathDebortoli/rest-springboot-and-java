package br.com.mathdebortoli.services;


import br.com.mathdebortoli.models.PeopleModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PeopleService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PeopleService.class.getName());


    public List<PeopleModel> findAll() {
        logger.info("Findind all Person!");

        List<PeopleModel> people = new ArrayList<PeopleModel>();
        for (int i = 0; i < 8; i++) {
            PeopleModel person = personMocked(i);
            people.add(person);
        }

        return people;
    }

    public PeopleModel create(PeopleModel people){
        logger.info("Creating one Person!");

        return people;
    }

    public PeopleModel update(PeopleModel people){
        logger.info("Updating one Person!");

        return people;
    }

    public void delete(String id){
        logger.info("Deleting one Person!");
    }



    public PeopleModel findById(String id) {
        logger.info("Findind by Id!");

        PeopleModel person = new PeopleModel();
        person.setId(counter.incrementAndGet());
        person.setNome("Matheus");
        person.setSobrenome("Debortoli");
        person.setEndereco("Baixo Guandu - Espírito Santo - Brazil");
        person.setGenero("Homem");

        return person;
    }

    private  PeopleModel personMocked(int i){
        PeopleModel person = new PeopleModel();
        person.setId(counter.incrementAndGet());
        person.setNome("Daniele " + i);
        person.setSobrenome("Debortoli");
        person.setEndereco("Aimores - Espírito Santo - Brazil");
        person.setGenero("Homem "+ i);

        return person;
    }
}
