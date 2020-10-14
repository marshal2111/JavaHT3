package lab2;

public class Main {

	public static void main(String[] args) {
	    MyList<Integer> list = new MyList<>((a, b) -> {
	    	if (((int) a.getValue() - (int) b.getValue()) > 0) {
	    		return 1;	
	    	} else if (((int) a.getValue() - (int) b.getValue()) == 0) {
	    		return 0;
	    	}
	    	return -1;
	    });
	    /*MyList<Integer> list = new MyList<>((a, b) -> {if((int)a.getValue() - (int)b.getValue() > 0)
        return 1; else if ((int)a.getValue() - (int)b.getValue() < 0) return -1; else return 0;});  */
	    Randomizer.randomFill(list, 100);
        System.out.println(list.toString());
   	}
}

