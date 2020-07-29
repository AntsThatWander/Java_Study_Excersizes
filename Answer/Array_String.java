package Answer;

import java.util.Scanner;

public class Array_String {
	final char[] ENCODER = new char[26];
	
	//Q1. 주어진 배열을 90도 회전시켜 출력하는 메소드를 작성하세요.
	//자바의 정석 출처 문제입니다.
	public void Q1() {
		//기존 배열
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
		
		//90도 회전시킬 배열. 모든 두번째 배열의 길이가 같기 때문에, 대표로 0번 인덱스의 길이를 가져옴.
		int[][] result = new int[original[0].length][original.length];
		
		//목표 행렬
		// 0 1 0 1 1
		// 0 0 0 1 1
		// 0 0 1 1 0
		// 1 1 1 0 1
		
		//기존 배열 출력
		System.out.println("Original Array is...");
		for(int i=0; i<original.length; i++) {
			for(int j=0; j<original[i].length; j++) {
				System.out.print(original[i][j]);
			}
			System.out.println();
		}
		
		//90도 회전
		for(int i=0; i<original.length; i++) {
			for(int j=0; j<original[0].length; j++) {
				result[j][result.length-i] = original[i][j];
			}
		}
		
		//90도 배열 출력
		System.out.println("And Rotated Array is...");
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
	//Q2. 문자열을 입력받아 암호화 시키는 메소드를 작성하세요.(참고 : 카이사르 암호라는 암호 체계입니다.)
	//예외처리는 무시하세요. 소문자 문장을 헷갈릴 수도 있기 때문에, 그냥 대문자로 바꿉니다.
	//예시 : HELLOWORLD -> KHOORZRUOG
	public void Q2() {
		//정수 입력 확인
		System.out.print("Please enter the key : ");
		//변수-입력 및 암호화
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		
		//암호화(엔코딩) 표 만들기
		for(int i=0; i<ENCODER.length; i++) {
			ENCODER[i] = (char)((i+key)%26+'a');
		}
		
		//개행 문자 제거
		sc.nextLine();
		
		//문자열 입력 확인
		System.out.print("Please enter the string : ");
		
		//변수-입력 문자열
		String inputString = sc.nextLine();
		String result = "";
		
		//대문자로
		inputString = inputString.toUpperCase();
		
		//엔코딩 과정
		for(int i=0; i<inputString.length(); i++) {
			char encoded = ENCODER[inputString.charAt(i)-'A'];
			result += encoded;
		}
		
		//출력
		System.out.println(result);
		sc.close();
	}
	
	
	//main
	public static void main(String[] args) {
		Array_String Qs = new Array_String();
		Qs.Q1();
		Qs.Q2();

	}

}
