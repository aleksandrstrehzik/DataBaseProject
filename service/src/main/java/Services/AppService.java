package Services;

import Enums.Months;
import Interfaces.AdminService;
import Interfaces.GeneralService;

public class AppService {


    public static void main(String[] args) {
        AdminService adminServiceImpl = new AdminServiceImpl();
        GeneralService generalService = new GeneralServicesImpl();
        generalService.createAdmin("GE");
        adminServiceImpl.createOperator("MTETS", "GE");
        adminServiceImpl.createTariff("GE", Months.January, 2000,
                1.3, 1.9, 2.5);
        adminServiceImpl.assignTheTariffForOperator("MTETS",Months.January,
                2000);

    }
}
