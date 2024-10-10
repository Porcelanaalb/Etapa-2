package laVamosNos;

import java.util.InputMismatchException;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vagas = 0;

        while (true) {
            try {
                System.out.print("Digite o número de vagas: \n ");
                vagas = scan.nextInt();
                scan.next();
                if (vagas <= 0) {
                    System.out.println("O número de vagas deve ser maior que zero.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scan.next();

            }
        }

        Estacionamento maquina = new Estacionamento(vagas);
        while (true) {
            try {
                System.out.printf("""
                        1- emitir ticket
                        2- pagar ticket
                        3- consultar saldo
                        4- olhar tickets
                        5- sair
                        Digite uma opção:
                        """);
                int opcao = scan.nextInt();
                scan.next();
                try {


                    switch (opcao) {
                        case 1:
                            Ticket ticket = maquina.emitirTicket();
                            if (ticket != null) {
                                System.out.println("Ticket emitido: " + ticket.getId());
                            }
                            break;
                        case 2:
                            System.out.print("Digite o ID do ticket: ");
                            int id = scan.nextInt();
                            scan.next();
                            Ticket ticketPagar = maquina.buscarTicket(id);
                            if (ticketPagar != null) {
                                maquina.pagarTickets(ticketPagar);

                            } else {
                                System.out.println("Ticket não encontrado");
                            }
                            if (ticketPagar.isPago() == true) {
                                maquina.tirarCarro(id);
                            }
                            break;

                        case 3:
                            System.out.println("Saldo: R$ " + maquina.consultarSaldo());
                            break;
                        case 4:
                            System.out.printf("Id do ticket a ser consultado: ");
                            id = scan.nextInt();
                            maquina.Olhar(id);

                            break;

                        case 5:
                            System.out.println("Saindo...");
                            System.exit(0);
                            scan.close();
                            break;
                        default:

                            System.out.println("Opção inválida");
                    }
                } catch (ConcurrentModificationException e) {
                    System.out.print(" \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scan.next();
            }
        }
    }
}