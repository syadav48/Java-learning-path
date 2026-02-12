package company.mockdata.model;

import company.mockdata.enums.ProjectStatus;

import java.time.LocalDate;

public class Project {
    private Long id;
    private String name;
    private ProjectStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    private Client client;

    public Project(Long id, String name, ProjectStatus status,
                   LocalDate startDate, LocalDate endDate,
                   double budget, Client client) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.client = client;
    }

    // getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getBudget() {
        return budget;
    }

    public Client getClient() {
        return client;
    }
}

