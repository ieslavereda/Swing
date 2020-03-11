package frames;

import java.io.Serializable;

public class Queue<T> implements Serializable {

	private int size;
	private Nodo<T> head;
	private Nodo<T> tail;

	public Queue() {
		size = 0;
		head = null;
		tail = null;
	}
	
	public boolean remove(Nodo<T> n) {
		boolean eliminado=false;
		Nodo<T> aux = head;
		
		while(aux!=n && aux!=null)
			aux=aux.getNext();
		
		if(aux!=null) {
			// comprobamos si es la cabeza
			if(head==tail) {
				head=null;
				tail=null;
			}else if(aux==head){
				head = aux.getNext();
				head.setPrev(null);
			}else if(aux==tail) {
				tail = aux.getPrev();
				tail.setNext(null);
			}else {
				aux.getNext().setPrev(aux.getPrev());
				aux.getPrev().setNext(aux.getNext());
			}
			size--;
			eliminado=true;
		}	
		
		return eliminado;
	}
	
	public void add(T info) {

		Nodo<T> n = new Nodo<T>(info);

		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			n.setPrev(tail);
			tail = n;
		}
		
		size++;
	}
	
	public Nodo<T> getHead(){
		return head;
	}

}