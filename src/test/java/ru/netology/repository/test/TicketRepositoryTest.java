package ru.netology.repository.test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;
public class TicketRepositoryTest {
    Ticket ticket1 = new Ticket(1, 3456, "U6", "B6", 150);
    Ticket ticket2 = new Ticket(2, 1200, "B6", "SQ", 100);
    Ticket ticket3 = new Ticket(3, 2580, "V3", "BJ", 240);
    Ticket ticket4 = new Ticket(4, 1150, "SL", "RB", 300);
    Ticket ticket5 = new Ticket(5, 3100, "JU", "TA", 320);


    @Test
    public void methodAdd() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);


        Ticket[] actual = repo.findAll();
        Ticket[] expected = { ticket1, ticket2, ticket3, ticket4, ticket5 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdAndFindByEmptyRepository() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.removeById(1);


        Ticket[] actual = repo.findAll();
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }


}
