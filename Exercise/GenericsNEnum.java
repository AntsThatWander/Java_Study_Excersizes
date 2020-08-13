//annotation�� ���ݱ��� �ô� @Override ���� �� ���� �˴ϴ�.
public class GenericsNEnum {
	
	//main�� �� ��������? �̰� �ٷ� Generics�� ���ϵ� ī��(wild card)�� ���� �����Դϴ�.
	//������ �츮�� ���� �װͱ��� �Ű� �� �ܰ谡 �ƴϴ�, ����� ���� �ؾ� �մϴ�.
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

//Q3. T Ÿ�� ������ ���� Generic Ŭ���� Box�� �ϼ��ϼ���. �̶� T�� ���� Content�� ��ӹ��� Ŭ������ ���մϴ�. ������ ��Ҹ� �����ϴ�.
//�Ӽ� - content. T Ÿ���� �����Դϴ�.
//������ - T Ÿ���� content ���� �޾Ƽ�, �ڽ��� content�� �����մϴ�.
//���1. - getPrice(). content ���� getPrice()�� content�� ������ �ִ� �±��� ���ݰ�, content�� ������ �ִ� Fee�� ���ؾ� �մϴ�.
//���2. - tagName(). content�� ������ �ִ� tag�� �̸��� ��ȯ�մϴ�. Enum Ŭ������ �ִ� name() �޼ҵ带 Ȱ���ϼ���.
class Box<T extends Content>{
	//���⿡ �ڵ带 �ۼ��ϼ���.
}

//Content Ŭ����. �� Ȱ���ϼ���.
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

//Q2. �Ʒ��� �ִ� Glass Ŭ����, Food Ŭ����, Figure Ŭ������ �����ϼ���.
//returnFee()�� �ù�� ��ȯ�մϴ�. ������� 3000, 1500, 2500 �Դϴ�.
//tag�� ���� �ÿ� ���� Ŭ������ �ο��˴ϴ�.
class Glass extends Content{
    //���⿡ �ڵ带 �ۼ��ϼ���.
}

class Food extends Content{
	//���⿡ �ڵ带 �ۼ��ϼ���.
}

class Figure extends Content{
    //���⿡ �ڵ带 �ۼ��ϼ���.
}

//Q1. enum�� �ϼ��ϼ���. �̶� ����� FRAGILE, QUICK, SIDE��, ���� ��� ����, ���� ���, ���� �����Դϴ�.
//�� �±׿��� price��� ���� �ʿ��մϴ�. ���� 100, 80, 50 �Դϴ�.
//�׸��� �ش� price�� ��ȯ�ϴ� getPrice()�� �����ϼ���.
enum Tag{
	//���⿡ �ڵ带 �ۼ��ϼ���.
}