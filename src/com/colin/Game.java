package com.colin;

import java.util.Scanner;

public class Game {
	private Player player;
	private String str1;//玩家
	private String str2;//电脑
	private int addScore;//玩家押注
	private String isAdd;//是否押注
	private int scoreCount;//总积分
	private String[] computer=new String[]{"石头","剪刀","布"}; 
	public Game(Player player){
		this.player = player;
	}
	public void startPlay(){
		scoreCount = player.getScore();//玩家初始分数
		System.out.println("开始游戏");
		System.out.println("欢迎"+player.getName()+"您的初始积分为："+player.getScore());
		System.out.println("游戏规则：请输入石头、剪刀、布或是exit退出游戏~");
		while(true){
			System.out.print("玩家输入：");
			Scanner sc=new Scanner(System.in);
			str1=sc.next();
			System.out.println("是否要押注? yes/no");
			Scanner add=new Scanner(System.in);
			isAdd=add.next();
			if(isAdd.equals("yes")){
				System.out.println("请输入你要压的积分：");
				Scanner inputAddScore=new Scanner(System.in);
				addScore=Integer.parseInt(inputAddScore.next());
				//如果押注大于当前账户的余额
				if(addScore>scoreCount){
					System.out.println("对不起，您的余额不足，即将退出游戏~");
					break;
				}
			}else{
				addScore = 10;//如果用户没有押注就是默认的10积分
			}
			if(!filter(str1)){
				continue;
			}
			if(str1.equals("exit")){
				break;
			}
			str2=computer[(int)(Math.random()*3)];
			System.out.println("玩家："+str1+"    电脑："+str2);
			int result = rule(str1,str2);
			if(result==1){
				scoreCount += addScore;
				System.out.println("恭喜"+player.getName()+"赢了，获得"+addScore+"积分~");
			}if(result==-1){
				scoreCount -= addScore;
				System.out.println("对不起"+player.getName()+"输了，扣除"+addScore+"积分~");
			}if(result==0){
				System.out.println("打平手了~");
			}
			System.out.println(player.getName()+"当前积分为："+scoreCount);
		}
	}

	/**
	 * 过滤用户的输入
	 */
	public boolean filter(String str){
		if(str.equals("石头")||str.equals("剪刀")||str.equals("布")||str.equals("exit")){
			return true;
		}
		return false;
	}
	
	/**
	 * 游戏规则
	 */
	public int rule(String s1,String s2){
		if(s1.equals(s2)){
			return 0;
		}
		if(s1.equals("石头")){
			if(s2.equals("剪刀")){
				return 1;
			}
			if(s2.equals("布")){
				return -1;
			}
		}
		if(s1.equals("剪刀")){
			if(s2.equals("石头")){
				return -1;
			}
			if(s2.equals("布")){
				return 1;
			}
		}
		if(s1.equals("布")){
			if(s2.equals("石头")){
				return 1;
			}
			if(s2.equals("剪刀")){
				return 0;
			}
		}
		return 0;
	}
}
