package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String ticker;

    @Column(nullable = false)
    private String category;   // e.g. Stock, Bond, ETF

    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL)
    private List<PortfolioSecurity> portfolioSecurities;

    public Security(String name, String ticker, String category) {
        this.name = name;
        this.ticker = ticker;
        this.category = category;
    }

    protected Security() {}

    public long getSecurityId() { return securityId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public List<PortfolioSecurity> getPortfolioSecurities() { return portfolioSecurities; }
    public void setPortfolioSecurities(List<PortfolioSecurity> portfolioSecurities) {
        this.portfolioSecurities = portfolioSecurities;
    }
}
