package Answer;

import java.util.Scanner;

public class Variable {
	
	//Q1 : 자바 내 8개의 기본형 변수들을 선언하고, 오버플로가 나지 않는 수로 초기화하세요.(어떤 수도 됩니다.)
	//또한, 문자형-정수형, 정수형-정수형, 정수형-실수형, 실수형-실수형에서 자동 형변환의 되는 사례를 보여주세요.(되기만 하면 됩니다.)
	public static void Q1() {
		//정수형
		byte A = 1;
		short B = 2;
		int C = 3;
		long D = 4L;
		
		//실수형
		float E = 1.5f;
		double F = 1.6;
		
		//문자형
		char G = 'A'; // char G = 65;
		
		//논리형
		boolean H = true;
		
		//문자형-정수형
		long charToInt = G;
		
		//정수형-정수형
		long intToLong = C;
		
		//정수형-실수형
		float intToFloat = C;
		
		//실수형-실수형
		double floatToDouble = E;
		
		//여기까지 출력되면 문제가 없는 겁니다.
		System.out.println("Not Problem Found.");
	}
	
	//Q2 : 1개의 숫자를 입력하면, 그에 대응하는 ASCII 문자열을 출력하는 메소드를 작성하세요.
	public static void Q2() {
		//프로그램이 시작됐음을 알려주는 코드.
		System.out.print("Please enter any number. This will show you ASCII character for the number : ");
		
		//입력
		Scanner scanner = new Scanner(System.in);
		int tmp = scanner.nextInt();
		//입력에 대한 출력.
		System.out.println((char)tmp);
		//스캐너 닫기.
		scanner.close();
	}

	public static void main(String[] args) {
		System.out.println("Q1 started.");
		Q1();
		System.out.println("Q2 started.");
		Q2();
	}

}