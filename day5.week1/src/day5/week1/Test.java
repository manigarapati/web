package day5.week1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCollection<String> my = new MyCollection<>(10);
		my.add("java");
		my.add("python");
		my.add("database");
		my.add("Mysql");
		System.out.println(my);
		my.add(1,"PHP");
		my.add(9,"Javascript");
		System.out.println(my);
		my.remove();
		my.remove(3);
		System.out.println(my);
	}

}
