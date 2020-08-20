//annotation은 지금까지 봤던 @Override 같은 거 보면 됩니다.
public class GenericsNEnum {
	
	//main이 꽤 더럽지요? 이게 바로 Generics의 와일드 카드(wild card)를 쓰는 이유입니다.
	//하지만 우리는 아직 그것까지 신경 쓸 단계가 아니니, 고생을 조금 해야 합니다.
	public static void main(String[] args) {
		Glass glass = new Glass();
		Box<Glass> glassBox = new Box<Glass>(glass);
		System.out.println(glassBox.tagName());
		System.out.println(glassBox.getPrice());
		
		Figure figure = new Figure();
		Box<Figure> figureBox = new Box<Figure>(figure);
		System.out.println(figureBox.tagName());
		System.out.println(figureBox.getPrice());
		
		Food food= new Food();
		Box<Food> foodBox = new Box<Food>(food);
		System.out.println(foodBox.tagName());
		System.out.println(foodBox.getPrice());

	}

}

//Q3. T 타입 변수를 갖는 Generic 클래스 Box를 완성하세요. 이때 T는 오직 Content를 상속받은 클래스에 한합니다. 다음의 요소를 갖습니다.
//속성 - content. T 타입의 변수입니다.
//생성자 - T 타입의 content 값을 받아서, 자신의 content에 저장합니다.
//기능1. - getPrice(). content 내의 getPrice()와 content가 가지고 있는 태그의 가격과, content가 가지고 있는 Fee를 더해야 합니다.
//기능2. - tagName(). content가 가지고 있는 tag의 이름을 반환합니다. Enum 클래스에 있는 name() 메소드를 활용하세요.
class Box<T extends Content>{
	T content;
	
	
	Box(T content){
		this.content = content;
	}
	
	public int getPrice() {
		return content.getPrice() + content.getTag().getPrice() + content.returnFee();
	}
	
	public String tagName() {
		return content.getTag().name();
	}
	
}

//Content 클래스. 잘 활용하세요.
abstract class Content{
	protected Tag tag;
	private int price;
	
	abstract public int returnFee();
	
	public int getPrice() {
		return price;
	}
	
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	public Tag getTag() {
		return tag;
	}
}

//Q2. 아래에 있는 Glass 클래스, Food 클래스, Figure 클래스를 구현하세요.
//returnFee()는 택배비를 반환합니다. 순서대로 3000, 1500, 2500 입니다.
//tag는 생성 시에 각각 클래스에 부여됩니다.
class Glass extends Content{
	Glass(){
		tag = Tag.FRAGILE;
	}
	
	public int returnFee() {
		return 3000;
	}
}

class Food extends Content{
	Food(){
		tag = Tag.QUICK;
	}
	
	public int returnFee() {
		return 1500;
	}
	
}

class Figure extends Content{
	Figure(){
		tag = Tag.SIDE;
	}
	
	public int returnFee() {
		return 2500;
	}
	
}

//Q1. enum을 완성하세요. 이때 상수는 FRAGILE, QUICK, SIDE고, 각각 취급 주의, 빠른 배송, 상하 주의입니다.
//각 태그에는 price라는 값이 필요합니다. 각각 100, 80, 50 입니다.
//그리고 해당 price를 반환하는 getPrice()를 구현하세요.
enum Tag{
	FRAGILE(100), QUICK(80), SIDE(50); //각각 취급 주의, 빠른 배송, 상하 주의
	
	private final int price;
	
	
	private Tag(int price) {
		this.price = price;

	}
	
	public int getPrice() {
		return price;
	}
	
}