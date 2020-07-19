import java.util.Scanner;

public class Operator_Condition_Loop {
	
	//Q1 : switch���� �̿��Ͽ�,1���� 3���� �Է��� ���� ���� ���� 3���� �޼ҵ���� �̿��� �� �ִ� ���α׷��� ���弼��.
	//������ �������� ���Ѵٸ�, �߸��� ������ �˷��ְ� ���α׷��� ����Ǿ�� �մϴ�.
	//����, 3���� �޼ҵ�鵵 �����ؾ� �մϴ�.
	//Q2(����) : �̸� ������ �ݺ��� �� �ִ� �޼���� �����ϼ���. 4�� �Է��ϸ� ����˴ϴ�.
	public static void Q1() {
		System.out.println("Q1 activated.");
		//scanner ����
		Scanner scanner = new Scanner(System.in);
		//������ �˸��� ���� ��¹�
		System.out.println("-----------------------------");
		System.out.print("Enter you input 1 to 3.");
		//���� ���� �� �ִ� tmp ����
		int tmp = scanner.nextInt();
		//���м�ddd
		System.out.println("-----------------------------");
		//���⿡ �ڵ带 �ۼ��ϼ���. �Ʒ��� ���� ������� �̿��ϼ���.
		//��Ʈ : ���⿡���� Switch���� �̿��ؾ� �մϴ�.

		//����1
		System.out.println("Method1 activated.");
		method1();
		//����2
		System.out.println("Method2 activated.");
		method2();
		//����3
		System.out.println("Method3 activated.");
		method3();
		//����4
		System.out.println("Wrong number.");
		
		scanner.close();
			
	}
	
	//�� ���� ���� �Է¹޾� +, -, /, *, % ������ �ϴ� �޼ҵ带 ���弼��. ��, ������� double������ ����ȯ�ؾ� �մϴ�.
	//0���� ������� �����÷δ� ������� �ʽ��ϴ�.
	private static void method1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter two integers : ");
		int tmp1 = scanner.nextInt(), tmp2 = scanner.nextInt();
		
		//���⿡ �ڵ带 �ۼ��ϼ���.
		
		System.out.println("Method1 inactivated.");
	}
	
	//���� ������ �빮�ڴ� �ҹ��ڷ�, �ҹ��ڴ� �빮�ڷ� ����� �޼ҵ带 ���弼��. ����ó���� ������� �ʽ��ϴ�.
	//��Ʈ : ���ڿ��� Ư�� �ε����� ���ڸ� ��� ������, charAt()�� �̿��ϸ� �˴ϴ�. string.charAt()
	//��Ʈ2 : ���ڿ��� ���̸� ��� ������, length()�� �̿��ϸ� �˴ϴ�. string.length()
	//��Ʈ3 : ���ڿ��� +�� �̿��Ͽ� �ڿ� ���� �� �ֽ��ϴ�. "Hello" + "World" == "HelloWorld"
	private static void method2() {
		String string = "HelloWorld";
		String tmp = "";

		//���⿡ �ڵ带 �ۼ��ϼ���.

		System.out.println(tmp);
		System.out.println("Method2 inactivated.");
	}
	
	//������ 2x + 4y = 10�� �ظ� ���ϼ���. �̶� x�� ������ 0<=x<=10�̰�, y�� ������ 0<=y<=10�Դϴ�.
	//�ڹ��� ���� ��ó �����Դϴ�.
	private static void method3() {

		//���⿡ �ڵ带 �ۼ��ϼ���.

		System.out.println("Method3 inactivated.");
	}
	
	//main method
	public static void main(String[] args) {
		Q1();
	}

}
