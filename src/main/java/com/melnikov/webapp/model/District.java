package com.melnikov.webapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "DISTRICT", schema = "webapp")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "quietness", nullable = false)
    private Double quietness;

    @Column(name = "education", nullable = false)
    private Double education;

    @Column(name = "health", nullable = false)
    private Double health;

    @Column(name = "transport", nullable = false)
    private Double transport;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "livability", nullable = false)
    private Double livability;

    @Column(name = "density", nullable = false)
    private Double density;

    @Column(name = "novelty", nullable = false)
    private Double novelty;

    @Column(name = "security", nullable = false)
    private Double security;

    @Column(name = "remoteness", nullable = false)
    private Double remoteness;

    // Constructors
    public District() {}

    public District(String name, Double quietness, Double education, Double health, Double transport, Double cost, Double livability, Double density, Double novelety, Double security, Double remoteness) {
        this.name = name;
        this.quietness = quietness;
        this.education = education;
        this.health = health;
        this.transport = transport;
        this.cost = cost;
        this.livability = livability;
        this.density = density;
        this.novelty = novelety;
        this.security = security;
        this.remoteness = remoteness;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuietness() {
        return quietness;
    }

    public void setQuietness(Double quietness) {
        this.quietness = quietness;
    }

    public Double getEducation() {
        return education;
    }

    public void setEducation(Double education) {
        this.education = education;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Double getTransport() {
        return transport;
    }

    public void setTransport(Double transport) {
        this.transport = transport;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getLivability() {
        return livability;
    }

    public void setLivability(Double livability) {
        this.livability = livability;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Double getNovelety() {
        return novelty;
    }

    public void setNovelety(Double novelety) {
        this.novelty = novelety;
    }

    public Double getSecurity() {
        return security;
    }

    public void setSecurity(Double security) {
        this.security = security;
    }

    public Double getRemoteness() {
        return remoteness;
    }

    public void setRemoteness(Double remoteness) {
        this.remoteness = remoteness;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quietness=" + quietness +
                ", education=" + education +
                ", health=" + health +
                ", transport=" + transport +
                ", cost=" + cost +
                ", livability=" + livability +
                ", density=" + density +
                ", novelty=" + novelty +
                ", security=" + security +
                ", remoteness=" + remoteness +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        District district = (District) o;

        if (!Objects.equals(id, district.id)) return false;
        if (!Objects.equals(name, district.name)) return false;
        if (!Objects.equals(quietness, district.quietness)) return false;
        if (!Objects.equals(education, district.education)) return false;
        if (!Objects.equals(health, district.health)) return false;
        if (!Objects.equals(transport, district.transport)) return false;
        if (!Objects.equals(cost, district.cost)) return false;
        if (!Objects.equals(livability, district.livability)) return false;
        if (!Objects.equals(density, district.density)) return false;
        if (!Objects.equals(novelty, district.novelty)) return false;
        if (!Objects.equals(security, district.security)) return false;
        return Objects.equals(remoteness, district.remoteness);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (quietness != null ? quietness.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (health != null ? health.hashCode() : 0);
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (livability != null ? livability.hashCode() : 0);
        result = 31 * result + (density != null ? density.hashCode() : 0);
        result = 31 * result + (novelty != null ? novelty.hashCode() : 0);
        result = 31 * result + (security != null ? security.hashCode() : 0);
        result = 31 * result + (remoteness != null ? remoteness.hashCode() : 0);
        return result;
    }
}
