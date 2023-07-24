package ru.relex.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.others.Coordinates;

public interface PointsDAO extends JpaRepository<Coordinates, Long> {

}
