package br.ufg.inf.backend.crudorm.repository;

import br.ufg.inf.backend.crudorm.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
