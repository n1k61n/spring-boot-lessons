package com.example.studentRaytings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentProfileUiInvalidIdTest {

    @Autowired
    private Environment env;

    @Test
    public void getProfileWithUndefinedIdShowsUiError() throws Exception {
        String port = env.getProperty("local.server.port");
        String urlString = "http://localhost:" + port + "/student-profile.html?id=undefined";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "text/html");

        int code = conn.getResponseCode();
        assertThat(code).isEqualTo(200);

        StringBuilder body = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                body.append(line).append('\n');
            }
        }

        String html = body.toString();
        // The Thymeleaf template contains server-side fallback content when student==null
        assertThat(html).contains("Telebə tapılmadı");
        assertThat(html).contains("Bu ID ilə tələbə mövcud deyil.");
    }
}
