package com.rajbhavsar.api.twitter.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

public class TweetsSyncScheduler
{
	@Scheduled(cron = "${app.scheduler.tweets-sync-scheduler.time:0 0 0/4 * * *}")
	public void tweetsDataSyncScheduler()
	{
		//TODO: Call twitter API by delegate layer method and update the data in DB.
		
	}


}
