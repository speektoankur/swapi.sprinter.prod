package com.swapi.prod.swapi.sprinter.prod.DataModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class InformationResponse {
    private InformationStarship starship;
    private String crew;
    private boolean isLeiaOnPlanet;
}

