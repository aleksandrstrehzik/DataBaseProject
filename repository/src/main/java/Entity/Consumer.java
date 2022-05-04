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
@EqualsAndHashCode(of = {"name", "surname"})
@ToString(exclude = {"monthReports", "yearReports", "operator"})
@Builder
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")
    private Operator operator;

    @Builder.Default
    @OneToMany(mappedBy = "consumer", cascade = CascadeType.MERGE)
    private List<MonthReport> monthReports = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "consumer", cascade = CascadeType.MERGE)
    private List<YearReport> yearReports = new ArrayList<>();

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "apartment_square")
    private Double apartmentsquare;

    @Column(name = "number_of_residents")
    private Integer numberOfResidents;
}
