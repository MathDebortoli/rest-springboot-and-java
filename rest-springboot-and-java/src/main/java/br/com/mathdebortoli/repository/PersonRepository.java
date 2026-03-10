package br.com.mathdebortoli.repository;

import br.com.mathdebortoli.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
