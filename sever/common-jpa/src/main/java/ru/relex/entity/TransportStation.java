package ru.relex.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "транспортные остановки")
public class TransportStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
