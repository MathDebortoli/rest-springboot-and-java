package br.com.mathdebortoli.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

import java.io.IOException;

public class GenderSerializer extends ValueSerializer<String> {
    @Override
    public void serialize(String value, tools.jackson.core.JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        System.out.println("SERIALIZER EXECUTANDO: " + value);

        String formattedGender = "Homem".equals(value) ? "H" : "F";
        gen.writeString(formattedGender);
    }
}
