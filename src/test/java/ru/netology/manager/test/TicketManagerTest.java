package ru.netology.manager.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;
public class TicketManagerTest {
    Ticket ticket1 = new Ticket(1, 3456, "U6", "B6", 150);
    Ticket ticket2 = new Ticket(2, 1200, "B6", "SQ", 100);
    Ticket ticket3 = new Ticket(3, 2580, "V3", "BJ", 240);
    Ticket ticket4 = new Ticket(4, 1150, "SL", "RB", 300);
    Ticket ticket5 = new Ticket(5, 3100, "JU", "TA", 320);

    @Test
    public void findAllBySort () {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAllBySort("6", "B");
        Ticket[] expected = {ticket4, ticket2, ticket3, ticket1};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void findAllEmptyRepository () {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        repo.add(ticket1);
        manager.add(ticket4);
        repo.removeById(1);
        repo.removeById(4);

        Ticket[] actual = manager.findAllBySort("6", "B");
        Ticket[] expected = {};
        assertArrayEquals(expected,actual);
    }
}
