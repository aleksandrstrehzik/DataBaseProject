package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"consumer", "operator", "monthReports"})
@ToString(exclude = {"consumer", "operator", "monthReports"})
@Builder
public class YearReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")
    private Operator operator;

    @Builder.Default
    @OneToMany(mappedBy = "yearReport", cascade = CascadeType.MERGE)
    private List<MonthReport> monthReports = new ArrayList<>();

    @Column(name = "volume_of_consumed_gas")
    private Double volumeOfConsumedGas;

    @Column(name = "amount_of_heat_energy_consumed")
    private Double amountOfHeatEnergyConsumed;

    @Column(name = "amount_of_electricity_energy_consumed")
    private Double amountOfElectricityEnergyConsumed;

    @Column(name = "pyament_for_gas")
    private Double paymentForGas;

    @Column(name = "pyament_heat_energy")
    private Double paymentHeatEnergy;

    @Column(name = "pyament_for_electricity_energy")
    private Double ElectricityEnergy;

    @Column(name = "year")
    private Integer year;
}
