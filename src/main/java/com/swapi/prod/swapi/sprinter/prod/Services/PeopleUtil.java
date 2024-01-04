package com.swapi.prod.swapi.sprinter.prod.Services;

import com.swapi.prod.swapi.sprinter.prod.Constants.SwapiConstants;
import com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels.People;
import com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels.Peoples;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;
@Service
@Slf4j
public class PeopleUtil {
    /**
     * Paginated Search from /people path
     * @return People
     */
    public Peoples getPeoples(int page){
        Peoples peoples;
        peoples = given()
                .baseUri(SwapiConstants.base_URI)
                .and()
                .queryParam("page", page)
                .and()
                .get("/people/")
                .then().extract().response().as(Peoples.class);
        return peoples;
    }

    /**
     * Finding person from list of Results from /people
     * Assuming we don't have any Query Param for Person to search
     * @param name
     * @return People
     */
    public People findPeople(Peoples peoples, String name){
        for(People ppl: peoples.getResults()){
            if(ppl.getName().equalsIgnoreCase(name)){
                return ppl;
            }
        }
        return null;
    }
    /**
     * PageWise Search as an Input assuming there is no mechanism to Query from Star Wars API
     * @param name
     * @return People
     */
    public People findPersonDetails(String name){
        int page = 1;
        Peoples peoples = getPeoples(page);
        People people = findPeople(peoples, name);
        while(peoples.getNext()!=null && people==null){
            page++;
            peoples = getPeoples(page);
            people = findPeople(peoples, name);
        }
        return people;
    }

    /**
     * GET people object from URIs
     * @param URI
     * @return
     */
    public People getPeople(String URI){
        People people;
        people = given()
                .baseUri(URI)
                .and()
                .get()
                .then().extract().response().as(People.class);
        return people;
    }

}
