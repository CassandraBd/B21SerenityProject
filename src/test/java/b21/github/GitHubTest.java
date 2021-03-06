package b21.github;

import com.sun.javafx.sg.prism.NGImageView;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class GitHubTest {

    // SEND GET https://api.github.com/users/CybertekSchool request

    @BeforeAll
    public  static void init(){
        RestAssured.baseURI = "https://api.github.com/";

    }
    @Test
    public void testGitHubUser(){
        given()
                .pathParam("user_id", "CybertekSchool")
                .log().all().
        when()
                .get("/users/{user_id}").
        then()
                .log().all()
                .statusCode(200);

    }

    @AfterAll
    public static void cleanup(){
        RestAssured.reset();
    }
}
