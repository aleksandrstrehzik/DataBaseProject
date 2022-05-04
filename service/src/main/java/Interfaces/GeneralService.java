package Interfaces;

import Entity.Admin;
import Entity.Operator;
import Entity.Tariff;
import Enums.Months;

public interface GeneralService {

    void createAdmin(String adminLabel);

    Admin getAdmin(String adminLabel);

    Tariff getTariff(Months month, Integer year);

    Operator getOperator(String operatorLabel);

}
