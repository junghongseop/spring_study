package com.jojoudy.book.springstudy.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void mainPage_loading() {
        // when
        String body = this.restTemplate.getForObject("/", String.class);

        // then
        // contains() 안에 있는 문자열이 mustache 파일 안에 내용이 있는지 확인
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
