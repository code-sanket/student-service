package com.sanket.student_service.service;

import com.sanket.student_service.dto.Marks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class StudentService {

    private RestTemplate restTemplate = new RestTemplate();

    public Long getStudentAverage(String id) throws URISyntaxException {
        ResponseEntity<Marks> marks = null;
        try {
              marks= restTemplate.getForEntity("http://localhost:8061/home/marks/getMarks/{id}" , Marks.class ,id);
        }catch (HttpClientErrorException exception){
            exception.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        Marks marks1 = marks.getBody();
        Long averageMarks = getAvg(marks1);
        return averageMarks;
    }

    private Long getAvg(Marks marks1) {
        Long sum = marks1.getSub1() + marks1.getSub2() + marks1.getSub3() + marks1.getSub4();
        return sum/4;
    }
}
