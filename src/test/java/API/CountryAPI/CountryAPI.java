package API.CountryAPI;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CountryAPI {
    Cookies cookies;

    @BeforeClass
    void login() {
        baseURI = "https://test.mersys.io/school-service/api/countries";

        Map<String, String> credentials = new HashedMap<>();
        credentials.put("username", "turkeyts");
        credentials.put("password", "TechnoStudy123");
        credentials.put("rememberMe", "true");

        cookies = given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("https://test.mersys.io/auth/login")
                .then()
                .log().body()
                .extract().response().getDetailedCookies();
    }

    public String randomCountryName() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public String randomCountryCode() {
        return RandomStringUtils.randomAlphabetic(3);
    }


    Country countryRequest;
    Country countryResponse;

    @Test
    void createCountry() {
        countryRequest = new Country();
        countryRequest.setName(randomCountryName());
        countryRequest.setCode(randomCountryCode());
        countryRequest.setHasState(false);

        countryResponse = given()
                .body(countryRequest)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post("")
                .then()
                .statusCode(201)
                .log().body()
                .extract().jsonPath().getObject("", Country.class);
    }

    @Test(dependsOnMethods = "createCountry", priority = 1)
    void createCountryNegativeTest() {

        given()
                .body(countryRequest)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post("")
                .then()
                .statusCode(400);
    }

    @Test(dependsOnMethods = "createCountry", priority = 2)
    void updateCountry() {
        countryResponse.setName(randomCountryName());

        given()
                .body(countryResponse)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .put("")
                .then()
                .statusCode(200)
                .body("name", equalTo(countryResponse.getName()));
    }

    @Test(dependsOnMethods = "createCountry", priority = 3)
    void deleteCountry() {
        given()
                .pathParam("countryId", countryResponse.getId())
                .cookies(cookies)
                .when()
                .delete("/{countryId}")
                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = {"createCountry", "deleteCountry"}, priority = 4)
    void deleteCountryNegativeTest() {
        given()
                .pathParam("countryId", countryResponse.getId())
                .cookies(cookies)
                .when()
                .delete("/{countryId}")
                .then()
                .statusCode(400);
    }


}
