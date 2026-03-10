package br.com.mathdebortoli.unitetest.mapper;

import br.com.mathdebortoli.dto.PersonDto;
import br.com.mathdebortoli.mapper.ObjectMapper;
import br.com.mathdebortoli.models.PersonModel;
import br.com.mathdebortoli.unitetest.mapper.mocks.MockPerson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperTests {

    private MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOTest() {

        PersonDto output = ObjectMapper.parseObject(inputObject.mockEntity(), PersonDto.class);

        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getNome());
        assertEquals("Last Name Test0", output.getSobrenome());
        assertEquals("Address Test0", output.getEndereco());
        assertEquals("Male", output.getGenero());
    }

    @Test
    public void parseEntityListToDTOListTest() {

        List<PersonDto> outputList =
                ObjectMapper.parseListObjects(inputObject.mockEntityList(), PersonDto.class);

        PersonDto outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getNome());
        assertEquals("Last Name Test0", outputZero.getSobrenome());
        assertEquals("Address Test0", outputZero.getEndereco());
        assertEquals("Male", outputZero.getGenero());

        PersonDto outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getNome());
        assertEquals("Last Name Test7", outputSeven.getSobrenome());
        assertEquals("Address Test7", outputSeven.getEndereco());
        assertEquals("Female", outputSeven.getGenero());

        PersonDto outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getNome());
        assertEquals("Last Name Test12", outputTwelve.getSobrenome());
        assertEquals("Address Test12", outputTwelve.getEndereco());
        assertEquals("Male", outputTwelve.getGenero());
    }

    @Test
    public void parseDTOToEntityTest() {

        PersonModel output = ObjectMapper.parseObject(inputObject.mockDTO(), PersonModel.class);

        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getNome());
        assertEquals("Last Name Test0", output.getSobrenome());
        assertEquals("Address Test0", output.getEndereco());
        assertEquals("Male", output.getGenero());
    }

    @Test
    public void parserDTOListToEntityListTest() {

        List<PersonModel> outputList =
                ObjectMapper.parseListObjects(inputObject.mockDTOList(), PersonModel.class);

        PersonModel outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getNome());
        assertEquals("Last Name Test0", outputZero.getSobrenome());
        assertEquals("Address Test0", outputZero.getEndereco());
        assertEquals("Male", outputZero.getGenero());

        PersonModel outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getNome());
        assertEquals("Last Name Test7", outputSeven.getSobrenome());
        assertEquals("Address Test7", outputSeven.getEndereco());
        assertEquals("Female", outputSeven.getGenero());

        PersonModel outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getNome());
        assertEquals("Last Name Test12", outputTwelve.getSobrenome());
        assertEquals("Address Test12", outputTwelve.getEndereco());
        assertEquals("Male", outputTwelve.getGenero());
    }
}