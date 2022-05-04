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
@ToString(of = "label")
@Builder
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    @OneToMany(mappedBy = "operator", cascade = CascadeType.MERGE)
    private List<MonthReport> reports = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Builder.Default
    @OneToMany(mappedBy = "operator", cascade = CascadeType.MERGE)
    private List<Consumer> consumers = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "operator", cascade = CascadeType.MERGE)
    private List<YearReport> yearReports = new ArrayList<>();

    private String label;
}
