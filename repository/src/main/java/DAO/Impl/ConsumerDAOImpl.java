package DAO.Impl;

import DAO.Interfaces.ConsumerDAO;
import Entity.Consumer;

public class ConsumerDAOImpl extends BaseDAO<Consumer> implements ConsumerDAO {

    public ConsumerDAOImpl() {
        super(Consumer.class);
    }
}
