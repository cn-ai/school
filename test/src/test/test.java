package test;

public class test {
public static void main(String[] args) {
	int arr[]= {8,2,1,0,3};
	int index[]= {2,0,3,24,0,1,3,2,3,3};
	String tel="";
	for (int i : index) {
		tel+=arr[i];
	}
	System.out.println("联系方法："+tel);
}
}
