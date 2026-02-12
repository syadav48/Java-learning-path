package company.mockdata.model;

public class Department {
    private Long id;
    private String name;
    private String location;
    private double budget;

    public Department(Long id, String name, String location, double budget) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.budget = budget;
    }

    // getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getBudget() {
        return budget;
    }
}

