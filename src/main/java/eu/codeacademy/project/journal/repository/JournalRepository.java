package eu.codeacademy.project.journal.repository;

import eu.codeacademy.project.journal.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
