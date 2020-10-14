package lab2;

import java.util.Collection;
import java.util.Iterator;

public class MyList<T> implements Collection<T> {
	class Item<T>{
		private T value;
		private Item<T> next;

		public Item(T value){
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

		public T getValue(){
			return value;
		}

		public void setValue(T value){
			this.value = value;
		}

		public Item<T> getNext(){
			return next;
		}

		public void setNext(Item<T> next){
			this.next = next;
		}

	}

	public int length;
	private Item<T> root;
	private Comparable comp;

	public MyList(Comparable comp){
		this.length = 0;	
		this.root = null;
		this.comp = comp;
	}

	public int getLength()
	{
		return length;
	}

	public Item end(){
		if (this.root == null)
			return null;
		Item<T> p = this.root;
		while (p.hasNext()) {
			p = p.getNext();
		}
		return p;
	}

	public T Get(int index){
		Item<T> p = root;
		for (int i = 0; i<index; i++){
			p = p.getNext();
		}
		T res = p.getValue();
		return res;
	}

	@Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return (this.root == null ? true : false);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
	public boolean add(T pValue){
		Item<T> newItem = new Item<T>(pValue);
		Item<T> iter = this.end();
		if (iter == null) 
			this.root = newItem;
		else 
			iter.setNext(newItem);
		this.length += 1;

		return true;
	}

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

	public void Swap(int firstPos, int secondPos){
		
		if (firstPos > secondPos) {
			int tmp = firstPos;
			firstPos = secondPos;
			secondPos = tmp;
		}
		if (firstPos >= 0) {
            Item<T> lp = indexAt(firstPos - 1);
            Item<T> first = indexAt(firstPos);
            Item<T> rp = indexAt(firstPos + 1);
            Item<T> lq = indexAt(secondPos - 1);
            Item<T> second = indexAt(secondPos);
            Item<T> rq = indexAt(secondPos + 1);

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
	
	/*public void Sort(){
		int z = this.length;
		while (z > 0){
			for (int i = 0; i < z - 1; i++)
			{
				Item<T> a = indexAt(i);
				Item<T> b = indexAt(i+1);
				if (a.getValue() > b.getValue())
				{
					this.Swap(i, i + 1);
				}
			}
			z--;
		}
	}*/

	public Item indexAt(int index){
		if ((index <= this.length - 1) & (index >= 0)){
			Item<T> p = root;
			for (; index>0; --index){
				p = p.getNext();
			}
			return p;
		}
		else
			return null;
	}

}

interface Comparable {
    int compare(MyList.Item a, MyList.Item b);
}
