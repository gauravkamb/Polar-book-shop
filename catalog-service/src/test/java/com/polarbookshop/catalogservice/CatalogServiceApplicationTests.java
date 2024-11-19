package com.polarbookshop.catalogservice;

import com.polarbookshop.catalogservice.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void whenPostRequestThenBookCreated(){
		var expectedBook = new Book("1213121414", "Title", "Author", 100.0);

		webTestClient
				.post()
				.uri("/books")
				.bodyValue(expectedBook)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(Book.class).value(actualBook -> {
					Assertions.assertThat(actualBook).isNotNull();
					Assertions.assertThat(actualBook.isbn()).isEqualTo(expectedBook.isbn());
				});
	}

	@Test
	void contextLoads() {
	}

}
