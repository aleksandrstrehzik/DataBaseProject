package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "label")
@ToString(exclude = {"operators", "tariffs"})
@Builder
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    @OneToMany(mappedBy = "admin", cascade = CascadeType.MERGE)
    private List<Tariff> tariffs = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "admin", cascade = CascadeType.MERGE)
    private List<Operator> operators = new ArrayList<>();

    private String label;
}
