package Entity;

import Enums.Months;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"admin", "operators", "monthReports"})
@ToString(exclude = {"admin", "operators", "monthReports"})
@Builder
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Builder.Default
    @OneToMany(mappedBy = "tariff", cascade = CascadeType.MERGE)
    private List<Operator> operators = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "tariff", cascade = CascadeType.MERGE)
    private List<MonthReport> monthReports = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "month")
    private Months month;

    @Column
    private Integer year;

    @Column(name = "electricity_cost")
    private Double electricityCost;

    @Column(name = "heat_energy_cost")
    private Double heatEnergyCost;

    @Column(name = "natural_gas_cost")
    private Double naturalGasCost;
}
