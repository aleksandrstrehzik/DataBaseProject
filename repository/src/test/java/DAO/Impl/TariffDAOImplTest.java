package DAO.Impl;

import DAO.Interfaces.TariffDAO;
import Entity.Tariff;
import Enums.Months;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TariffDAOImplTest {

    private final TariffDAO tariffDAO = new TariffDAOImpl();

    @Test
    public void findById() {
        Tariff tariff = Tariff.builder()
                .month(Months.July)
                .build();
        tariffDAO.save(tariff);
        Tariff actual = tariffDAO.findById(tariff.getId());
        assertNotNull(actual);
        assertEquals(actual.getMonth(), Months.July);
    }

    @Test
    public void deleteById() {
        Tariff tariff = Tariff.builder()
                .month(Months.February)
                .build();
        tariffDAO.save(tariff);
        tariffDAO.deleteById(tariff.getId());
        Tariff actual = tariffDAO.findById(tariff.getId());
        assertNull(actual);
    }

    @Test
    public void findAll() {
        Tariff tariff = Tariff.builder()
                .month(Months.March)
                .build();
        tariffDAO.save(tariff);
        List<Tariff> all = tariffDAO.findAll();
        assertNotNull(all);
        Tariff actual = all.stream()
                .filter(s -> s.getMonth().equals(Months.March))
                .findFirst()
                .orElse(null);
        assertEquals(actual.getMonth(), Months.March);
    }

    @Test
    public void save() {
        Tariff tariff = Tariff.builder()
                .month(Months.April)
                .build();
        tariffDAO.save(tariff);
        Tariff actual = tariffDAO.findById(tariff.getId());
        assertNotNull(actual);
        assertEquals(actual.getMonth(), Months.April);
    }

    @Test
    public void update() {
        Tariff tariff = Tariff.builder()
                .month(Months.October)
                .build();
        tariffDAO.save(tariff);
        tariff.setMonth(Months.November);
        tariffDAO.update(tariff);
        Tariff actual = tariffDAO.findById(tariff.getId());
        assertNotNull(actual);
        assertEquals(actual.getMonth(), Months.November);
    }

}