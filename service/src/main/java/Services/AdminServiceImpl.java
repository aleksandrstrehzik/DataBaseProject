package Services;


import DAO.Impl.OperatorDAOImpl;
import DAO.Impl.TariffDAOImpl;
import DAO.Interfaces.OperatorDAO;
import DAO.Interfaces.TariffDAO;
import Entity.Operator;
import Entity.Tariff;
import Enums.Months;
import Interfaces.AdminService;
import Interfaces.GeneralService;

public class AdminServiceImpl implements AdminService {

    OperatorDAO operatorDAO = new OperatorDAOImpl();
    TariffDAO tariffDAO = new TariffDAOImpl();
    GeneralService generalService = new GeneralServicesImpl();

    public void createTariff(String adminLabel, Months month, Integer year,
                             Double electricityCost, Double heatEnergyCost,
                             Double naturalGasCost) {
        tariffDAO.save(Tariff.builder()
                .admin(generalService.getAdmin(adminLabel))
                .month(month)
                .year(year)
                .electricityCost(electricityCost)
                .heatEnergyCost(heatEnergyCost)
                .naturalGasCost(naturalGasCost)
                .build());
    }

    public void createOperator(String label, String adminLabel) {
        operatorDAO.save(Operator.builder()
                .label(label)
                .admin(generalService.getAdmin(adminLabel))
                .build());

    }

    public void assignTheTariffForOperator(String operatorLabel, Months tariffMonth,
                                           Integer tariffYear) {
        Operator operator = generalService.getOperator(operatorLabel);
        Tariff tariff = generalService.getTariff(tariffMonth, tariffYear);
        operator.setTariff(tariff);
        operatorDAO.update(operator);
    }
}
