package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIController {
    private static String url = "https://api.thecatapi.com/v1/images/search";

    public static Response getImageResponse() {
        return RestAssured.given()
                .header("Accept", "application/json")
                .get(url);
    }

    public static CatAPIResponse parseImageResponse(Response imageResponse) {
        return imageResponse.as(CatAPIResponse[].class)[0];
    }
}
