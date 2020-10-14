package lab2;

public class Main {

	public static void main(String[] args) {
	    /*MyList<Integer> list = new MyList<>((a, b) -> {
	    	if (( (int)a.getValue() - (int)b.getValue()) > 0) {
	    		return 1;	
	    	} else if (((int) a.getValue() - (int) b.getValue()) == 0) {
	    		return 0;
	    	}
	    	return -1;
	    });*/
	    MyList<String> list = new MyList<>((a, b) -> {return 1;});
	    list.add(Randomizer.random_string(50));
	    list.add(Randomizer.random_string(10));
	    list.add(Randomizer.random_string(30));
	    //Randomizer.randomFill_int(list, 100);
	    //list.Sort();
        System.out.println(list.toString());
   	}
}

