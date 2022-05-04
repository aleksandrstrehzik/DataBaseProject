package DAO.Impl;

import DAO.Interfaces.OperatorDAO;
import Entity.Operator;
import org.junit.Test;

import java.util.List;

import static DAO.Impl.MockConstants.*;
import static org.junit.Assert.*;

public class OperatorDAOImplTest {

    private final OperatorDAO operatorDAO = new OperatorDAOImpl();

    public void findById() {
        Operator operator = Operator.builder()
                .label(MINSK_ENERGO)
                .build();
        operatorDAO.save(operator);
        Operator actual = operatorDAO.findById(operator.getId());
        assertNotNull(actual);
        assertEquals(actual.getLabel(), MINSK_ENERGO);
    }

    @Test
    public void deleteById() {
        Operator operator = Operator.builder()
                .label(BREST_ENERGO)
                .build();
        operatorDAO.save(operator);
        operatorDAO.deleteById(operator.getId());
        Operator actual = operatorDAO.findById(operator.getId());
        assertNull(actual);
    }

    @Test
    public void findAll() {
        Operator operator = Operator.builder()
                .label(VITEBSK_ENERGO)
                .build();
        operatorDAO.save(operator);
        List<Operator> all = operatorDAO.findAll();
        assertNotNull(all);
        Operator actual = all.stream()
                .filter(s -> s.getLabel().equals(VITEBSK_ENERGO))
                .findFirst()
                .orElse(null);
        assertEquals(actual.getLabel(), VITEBSK_ENERGO);
    }

    @Test
    public void save() {
        Operator operator = Operator.builder()
                .label(GOMEL_ENERGO)
                .build();
        operatorDAO.save(operator);
        Operator actual = operatorDAO.findById(operator.getId());
        assertNotNull(actual);
        assertEquals(actual.getLabel(), GOMEL_ENERGO);
    }

    @Test
    public void update() {
        Operator operator = Operator.builder()
                .label(GRODNO_ENERGO)
                .build();
        operatorDAO.save(operator);
        operator.setLabel(DJ);
        operatorDAO.update(operator);
        Operator actual = operatorDAO.findById(operator.getId());
        assertNotNull(actual);
        assertEquals(actual.getLabel(), DJ);
    }

}