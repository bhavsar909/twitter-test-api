package com.rajbhavsar.api.twitter.repository;

import com.rajbhavsar.api.twitter.model.impl.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long>
{

	@Query(value = "SELECT t.text FROM Tweet t " +
			"INNER JOIN TweetHashTagMap thm ON t.tweetId=thm.tweetId " +
			"INNER JOIN HashTag h ON thm.tagId=h.tagId " +
			"WHERE h.tagName like :hashTag " +
			"AND h.deleteDate IS NULL AND t.deleteDate IS NULL " +
			" LIMIT :limit OFFSET :offset ", nativeQuery = true)
	List<String> findTweetsByHashTag(@Param("hashTag") String hashTag, @Param("limit") int limit, @Param("offset") int offset);

}
