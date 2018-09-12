package org.hopto.delow.springbootdemo;

import org.hopto.delow.springbootdemo.controller.HelloWorldResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class SpringBootDemoApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testHelloWorldControllerWithoutParams() {
        HelloWorldResponse responseBody = webTestClient.get().uri("/api/hello").exchange().expectStatus().isOk()
                .expectBody(HelloWorldResponse.class).returnResult().getResponseBody();

        assertThat(responseBody).isNotNull();
        assertThat(responseBody.getId()).isNotNull();
        assertThat(responseBody.getMessage()).isEqualTo("Hello world!");
    }

    @Test
    public void testHelloWorldControllerWithParams() {
        String target = "Denis";
        HelloWorldResponse responseBody = webTestClient.get().uri("/api/hello?target="+target).exchange().expectStatus().isOk()
                .expectBody(HelloWorldResponse.class).returnResult().getResponseBody();

        assertThat(responseBody).isNotNull();
        assertThat(responseBody.getId()).isNotNull();
        assertThat(responseBody.getMessage()).isEqualTo("Hello "+target+"!");
    }

}
