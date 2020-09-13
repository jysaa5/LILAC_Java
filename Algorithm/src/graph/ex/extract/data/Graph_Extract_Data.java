package graph.ex.extract.data;

import java.util.HashMap;
import java.util.LinkedList;

// ����: ȸ�翡 ���� ���� ������Ʈ�� �ִµ�, � ������Ʈ���� Ư�� ������Ʈ�� �Ϸ�Ǿ�߸� ���� �� �� �ִ� ������Ʈ�� �ִ�.
// ������Ʈ�� ��ϰ� �� ������Ʈ���� �������θ� �Ѱ��ָ� �������� �԰��� ������Ʈ�� ��������� ��ȯ�ϴ� �Լ��� �����Ͻÿ�.

// ����: Projects: a, b, c, d, e, f, g
//      dependencies: (f, a), (f, b), (f, c), (b, a), (c, a), (a, e), (b, e), (d, g)
// (f, a): �տ� �ִ� f�� ���� �Ǿ�� �ڿ� �ִ� a�� ����ȴٴ� �ǹ��̴�.

// Graph�� �ڷᱸ���� �����ϴ� ���: 1. Matrix (��Ʈ����) 2. Linked List (���� ����Ʈ)

// Solution: ���Ḯ��Ʈ�� �׷��� �����ϱ�. 
// 1. ������Ʈ���� LinkedList�� �����Ѵ�. 
/* | a | -> f -> b -> c
 * | b | -> f
 * | c | -> f
 * | d | 
 * | e | -> a -> b
 * | f | 
 * | g | -> d
 * 
 * 
 * 2. ������Ʈ ������ŭ �迭 �� �����
 * 3. �Լ� ����� = F()
 * 
 * 4. �Լ� ȣ��
 * F(a) -> F(f)
 * F(b)
 * F(c)
 * F(d)
 * F(e)
 * F(g)
 * 
 * | f | b | c | a | d | e | g |
 * 
 * */

// project Ŭ����
class Project {
	
	// ������Ʈ �̸�
	private String name; 
	
	// ���� ó�� �Ǿ�� �� ������Ʈ�� �����ϴ� ���Ḯ��Ʈ ����
	private LinkedList<Project> dependencies;
	
	// ������ ���� ��, �迭�� ��Ҵ��� ���θ� üũ�ϴ� ����
	private boolean marked;
	
	// ������
	public Project(String name) {
		this.name = name;
		// ��ŷ �÷��״� false�� �ʱ�ȭ
		this.marked = false;
		this.dependencies = new LinkedList<Project>();
	}
	
	// addDependency �޼���: �������踦 �߰����ִ� �Լ�
	public void addDependency(Project project) {
		
		// ���� ó���ؾߵǴ� ������Ʈ�� �޾Ƽ� ����Ʈ�� �߰�
		if(!dependencies.contains(project)) {
			dependencies.add(project);
		}
		
	}// addDependency �޼��� ����
	
	
	// ��������� private���� ���������Ƿ�, ���� �����͸� �������ų� ������ public ������ �޼��� ����
	
	// getDependencies �޼���: dependencies ������ �������� �޼���
	public LinkedList<Project> getDependencies(){
	
		return this.dependencies;
	
	}// getDependencies �޼��� ����
	
	
	// getName �޼���: name ������ �������� �޼��� 
	public String getName() {
		
		return this.name;
	
	}// getName �޼��� ����
	
	
	// setMarked �޼���: marked ������ �����ϴ� �޼���
	public void setMarked(boolean marked) {
	
		this.marked = marked;
	
	}// setMarked �޼��� ����
	
	
	// getMarked �޼���: marked ������ �������� �޼���
	public boolean getMarked() {
		
		return this.marked;
	
	}// getMarked �޼��� ����
		
}//Project Ŭ���� ����


// ProjectManager Ŭ����: ������Ʈ�� ������ Ŭ���� 
class ProjectManager{
	
	// ������Ʈ�� ������ �ؽø� -> �迭�� ��ſ� �ؽø� ���: ������Ʈ �̸����� �˻����� ��, �� ������ �����̴�.
	private HashMap<String, Project> projects;
	
	// ������
	// names: �̸����� ������Ʈ�� �����.
	// dependencies: �������� ������Ʈ ��忡 �߰��Ѵ�.
	public ProjectManager(String[] names, String[][] dependencies) {
		buildProjects(names);
		addDependencies(dependencies);
	}
	
	// buildProjects �޼���: ������Ʈ�� ����� �Լ�
	public void buildProjects(String[] names) {
		//������Ʈ�� �ؽø����� ����
		projects = new HashMap<String, Project>();
		
		// ������Ʈ �̸��� ������Ʈ ��ü�� �߰�
		for(int i = 0; i < names.length; i++) {
			projects.put(names[i], new Project(names[i]));
		}
		
	}// buildProjects �޼��� ����

	
	// addDependencies �޼���: �������� �߰��ϴ� �Լ� 
	public void addDependencies(String[][] dependencies) {
		
		// ������ �迭�� ����.
		for(String[] dependency : dependencies) {
			// before: �տ� ���� ���� ó��
			Project before = findProject(dependency[0]);
			// after: �ڿ� ���� ���߿� ó��
			Project after = findProject(dependency[1]);
			// ���߿� ó�� �ϴ� �Ϳ� dependency�� ���� ó���ؾ� �ϴ� �͵��� �߰��Ѵ�.
			after.addDependency(before);
			
		}
		
	}// addDependencies �޼��� ����
	
	
	// ������ �԰�
	
	private int index;
	
	// ������Ʈ ���� ���ϴ� �޼���
	public Project[] buildOrder() {
		
		// ��ŷ �÷��׸� �ʱ�ȭ
		initMarkingFlages();
		
		// ������� ������ �迭
		Project[] ordered = new Project[this.projects.size()];
		
		index = 0;
		// ������Ʈ�� �ϳ��� ���鼭 ����Լ� ȣ��
		for(Project project : this.projects.values()) {
			buildOrder(project, ordered);
		}
		
		// �Լ��� ������ ����� ����� �迭�� ��ȯ
		return ordered;
		
	}//buildOrder �޼��� ����
	
	//buildOrder �޼���
	public void buildOrder(Project project, Project[] ordered) {
		
		// ȣ���� ������, ���� ó���ؾ� �ϴ� ������Ʈ�� �ִ��� Ȯ��
		if(!project.getDependencies().isEmpty()) {
			
			// ���� ó�� �ؾ��ϴ� ������Ʈ�� ���� ��.
			for(Project p: project.getDependencies()) {
				buildOrder(p, ordered);
			}
			
		}
		
		// ��� �����ϴ� ������Ʈ�� ó�� �Ǿ��� ��.
		// ��� �迭�濡 �߰��� �Ǿ����� Ȯ���ϰ� ���� �迭�濡 �߰��� �ȵ� ������Ʈ�̸�
		// ��ŷ �÷��׸� true�� ����
		if(project.getMarked() == false) {
			
			project.setMarked(true);
			
			// �迭�濡 ������Ʈ ����
			ordered[index] = project;
			
			index ++;
			
		}
		
	}//buildOrder �޼��� ����
	
	
	// initMarkingFlages: ������ ���ϱ� ���� ��ŷ �÷��׸� �ʱ�ȭ ���ִ� �޼���
	private void initMarkingFlages() {
	
		for(Project project : this.projects.values()) {
			project.setMarked(false);
		}
		
	}// initMarkingFlages �޼��� ����
	
	
	// findProject: ������Ʈ�� �̸����� ������Ʈ ��ü�� ��ȯ�ϴ� �޼���
	// ������Ʈ�� hash Map���� ���������Ƿ� �˻��� O(1) �ð��� �ɸ�
	public Project findProject(String name) {
		return projects.get(name);
	}
	
	
}

// Graph_Extract_Data Ŭ����
public class Graph_Extract_Data {
	
	// main: ���� ���� �Լ� 
	public static void main(String[] args) {
	
		String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
		String[][] dependencies = {{"f", "a"}, {"f","b"}, {"f", "c"}, {"b", "a"}, {"c", "a"}, {"a", "e"}, {"b", "e"}, {"d","g"}};
		
		ProjectManager pm = new ProjectManager(projects, dependencies);
		
		Project[] ps = pm.buildOrder();
		
		for(Project p : ps) {
			if(p!= null) {
				System.out.print(p.getName()+" ");
			}
		}
		
		
		
	}// main �޼��� ����
	
	
}// Graph_Extract_Data Ŭ���� ����
