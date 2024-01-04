package com.swapi.prod.swapi.sprinter.prod.Services;

import com.swapi.prod.swapi.sprinter.prod.DataModels.InformationResponse;
import com.swapi.prod.swapi.sprinter.prod.DataModels.InformationStarship;
import com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels.People;
import com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels.Planet;
import com.swapi.prod.swapi.sprinter.prod.DataModels.SWAPIModels.Starship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InformationService {
    @Autowired
    private PeopleUtil peopleUtil;
    @Autowired
    private StarshipsUtil starshipsUtil;
    @Autowired
    private PlanetsUtil planetsUtil;

    public int countCrewMembers(String getCrewValue){
        if(getCrewValue.contains(",")){
            String [] splitter = getCrewValue.split(",");
            return splitter.length;
        }
        return 1;
    }
    public InformationResponse getInformation(String attackingPersonName, String planetToVerifyQueenPresence){
        People people = peopleUtil.findPersonDetails(attackingPersonName);
        Starship starship = !people.getStarships().isEmpty() ? starshipsUtil.getStarship(people.getStarships().get(0).toString()):null;
        InformationStarship informationStarship = new InformationStarship(starship.getName(),starship.getStarship_class(),starship.getModel());
        Planet planet = planetsUtil.getPlanet(planetToVerifyQueenPresence);
        boolean isLieaOnPlanet = planetsUtil.verifyPersonOnPlanet(planet, "Leia Organa");
        return new InformationResponse(informationStarship, countCrewMembers(starship.getCrew()), isLieaOnPlanet);
    }
}
