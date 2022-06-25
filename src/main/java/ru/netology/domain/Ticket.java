package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Comparable<Ticket>{
    private int id;
    private int cost;
    private String from;
    private String to;
    private int time;



    @Override
    public int compareTo(Ticket otherTicket) {
        if (cost < otherTicket.cost) {
            return -1;
        }
        if (cost > otherTicket.cost) {
            return +1;
        }
        return 0;
    }
}
