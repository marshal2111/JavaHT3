package lab2;
import lab2.*;

class Main{

	public static void main(String[] args){

		lab2.MyList lst = new MyList();
		lst.Push(5);
		lst.Push(4);
		lst.Push(8);
		lst.Push(2);
		lst.Push(10);
		lst.Push(9);

		System.out.println(lst.toString());
		lst.Swap(3, 0);
		System.out.println(lst.toString());
		lst.Swap(-5, 3);
		System.out.println(lst.toString());
		lst.Swap(2, 4);
		System.out.println(lst.toString());
		lst.Swap(0, 1);
		lst.Sort();
		System.out.println(lst.toString());
	}
}
