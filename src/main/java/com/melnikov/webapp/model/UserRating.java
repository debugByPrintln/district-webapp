package com.melnikov.webapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "USER_RATING", schema = "webapp")
public class UserRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

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
    public UserRating() {}

    public UserRating(Double quietness, Double education, Double health, Double transport, Double cost, Double livability, Double density, Double novelety, Double security, Double remoteness, User user, District district) {
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
        this.user = user;
        this.district = district;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "UserRating{" +
                "id=" + id +
                ", user=" + user +
                ", district=" + district +
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

        UserRating that = (UserRating) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(user, that.user)) return false;
        if (!Objects.equals(district, that.district)) return false;
        if (!Objects.equals(quietness, that.quietness)) return false;
        if (!Objects.equals(education, that.education)) return false;
        if (!Objects.equals(health, that.health)) return false;
        if (!Objects.equals(transport, that.transport)) return false;
        if (!Objects.equals(cost, that.cost)) return false;
        if (!Objects.equals(livability, that.livability)) return false;
        if (!Objects.equals(density, that.density)) return false;
        if (!Objects.equals(novelty, that.novelty)) return false;
        if (!Objects.equals(security, that.security)) return false;
        return Objects.equals(remoteness, that.remoteness);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
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
