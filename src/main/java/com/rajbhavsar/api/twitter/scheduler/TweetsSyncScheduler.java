package com.rajbhavsar.api.twitter.scheduler;

import com.rajbhavsar.api.twitter.delegate.TwitterDelegate;
import com.rajbhavsar.api.twitter.service.TweetSyncService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TweetsSyncScheduler
{
	private final TwitterDelegate twitterDelegate;
	private final TweetSyncService tweetSyncService;
	
	@Scheduled(cron = "${app.scheduler.tweets-sync-scheduler.time:0 0 0/4 * * *}")
	public void tweetsDataSyncScheduler()
	{
		tweetSyncService.syncTweets(twitterDelegate.getTweets());
	}
}
