package Interfaces;

import Enums.Months;

public interface AdminService {

    void createTariff(String adminLabel, Months month, Integer year,
                      Double electricityCost, Double heatEnergyCost,
                      Double naturalGasCost);

    void createOperator(String label, String adminLabel);

    void assignTheTariffForOperator(String operatorLabel, Months tariffMonth,
                                    Integer tariffYear);
}
