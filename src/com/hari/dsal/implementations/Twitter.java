package com.hari.dsal.implementations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

public class Twitter {
	Map<Integer, Set<Integer>> friendMap;
	Map<Integer, PriorityQueue<Tweet>> tweetMap;
	SeqTime seqTime;

	/** Initialize your data structure here. */
	public Twitter() {
		friendMap = new HashMap<>();
		tweetMap = new HashMap<>();
		seqTime = new SeqTime();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		// init the friend map
		Tweet tweet = new Tweet(userId, tweetId, seqTime.getTime());
		Set<Integer> friends = friendMap.getOrDefault(userId, new HashSet<>());
		friends.add(userId);
		friendMap.put(userId, friends);

		// save the tweet into the tweetmap
		PriorityQueue<Tweet> tweets = tweetMap.getOrDefault(userId, new PriorityQueue<>(new MyTweetComparator()));
		tweets.offer(tweet);
		tweetMap.put(userId, tweets);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		Set<Integer> friends = friendMap.get(userId);

		if (friends == null || friends.isEmpty()) {
			return new ArrayList<>();
		}

		Map<Integer, PriorityQueue<Tweet>> tweetList = new HashMap<>();
		for (Integer friend : friends) {
			PriorityQueue<Tweet> tweets = tweetMap.get(friend);
			PriorityQueue<Tweet> top10List = getTop10Tweets(tweets);

			Iterator<Tweet> it = top10List.iterator();
			if (!top10List.isEmpty()) {
				tweetList.put(friend, top10List);
			}
		}

		return mergeTweets(tweetList);
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		Set<Integer> friends = friendMap.getOrDefault(followerId, new HashSet<>());
		friends.add(followerId);
		friends.add(followeeId);
		friendMap.put(followerId, friends);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (followerId == followeeId) {
			return;
		}
		Set<Integer> friends = friendMap.getOrDefault(followerId, new HashSet<>());
		friends.remove(followeeId);
		friendMap.put(followerId, friends);
	}

	private PriorityQueue<Tweet> getTop10Tweets(PriorityQueue<Tweet> tweets) {
		PriorityQueue<Tweet> top10Tweets = new PriorityQueue<>(new MyTweetComparator());
		for (int i = 0; i < 10; i++) {
			if (tweets == null || tweets.isEmpty()) {
				break;
			}

			top10Tweets.offer(tweets.poll());
		}

		// push back
		Iterator it = top10Tweets.iterator();
		while (it.hasNext()) {
			tweets.offer((Tweet) it.next());
		}

		return top10Tweets;
	}

	private List<Integer> mergeTweets(Map<Integer, PriorityQueue<Tweet>> tweetLists) {
		List<Integer> ans = new ArrayList<>();
		PriorityQueue<Tweet> finalPQ = new PriorityQueue<>(new MyTweetComparator());
		for (Integer userId : tweetLists.keySet()) {
			PriorityQueue<Tweet> tweets = tweetLists.get(userId);
			Tweet top = tweets.poll();
			// tweetLists.put(userId, tweets);
			finalPQ.offer(top);
		}

		int count = 0;
		while (count < 10 && !tweetLists.isEmpty()) {
			Tweet curr = finalPQ.poll();
			ans.add(curr.tid);
			PriorityQueue<Tweet> nextTweetList = tweetLists.get(curr.uid);

			if (!nextTweetList.isEmpty()) {
				finalPQ.offer(nextTweetList.poll());
			} else {
				tweetLists.remove(curr.uid);
			}
			count += 1;
		}

		return ans;
	}
}
 
class Tweet {
    int tid;
    int uid;
    int time;
    public Tweet(int uid, int tid, int time) {
        this.uid = uid;
        this.tid = tid;
        this.time = time;
    }
}
 
class SeqTime {
    int time;
    public SeqTime() {
        time = 0;
    }
     
    public int getTime() {
        int curTime = time;
        time += 1;
        return curTime;
    }
}
 
class MyTweetComparator implements Comparator<Tweet> {
    @Override
    public int compare(Tweet a, Tweet b) {
        return b.time - a.time;
    }
}