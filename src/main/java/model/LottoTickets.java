package model;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets = new ArrayList<>();

    public void add(Lotto lotto) {
        tickets.add(lotto);
    }
    public int size() {
        return tickets.size();
    }
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Lotto ticket : tickets) output.append(ticket).append("\n");
        return output.toString();
    }

    public List<Lotto> getLottos() {
        return tickets;
    }
}

