package com.example.studentRaytings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentRestControllerInvalidIdTest {

    @Autowired
    private Environment env;

    @Test
    public void putWithInvalidIdReturnsBadRequest() throws Exception {
        String invalidId = "undefined";
        String port = env.getProperty("local.server.port");
        String urlString = "http://localhost:" + port + "/api/students/" + invalidId + "/exam-result";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String body = "{\"examScore\": 50}";
        try (OutputStream os = conn.getOutputStream()) {
            os.write(body.getBytes());
            os.flush();
        }

        int responseCode = conn.getResponseCode();
        assertThat(responseCode).isEqualTo(400);
    }
}
