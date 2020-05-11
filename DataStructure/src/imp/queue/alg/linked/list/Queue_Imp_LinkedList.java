package imp.queue.alg.linked.list;

import java.util.LinkedList;

//����: ���� ����̸� �о��ϴ� �о�Ұ� �ִ�. �о�޴� ����� ������ ������ �� �� �ְ�, �о�ҿ��� ���� ����
//�ִ� ������ �ڵ����� �о�� ������ �������� Ŭ������ �����Ͻÿ�.
//��, �ڹٿ��� �����ϴ� LinkedList�� �����Ͻÿ�.

//LinkedList�� Queue�� ����
//���� Ÿ�� ����
enum AnimalType {
	
	DOG, CAT

}

//���� �׸��� �߻� Ŭ�������� �ٷ��.
//Animal: �߻� Ŭ����
abstract class Animal {

	AnimalType type;
	String name;
	int order;

	// ������
	Animal(AnimalType type, String name) {
		this.type = type;
		this.name = name;
	}

	// setOrder �޼���: ���� ����
	void setOrder(int order) {
		
		this.order = order;
	
	}//setOrder �޼��� ����

	
	// getOrder �޼���: ���� ����
	int getOrder() {
	
		return order;
	
	}// getOrder �޼��� ����

	
	// info �޼���
	String info() {
		
		return order + ") type: " + type + ", name: " + name;
	
	}// info �޼��� ����
	
}// Animal �߻� Ŭ���� ����


//Dog Ŭ���� 
class Dog extends Animal {

	// ������
	Dog(String name) {
		
		super(AnimalType.DOG, name);
	
	}

}// Dog Ŭ���� ����


//Cat Ŭ���� 
class Cat extends Animal {
	
	// ������
	Cat(String name) {
	
		super(AnimalType.CAT, name);
	
	}
	
}// Cat Ŭ���� ����


//���� �о��
class AnimalShelter {

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();

	// ������ ��ȣ = ����
	int order;

	// ������
	AnimalShelter() {
	
		order = 1;
	
	}

	// enqueue �޼���: ť�� ������ �߰��ϴ� ���
	void enqueue(Animal animal) {
		//���� ����
		animal.setOrder(order);
		
		//���� ����
		order++;

		//�� �� ��
		if (animal.type == AnimalType.DOG) {
	
			//�� ���Ḯ��Ʈ�� ������ �߰�
			dogs.addLast((Dog) animal);
		
		//����� �� ��
		} else if (animal.type == AnimalType.CAT) {
		
			//����� ���Ḯ��Ʈ�� ������ �߰�
			cats.addLast((Cat) animal);
	
		}
		
	}// enqueue �޼��� ����

	
	// dequeueDog �޼���: �� ť���� ������ ������ �����ϴ� ���
	Animal dequeueDog() {
	
		return dogs.poll();
	
	}// dequeueDog �޼��� ����

	
	// dequeueCat �޼���: ����� ť���� ������ ������ �����ϴ� ��� 
	Animal dequeueCat() {
		
		return cats.poll();
	
	}// dequeueCat �޼��� ����

	
	// dequeue �޼���: ����̳� �� �߿��� ������� �ƹ��ų� ������ ���
	Animal dequeue() {
		
		// ��, ����̰� ��� �� ���� ��.
		if (dogs.size() == 0 && cats.size() == 0) {
		
			return null;
		
		// ���� ���� ��
		} else if (dogs.size() == 0) {

			return cats.poll();

		// ����̸� ���� ��
		} else if (cats.size() == 0) {
			
			return dogs.poll();
		}
		
		//�� �� ���� �� ���� ���� �ִ� ���� ���� ����.
		Animal dog = dogs.peek();
		Animal cat = cats.peek();

		//���� ��
		if(cat.order < dog.order) {
			return cats.poll();
		}else {
			return dogs.poll();
		}
		
	}// dequeue �޼��� ����

}//AnimalShelter Ŭ���� ����


//Queue_alg_Imp Ŭ����
public class Queue_Imp_LinkedList {

	// main �޼���: ���� �Լ�
	public static void main(String[] args) {
		
		Dog d1 = new Dog("puppy");
		Dog d2 = new Dog("chichi");
		Dog d3 = new Dog("choco");
		
		Cat c1 = new Cat("shasha");
		Cat c2 = new Cat("miumiu");
		Cat c3 = new Cat("gaga");

		
		AnimalShelter as = new AnimalShelter();
		as.enqueue(d1);
		as.enqueue(c1);
		as.enqueue(d2);
		as.enqueue(c2);
		as.enqueue(d3);
		as.enqueue(c3);
		
		System.out.println(as.dequeueCat().info());
		System.out.println(as.dequeueDog().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		
		
	}// main �޼��� ����

}// Queue_alg_Imp ����
