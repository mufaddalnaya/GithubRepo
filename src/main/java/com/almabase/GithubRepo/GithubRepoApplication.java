package com.almabase.GithubRepo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GithubRepoApplication {

	@Value("${api.PAT}")
	private String PAT;

	public static void main(String[] args) {
		SpringApplication.run(GithubRepoApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public HttpEntity getHttpEntity() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "token "+PAT);
		return new HttpEntity(httpHeaders);
	}

}
