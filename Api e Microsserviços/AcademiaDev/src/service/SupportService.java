package src.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

import src.model.SupportTicket;
import src.model.User;
import src.model.enums.TicketStatus;

public class SupportService {

    private Queue<SupportTicket> ticketsQueue = new LinkedList<>();
        
        public SupportTicket  AtenderTicketsdeSuporte(boolean resolver) {
            SupportTicket ticket = ticketsQueue.poll(); 
            if (ticket == null) {
                System.out.println("Nenhum ticket na fila.");
                return null;
            }

            if (resolver) {
                ticket.setTicketStatus(TicketStatus.RESOLVIDO);
                System.out.println("Ticket resolvido: " + ticket.getTitle());
            } else {
                ticket.setTicketStatus(TicketStatus.EM_ATENDIMENTO);
                System.out.println("Ticket em atendimento: " + ticket.getTitle());
            }

            return ticket;
        }

        public void AbrirTicketdeSuporte(String title, String message, User user) {
            SupportTicket createTicket = new SupportTicket(title, message, user, LocalDateTime.now());
            ticketsQueue.add(createTicket);
            System.out.println("Ticket criado com sucesso");
        }

        public SupportTicket verProximoTicket() {
            return ticketsQueue.peek();
        }
}
