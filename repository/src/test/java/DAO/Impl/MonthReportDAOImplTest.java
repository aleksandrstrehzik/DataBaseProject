package DAO.Impl;

import DAO.Interfaces.MonthReportDAO;
import Entity.MonthReport;
import Enums.Months;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MonthReportDAOImplTest {

    private final MonthReportDAO monthReportDAO = new MonthReportDAOImpl();

    @Test
    public void findById() {
        MonthReport monthReport = MonthReport.builder()
                .month(Months.July)
                .build();
        monthReportDAO.save(monthReport);
        MonthReport actual = monthReportDAO.findById(monthReport.getId());
        assertNotNull(actual);
        assertEquals(actual.getMonth(), Months.July);
    }

    @Test
    public void deleteById() {
        MonthReport monthReport = MonthReport.builder()
                .month(Months.February)
                .build();
        monthReportDAO.save(monthReport);
        monthReportDAO.deleteById(monthReport.getId());
        MonthReport actual = monthReportDAO.findById(monthReport.getId());
        assertNull(actual);
    }

    @Test
    public void findAll() {
        MonthReport monthReport = MonthReport.builder()
                .month(Months.March)
                .build();
        monthReportDAO.save(monthReport);
        List<MonthReport> all = monthReportDAO.findAll();
        assertNotNull(all);
        MonthReport actual = all.stream()
                .filter(s -> s.getMonth().equals(Months.March))
                .findFirst()
                .orElse(null);
        assertEquals(actual.getMonth(), Months.March);
    }

    @Test
    public void save() {
        MonthReport monthReport = MonthReport.builder()
                .month(Months.April)
                .build();
        monthReportDAO.save(monthReport);
        MonthReport actual = monthReportDAO.findById(monthReport.getId());
        assertNotNull(actual);
        assertEquals(actual.getMonth(), Months.April);
    }

    @Test
    public void update() {
        MonthReport monthReport = MonthReport.builder()
                .month(Months.October)
                .build();
        monthReportDAO.save(monthReport);
        monthReport.setMonth(Months.November);
        monthReportDAO.update(monthReport);
        MonthReport actual = monthReportDAO.findById(monthReport.getId());
        assertNotNull(actual);
        assertEquals(actual.getMonth(), Months.November);
    }
}