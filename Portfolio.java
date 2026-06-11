package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<PortfolioSecurity> portfolioSecurities;

    public Portfolio(Client client, String name, Date creationDate) {
        this.client = client;
        this.name = name;
        this.creationDate = creationDate;
    }

    protected Portfolio() {}

    public long getPortfolioId() { return portfolioId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public List<PortfolioSecurity> getPortfolioSecurities() { return portfolioSecurities; }
    public void setPortfolioSecurities(List<PortfolioSecurity> portfolioSecurities) {
        this.portfolioSecurities = portfolioSecurities;
    }
}
