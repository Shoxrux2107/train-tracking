package com.asuss.poyezd_hrakati.poyezd_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Train_dto {

    private Integer id;
    private Integer number;
    private String index;
    private String activity;
    private Integer numberOfLine;
    private LocalDateTime localDateTime;




}
