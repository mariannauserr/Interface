package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repo) {
        this.repository = repo;
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public boolean matchesFromTo(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
            return true;
        }
        if (ticket.getTo().contains(to)) {
            return true;
        }
        else {
            return false;
        }
    }

    public Ticket[] findAllBySort(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesFromTo(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result [i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
