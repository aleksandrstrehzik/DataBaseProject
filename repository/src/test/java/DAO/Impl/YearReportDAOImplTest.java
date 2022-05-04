package DAO.Impl;

import DAO.Interfaces.YearReportDAO;
import Entity.YearReport;
import org.junit.Test;

import java.util.List;

import static DAO.Impl.MockConstants.*;
import static org.junit.Assert.*;

public class YearReportDAOImplTest {


    private final YearReportDAO yearReportDAO = new YearReportDAOImpl();

    @Test
    public void findById() {
        YearReport yearReport = YearReport.builder()
                .year(YEAR)
                .build();
        yearReportDAO.save(yearReport);
        YearReport actual = yearReportDAO.findById(yearReport.getId());
        assertNotNull(actual);
        assertEquals(actual.getYear(), YEAR);
    }

    @Test
    public void deleteById() {
        YearReport yearReport = YearReport.builder()
                .year(YEAR1)
                .build();
        yearReportDAO.save(yearReport);
        yearReportDAO.deleteById(yearReport.getId());
        YearReport actual = yearReportDAO.findById(yearReport.getId());
        assertNull(actual);
    }

    @Test
    public void findAll() {
        YearReport yearReport = YearReport.builder()
                .year(YEAR2)
                .build();
        yearReportDAO.save(yearReport);
        List<YearReport> all = yearReportDAO.findAll();
        assertNotNull(all);
        YearReport actual = all.stream()
                .filter(s -> s.getYear().equals(YEAR2))
                .findFirst()
                .orElse(null);
        assertEquals(actual.getYear(), YEAR2);
    }

    @Test
    public void save() {
        YearReport yearReport = YearReport.builder()
                .year(YEAR3)
                .build();
        yearReportDAO.save(yearReport);
        YearReport actual = yearReportDAO.findById(yearReport.getId());
        assertNotNull(actual);
        assertEquals(actual.getYear(), YEAR3);
    }

    @Test
    public void update() {
        YearReport yearReport = YearReport.builder()
                .year(YEAR4)
                .build();
        yearReportDAO.save(yearReport);
        yearReport.setYear(YEAR1);
        yearReportDAO.update(yearReport);
        YearReport actual = yearReportDAO.findById(yearReport.getId());
        assertNotNull(actual);
        assertEquals(actual.getYear(), YEAR1);
    }

}