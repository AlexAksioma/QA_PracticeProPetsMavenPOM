package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LoginApi implements BaseApi{
    public static void main(String[] args) {
        System.out.println(login().getStatusCode());
        System.out.println(login().getHeader("X-Token"));
    }
    public static Response login(){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Basic YWxleG1lZHF3ZXJ0eTFAZ21haWwuY29tOlF3ZXJ0eTEyMyE=")
                .when()
                .post(HOST+"/account/en/v1/login");
    }
}
