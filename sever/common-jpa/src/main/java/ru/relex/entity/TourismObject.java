package ru.relex.entity;

import lombok.*;
import ru.relex.others.Coordinates;
import ru.relex.others.tourismobject.Transport;
import ru.relex.others.tourismobject.TypeObject;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "туристические_объекты")
public class TourismObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Coordinates coordinates;
    private Double countRequestAtMonth; // кол-во запросов в месяц
    private Transport transport;
    private TypeObject typeObject;


}
