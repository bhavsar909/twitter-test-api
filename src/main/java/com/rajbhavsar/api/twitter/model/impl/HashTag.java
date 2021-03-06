package com.rajbhavsar.api.twitter.model.impl;

import com.rajbhavsar.api.twitter.model.IHashTag;
import com.rajbhavsar.api.twitter.model.ITweet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "HashTag")
public class HashTag implements IHashTag
{
	@Id
	@Column(unique = true, nullable = false)
	private Long tagId;

	@Column
	private String tagName;

	@Column
	private Date createDate;

	@Column
	private Date updateDate;

	@Column
	private Date deleteDate;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Tweet.class)
	@JoinTable(name = "TweetHashTagMap",
			joinColumns = @JoinColumn(name = "tagId"),
			inverseJoinColumns = @JoinColumn(name = "tweetId"))
	private List<ITweet> tweets;

}
