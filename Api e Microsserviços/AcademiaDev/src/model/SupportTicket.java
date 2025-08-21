package src.model;

import java.time.LocalDateTime;

import src.model.enums.CourseStatus;
import src.model.enums.TicketStatus;

public class SupportTicket {
        private String title;
        private String message;
        private User user;
        private LocalDateTime createdAt;
        private TicketStatus ticketStatus;

        public SupportTicket(String title, String message, User user, LocalDateTime createdAt){
            this.title = title;
            this.message = message;
            this.user = user;
            this.ticketStatus = TicketStatus.ABERTO;
            this.createdAt = createdAt;
        }

        public TicketStatus getTicketStatus() {
            return ticketStatus;
        }
        public void setTicketStatus(TicketStatus status) {
            this.ticketStatus = status;
        }
        public String getTitle() {
            return title;
            
        }

        @Override
	    public String toString() {
	        return "\n Estatus: "+ ticketStatus+"\n Data de Envio: " + createdAt + "\n Usuario: "+ user +"\n Título: " + title + "\n Texto: \n" + message;
	    }

        
        
    }
