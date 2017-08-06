package my.company.tests.api;

import static io.restassured.RestAssured.given;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestApiTest {

    private static RequestSpecification spec;

    @BeforeClass
    public static void initSpec(){

        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://alluredemo.cloudhub.io/")
                .addFilter(new AllureRestAssured())
                .build();
    }

    @Test
    public void testGet() {
        given()
                .spec(spec)
                .body("Allure test")
                .when()
                .get()
                .then()
                .statusCode(200);
    }
}
