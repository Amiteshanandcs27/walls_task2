package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PortfolioSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioSecurityId;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double purchasePrice;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    public PortfolioSecurity(Portfolio portfolio, Security security,
                             int quantity, double purchasePrice, Date purchaseDate) {
        this.portfolio = portfolio;
        this.security = security;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
    }

    protected PortfolioSecurity() {}

    public long getPortfolioSecurityId() { return portfolioSecurityId; }

    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }

    public Security getSecurity() { return security; }
    public void setSecurity(Security security) { this.security = security; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(double purchasePrice) { this.purchasePrice = purchasePrice; }

    public Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }
}
