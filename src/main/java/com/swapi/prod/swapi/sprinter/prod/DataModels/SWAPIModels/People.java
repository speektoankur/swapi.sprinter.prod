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
public class People {
    public String name;
    public String height;
    public String mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public ArrayList<String> films;
    public ArrayList<Object> species;
    public ArrayList<Object> vehicles;
    public ArrayList<Object> starships;
    public Date created;
    public Date edited;
    public String url;
}
