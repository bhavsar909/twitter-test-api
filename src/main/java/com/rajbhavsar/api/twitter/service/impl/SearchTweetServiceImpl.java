package com.rajbhavsar.api.twitter.service.impl;

import com.rajbhavsar.api.twitter.repository.TweetRepository;
import com.rajbhavsar.api.twitter.service.SearchTweetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class SearchTweetServiceImpl implements SearchTweetService
{
	private final TweetRepository tweetRepository;

	@Override
	public List<String> fetchTweetsByHashTag(final String hashTag, final int limit, final int offset)
	{
		if (hashTag == null)
			return Collections.emptyList();

		return tweetRepository.findTweetsByHashTag(hashTag, limit, offset);
	}

}
