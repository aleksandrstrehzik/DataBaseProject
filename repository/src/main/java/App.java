import Entity.Admin;
import Entity.Consumer;
import Entity.Operator;
import Utils.HibernateUtils;

import javax.persistence.EntityManager;

public class App {

    public static void main(String[] args) {
        Consumer consumer = Consumer.builder()
                .name("Andrei")
                .surname("Strezhik")
                .build();
        Admin minskEnergo = Admin.builder()
                .label("MinskEnergo")
                .build();
        Operator minskPowerStation = Operator.builder()
                .label("MinskPowerStation")
                .build();
        EntityManager em = HibernateUtils.getEntityManager();

        em.getTransaction().begin();
        em.persist(minskPowerStation);
        em.persist(minskEnergo);
        em.persist(consumer);
        em.getTransaction().commit();
        em.getTransaction().begin();
        Admin admin = em.find(Admin.class, 1);
        Operator operator = em.find(Operator.class, 1);
        Consumer consumer1 = em.find(Consumer.class, 1);
        operator.setAdmin(admin);
        admin.getOperators().add(operator);
        operator.getConsumers().add(consumer1);
        consumer1.setOperator(operator);
        em.getTransaction().commit();
        em.close();
    }
}
