package br.com.mathdebortoli.unitetest.mapper.mocks;

import br.com.mathdebortoli.dto.PersonDto;
import br.com.mathdebortoli.models.PersonModel;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public PersonModel mockEntity() {
        return mockEntity(0);
    }

    public PersonDto mockDTO() {
        return mockDTO(0);
    }

    public List<PersonModel> mockEntityList() {
        List<PersonModel> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDto> mockDTOList() {
        List<PersonDto> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }

    public PersonModel mockEntity(Integer number) {
        PersonModel person = new PersonModel();
        person.setEndereco("Address Test" + number);
        person.setNome("First Name Test" + number);
        person.setGenero((number % 2 == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }

    public PersonDto mockDTO(Integer number) {
        PersonDto person = new PersonDto();
        person.setEndereco("Address Test" + number);
        person.setNome("First Name Test" + number); // CORRIGIDO
        person.setGenero((number % 2 == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }
}