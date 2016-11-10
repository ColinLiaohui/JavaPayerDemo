package com.colin;

public class StartGame {
	public static void main(String[] args){
		Player player=new Player("colin",100);
		Game game=new Game(player);
		game.startPlay();
	}
}
