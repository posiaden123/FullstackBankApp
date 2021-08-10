package org.posiaden.bank.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@ToString
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "card_number")
    private Long number;

    public Card(Long number) {
        this.number = number;
    }

    public Card() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
