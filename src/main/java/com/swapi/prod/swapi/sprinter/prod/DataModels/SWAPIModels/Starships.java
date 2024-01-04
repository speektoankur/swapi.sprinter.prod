package com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Starships {
    public int count;
    public Object next;
    public Object previous;
    public ArrayList<Starship> results;
}