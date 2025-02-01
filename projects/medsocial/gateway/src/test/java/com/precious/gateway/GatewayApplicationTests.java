package com.precious.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GatewayApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	void contextLoads() throws Exception {
		webClient.get()
			.uri("/api/v1/auth/add")
			.exchange()
			.expectStatus().isOk()
			.expectBody(String.class)
			.consumeWith(response -> {
				assertThat(response.getResponseBody()).isEqualTo("Auth service is taking longer than expected. Please try again later");
			});

		webClient.get()
			.uri("/api/v1/users/get")
			.exchange()
			.expectStatus().isOk()
			.expectBody(String.class)
			.consumeWith(response -> {
				assertThat(response.getResponseBody()).isEqualTo("User service is taking longer than expected. Please try again later");
			});
	}

}
