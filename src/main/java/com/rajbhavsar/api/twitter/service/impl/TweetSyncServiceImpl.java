package com.rajbhavsar.api.twitter.service.impl;

import com.rajbhavsar.api.twitter.delegate.dto.ResponseDTO;
import com.rajbhavsar.api.twitter.model.impl.Tweet;
import com.rajbhavsar.api.twitter.repository.TweetRepository;
import com.rajbhavsar.api.twitter.service.TweetSyncService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class TweetSyncServiceImpl implements TweetSyncService
{
	private final TweetRepository tweetRepository;
	
	@Override
	public boolean syncTweets(ResponseDTO responseDTO)
	{
		if (responseDTO == null)
			return false;
		
		List<Tweet> tweetList = new ArrayList<>();
		responseDTO.getData().forEach(tweetDTO -> {
			tweetList.add((Tweet) tweetDTO.getITweet());
		});

		List<Tweet> tweets = tweetRepository.saveAll(tweetList);
		return tweets.size()==responseDTO.getData().size();
	}
}
