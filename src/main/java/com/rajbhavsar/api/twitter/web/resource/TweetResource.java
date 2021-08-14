package com.rajbhavsar.api.twitter.web.resource;

import com.rajbhavsar.api.twitter.service.SearchTweetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class TweetResource
{

	private final SearchTweetService searchTweetService;
	
	@GetMapping("/tweets")
	public ResponseEntity<List<String>> testCrmIntegration(@RequestParam final String hashTag, 
	                                                       @RequestParam final int limit, 
	                                                       @RequestParam final int offset)
	{
		log.debug("Received request to fetch the data for hashTag={}, limit={} and with offset={}", hashTag, limit, offset);
		
		List<String> tweets = searchTweetService.fetchTweetsByHashTag(hashTag, limit, offset);
		
		log.info("Total {} tweets found for hashTag={}", tweets.size(), hashTag);
		return ResponseEntity.status(HttpStatus.OK).body(tweets);
	}
}