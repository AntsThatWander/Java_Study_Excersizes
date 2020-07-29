package Answer;

import java.util.Scanner;

public class Operator_Condition_Loop {
	
	//Q1 : switch문을 이용하여,1부터 3까지 입력한 수에 따라 다음 3개의 메소드들을 이용할 수 있는 프로그램을 만드세요.
	//조건을 만족하지 못한다면, 잘못된 수임을 알려주고 프로그램이 종료되어야 합니다.
	//물론, 3개의 메소드들도 구현해야 합니다.
	//Q2(선택) : 이를 무한히 반복할 수 있는 메서드로 구현하세요. 4를 입력하면 종료됩니다.
	public static void Q2() {
		System.out.println("Q2 activated.");
		//scanner 변수
		Scanner scanner = new Scanner(System.in);
		//while loop를 조절하는 boolean 변수
		boolean isEnd = false;
		//while loop
		while(!isEnd) {
			//시작을 알리기 위한 출력문
			System.out.println("-----------------------------");
			System.out.print("Enter you input 1 to 3. If you want to quit, enter 4. : ");
			//수를 담을 수 있는 tmp 변수
			int tmp = scanner.nextInt();
			//구분선
			System.out.println("-----------------------------");
			//switch문
			switch(tmp) {
				case 1 :
					System.out.println("Method1 activated.");
					method1();
					break;
				case 2 :
					System.out.println("Method2 activated.");
					method2();
					break;
				case 3 :
					System.out.println("Method3 activated.");
					method3();
					break;
				//종료 케이스
				case 4 : 
					System.out.println("Q2 inactivated.");
					scanner.close();
					isEnd = true;
					break;
				default :
					System.out.println("Wrong number. Please try again.");
			}
		}
			
	}
	
	//Q1으로 풀었을 시 정답 코드.
	public static void Q1() {
		System.out.println("Q1 activated.");
		//scanner 변수
		Scanner scanner = new Scanner(System.in);

		//시작을 알리기 위한 출력문
		System.out.println("-----------------------------");
		System.out.print("Enter you input 1 to 3.");
		//수를 담을 수 있는 tmp 변수
		int tmp = scanner.nextInt();
		//구분선
		System.out.println("-----------------------------");
		//switch문
		switch(tmp) {
			case 1 :
				System.out.println("Method1 activated.");
				method1();
				break;
			case 2 :
				System.out.println("Method2 activated.");
				method2();
				break;
			case 3 :
				System.out.println("Method3 activated.");
				method3();
				break;

			default :
				System.out.println("Wrong number.");
		}
		scanner.close();
			
	}
	
	//두 개의 수를 입력받아 +, -, /, *, % 연산을 하는 메소드를 만드세요. 단, 나누기는 double형으로 형변환해야 합니다.
	//0으로 나누기와 오버플로는 고려하지 않습니다.
	private static void method1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter two integers : ");
		int tmp1 = scanner.nextInt(), tmp2 = scanner.nextInt();
		
		System.out.println(tmp1 + tmp2);
		System.out.println(tmp1 - tmp2);
		System.out.println(tmp1 / (double)tmp2);
		System.out.println(tmp1 * tmp2);
		System.out.println(tmp1 % tmp2);
		
		System.out.println("Method1 inactivated.");
	}
	
	//영어 문장을 대문자는 소문자로, 소문자는 대문자로 만드는 메소드를 만드세요. 예외처리는 고려하지 않습니다.
	//힌트 : 문자열의 특정 인덱스의 문자를 얻고 싶으면, charAt()을 이용하면 됩니다. string.charAt()
	//힌트2 : 문자열의 길이를 얻고 싶으면, length()를 이용하면 됩니다. string.length()
	//힌트3 : 문자열은 +를 이용하여 뒤에 붙일 수 있습니다. "Hello" + "World" == "HelloWorld"
	private static void method2() {
		String string = "HelloWorld";
		String tmp = "";
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i)>='A' && string.charAt(i)<= 'Z') {
				tmp += (char)(string.charAt(i) + 32);
			}else {
				tmp += (char)(string.charAt(i) - 32);
			}
		}
		System.out.println(tmp);
		System.out.println("Method2 inactivated.");
	}
	
	//방정식 2x + 4y = 10의 해를 구하세요. 이때 x의 범위는 0<=x<=10이고, y의 범위는 0<=y<=10입니다.
	//자바의 정석 출처 문제입니다.
	private static void method3() {
		for(int x=0; x<=10; x++) {
			for(int y=0; y<=10; y++) {
				if(x*2 + 4*y == 10) {
					System.out.println("x = " + x + " y = " + y);
				}
			}
		}
		System.out.println("Method3 inactivated.");
	}
	
	//main method
	public static void main(String[] args) {
		Q2();
	}

}