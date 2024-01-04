package com.swapi.prod.swapi.sprinter.prod.Services;

import com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels.Starship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import static io.restassured.RestAssured.given;
@Service
@Slf4j
public class StarshipsUtil {
    /**
     * Paginated search on /starship path
     * @return Starship object
     */
    public Starship getStarship(String starshipURI){
        Starship ship;
        ship = given()
                .baseUri(starshipURI)
                .and()
                .get()
                .then().extract().response().as(Starship.class);
        return ship;
    }


}
