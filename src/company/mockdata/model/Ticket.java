package company.mockdata.model;

import company.mockdata.enums.TicketPriority;
import company.mockdata.enums.TicketStatus;

import java.time.LocalDate;

public class Ticket {
    private Long id;
    private TicketPriority priority;
    private TicketStatus status;
    private Employee assignedTo;
    private LocalDate createdDate;
    private LocalDate resolvedDate;

    public Ticket(Long id, TicketPriority priority, TicketStatus status,
                  Employee assignedTo,
                  LocalDate createdDate,
                  LocalDate resolvedDate) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.assignedTo = assignedTo;
        this.createdDate = createdDate;
        this.resolvedDate = resolvedDate;
    }

    public Long getId() {
        return id;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getResolvedDate() {
        return resolvedDate;
    }
// getters
}

