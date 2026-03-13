package br.com.mathdebortoli.dto.v1;

import br.com.mathdebortoli.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@JsonPropertyOrder({"id","nome","sobrenome","genero","endereco"})
public class PersonDto implements Serializable {

    private static final Long personModelUID = 1L;

    private Long id;

    //@JsonProperty("nome")
    private String nome;

    // @JsonIgnore
    private String sobrenome;

    //@JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    private String endereco;

    @JsonSerialize(using = GenderSerializer.class)
    private String genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDto personDto)) return false;
        return Objects.equals(getId(), personDto.getId()) && Objects.equals(getNome(), personDto.getNome()) && Objects.equals(getSobrenome(), personDto.getSobrenome()) && Objects.equals(getNascimento(), personDto.getNascimento()) && Objects.equals(getEndereco(), personDto.getEndereco()) && Objects.equals(getGenero(), personDto.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getNascimento(), getEndereco(), getGenero());
    }
}

