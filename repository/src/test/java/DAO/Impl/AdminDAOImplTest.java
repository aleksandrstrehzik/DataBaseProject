package DAO.Impl;

import DAO.Interfaces.AdminDAO;
import Entity.Admin;
import org.junit.Test;

import java.util.List;

import static DAO.Impl.MockConstants.*;
import static org.junit.Assert.*;

public class AdminDAOImplTest {

    private final AdminDAO adminDAO = new AdminDAOImpl();

    @Test
    public void findById() {
        Admin minskEnergo = Admin.builder()
                .label(MINSK_ENERGO)
                .build();
        adminDAO.save(minskEnergo);
        Admin actual = adminDAO.findById(minskEnergo.getId());
        assertNotNull(actual);
        assertEquals(actual.getLabel(), MINSK_ENERGO);
    }

    @Test
    public void deleteById() {
        Admin brestEnergo = Admin.builder()
                .label(BREST_ENERGO)
                .build();
        adminDAO.save(brestEnergo);
        adminDAO.deleteById(brestEnergo.getId());
        Admin actual = adminDAO.findById(brestEnergo.getId());
        assertNull(actual);
    }

    @Test
    public void findAll() {
        Admin vitebskEnergo = Admin.builder()
                .label(VITEBSK_ENERGO)
                .build();
        adminDAO.save(vitebskEnergo);
        List<Admin> all = adminDAO.findAll();
        assertNotNull(all);
        Admin actual = all.stream()
                .filter(s -> s.getLabel().equals(VITEBSK_ENERGO))
                .findFirst()
                .orElse(null);
        assertEquals(actual.getLabel(), VITEBSK_ENERGO);
    }

    @Test
    public void save() {
        Admin GomelEnergo = Admin.builder()
                .label(GOMEL_ENERGO)
                .build();
        adminDAO.save(GomelEnergo);
        Admin actual = adminDAO.findById(GomelEnergo.getId());
        assertNotNull(actual);
        assertEquals(actual.getLabel(), GOMEL_ENERGO);
    }

    @Test
    public void update() {
        Admin GrodnoEnergo = Admin.builder()
                .label(GRODNO_ENERGO)
                .build();
        adminDAO.save(GrodnoEnergo);
        GrodnoEnergo.setLabel(DJ);
        adminDAO.update(GrodnoEnergo);
        Admin actual = adminDAO.findById(GrodnoEnergo.getId());
        assertNotNull(actual);
        assertEquals(actual.getLabel(), DJ);
    }
}