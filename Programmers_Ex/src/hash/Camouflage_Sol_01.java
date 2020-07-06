package hash;

import java.util.HashMap;


// ����: ����
/*
���� ����
�����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.

���� ��� �����̰� ���� ���� �Ʒ��� ���� ���� �����̰� ���׶� �Ȱ�,
 �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� �������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.

���� | �̸�
�� | ���׶� �Ȱ�, ���� ���۶�
���� |�Ķ��� Ƽ����
���� |û����
�ѿ� |�� ��Ʈ

�����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
clothes�� �� ���� [�ǻ��� �̸�, �ǻ��� ����]�� �̷���� �ֽ��ϴ�.
�����̰� ���� �ǻ��� ���� 1�� �̻� 30�� �����Դϴ�.
���� �̸��� ���� �ǻ��� �������� �ʽ��ϴ�.
clothes�� ��� ���Ҵ� ���ڿ��� �̷���� �ֽ��ϴ�.
��� ���ڿ��� ���̴� 1 �̻� 20 ������ �ڿ����̰� ���ĺ� �ҹ��� �Ǵ� '_' �θ� �̷���� �ֽ��ϴ�.
�����̴� �Ϸ翡 �ּ� �� ���� �ǻ��� �Խ��ϴ�.

����� ��
clothes	return
[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
[[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3

����� �� ����
���� #1
headgear�� �ش��ϴ� �ǻ��� yellow_hat, green_turban�̰� eyewear�� �ش��ϴ� �ǻ���
 blue_sunglasses�̹Ƿ� �Ʒ��� ���� 5���� ������ �����մϴ�.

1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses

���� #2
face�� �ش��ϴ� �ǻ��� crow_mask, blue_sunglasses, smoky_makeup�̹Ƿ� �Ʒ��� ���� 3���� ������ �����մϴ�.

1. crow_mask
2. blue_sunglasses
3. smoky_makeup
*/
/* 
�ַ��: 
�� �������� �ʿ��� ���� �� ������ ������ �� ���� �ִ����̴�.
���� �� ������ �̸��� ���� ���� ���̴�.
{�� ����}:{�� ����}�� ���� ���·� ��Ī�Ǿ�� �ϹǷ�, key:Value ���¿� ����ϴٰ� �����ؼ�
HashMap�� ����Ͽ���.
HashMap�� ����ϸ� �̹� �ִ� �������� �ľ��ϴ� key �˻��� ������, key �˻��� ������ ������ �׿� ����
value ������Ʈ�� ������.

����� ���� ���ϴ� ������ 4������ �ʰ� �� ���� {n, m, o, p}�� ������ ���� �� �Ʒ��� ����.
(n+1)*(m+1)*(o+1)*(p+1) -1
�� �������� �ϳ��� �԰ų� �� �԰ų��� �������� �ֱ� ������ ���� ������ �� �Դ� �������� �ϳ� �߰��Ѵ�.
�׸��� ���� ���� ������ ���ÿ� �Ͼ�� ���̱� ������ �� �ʵ��� ���� ����� ���� ����Ѵ�.
�� ��, �ϳ��� �� ���� �������� �����Ƿ� �� ����� ���� �ϳ��� ����. 
 
*/
class Camouflage_Solution_01 {

	public int solution(String[][] clothes) {
		int answer = 1;

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			
			if (map.get(clothes[i][1]) == null) {
			
				map.put(clothes[i][1], 1);
			
			} else {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			}
		}

		for (String keys : map.keySet()) {
			answer *= (map.get(keys) + 1);
		}

		answer -= 1;

		return answer;
	}
}

public class Camouflage_Sol_01 {

	public static void main(String[] args) {
		Camouflage_Solution_01 sol = new Camouflage_Solution_01();
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(sol.solution(clothes));
	}

}
