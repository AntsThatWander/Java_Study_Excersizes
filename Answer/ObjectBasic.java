package Answer;

import java.util.*;

//public class�� ���� �ϳ��� �ϳ��Դϴ�. ������ �� �� (default), �� �ƹ��͵� �� �� class�� �� �ᵵ �������ϴ�.
//�� Ŭ������ ������ Q ��ü �迭�� ObjectBasic Ŭ������ main �Լ����� ������ ��, �� �迭�� playGame �޼ҵ��� ���ڷ� �Ѱܼ� ������ �÷����մϴ�.
//���� �����е��� Q Ŭ������ ����, ObjectBasic�� playGame �޼ҵ带 �� ��, main �޼ҵ�� Print Ŭ������ ���� �մϴ�.
//�� �𸣰ڴٸ�, ���� ��ȣ�� �� �����ּ���.
public class ObjectBasic {
	
	
	//Q3. playGame �޼ҵ带 �ϼ��ϼ���.
	public static void playGame(Q[] Qarray) {
		boolean isEnd = false; //while�� ������ ����.
		Scanner scan = new Scanner(System.in);//scanner.
		
		//���� ����
		while(!isEnd) {
			//�⺻ ��¹�
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome! Please Enter One of the Below.");
			System.out.println("Q : quit game. F : fortune game. S : show status. ");
			char input = scan.next().charAt(0);//���� �ϳ� �Է�
			switch(input) {
				//Q�� ������ �����.
				case 'Q' :
					System.out.println("Thank you for playing.");
					isEnd = true;
					scan.close();
					break;
				//R�� ������ ������ ������.
				//���� fortuneGame�� �ϼ����Ѽ� �̿��ϼ���.
				case 'F' :
					fortuneGame(Qarray);
					break;
				//S�� ������ ���� ��ü���� ���¸� �����. 
				//Print ��ü�� myPrint�� �̿��ϼ���.
				case 'S' :
					Printer.myPrint(Qarray);
					break;
				default :
					System.out.println("Wrong Input. Please try again.");
			}
		}
		
	}//playGame ��.
	
	//R�� ������ �����ϴ� ���� �޼ҵ�.
	private static void fortuneGame(Q[] Qarray) {
		//game Ƚ�� ����.
		Q.gamePlay();
		
		//��� ���ϱ�
		double average = 0.0;
		for(int i=0; i<Qarray.length; i++) {
			average += Qarray[i].getStat();
		}
		average /= Qarray.length;
		average = Q.makeRound(average, 2);
		System.out.println("Today's Average is : " + average);
		
		
		//���� ����. 
		//medal�� �� Q�� getPunch()�� average�� ���� ���� �ݿø��� ���Դϴ�.
		//��, addMedal�� �̿��ؼ� �� Q�� medal�� �����ּ���.
		//��Ʈ1 : Math.round�� �̿��ϼ���. �̴� long ���� �����Կ� �����ϼ���.
		//Ȥ�ö� ��¿� ������ �ɱ� �����ϴ�. System.out.println("Player " + (i+1) + "'s medal : " + medal); ������ �����ָ� �����ϴ�.
		for(int i=0; i<Qarray.length; i++) {
			int medal = (int)Math.round(Qarray[i].getStat()/average);
			if(medal < 0) medal = 0;
			System.out.println("Player " + (i+1) + "'s medal : " + medal);
			Qarray[i].addMedal(medal);
		}
		
		System.out.println("Game is done!");
	}//fortuneGame ��.
	
	
	//main �Լ�.
	public static void main(String[] args) {
		//Q ��ü �迭 ����
		Q[] Qarray = new Q[5];
		
		//Q ��ü ���� ���� �� ������ �̸� �ֱ�
		for(int i=0; i<Qarray.length; i++) {
			//������ �빮�� ���ĺ� ����
			String name = Character.toString((char)(Math.random()*26+'A'));
			//Q ��ü ����
			Qarray[i] = new Q(name + (i+1));
		}
		
		playGame(Qarray);
		
	}//main �Լ� ��.

}//ObjectBasic Ŭ���� ��.

//Q Ŭ����.
class Q{
	//Ŭ���� ����.
	private static int game = 0;//���� Ƚ��. ���� �����δ� �ν��Ͻ� ������ �δ� �� ������, �츮�� �߰��� �ν��Ͻ��� ��ü�� ���� �����Ƿ� �׳� �̷��� �Ӵϴ�.
	
	//�ν��Ͻ� ����.
	private double stat; //����. 1 ~ 10 ����.
	
	private int medal; //�޴� ����.
	
	private String name; //�̸�
	
	//Q1. �Ǽ��� ���ϴ� �ڸ������� �ݿø���Ű�� �޼ҵ带 �ۼ��ϼ���.
	//�ݿø� �ϴ� ����� �ڸ����� �� �����ؼ�, �׸�ŭ 10�� ���� ���� 10���� ������ �մϴ�.
	//��Ʈ1: �� �𸣰����� ���ͳ��� ã�ƺ�����.
	//��Ʈ2: Math.round()�� �̿��մϴ�.
	//��Ʈ3: 10�� �ŵ������� �ؿ� �ִ� tenpow()�� �̿��ϼ���.
	public static double makeRound(double num, int wanted) {
		return Math.round(num*tenpow(wanted-1))/tenpow(wanted-1);
	}
	
	public static double tenpow(int num) {
		return Math.pow(10, num);
	}
	
	//Q2. name�� ���ڷ� ���� �����ڿ�, stat�� name �Ѵ� ���ڷ� ���� �����ڸ� ���弼��.
	//��Ʈ1 : name�� ���ڷ� ���� �����ڴ� this()�� �̿��ϵ�, �� ���� Math.random()�� �̿��� ������ ���� ���弼��.
	//Math.random()�� 0.0 ~ 1.0 ������ ���̱� ������, 10�� ���ؾ� �մϴ�.
	//��Ʈ2 : �� ���� ���ڰ� �ִ� �����ڴ� stat�� 0���� �۰ų� ���� ���̳� 10���� ū ���� ���� �Ϳ� ���Ͽ� ��� �ؾ� �մϴ�.
	//��Ʈ3 : name ���ڴ� main()�� ���� ���� ���̴�, �ʱ�ȭ�� �����صθ� �˴ϴ�.
	//��Ʈ4 : stat�� makeRound�� �̿��Ͽ� �ݿø� �ϼ���.
	public Q(String name) {
		this(Math.random()*10, name);
	}//������1 ��
	
	public Q(double stat, String name) {
		if(stat <= 0) stat = 1.0; //0���� �۰ų� ���� ���
		if(stat > 10) stat = 10.0; //10���� ū ���
		this.stat = makeRound(stat, 3); //stat
		this.name = name;
		medal = 0;
	}//������2 ��
	
	public double getPunch() {
		long tmp = Math.round(Math.random()*10);
		double bonus = makeRound(Math.random(),3);
		return tmp%2==0 ? stat - bonus : stat + bonus ;
	}
	
	//Medal�� ������ŵ�ϴ�.
	public void addMedal(int medal) {
		this.medal += medal;
	}
	
	//gamePlay Ƚ���� ������ŵ�ϴ�.
	public static void gamePlay() {
		game++;
	}
	
	//Stat getter. Stat�� �����մϴ�.
		public double getStat() {
			return stat;
		}
	
	//�·� ���.
	private double winRate() {
		return game == 0 ? 0.0 : makeRound(medal/(double)game,2);
	}//winRate ��.
	
	@Override
	//���ڿ��� �ٲ��ִ� �޼ҵ�.
	public String toString() {
		return "\nName : " + name + "\nStats : " + stat +
				"\nTotal Games : " + game + "\nWin Rate : " + winRate() ;
	}//toString ��.
	
}//Q Ŭ���� ��.


//����� ���� Ŭ����
class Printer{
	public static void myPrint(Object[] arr) {
		//��� for��
		for(int i=0; i<arr.length; i++) {
			System.out.println("[" + (i+1) + "]" + arr[i].toString());

		}
	}//myPrint ��
}//Printer ��

