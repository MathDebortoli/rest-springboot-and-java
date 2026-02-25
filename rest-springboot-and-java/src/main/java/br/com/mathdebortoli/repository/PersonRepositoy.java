package br.com.mathdebortoli.repository;

import br.com.mathdebortoli.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoy extends JpaRepository<PersonModel, Long> {
}
