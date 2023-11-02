package base;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.telerikacademy.api.tests.Constants.password;
import static com.telerikacademy.api.tests.Constants.user_email;

public class BaseTestSetup {


    public  static  String projectId;
    public static RequestSpecification getApplicationJSONSpecification() {
        return RestAssured.given().auth().preemptive().basic(user_email, password)
                          .contentType("application/json").when();
    }
    @BeforeMethod
    public void setup() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
    }
}
