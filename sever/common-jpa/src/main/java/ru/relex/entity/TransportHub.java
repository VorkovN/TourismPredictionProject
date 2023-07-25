package ru.relex.entity;

import lombok.*;
import ru.relex.others.Coordinates;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "траспортные узлы")
public class TransportHub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Coordinates coordinates;
}
