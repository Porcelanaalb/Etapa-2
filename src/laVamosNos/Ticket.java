package laVamosNos;

public class Ticket {
    private static int ticketCounter = 0;
    private int Id;
    private int valor;
    private boolean pago;

    public Ticket() {
        this.Id = ++ticketCounter;
        this.valor = 10;
        this.pago = false;
    }

    public int getId() {
        return Id;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void pagarTicket() {
        this.pago = true;
    }
}

