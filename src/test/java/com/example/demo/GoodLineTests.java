package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class GoodLineTests {
    // @GetMapping("/pet/{petId}")
    @Test
    public void getTestStatus200() {
        RestAssured.given().baseUri("https://petstore.swagger.io/").basePath("/v2/pet/{petId}")
                .contentType(ContentType.JSON)
                .pathParam("petId", "1")
                .when().log().params().get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void getTestStatus404() {
        RestAssured.given().baseUri("https://petstore.swagger.io/").basePath("/v2/pet/{petId}")
                .contentType(ContentType.JSON)
                .pathParam("petId", "99999999")
                .when().log().params().get()
                .then().log().body()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    // @PostMapping("/user")
    @Test
    public void postTestStatus200() {
        CreationUserRequest createUserRequest = new CreationUserRequest(
                1, "Иван2000", "Иван", "Иванов", "ivan2000@gmail.com", "qwerty123", "88005553536", 1);

        RestAssured.given().baseUri("https://petstore.swagger.io/").basePath("/v2/user")
                .contentType(ContentType.JSON)
                .body(createUserRequest)
                .when().log().body().post()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    // @DeleteMapping("/user/{username}")
    @Test
    public void deleteTestStatus200() {
        RestAssured.given().baseUri("https://petstore.swagger.io/").basePath("/v2/user/{username}")
                .contentType(ContentType.JSON)
                .pathParam("username", "Иван2000")
                .when().log().params().delete()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deleteTestStatus404() {
        RestAssured.given().baseUri("https://petstore.swagger.io/").basePath("/v2/user/{username}")
                .contentType(ContentType.JSON)
                .pathParam("username", "ivan2001")
                .when().log().params().delete()
                .then().log().body()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    // @PostMapping("/user")
    @Test
    public void putTestStatus200() {
        CreationUserRequest createUserRequest = new CreationUserRequest(
                1, "Ivan2000Ivan", "Иван", "", "ivan2000@gmail.com", "qwerty123", "88005553536", 1);

        RestAssured.given().baseUri("https://petstore.swagger.io/").basePath("/v2/user/{username}")
                .contentType(ContentType.JSON)
                .pathParam("username", "Иван2000")
                .body(createUserRequest)
                .when().log().params().log().body().put()
                .then().log().body()
                .statusCode(HttpStatus.OK.value());
    }
}
