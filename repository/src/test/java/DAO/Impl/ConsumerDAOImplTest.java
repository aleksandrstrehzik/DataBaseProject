package DAO.Impl;

import DAO.Interfaces.ConsumerDAO;
import Entity.Consumer;
import org.junit.Test;

import java.util.List;

import static DAO.Impl.MockConstants.*;
import static org.junit.Assert.*;

public class ConsumerDAOImplTest {

    private final ConsumerDAO consumerDAO = new ConsumerDAOImpl();

    @Test
    public void findById() {
        Consumer consumer = Consumer.builder()
                .name(NIKITA)
                .build();
        consumerDAO.save(consumer);
        Consumer actual = consumerDAO.findById(consumer.getId());
        assertNotNull(actual);
        assertEquals(actual.getName(),NIKITA);
    }

    @Test
    public void deleteById() {
        Consumer consumer = Consumer.builder()
                .name(IVAN)
                .build();
        consumerDAO.save(consumer);
        consumerDAO.deleteById(consumer.getId());
        Consumer actual = consumerDAO.findById(consumer.getId());
        assertNull(actual);
    }

    @Test
    public void findAll() {
        Consumer consumer = Consumer.builder()
                .name(ANREY)
                .build();
        consumerDAO.save(consumer);
        List<Consumer> all = consumerDAO.findAll();
        assertNotNull(all);
        Consumer actual = all.stream()
                .filter(s -> s.getName().equals(ANREY))
                .findFirst()
                .orElse(null);
        assertEquals(actual.getName(), ANREY);
    }

    @Test
    public void save() {
        Consumer consumer = Consumer.builder()
                .name(DMITRIY)
                .build();
        consumerDAO.save(consumer);
        Consumer actual = consumerDAO.findById(consumer.getId());
        assertNotNull(actual);
        assertEquals(actual.getName(),DMITRIY);
    }

    @Test
    public void update() {
        Consumer consumer = Consumer.builder()
                .name(SERGEY)
                .build();
        consumerDAO.save(consumer);
        consumer.setName(IVAN);
        consumerDAO.update(consumer);
        Consumer actual = consumerDAO.findById(consumer.getId());
        assertNotNull(actual);
        assertEquals(actual.getName(), IVAN);
    }

}