package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetLostPets implements BaseApi {
    public static void main(String[] args) {
        System.out.println(GetLostPets().getStatusCode());

    }

    public static Response GetLostPets() {
        String xToken = "";
        Response responseLogin = LoginApi.login();
        if (responseLogin.getStatusCode() == 200) {
            xToken = LoginApi.login().getHeader("X-Token");
            return given()
                    .contentType(ContentType.JSON)
                    .header("X-Token", xToken)
                    .when()
                    .get(HOST + "/lostfound/en/v1/losts?currentPage=0");
        } else {
            System.out.println("Bad login -->" + responseLogin.getStatusCode());
            return null;
        }

    }
}
