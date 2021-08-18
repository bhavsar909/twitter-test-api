package com.rajbhavsar.api.twitter.delegate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Entity
{
	@JsonProperty("hashtags")
	List<HashTagDTO> hashTags;
}
