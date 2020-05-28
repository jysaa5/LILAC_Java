package summer.winter.coding;

// ����: ��ų Ʈ��
// �־��� ��ų���� ���� ��ų�� ���µ� ���� ��ų�� �ִ� ��� ��ų Ʈ������ ���� �ȴ�. 
// ����: Skill = "CBD", Skill_trees = {"BACDE", "CBADF", "AECB", "BDA"}
// BACDE�� C�� B���� �ڿ� �����Ƿ� ��ųƮ������ ���� �ȴ�.
// CBADF�� C���� B�� �ְ� B���� D�� �����Ƿ� ��ųƮ���� �ȴ�. 
// AECB�� C���� B�� �����Ƿ� ��ųƮ���� �ȴ�.
// BDA�� C�� ���� B�� �����Ƿ� ��ųƮ������ ���ܵȴ�. 
// �׷��Ƿ� �� 2���� ��ųƮ���� �����ϴ�. 

// �ַ��: ���ڿ����� ���ڰ� ��ġ�ϴ� �ε��� �� 

class Solution_01{

	public int solution(String skill, String[] skill_trees) {
		
		// �ϴ� ��ü ��ųƮ���� ��� ����� �� �ִٰ� �����ϰ� ����
		int answer = skill_trees.length;
		
		int beforeIdx = 0;
		
		int currentIdx = 0;
		
		for(int i=0; i<skill_trees.length ; i++) {
			
			beforeIdx = skill_trees[i].indexOf(skill.charAt(0));
			
			for(int j=1; j<skill.length(); j++) {
				
				currentIdx = skill_trees[i].indexOf(skill.charAt(j));
				
				
				// ��ų�� ����� �� ���� ���� ��ü ��ųƮ������ ���� ��Ű��
				// ���� ��ų���� ���� ��ų�� ���� ��ųƮ������ ������ ���� ��ų�� ������ ���
				// ���� ��ų�� ���µ� ���� ��ų�� �ִ� ��� 
				if(((beforeIdx > currentIdx) && currentIdx != -1) || ((beforeIdx == -1) && (currentIdx != -1))) {
					answer--;
					break;
				}
				
				beforeIdx = currentIdx;
				
			}
			
		}
		
		
		
		
		return answer;
	}

}

public class Skill_Tree_Sol_01 {

	public static void main(String[] args) {
		
		Solution_01 sol = new Solution_01();
		
		String skill = "CBD";
		
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		System.out.println(sol.solution(skill, skill_trees));

	}
}
