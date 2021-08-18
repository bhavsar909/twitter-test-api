package com.rajbhavsar.api.twitter.delegate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDTO
{
	List<TweetDTO> data;
}
