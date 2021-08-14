package com.rajbhavsar.api.twitter.service;

import java.util.List;

public interface SearchTweetService
{
	List<String> fetchTweetsByHashTag(final String hashTag, final int limit, final int offset);
}
