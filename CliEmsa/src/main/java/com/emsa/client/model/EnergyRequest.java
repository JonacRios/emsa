package com.emsa.client.model;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;


@Entity
@Table(name = "ENERGY_REQUEST")
@Data
public class EnergyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codRequest")
    private Long codRequest;

    @Column(name = "processId")
    private String processId;

    @Column(name = "barrio")
    private String barrio;

    @Column(name = "status")
    private String status;

    @Column(name = "tipo")
    private String tipo;
    @Column(name = "estrato")
    private String estrato;
    @Column(name = "servicio")
    private String servicio;
    @Column(name = "medidor")
    private String medidor;
    @Column(name = "requestDate")
    private LocalDateTime requestDate;

    @Column(name = "countReviewCR")
    private Long countReviewCR;

    @OneToOne
    @JoinColumn(name = "FK_PERSON", referencedColumnName = "id")
    private Person applicant;
}