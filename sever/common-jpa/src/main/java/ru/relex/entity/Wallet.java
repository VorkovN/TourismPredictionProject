package ru.relex.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@Table(name = "wallet")
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Builder.Default
    private Long balance;
}
