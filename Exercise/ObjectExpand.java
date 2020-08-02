
//Driver. 보통 main 함수가 있는 클래스를 구동기, driver라고 부릅니다.
public class ObjectExpand {
	public static void main(String[] args) {
		Storage defaultStorage = new Storage();
	
		Ingredient[] array = new Ingredient[5];
		array[0] = new Red();
		array[1] = new Green();
		array[2] = new Green(50);
		array[3] = new Blue();
		array[4] = new Blue(50);
		
		for(int i=0; i<array.length; i++) {
			defaultStorage.store(array[i]);
		}
		
		System.out.println(defaultStorage.getStock()); //8200 나오면 정답!

	}

}

//전체적인 시스템은, Storage 인스터스가 Ingredient 인스턴스를 받은 후 각 Ingredient의 getReource() 반환값을 받아서 저장합니다.(store(Ingredient i))
//만약, 해당 Ingredient 인스턴스가 Processable 하다면, process(Processable a, Processable b)를 호출합니다. 이때, Green과 Blue가 Processable 합니다.
//단, 해당 인스턴스의 quantity가 기준(BASIS)보다 적다면, getResource()에 맞는 양을 리턴해야 합니다.
//Red, Green, Blue 이외의 다른 Ingredient 인스턴스는 받지 않습니다.

//재료들을 모은 후, 각 재료의 가치에 맞게 int 타입의 값으로 변환하여 갖는 클래스입니다.
class Storage{
	//인스턴스 변수
	private int stock; //자원 저장

	//인자 없는 기본 생성자.
	public Storage() {
		stock = 0;
	}
	
	//Q2.store(Ingredient i) 메소드를 구현하세요. 실행 방식은 위 시스템을 참고하세요.
	//재료를 인자로 받은 후, int 가치를 계산하여 저장하는 메소드입니다.
	//Red, Blue, Green만 받습니다.
	public void store(Ingredient i) {

	}
	
	//Q3. process(Processable a, Processable b) 메소드를 구현하세요. 실행 방식은 위 시스템을 참고하세요.
	//Blue, Green만 받습니다.
	private void process(Processable a) {
	}
	
	//stock에 값을 더함.
	public void addStock(int stock) {
		this.stock += stock;
	}
	
	//stock 값을 리턴함.
	public int getStock() {
		return stock;
	}
	
}

interface Processable{
	//getProcess를 정하는 기준입니다. 만약 재료의 quantity가 BASIS보다 작으면, getProcess를 가동할 수 없습니다.
	public final static int BASIS = 50;
	
	//재료를 가공하여 return 합니다.
	//Blue는 getResource 값의 10배, Green은 getResource 값의 15배를 리턴하면 됩니다.
	public abstract int getProcess();
	
	//재료가 BASIS 보다 작은지 큰지 확인하는 메소드.
	//힌트 : num에 quantity를 넣으면 됩니다.
	public static boolean isEnough(int num) {
		return num >= BASIS;
	}
	
}

//Q1. 추상클래스 Ingredient를 부모로 하는 Red, Blue, Green 클래스를 구현하세요.
//이때, getResource()를 구현해야 합니다.
//또한, Blue와 Green은 각각 Processable 인터페이스를 구현해야 합니다.
//힌트1 : 하나를 구현하면, 나머지는 다 똑같습니다.
abstract class Ingredient{
	protected int quantity;
	
	//인자 없는 생성자.
	public Ingredient() {
		this(25);
	}
	
	//인자 있는 생성자.
	public Ingredient(int quantity) {
		this.quantity = quantity;
	}
	
	//실제 해당 재료의 int 가치를 return 하는 메소드입니다. 공식은 quantity * (재료 본연의 가치) 입니다.
	public abstract int getResource();
	
	//quantity 곱하기에 도움이 되는 메소드입니다.
	protected int quantMult(int value) {
		return quantity * value;
	}
	
						
}

class Red extends Ingredient{
	//Red 재료의 보너스 가치입니다.
	private final int RED_VALUE = 6;
}

class Blue extends Ingredient implements Processable{
	//Blue 재료의 보너스 가치입니다.
	private final int BLUE_VALUE = 5;
	//Blue의 process 보너스 가치는 10입니다.
}


class Green extends Ingredient implements Processable{
	//Green 재료의 보너스 가치입니다.
	private final int GREEN_VALUE = 7;
	//Green의 process 보너스 가치는 15입니다.
}