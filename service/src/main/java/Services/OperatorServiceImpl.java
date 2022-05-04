package Services;

import DAO.Impl.ConsumerDAOImpl;
import DAO.Interfaces.ConsumerDAO;
import Entity.Consumer;
import Entity.MonthReport;
import Entity.Tariff;
import Interfaces.GeneralService;
import Interfaces.OperatorService;
import Utils.HibernateUtils;

import javax.persistence.EntityManager;

public class OperatorServiceImpl implements OperatorService {

    public static final int CONSUMPTION_RATE = 80;
    private final GeneralService gs = new GeneralServicesImpl();
    private final ConsumerDAO consumerDAO = new ConsumerDAOImpl();

    public void createConsumer(String name, String surname, String operatorLabel,
                               Double apartmentSquare, Integer numbersOfResidents) {
        consumerDAO.save(Consumer.builder()
                .name(name)
                .surname(surname)
                .operator(gs.getOperator(operatorLabel))
                .apartmentsquare(apartmentSquare)
                .numberOfResidents(numbersOfResidents)
                .build());
    }

    public void createMonthReport(String name, String surname) {
        EntityManager em = HibernateUtils.getEntityManager();
        Consumer consumer = em.createQuery("select c from Consumer c " +
                        "where c.name = :name and c.surname = :surname", Consumer.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .getSingleResult();
        Tariff tariff = consumer.getOperator().getTariff();
        Double ElPayment = tariff.getElectricityCost() * CONSUMPTION_RATE * consumer.getNumberOfResidents();
        em.close();
    }
}
