package com.colin;

public class Player {
	private String name;//玩家
	private int score;
	
	public Player(String name,int score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString(){
		return "玩家:"+name+",当前积分为:"+score;
		
	}
}
