package laVamosNos;

import java.util.ArrayList;

public class Estacionamento {
    private int vagas;
    private ArrayList<Ticket> tickets;
    private int saldo;

    public Estacionamento(int vagas) {
        this.vagas = vagas;
        this.saldo = 0;
        this.tickets = new ArrayList<>();

    }

    public Ticket emitirTicket() {
        if (tickets.size() < vagas) {
            Ticket ticket = new Ticket();
            tickets.add(ticket);
            return ticket;
        } else {
            System.out.println("Não há vagas disponíveis");
            return null;
        }
    }

    public int pagarTickets(Ticket ticket) {
        if (ticket != null && !ticket.isPago()) {
            ticket.pagarTicket();
            saldo += ticket.getValor();
            System.out.println("Ticket pago com sucesso!");
            System.out.println("Valor do ticket: R$ " + ticket.getValor());
            System.out.println("Saldo atual: R$ " + saldo);
            return saldo;
        } else {
            System.out.println("Ticket já pago ou não existe");
            return 0;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public Ticket buscarTicket(int id) {

        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void Olhar(int ticket) {
        for (Ticket tick : tickets) {
            if (tick.getId() == ticket) {
                if (tick.isPago()) {
                    System.out.print("Ticket pago \n");
                } else {
                    System.out.print("Ticket pendente \n");
                }
                return;
            }
        }
        System.out.printf("Carro não presente  \n");
    }

    public void tirarCarro(int ticket) {
        for (Ticket ticke : tickets) {
            if (ticke.getId() == ticket) {
                tickets.remove(ticke);
                System.out.printf("Carro saiu do estacionamento \n");
            }
        }
    }
}
