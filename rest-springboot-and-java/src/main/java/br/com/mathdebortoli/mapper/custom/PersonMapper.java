package br.com.mathdebortoli.mapper.custom;

import br.com.mathdebortoli.dto.v2.PersonDtoV2;
import br.com.mathdebortoli.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDtoV2 parseEntityToDto(PersonModel person){
        PersonDtoV2 dto = new PersonDtoV2();
        dto.setId(person.getId());
        dto.setNome(person.getNome());
        dto.setNascimento(new Date());
        dto.setSobrenome(person.getSobrenome());
        dto.setEndereco(person.getEndereco());
        dto.setGenero(person.getGenero());
        return dto;
    }

    public PersonModel parseDtotoEntity(PersonDtoV2 dto){
        PersonModel person = new PersonModel();
        person.setId(dto.getId());
        person.setNome(dto.getNome());
        //person.setNascimento(new Date());
        person.setSobrenome(dto.getSobrenome());
        person.setEndereco(dto.getEndereco());
        person.setGenero(dto.getGenero());
        return person;
    }
}
