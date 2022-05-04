package Entity;

import Enums.Months;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"volumeOfConsumedGas", "amountOfHeatEnergyConsumed", "amountOfElectricityEnergyConsumed"})
@ToString(exclude = {"yearReport", "consumer", "operator"})
@Builder
public class MonthReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_report_id")
    private YearReport yearReport;

    @Enumerated(EnumType.STRING)
    @Column(name = "month")
    private Months month;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")
    private Operator operator;

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

}
