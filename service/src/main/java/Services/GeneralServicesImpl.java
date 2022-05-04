package Services;

import DAO.Impl.AdminDAOImpl;
import DAO.Interfaces.AdminDAO;
import Entity.Admin;
import Entity.Operator;
import Entity.Tariff;
import Enums.Months;
import Interfaces.GeneralService;
import Utils.HibernateUtils;

import javax.persistence.EntityManager;

public class GeneralServicesImpl implements GeneralService {

    @Override
    public void createAdmin(String adminLabel) {
        final AdminDAO adminDAO = new AdminDAOImpl();
        adminDAO.save(Admin.builder()
                .label(adminLabel)
                .build());
    }

    @Override
    public Admin getAdmin(String adminLabel) {
        EntityManager em = HibernateUtils.getEntityManager();
        return em.createQuery("select a from Admin a " +
                        "where a.label = :adminLabel", Admin.class)
                .setParameter("adminLabel", adminLabel)
                .getSingleResult();
    }

    @Override
    public Tariff getTariff(Months month, Integer year) {
        EntityManager em = HibernateUtils.getEntityManager();
        return em.createQuery("select t from Tariff t where " +
                        "t.month = :month and t.year = :year", Tariff.class)
                .setParameter("month", month)
                .setParameter("year", year)
                .getSingleResult();

    }

    @Override
    public Operator getOperator(String operatorLabel) {
        EntityManager em = HibernateUtils.getEntityManager();
        return em.createQuery("select o from Operator o " +
                        "where o.label = :operatorLabel", Operator.class)
                .setParameter("operatorLabel", operatorLabel)
                .getSingleResult();
    }


}
