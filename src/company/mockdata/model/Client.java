package company.mockdata.model;

import company.mockdata.enums.ClientType;

public class Client {
    private Long id;
    private String name;
    private String country;
    private ClientType type;

    public Client(Long id, String name, String country, ClientType type) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public ClientType getType() {
        return type;
    }
// getters
}

