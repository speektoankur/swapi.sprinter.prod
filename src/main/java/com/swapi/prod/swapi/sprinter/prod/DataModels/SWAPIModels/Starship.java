package com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Starship {
    public String name;
    public String model;
    public String manufacturer;
    public String cost_in_credits;
    public String length;
    public String max_atmosphering_speed;
    public String crew;
    public String passengers;
    public String cargo_capacity;
    public String consumables;
    public String hyperdrive_rating;
    @JsonProperty("MGLT")
    public String mGLT;
    public String starship_class;
    public ArrayList<String> pilots;
    public ArrayList<String> films;
    public Date created;
    public Date edited;
    public String url;
}
