package DAO.Impl;

import DAO.Interfaces.TariffDAO;
import Entity.Tariff;

public class TariffDAOImpl extends BaseDAO<Tariff> implements TariffDAO {

    public TariffDAOImpl() {
        super(Tariff.class);
    }
}
