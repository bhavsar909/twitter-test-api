package com.rajbhavsar.api.twitter.repository;

import com.rajbhavsar.api.twitter.model.impl.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashTagRepository extends JpaRepository<HashTag, Long>
{

}
