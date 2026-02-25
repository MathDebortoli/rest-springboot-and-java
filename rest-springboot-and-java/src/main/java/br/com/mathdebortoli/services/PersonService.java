package br.com.mathdebortoli.services;


import br.com.mathdebortoli.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());


    public List<PersonModel> findAll() {
        logger.info("Findind all Person!");

        List<PersonModel> people = new ArrayList<PersonModel>();
        for (int i = 0; i < 8; i++) {
            PersonModel person = personMocked(i);
            people.add(person);
        }

        return people;
    }

    public PersonModel create(PersonModel people){
        logger.info("Creating one Person!");

        return people;
    }

    public PersonModel update(PersonModel people){
        logger.info("Updating one Person!");

        return people;
    }

    public void delete(String id){
        logger.info("Deleting one Person!");
    }



    public PersonModel findById(String id) {
        logger.info("Findind by Id!");

        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setNome("Matheus");
        person.setSobrenome("Debortoli");
        person.setEndereco("Baixo Guandu - Espírito Santo - Brazil");
        person.setGenero("Homem");

        return person;
    }

    private PersonModel personMocked(int i){
        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setNome("Daniele " + i);
        person.setSobrenome("Debortoli");
        person.setEndereco("Aimores - Espírito Santo - Brazil");
        person.setGenero("Homem "+ i);

        return person;
    }
}
