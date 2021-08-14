package com.rajbhavsar.api.twitter.model;

import java.io.Serializable;
import java.util.Date;

public interface IHashTag extends Serializable
{
	Long getTagId();

	void setTagId(Long tagId);

	String getTagName();

	void setTagName(String tagName);

	Date getCreateDate();

	void setCreateDate(Date createDate);

	Date getUpdateDate();

	void setUpdateDate(final Date updateDate);

	Date getDeleteDate();

	void setDeleteDate(final Date deleteDate);
	
}
