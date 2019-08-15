package com.ven.comparator;

public class Score {
	private Integer score;

	public Score(Integer score) {
		super();
		this.score = score;
	};
	
	public Integer getScore() {
		return this.score;
	}

	@Override
	public String toString() {
		return "Score [score=" + score + "]";
	}
	
	
}
