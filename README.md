# Twitter API Test

## 1. Set up steps

- After cloning create the new schema called TwitterTest as follow:
```
CREATE SCHEMA `TwitterTest` ;
```

- Update the DB configuration in application.yml as per required.
- Run the application
```./gradlew clean bootrun```
- Following endpoint will fetch the required data and it will return the list of tweets present in DB:
```
curl --location --request GET 'localhost:8001/tweets?hashTag=covid19&limit=2&offset=4'
```

- To Add some sample data in DB tables following queries can be helpful
```
Add some tweets:
INSERT INTO `TwitterTest`.`Tweet` (`tweetId`, `text`) VALUES ('1', 'Covid 19 test-1');
INSERT INTO `TwitterTest`.`Tweet` (`tweetId`, `text`) VALUES ('2', 'Covid 19 test-2');
INSERT INTO `TwitterTest`.`Tweet` (`tweetId`, `text`) VALUES ('3', 'Covid 19 test-3');
INSERT INTO `TwitterTest`.`Tweet` (`tweetId`, `text`) VALUES ('4', 'Covid 19 test-4');

Add some hashtag:
INSERT INTO `TwitterTest`.`HashTag` (`tagId`, `tagName`) VALUES ('1', 'covid19');

Add the tweet and hashtag mapping:
INSERT INTO `TwitterTest`.`TweetHashTagMap` (`tweetId`, `tagId`) VALUES ('1', '1');
INSERT INTO `TwitterTest`.`TweetHashTagMap` (`tweetId`, `tagId`) VALUES ('2', '1');
INSERT INTO `TwitterTest`.`TweetHashTagMap` (`tweetId`, `tagId`) VALUES ('3', '1');

```