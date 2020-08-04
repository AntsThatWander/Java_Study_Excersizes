package Answer;

import java.util.*;

//public class는 파일 하나당 하나입니다. 하지만 그 외 (default), 즉 아무것도 안 쓴 class는 더 써도 괜찮습니다.
//이 클래스의 구조는 Q 객체 배열을 ObjectBasic 클래스의 main 함수에서 생성한 후, 그 배열을 playGame 메소드의 인자로 넘겨서 게임을 플레이합니다.
//따라서 여러분들은 Q 클래스를 보고, ObjectBasic의 playGame 메소드를 본 후, main 메소드와 Print 클래스를 봐야 합니다.
//잘 모르겠다면, 문제 번호를 잘 따라가주세요.
public class ObjectBasic {
	
	
	//Q3. playGame 메소드를 완성하세요.
	public static void playGame(Q[] Qarray) {
		boolean isEnd = false; //while문 끝내는 조건.
		Scanner scan = new Scanner(System.in);//scanner.
		
		//무한 루프
		while(!isEnd) {
			//기본 출력문
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome! Please Enter One of the Below.");
			System.out.println("Q : quit game. F : fortune game. S : show status. ");
			char input = scan.next().charAt(0);//문자 하나 입력
			switch(input) {
				//Q를 누르면 종료됨.
				case 'Q' :
					System.out.println("Thank you for playing.");
					isEnd = true;
					scan.close();
					break;
				//R을 누르면 게임을 진행함.
				//밑의 fortuneGame을 완성시켜서 이용하세요.
				case 'F' :
					fortuneGame(Qarray);
					break;
				//S를 누르면 현재 객체들의 상태를 출력함. 
				//Print 객체의 myPrint를 이용하세요.
				case 'S' :
					Printer.myPrint(Qarray);
					break;
				default :
					System.out.println("Wrong Input. Please try again.");
			}
		}
		
	}//playGame 끝.
	
	//R을 누르면 진행하는 게임 메소드.
	private static void fortuneGame(Q[] Qarray) {
		//game 횟수 증가.
		Q.gamePlay();
		
		//평균 구하기
		double average = 0.0;
		for(int i=0; i<Qarray.length; i++) {
			average += Qarray[i].getStat();
		}
		average /= Qarray.length;
		average = Q.makeRound(average, 2);
		System.out.println("Today's Average is : " + average);
		
		
		//실제 게임. 
		//medal은 각 Q의 getPunch()와 average를 나눈 값을 반올림한 값입니다.
		//후, addMedal을 이용해서 각 Q에 medal을 더해주세요.
		//힌트1 : Math.round를 이용하세요. 이는 long 값을 리턴함에 유의하세요.
		//혹시라도 출력에 도움이 될까 적습니다. System.out.println("Player " + (i+1) + "'s medal : " + medal); 식으로 적어주면 좋습니다.
		for(int i=0; i<Qarray.length; i++) {
			int medal = (int)Math.round(Qarray[i].getStat()/average);
			if(medal < 0) medal = 0;
			System.out.println("Player " + (i+1) + "'s medal : " + medal);
			Qarray[i].addMedal(medal);
		}
		
		System.out.println("Game is done!");
	}//fortuneGame 끝.
	
	
	//main 함수.
	public static void main(String[] args) {
		//Q 객체 배열 생성
		Q[] Qarray = new Q[5];
		
		//Q 객체 각각 생성 및 무작위 이름 넣기
		for(int i=0; i<Qarray.length; i++) {
			//무작위 대문자 알파벳 생성
			String name = Character.toString((char)(Math.random()*26+'A'));
			//Q 객체 생성
			Qarray[i] = new Q(name + (i+1));
		}
		
		playGame(Qarray);
		
	}//main 함수 끝.

}//ObjectBasic 클래스 끝.

//Q 클래스.
class Q{
	//클래스 변수.
	private static int game = 0;//게임 횟수. 물론 실제로는 인스턴스 변수로 두는 게 맞지만, 우리는 중간에 인스턴스를 교체할 일이 없으므로 그냥 이렇게 둡니다.
	
	//인스턴스 변수.
	private double stat; //스탯. 1 ~ 10 까지.
	
	private int medal; //메달 개수.
	
	private String name; //이름
	
	//Q1. 실수를 원하는 자릿수에서 반올림시키는 메소드를 작성하세요.
	//반올림 하는 방법은 자릿수를 잘 생각해서, 그만큼 10을 곱한 다음 10으로 나눠야 합니다.
	//힌트1: 잘 모르겠으면 인터넷을 찾아보세요.
	//힌트2: Math.round()를 이용합니다.
	//힌트3: 10의 거듭제곱은 밑에 있는 tenpow()를 이용하세요.
	public static double makeRound(double num, int wanted) {
		return Math.round(num*tenpow(wanted-1))/tenpow(wanted-1);
	}
	
	public static double tenpow(int num) {
		return Math.pow(10, num);
	}
	
	//Q2. name을 인자로 갖는 생성자와, stat과 name 둘다 인자로 갖는 생성자를 만드세요.
	//힌트1 : name을 인자로 갖는 생성자는 this()를 이용하되, 그 값은 Math.random()을 이용해 무작위 값을 만드세요.
	//Math.random()은 0.0 ~ 1.0 사이의 값이기 때문에, 10을 곱해야 합니다.
	//힌트2 : 두 개의 인자가 있는 생성자는 stat이 0보다 작거나 같은 값이나 10보다 큰 값을 갖는 것에 대하여 대비를 해야 합니다.
	//힌트3 : name 인자는 main()을 통해 넣을 것이니, 초기화만 설정해두면 됩니다.
	//힌트4 : stat을 makeRound를 이용하여 반올림 하세요.
	public Q(String name) {
		this(Math.random()*10, name);
	}//생성자1 끝
	
	public Q(double stat, String name) {
		if(stat <= 0) stat = 1.0; //0보다 작거나 같은 경우
		if(stat > 10) stat = 10.0; //10보다 큰 경우
		this.stat = makeRound(stat, 3); //stat
		this.name = name;
		medal = 0;
	}//생성자2 끝
	
	public double getPunch() {
		long tmp = Math.round(Math.random()*10);
		double bonus = makeRound(Math.random(),3);
		return tmp%2==0 ? stat - bonus : stat + bonus ;
	}
	
	//Medal을 증가시킵니다.
	public void addMedal(int medal) {
		this.medal += medal;
	}
	
	//gamePlay 횟수를 증가시킵니다.
	public static void gamePlay() {
		game++;
	}
	
	//Stat getter. Stat을 리턴합니다.
		public double getStat() {
			return stat;
		}
	
	//승률 계산.
	private double winRate() {
		return game == 0 ? 0.0 : makeRound(medal/(double)game,2);
	}//winRate 끝.
	
	@Override
	//문자열로 바꿔주는 메소드.
	public String toString() {
		return "\nName : " + name + "\nStats : " + stat +
				"\nTotal Games : " + game + "\nWin Rate : " + winRate() ;
	}//toString 끝.
	
}//Q 클래스 끝.


//출력을 위한 클래스
class Printer{
	public static void myPrint(Object[] arr) {
		//출력 for문
		for(int i=0; i<arr.length; i++) {
			System.out.println("[" + (i+1) + "]" + arr[i].toString());

		}
	}//myPrint 끝
}//Printer 끝

