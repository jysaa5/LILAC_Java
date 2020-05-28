package summer.winter.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//����: ��ų Ʈ��
//�־��� ��ų���� ���� ��ų�� ���µ� ���� ��ų�� �ִ� ��� ��ų Ʈ������ ���� �ȴ�. 
//����: Skill = "CBD", Skill_trees = {"BACDE", "CBADF", "AECB", "BDA"}
//BACDE�� C�� B���� �ڿ� �����Ƿ� ��ųƮ������ ���� �ȴ�.
//CBADF�� C���� B�� �ְ� B���� D�� �����Ƿ� ��ųƮ���� �ȴ�. 
//AECB�� C���� B�� �����Ƿ� ��ųƮ���� �ȴ�.
//BDA�� C�� ���� B�� �����Ƿ� ��ųƮ������ ���ܵȴ�. 
//�׷��Ƿ� �� 2���� ��ųƮ���� �����ϴ�. 

// �ַ��: ��ųƮ������ ��ų�� �����ϰ� ��� �� �������� ��ä -> �� ������ �߾��µ� � ������ ������ �� ��������. 
// ArrayList, iterator, asList, replaceAll ��� 

class Solution_02 {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));

		Iterator<String> it = skillTrees.iterator();

		while (it.hasNext()) {
			
			// skill�� �����ϰ� �������� "" �������� �ٲٱ� (���⳪ ��ĭ�� �ƴ�)
			// skill�� replaceAll�� ��ü�� ��ų Ʈ���� ������ index = 0 �̰� �׷��� ������ -1�� ��ȯ�Ѵ�. 
			if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
				// skill�� �԰��� ��ųƮ���� �ƴϹǷ� ����Ʈ���� �����ȴ�. 
				it.remove();
			}
		}

		// ����� �� �ִ� ��ų Ʈ���� ����� ��ȯ 
		answer = skillTrees.size();

		return answer;
	}

}

public class Skill_Tree_Sol_02 {

	public static void main(String[] args) {
		Solution_02 sol = new Solution_02();

		String skill = "CBD";

		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		System.out.println(sol.solution(skill, skill_trees));
	}
}