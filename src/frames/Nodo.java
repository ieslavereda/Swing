package frames;

import java.io.Serializable;

public class Nodo<T> implements Serializable{

	private T info;
	private Nodo<T> next;
	private Nodo<T> prev;
	
	public Nodo(T info) {
		this.info=info;
		this.next=null;
		this.prev=null;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}	

	public Nodo<T> getPrev() {
		return prev;
	}

	public void setPrev(Nodo<T> prev) {
		this.prev = prev;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return  info.toString() ;
	}	
}