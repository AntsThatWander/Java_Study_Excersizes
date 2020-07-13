import java.util.Scanner;

public class Variable {
	
	//Q1 : �ڹ� �� 8���� �⺻�� �������� �����ϰ�, �����÷ΰ� ���� �ʴ� ���� �ʱ�ȭ�ϼ���.(� ���� �˴ϴ�.)
	//����, ������-������, ������-������, ������-�Ǽ���, �Ǽ���-�Ǽ������� �ڵ� ����ȯ�� �Ǵ� ��ʸ� �����ּ���.(�Ǳ⸸ �ϸ� �˴ϴ�.)
	public static void Q1() {
		//������
		byte A = 1;
		short B = 2;
		int C = 3;
		long D = 4L;
		
		//�Ǽ���
		float E = 1.5f;
		double F = 1.6;
		
		//������
		char G = 'A'; // char G = 65;
		
		//������
		boolean H = true;
		
		//������-������
		long charToInt = G;
		
		//������-������
		long intToLong = C;
		
		//������-�Ǽ���
		float intToFloat = C;
		
		//�Ǽ���-�Ǽ���
		double floatToDouble = E;
		
		//������� ��µǸ� ������ ���� �̴ϴ�.
		System.out.println("Not Problem Found.");
	}
	
	//Q2 : 1���� ���ڸ� �Է��ϸ�, �׿� �����ϴ� ASCII ���ڿ��� ����ϴ� �޼ҵ带 �ۼ��ϼ���.
	public static void Q2() {
		//���α׷��� ���۵����� �˷��ִ� �ڵ�.
		System.out.print("Please enter any number. This will show you ASCII character for the number : ");
		
		//�Է�
		Scanner scanner = new Scanner(System.in);
		int tmp = scanner.nextInt();
		//�Է¿� ���� ���.
		System.out.println((char)tmp);
		//��ĳ�� �ݱ�.
		scanner.close();
	}

	public static void main(String[] args) {
		System.out.println("Q1 started.");
		Q1();
		System.out.println("Q2 started.");
		Q2();

	}

}
