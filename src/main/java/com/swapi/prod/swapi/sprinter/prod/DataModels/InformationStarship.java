package com.swapi.prod.swapi.sprinter.prod.DataModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class InformationStarship {
    private String name;
    private String starshipClass;
    private String model;
}
