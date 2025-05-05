package com.example.reminder.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evento", uniqueConstraints = @UniqueConstraint(columnNames = {"category_id", "event_title"}))
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categoria categoria;

    @Column(name = "event_title", length = 50, nullable = false)
    private String eventTitle;

    @Column(name = "event_desc", length = 300)
    private String eventDesc;

    @Column(name = "event_in")
    private LocalDateTime eventIn;

    @Column(name = "event_out")
    private LocalDateTime eventOut;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getEventIn() {
        return eventIn;
    }

    public void setEventIn(LocalDateTime eventIn) {
        this.eventIn = eventIn;
    }

    public LocalDateTime getEventOut() {
        return eventOut;
    }

    public void setEventOut(LocalDateTime eventOut) {
        this.eventOut = eventOut;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
}
