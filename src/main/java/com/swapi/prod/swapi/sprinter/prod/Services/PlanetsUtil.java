package com.swapi.prod.swapi.sprinter.prod.Services;
import com.swapi.prod.swapi.sprinter.prod.Constants.SwapiConstants;
import com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels.Planet;
import com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels.Planets;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
@Slf4j
public class PlanetsUtil extends PeopleUtil{
    public Planets getPlanets(int page){
        Planets planets;
        Response response = given()
                .baseUri(SwapiConstants.base_URI)
                .and()
                .queryParam("page", page)
                .and()
                .get("planets/")
                .then().extract().response();
        System.out.println(response.getBody());
        return response.as(Planets.class);
    }

    public Planet findPlanet(Planets planets, String planetName){
        Planet planet;
        for(Planet plt: planets.getResults()){
            if(plt.getName().contentEquals(planetName)){
                return plt;
            }
        }
        return null;
    }

    public Planet getPlanet(String planetName){
        int page = 1;
        Planets planets = getPlanets(page);
        Planet planet = findPlanet(planets, planetName);
        while (planets.getNext()!=null && planet==null){
            page++;
            planets = getPlanets(page);
            planet = findPlanet(planets, planetName);
        }
        return planet;
    }

    public boolean verifyPersonOnPlanet(Planet planet, String name){
        for(String URI: planet.getResidents()){
            if(getPeople(URI).getName().contentEquals(name)){
                return true;
            }
        }
        return false;
    }

}
