import java.util.Scanner;

public class Array_String {
	final char[] ENCODER = new char[26];
	
	//Q1. �־��� �迭�� 90�� ȸ������ ����ϴ� �޼ҵ带 �ۼ��ϼ���.
	//�ڹ��� ���� ��ó �����Դϴ�.
	public void Q1() {
		//���� �迭
		int[][] original = {
				{1,1,0,1},
				{1,1,1,0},
				{0,0,1,1},
				{1,0,0,1},
				{0,0,0,1}
		};
		// 1 1 0 1
		// 1 1 1 0
		// 0 0 1 1
		// 1 0 0 1
		// 0 0 0 1
		
		//90�� ȸ����ų �迭. ��� �ι�° �迭�� ���̰� ���� ������, ��ǥ�� 0�� �ε����� ���̸� ������.
		int[][] result = new int[original[0].length][original.length];
		
		//��ǥ ���
		// 0 1 0 1 1
		// 0 0 0 1 1
		// 0 0 1 1 0
		// 1 1 1 0 1
		
		//���� �迭 ���
		System.out.println("Original Array is...");
		for(int i=0; i<original.length; i++) {
			for(int j=0; j<original[i].length; j++) {
				System.out.print(original[i][j]);
			}
			System.out.println();
		}
		
		//90�� ȸ��
		for(int i=0; i<original.length; i++) {
			for(int j=0; j<original[0].length; j++) {
				//���⿡ �ڵ带 �ۼ��ϼ���.
			}
		}
		
		//90�� �迭 ���
		System.out.println("And Rotated Array is...");
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
	//Q2. ���ڿ��� �Է¹޾� ��ȣȭ ��Ű�� ����ϴ� �޼ҵ带 �ۼ��ϼ���.(���� : ī�̻縣 ��ȣ��� ��ȣ ü���Դϴ�.)
	//����ó���� �����ϼ���. �ҹ��� ������ �򰥸� ���� �ֱ� ������, �Է� ������ �빮�ڷ� �ٲټ���. toUpperCase()��� �޼ҵ带 �̿��ϼ���.
	//���� : HELLOWORLD -> KHOORZRUOG
	public void Q2() {
		//���� �Է� Ȯ��
		System.out.print("Please enter the key : ");
		//����-�Է� �� ��ȣȭ
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		
		//��ȣȭ(���ڵ�) ǥ �����
		for(int i=0; i<ENCODER.length; i++) {
			ENCODER[i] = (char)((i+key)%26+'a');
		}
		
		//���� ���� ����
		sc.nextLine();
		
		//���ڿ� �Է� Ȯ��
		System.out.print("Please enter the string : ");
		
		//���⿡ �ڵ带 �ۼ��ϼ���.
		
		sc.close();
	}
	
	
	//main
	public static void main(String[] args) {
		Array_String Qs = new Array_String();
		Qs.Q1();
		Qs.Q2();

	}

}