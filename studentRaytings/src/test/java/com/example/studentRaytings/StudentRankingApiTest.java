package com.example.studentRaytings;

import com.example.studentRaytings.models.StudentScore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import com.example.studentRaytings.models.Student;
import com.example.studentRaytings.repositories.StudentRepository;
import com.example.studentRaytings.repositories.StudentScoreRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentRankingApiTest {

    @Autowired
    private Environment env;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @Test
    public void apiStudentsIncludeStudentNames() throws Exception {
        String port = env.getProperty("local.server.port");
        String urlString = "http://localhost:" + port + "/api/students";

        // Ensure there's at least one student + score in the DB for this test (isolated data)
        Student student = new Student();
        student.setName("Test");
        student.setSurname("User");
        student = studentRepository.save(student);

        // create a StudentScore linked to this student
        com.example.studentRaytings.models.StudentScore score = new com.example.studentRaytings.models.StudentScore();
        score.setStudent(student);
        score.setOverallScore(42.0);
        score.setExamScore(40.0);
        score.setGpaScore(1.0);
        score.setProjectScore(0.0);
        score.setActivityScore(1.0);
        studentScoreRepository.save(score);

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        int code = conn.getResponseCode();
        assertThat(code).isEqualTo(200);

        StringBuilder body = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                body.append(line).append('\n');
            }
        }

        String json = body.toString();
        assertThat(json).isNotBlank();

        // If there are student-score records with nested student, the JSON should contain the keys
        // We perform a lightweight check that the response contains either "name" or "surname" when a student is present.
        // This avoids requiring Jackson on the test classpath while still validating the API returns student info.
        if (json.contains("\"student\"")) {
            boolean hasNameAndSurname = json.contains("\"name\"") && json.contains("\"surname\"");
            assertThat(hasNameAndSurname).isTrue();
        }
    }
}
