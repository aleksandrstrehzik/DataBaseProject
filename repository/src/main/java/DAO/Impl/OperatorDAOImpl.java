package DAO.Impl;

import DAO.Interfaces.OperatorDAO;
import Entity.Operator;

public class OperatorDAOImpl extends BaseDAO<Operator> implements OperatorDAO {

    public OperatorDAOImpl() {
        super(Operator.class);
    }
}
