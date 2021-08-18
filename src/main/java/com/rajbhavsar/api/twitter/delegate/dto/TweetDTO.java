package com.rajbhavsar.api.twitter.delegate.dto;

import com.rajbhavsar.api.twitter.model.ITweet;
import com.rajbhavsar.api.twitter.model.impl.HashTag;
import com.rajbhavsar.api.twitter.model.impl.Tweet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class TweetDTO
{
	private String id;
	private String text;
	private Date created_at;
	private Entity entities;

	public ITweet getITweet()
	{
		ITweet tweet = new Tweet();
		tweet.setTweetId(id);
		tweet.setText(text);
		tweet.setCreateDate(created_at);
		tweet.setHashTags(entities.getHashTags().stream()
				.map(hashTagDTO -> HashTag.builder().tagName(hashTagDTO.getTag()).build())
				.collect(Collectors.toList()));
		
		return tweet;
	}

}
