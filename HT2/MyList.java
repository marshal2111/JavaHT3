package lab2;

public class MyList
{
	class Item{
		private int value;
		private Item next;

		public Item(int value){
			this.value = value;
			this.next = null;
		}

		public boolean hasNext(){
			if (this.next == null){
				return false;
			} 
			else {
				return true;
			}
		}

		public int getValue(){
			return value;
		}

		public void setValue(int value){
			this.value = value;
		}

		public Item getNext(){
			return next;
		}

		public void setNext(Item next){
			this.next = next;
		}

		public String toString(){
			return Long.toString(this.value);
		}

	}

	public int length;
	public int test;
	private Item root;

	public MyList(){
		this.length = 0;	
		this.root = null;
	}

	public void Push(int pValue){
		Item newItem = new Item(pValue);
		Item pCurrent = this.end();
		if (pCurrent == null) 
			this.root = newItem;
		else 
			pCurrent.setNext(newItem);
		this.length += 1;
	}

	public Item end(){
		if (this.root == null)
			return null;
		Item p = this.root;
		while (p.hasNext()) {
			p = p.getNext();
		}
		return p;
	}

	public int Get(int index){
		Item p = root;
		for (int i = 0; i<index; i++){
			p = p.getNext();
		}
		int res = p.getValue();
		return res;
	}

	public int Remove(int index){
		if (index == 0){
			int res = root.getValue();
			root = root.getNext();
			this.length -= 1;
			return res;
		}
		Item p = root;
		for (int i = 0; i<index-1; i++){
			p = p.getNext();
		}
		Item q = p.getNext();
		int res = q.getValue();
		p.setNext(q.getNext());
		this.length -= 1;
		return res;
	}

	public String toString(){
		String res = "[ ";
		if (this.root == null){
			return null;
		}
		else {
			Item p = this.root;
			while (p.hasNext()) {
				res += p.toString() + ", ";
				p = p.getNext();
			}
			res += p.toString();
		}
		res += " ]";
		return res;
	}

	public void Swap(int firstPos, int secondPos){
		
		if (firstPos > secondPos) {
			int tmp = firstPos;
			firstPos = secondPos;
			secondPos = tmp;
		}
		if (firstPos >= 0) {
            Item lp = indexAt(firstPos - 1);
            Item first = indexAt(firstPos);
            Item rp = indexAt(firstPos + 1);
            Item lq = indexAt(secondPos - 1);
            Item second = indexAt(secondPos);
            Item rq = indexAt(secondPos + 1);

            if (lp != null) {
                lp.setNext(second);
            }
            else {
                this.root = second;
            }
		
            first.setNext(rq);
		
            if (lq == first) {
                second.setNext(first);
            }
            else {
                second.setNext(rp);
                lq.setNext(first);
            }
        }
	}
	public void sort() {
		int k = 0;
		Item one;
		Item two;
		boolean thatsAll = true;
		while (thatsAll) {
			for (int i = 1; i <= this.counter - 1; i++) {
				one = indexAt(i - 1);
				two = indexAt(i);
				if (two.getValue() < one.getValue()) {
					swap(i - 1, i);
					k++;
				}

			}
			if (k == 0)
				thatsAll = false;
			k = 0;

		}
	}


	public Item indexAt(int index){
		if ((index <= this.length - 1) & (index >= 0)){
			Item p = root;
			for (; index>0; --index){
				p = p.getNext();
			}
			return p;
		}
		else
			return null;
	}

}
