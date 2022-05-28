package Michael_Kogan_Ayal_Cohen_Project.Model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;


public class Set<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int size;
	int index;
	private Vector<T> collection;

	public Set() {
		this.size = 10;
		this.index = 0;
		this.setCollection(new Vector<T>(size));

	}
	public Iterator<T> iterator() {
		Iterator<T> iter = this.getCollection().iterator();
		return iter;
	}
	public boolean add(T E) throws Exception  {
		if (!(E instanceof Employee) && !(E instanceof Role) && !(E instanceof Department))  {
			throw new Exception("The element to insert is not from the same type");
		}
		if (E instanceof Employee ) {
			if(this.getCollection().contains(E)) {
				return false;
			}
			this.getCollection().add(index, E);
			this.index++;
			if(index == size) {
				size *= 2;
			}
			return true;
		}
		if (E instanceof Role) {
			if (this.getCollection().contains(E)) {
				return false;
			}
			this.getCollection().add(index, E);
			this.index++;
			if (index == size) {
				size *= 2;		
			}
			return true;
		}
		if (E instanceof Department) {
			if (this.getCollection().contains(E)) {
				return false;
			}
			this.getCollection().add(index, E);
			this.index++;
			if (index == size) {
				size *= 2;
			}
			return true;
		}
		return false;
	}
	public boolean addAll(Vector<T> collection) {
		Iterator<T> iter = (Iterator<T>) collection.iterator();
		while (iter.hasNext()) {
			if (iter == this.getCollection().elementAt(this.index)) {
				return false;
			}
			this.getCollection().add((T)(collection.elementAt(this.index)));
			index++;
			iter.next();
		}
		return false;
	}
	public Vector<T> getCollection() {
		return collection;
	}
	private void setCollection(Vector<T> vector) {
		this.collection = vector;
	}
	public boolean contains(T E) {
		if (E instanceof Employee) {
			if (this.getCollection().contains(E)) {
				return true;
			}
		}if (E instanceof Department) {
			if (this.getCollection().contains(E)) {
				return true;
			}
		}if (E instanceof Role) {
			if (this.getCollection().contains(E)) {
				return true;
			}
		}
		return false;
	}	
	public boolean containsAll(Vector<T> collection) {
		Iterator<T> iter = collection.iterator();
		while (iter.hasNext()) {
			if (!this.getCollection().contains(iter)) {
				return false;
			}
			iter.next();
		}
		return true;
	}	
	public int hashCode() {
		return this.getCollection().hashCode();
	}
	public boolean isEmpty() {
		if (this.getCollection() == null) {
			return true;
		}
		return false;
	}
	public boolean equals(Vector<Object> obj) {
		if (!super.equals(obj))
			return false;

		return this.getCollection().size() == obj.size();
	}	
	public void clear() {
		this.getCollection().clear();
		this.size = 0;
	}
	public boolean remove(T E) {
		if (isEmpty() || !this.getCollection().contains(E)) {
			return false;
		}
		this.getCollection().remove(E);
		this.size--;
		return true;
	}
	public boolean removeAll(Vector<T> collection) {
		Iterator<T> iter = collection.iterator();
		while (iter.hasNext() || this.getCollection().size() == 0) {
			if (this.getCollection().contains(iter)) {
				this.getCollection().remove(iter);
				this.size--;
			}
			iter.next();
		}
		return true;
	}	
	public boolean retainAll(Vector<T> Set) {
		Iterator<T> iter=getCollection().iterator();
		int i=0;//index for set
		while(iter.hasNext() || this.size!=0) {
			if(!this.getCollection().contains(iter)) {
				this.getCollection().remove(i);
				this.size--;
			}
			iter.next();
		}
		return true;
	}	
	public int getSize() {
		return this.size;
	}	
	public Object[] toArray() {
		return this.getCollection().toArray();
	}
}