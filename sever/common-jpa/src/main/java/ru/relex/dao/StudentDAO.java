package ru.relex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {
}
