import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
	//모든 메소드에서 해당 문자열이 출력되면, 성공한 겁니다.
	private static final String endString = "Well Done.";

	public static void main(String[] args) {
		System.out.println(Q1());
		System.out.println(Q2());
		System.out.println(Q3());
		try {
			System.out.println(Q4());
		}catch(Exception e) {
			System.out.println(endString);
			Viewer.printEnd(4);
		}
		System.out.println("\nAll Done. Great Job.");

	}
	
	//Q1. 다음 코드가 중간에 비정상적으로 종료되지 않도록 예외 처리를 진행하세요.
	//힌트 : NullPointerException을 이용하면 됩니다.
	public static String Q1() {
		Object[] o = new Object[3];
		
		Viewer.printStart(1);
		
		try {
			for(int i=0; i<o.length; i++) {
				System.out.println(o[0].toString());
			}
		}
		catch(NullPointerException npe) {
			System.out.println("Uh-Oh. Wrong array reference.");
		}
		
		Viewer.printEnd(1);
		return endString;
	}
	
	//Q2. 다음 코드가 중간에 비상적으로 종료되지 않도록 예외 처리를 진행하세요.
	//힌트 : InputMismatchException 과 ArithmeticException을 이용하세요.
	public static String Q2() {
		Scanner scan = new Scanner(System.in);
		
		Viewer.printStart(2);
		
		try {
			int tmp = scan.nextInt();
			int tmp2 = scan.nextInt();
			System.out.println(tmp/tmp2);
		}
		catch(InputMismatchException e) {
			System.out.println("Uh-Oh. Wrong input.");
		}
		catch(ArithmeticException e) {
			System.out.println("Uh-Oh. Wrong calculating.");
		}
		finally {
			scan.close();
		}
		
		Viewer.printEnd(2);
		return endString;
	}
	
	//Q3. 다음 코드가 비상적으로 종료되지 않도록 예외 처리를 진행하세요. 단, 이번에는 "Wrong class field reference."라는 메시지를 출력하세요.
	//힌트 : if문과 throw를 이용하세요.
    //힌트2 : 이번 예외는 NoSuchFieldException 입니다.
    //힌트3 : instanceof 연산자를 잘 이용해보세요.
	public static String Q3() {
		Object[] o = new Object[2];
		Q3 c1 = new Q3_1();
		Q3_2 c2 = new Q3_2();
		o[0] = c1;
		o[1] = c2;
		
		Viewer.printStart(3);
		
		try {
			for(int i=0; i<o.length; i++) {
				if(!(o[i] instanceof Q3)) throw new NoSuchFieldException("Wrong class field reference.");
				System.out.println(((Q3)o[i]).example);
			}
		}catch(NoSuchFieldException e) {
			System.out.println(e.getMessage());
		}
		
		Viewer.printEnd(3);
		return endString;
	}
	
	//Q4. 다음 코드가 비상적으로 종료되지 않도록 예외 처리를 진행하세요. 단, 어찌 됐던 간에 마지막엔 endString을 출력해야 합니다.
	public static String Q4() throws Exception{
		Viewer.printStart(4);

		String tmp = "Hello_World"; //"HelloWorld"로도 시도해보세요.

		if(tmp.indexOf("_") < 0) throw new IllegalArgumentException();
		
		
		Viewer.printEnd(4);
		return endString;
	}
	
	//Q5.(선택) ObjectExpand 과제에서, storage의 store와 process 메소드에 대해 예외처리를 진행하세요.

}

//출력을 위해 별도로 지정해주는 클래스입니다.
//원래는 별도의 컨트롤러를 이용하지만, 우리는 그러지 않으니 전부 static 메소드(클래스 메소드)로 만들도록 하겠습니다.
class Viewer{
	public static void printStart(int num) {
		System.out.println("-------------------");
		System.out.println("Q" + num + " activated.");
	}
	
	public static void printEnd(int num) {
		System.out.println("Q" + num + " deactivated.");
	}
}

//Q3을 위한 별도의 클래스들.
class Q3{public int example = 10;}
class Q3_1 extends Q3{}
class Q3_2{}