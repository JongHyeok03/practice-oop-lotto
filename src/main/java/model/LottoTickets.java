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
        for (Lotto lotto : tickets) {
            System.out.println(lotto);
        }
        return null;
    }

    public List<Lotto> getLottos() {
        return tickets;
    }
}

