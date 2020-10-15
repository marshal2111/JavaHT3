package lab2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;	

public class MyList<T> implements Collection<T> {
	class Node<T>{
		private T value;
		private Node<T> next;

		public Node(T value){
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

		public Node<T> getNext(){
			return next;
		}

		public void setNext(Node<T> next){
			this.next = next;
		}

		@Override
		public String toString() {
			return value.toString();
		}

	}

	public int length;
	private Node<T> root;
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

	public Node end(){
		if (this.root == null)
			return null;
		Node<T> p = this.root;
		while (p.hasNext()) {
			p = p.getNext();
		}
		return p;
	}

	public T Get(int index){
		Node<T> p = root;
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
		Node<T> newNode = new Node<T>(pValue);
		Node<T> iter = this.end();
		if (iter == null) 
			this.root = newNode;
		else 
			iter.setNext(newNode);
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

    public String toString() {
		String result = "[";
		if (this.root == null) {
			return null;
		}
		else {
			Node<T> iter = this.root;
			while (iter.hasNext()) {
				result += iter.toString() + ", ";
				iter = iter.getNext();
			}
			result += iter.toString();
		}
		result += "]";
		return result;
	}

	public void Swap(int firstPos, int secondPos){
		
		if (firstPos > secondPos) {
			int tmp = firstPos;
			firstPos = secondPos;
			secondPos = tmp;
		}
		if (firstPos >= 0) {
            Node<T> lp = indexAt(firstPos - 1);
            Node<T> first = indexAt(firstPos);
            Node<T> rp = indexAt(firstPos + 1);
            Node<T> lq = indexAt(secondPos - 1);
            Node<T> second = indexAt(secondPos);
            Node<T> rq = indexAt(secondPos + 1);

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
	
	public void Sort(){
		int z = this.getLength();
		while (z > 0){
			for (int i = 0; i < z - 1; i++)
			{
				Node <T> a = indexAt(i);
				Node <T> b = indexAt(i+1);
				if (comp.compare(a, b) > 0)
				{
					this.Swap(i, i + 1);
				}
			}
			z--;
		}
	}

	public Node indexAt(int index){
		if ((index <= this.length - 1) & (index >= 0)){
			Node<T> p = root;
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
    int compare(MyList.Node a, MyList.Node b);
}
