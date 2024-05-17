package com.emsa.client.dto;

import com.emsa.client.model.Person;
import lombok.Data;


import java.time.LocalDateTime;


@Data
public class EnergyInfoDTO {
    private Long codRequest;
    private Person person;
    private String applicantPersonId;
    private String processId;
    private String barrio;
    private String medidor;
    private String tipo;
    private String estrato;
    private String servicio;
    private String status;
    private LocalDateTime requestDate;
    private TaskInfo taskInfo;
    private Long countReviewCR;

}