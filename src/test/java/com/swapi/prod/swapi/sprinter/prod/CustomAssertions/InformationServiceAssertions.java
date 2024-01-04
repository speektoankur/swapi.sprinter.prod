package com.swapi.prod.swapi.sprinter.prod.CustomAssertions;

import com.swapi.prod.swapi.sprinter.prod.DataModels.ErrorResponse;
import com.swapi.prod.swapi.sprinter.prod.DataModels.InformationResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class InformationServiceAssertions {
    /**
     * Valid Response Assertion
     * @param informationResponse
     */
    public void AssertValidInformationServiceResponse(InformationResponse informationResponse){
        Assert.assertEquals(informationResponse.getStarship().getName(), "TIE Advanced x1");
        Assert.assertEquals(informationResponse.getStarship().getStarshipClass(), "Starfighter");
        Assert.assertEquals(informationResponse.getStarship().getModel(), "Twin Ion Engine Advanced x1");
        Assert.assertEquals(informationResponse.getCrew(), "1");
        Assert.assertTrue(informationResponse.isLeiaOnPlanet());
    }

    /**
     * Invalid Query Param response body validations - Internal Server Error
     * @param errorResponse
     */
    public void AssertInvalidQueryParamResponse(ErrorResponse errorResponse){
        Assert.assertNotNull(errorResponse.getTimestamp());
        Assert.assertEquals(errorResponse.getStatus(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
        Assert.assertEquals(errorResponse.getError(), "Internal Server Error");
        Assert.assertEquals(errorResponse.getPath(), "/information");
    }

    /**
     * Invalid Request missing Query Params validations - Bad Request
     * @param errorResponse
     */
    public void AssertBadRequestResponse(ErrorResponse errorResponse){
        Assert.assertNotNull(errorResponse.getTimestamp());
        Assert.assertEquals(errorResponse.getStatus(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(errorResponse.getError(), "Bad Request");
        Assert.assertEquals(errorResponse.getPath(), "/information");
    }


}
