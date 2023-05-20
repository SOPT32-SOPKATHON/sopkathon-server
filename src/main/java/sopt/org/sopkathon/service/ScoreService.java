package sopt.org.sopkathon.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import sopt.org.sopkathon.controller.score.dto.ScoreResponseDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
@RequiredArgsConstructor
public class ScoreService {
    public ScoreResponseDto getScore() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
        urlBuilder.append("/" + URLEncoder.encode("485577456d61636831303348776c6c58", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("MosquitoStatus", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("5", "UTF-8"));


        urlBuilder.append("/" + URLEncoder.encode("2023-05-20", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
        BufferedReader rd;


        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        JSONParser jsonParser = new JSONParser();
        JSONObject data = new JSONObject();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());

            JSONObject result = (JSONObject) jsonObject.get("MosquitoStatus");
            JSONArray row = (JSONArray) result.get("row");
            data = (JSONObject) row.get(0);


        } catch (ParseException e) {
        }
        return ScoreResponseDto.builder()
                .date("2023-05-20")
                .houseScore(Double.parseDouble(data.get("MOSQUITO_VALUE_HOUSE").toString()))
                .parkScore(Double.parseDouble(data.get("MOSQUITO_VALUE_PARK").toString()))
                .waterScore(Double.parseDouble(data.get("MOSQUITO_VALUE_WATER").toString()))
                .build();
    }

    ;
}
