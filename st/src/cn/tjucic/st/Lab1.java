package cn.tjucic.st;

public class Lab1 {
	// ��Ʊģ��
	int[] pocket = {50, 20, 5, 5, 1, 1, 1};
	public Boolean takeOut(int x) {
		for(int money: pocket) {
			// �����ڵ�ǰ��ֵ���ȥ��ǰ��ֵ 
			if(x >= money) {
				x -= money;
			}
			// �ж��Ƿ��������
			if(x == 0) {
				return true;
			}
		}
		return false;
	}
}
