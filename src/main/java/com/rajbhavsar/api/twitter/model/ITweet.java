package com.rajbhavsar.api.twitter.model;

import com.rajbhavsar.api.twitter.delegate.dto.HashTagDTO;
import com.rajbhavsar.api.twitter.model.impl.HashTag;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface ITweet extends Serializable
{
	String getTweetId();

	void setTweetId(String tweetId);

	String getText();

	void setText(String text);

	Date getCreateDate();

	void setCreateDate(Date createDate);

	Date getUpdateDate();

	void setUpdateDate(final Date updateDate);

	Date getDeleteDate();

	void setDeleteDate(final Date deleteDate);

	List<IHashTag> getHashTags();

	void setHashTags(final List<IHashTag> hashTags);

}
