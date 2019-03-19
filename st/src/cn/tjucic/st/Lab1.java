package cn.tjucic.st;

public class Lab1 {
	// 钞票模拟
	int[] pocket = {50, 20, 5, 5, 1, 1, 1};
	public Boolean takeOut(int x) {
		for(int money: pocket) {
			// 若大于当前面值则减去当前面值 
			if(x >= money) {
				x -= money;
			}
			// 判断是否完成找零
			if(x == 0) {
				return true;
			}
		}
		return false;
	}
}
