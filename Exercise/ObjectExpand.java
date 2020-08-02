
//Driver. ���� main �Լ��� �ִ� Ŭ������ ������, driver��� �θ��ϴ�.
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
		
		System.out.println(defaultStorage.getStock()); //8200 ������ ����!

	}

}

//��ü���� �ý�����, Storage �ν��ͽ��� Ingredient �ν��Ͻ��� ���� �� �� Ingredient�� getReource() ��ȯ���� �޾Ƽ� �����մϴ�.(store(Ingredient i))
//����, �ش� Ingredient �ν��Ͻ��� Processable �ϴٸ�, process(Processable a, Processable b)�� ȣ���մϴ�. �̶�, Green�� Blue�� Processable �մϴ�.
//��, �ش� �ν��Ͻ��� quantity�� ����(BASIS)���� ���ٸ�, getResource()�� �´� ���� �����ؾ� �մϴ�.
//Red, Green, Blue �̿��� �ٸ� Ingredient �ν��Ͻ��� ���� �ʽ��ϴ�.

//������ ���� ��, �� ����� ��ġ�� �°� int Ÿ���� ������ ��ȯ�Ͽ� ���� Ŭ�����Դϴ�.
class Storage{
	//�ν��Ͻ� ����
	private int stock; //�ڿ� ����

	//���� ���� �⺻ ������.
	public Storage() {
		stock = 0;
	}
	
	//Q2.store(Ingredient i) �޼ҵ带 �����ϼ���. ���� ����� �� �ý����� �����ϼ���.
	//��Ḧ ���ڷ� ���� ��, int ��ġ�� ����Ͽ� �����ϴ� �޼ҵ��Դϴ�.
	//Red, Blue, Green�� �޽��ϴ�.
	public void store(Ingredient i) {

	}
	
	//Q3. process(Processable a, Processable b) �޼ҵ带 �����ϼ���. ���� ����� �� �ý����� �����ϼ���.
	//Blue, Green�� �޽��ϴ�.
	private void process(Processable a) {
	}
	
	//stock�� ���� ����.
	public void addStock(int stock) {
		this.stock += stock;
	}
	
	//stock ���� ������.
	public int getStock() {
		return stock;
	}
	
}

interface Processable{
	//getProcess�� ���ϴ� �����Դϴ�. ���� ����� quantity�� BASIS���� ������, getProcess�� ������ �� �����ϴ�.
	public final static int BASIS = 50;
	
	//��Ḧ �����Ͽ� return �մϴ�.
	//Blue�� getResource ���� 10��, Green�� getResource ���� 15�踦 �����ϸ� �˴ϴ�.
	public abstract int getProcess();
	
	//��ᰡ BASIS ���� ������ ū�� Ȯ���ϴ� �޼ҵ�.
	//��Ʈ : num�� quantity�� ������ �˴ϴ�.
	public static boolean isEnough(int num) {
		return num >= BASIS;
	}
	
}

//Q1. �߻�Ŭ���� Ingredient�� �θ�� �ϴ� Red, Blue, Green Ŭ������ �����ϼ���.
//�̶�, getResource()�� �����ؾ� �մϴ�.
//����, Blue�� Green�� ���� Processable �������̽��� �����ؾ� �մϴ�.
//��Ʈ1 : �ϳ��� �����ϸ�, �������� �� �Ȱ����ϴ�.
abstract class Ingredient{
	protected int quantity;
	
	//���� ���� ������.
	public Ingredient() {
		this(25);
	}
	
	//���� �ִ� ������.
	public Ingredient(int quantity) {
		this.quantity = quantity;
	}
	
	//���� �ش� ����� int ��ġ�� return �ϴ� �޼ҵ��Դϴ�. ������ quantity * (��� ������ ��ġ) �Դϴ�.
	public abstract int getResource();
	
	//quantity ���ϱ⿡ ������ �Ǵ� �޼ҵ��Դϴ�.
	protected int quantMult(int value) {
		return quantity * value;
	}
	
						
}

class Red extends Ingredient{
	//Red ����� ���ʽ� ��ġ�Դϴ�.
	private final int RED_VALUE = 6;
}

class Blue extends Ingredient implements Processable{
	//Blue ����� ���ʽ� ��ġ�Դϴ�.
	private final int BLUE_VALUE = 5;
	//Blue�� process ���ʽ� ��ġ�� 10�Դϴ�.
}


class Green extends Ingredient implements Processable{
	//Green ����� ���ʽ� ��ġ�Դϴ�.
	private final int GREEN_VALUE = 7;
	//Green�� process ���ʽ� ��ġ�� 15�Դϴ�.
}