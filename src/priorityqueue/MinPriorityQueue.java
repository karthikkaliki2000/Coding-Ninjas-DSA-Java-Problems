package priorityqueue;

import java.util.ArrayList;

public class MinPriorityQueue<T> {
    ArrayList<Element<T>> heap;
    public MinPriorityQueue() {
    	heap=new ArrayList<>();
    	
    }
    public void insert(T data,int priority) {
    	Element<T> e=new Element<>(data,priority);
    	heap.add(e);
    	int childIndex=heap.size()-1;
    	int parentIndex=(childIndex-1)/2;
    	while(childIndex>0) {
    		if(heap.get(childIndex).priority<heap.get(parentIndex).priority) {
    			Element temp=heap.get(childIndex);
    			heap.set(childIndex, heap.get(parentIndex));
    			heap.set(parentIndex, temp);
    			childIndex=parentIndex;
    			parentIndex=(childIndex-1)/2;
    		}
    		else {
    			return;
    		}
    	}
    }
    public T deleteMin() throws PQException {

    	if(size()==0) {
    		throw new PQException();
    	}
    	Element<T> removed=heap.get(0);
    	T ans=removed.data;
    	heap.set(0, heap.get(heap.size()-1));
    	heap.remove(heap.size()-1);
    	int parentIndex=0;
    	int LchildIndex=2*parentIndex+1;
    	int RchildIndex=2*parentIndex+2;
    	while(LchildIndex < heap.size()) {
	    	int minIndex=parentIndex;
	    	if(heap.get(LchildIndex).priority<heap.get(minIndex).priority) {
	    		minIndex=LchildIndex;
	    	}
	    	if(RchildIndex< heap.size()  && heap.get(RchildIndex).priority<heap.get(minIndex).priority) {
	    		minIndex=RchildIndex;
	    	}
	    	if(parentIndex==minIndex) {
	    		break;
	    	}
	    	Element temp=heap.get(minIndex);
	    	heap.set(minIndex, heap.get(parentIndex));
	    	heap.set(parentIndex, temp);
	    	parentIndex=minIndex;
	    	LchildIndex=2*parentIndex+1;
	    	RchildIndex=2*parentIndex+2;
	    	
    	}
    	return ans;
    	
    	
    }
    public T getMin() throws PQException {
    	if(size()==0) {
    		throw new PQException();
    	}
    	return heap.get(0).data;
    }
    public int size() {
    	return heap.size();
    }
    public boolean isEmpty() {
    	if(size()==0) {
    		return true;
    	}
    	return false;
    }
}
