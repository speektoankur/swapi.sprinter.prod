package com.swapi.prod.swapi.sprinter.prod.Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Base Class for common test Functions
 */
public class TestBase {
    public RequestSpecification requestSpecifications;
    public RequestSpecBuilder requestSpecBuilder;

    public TestBase() {
    }
}
