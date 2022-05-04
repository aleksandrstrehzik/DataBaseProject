package DAO.Impl;

import DAO.Interfaces.AdminDAO;
import Entity.Admin;

public class AdminDAOImpl extends BaseDAO<Admin> implements AdminDAO {

    public AdminDAOImpl() {
        super(Admin.class);
    }
}
