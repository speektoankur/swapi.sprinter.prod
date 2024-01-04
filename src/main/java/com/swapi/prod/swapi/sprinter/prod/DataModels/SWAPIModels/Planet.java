package com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Planet {
    public String name;
    public String rotation_period;
    public String orbital_period;
    public String diameter;
    public String climate;
    public String gravity;
    public String terrain;
    public String surface_water;
    public String population;
    public ArrayList<String> residents;
    public ArrayList<String> films;
    public Date created;
    public Date edited;
    public String url;
}
