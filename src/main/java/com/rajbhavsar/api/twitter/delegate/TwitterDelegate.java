package com.rajbhavsar.api.twitter.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajbhavsar.api.twitter.delegate.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;

@Data
@Component
@Slf4j
@AllArgsConstructor
public class TwitterDelegate
{
	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;
	
	public static final String AUTHORIZATION = "authorization";
	public static final String BEARER = "Bearer ";
	public static final String ACCESS_TOKEN = "AAAAAAAAAAAAAAAAAAAAABewSgEAAAAADT7vv2fpNHg3jZvnACyy5NyVmwc%3DrCC8jOeWN2r0eMdCvUZ62fPAmntyKOMXUbtlZY5s9c4mBzVJkP";
	public static final String URL = "https://api.twitter.com/2/tweets/search/recent?query=covid19&tweet.fields=author_id,created_at,entities,text";

	public ResponseDTO getTweets()
	{
		final RequestEntity<Void> requestEntity = RequestEntity
			.get(URI.create(URL))
			.header(AUTHORIZATION, BEARER + ACCESS_TOKEN).build();

		final ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

		if (HttpStatus.UNAUTHORIZED.equals(responseEntity.getStatusCode()))
			log.error("access token expired");

		try
		{
			return objectMapper.readValue(responseEntity.getBody(), ResponseDTO.class);
		} catch (IOException e)
		{
			log.error("Failed to parse json into class={}", ResponseDTO.class);
		}
		
		return null;
	}
	
}
