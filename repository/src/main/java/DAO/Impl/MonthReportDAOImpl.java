package DAO.Impl;

import DAO.Interfaces.MonthReportDAO;
import Entity.MonthReport;

public class MonthReportDAOImpl extends BaseDAO<MonthReport> implements MonthReportDAO {

    public MonthReportDAOImpl() {
        super(MonthReport.class);
    }
}
