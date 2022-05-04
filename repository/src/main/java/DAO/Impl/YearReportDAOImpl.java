package DAO.Impl;

import DAO.Interfaces.YearReportDAO;
import Entity.YearReport;

public class YearReportDAOImpl extends BaseDAO<YearReport> implements YearReportDAO {

    public YearReportDAOImpl() {
        super(YearReport.class);
    }
}
