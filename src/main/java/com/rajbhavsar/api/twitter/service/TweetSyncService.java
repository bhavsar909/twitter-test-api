package com.rajbhavsar.api.twitter.service;

import com.rajbhavsar.api.twitter.delegate.dto.ResponseDTO;

import java.util.List;

public interface TweetSyncService
{
	boolean syncTweets(ResponseDTO responseDTO);
}
