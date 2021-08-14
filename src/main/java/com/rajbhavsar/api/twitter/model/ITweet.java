package com.rajbhavsar.api.twitter.model;

import java.io.Serializable;
import java.util.Date;

public interface ITweet extends Serializable
{
	Long getTweetId();

	void setTweetId(Long tweetId);

	String getText();

	void setText(String text);

	Date getCreateDate();

	void setCreateDate(Date createDate);

	Date getUpdateDate();

	void setUpdateDate(final Date updateDate);

	Date getDeleteDate();

	void setDeleteDate(final Date deleteDate);

}
