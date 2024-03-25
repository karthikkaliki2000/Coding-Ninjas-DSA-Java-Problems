package hashmap;

import java.util.ArrayList;
//VV Impoertant in interviews
public class Map<K,V> {
	ArrayList<MapNode<K,V>> bucket;
	int count;
	int bucketNum;
	public Map() {
		bucket=new ArrayList<>();
		bucketNum=5;
		for(int i=0;i<bucketNum;i++) {
			bucket.add(null);
		}
	}
	public int size() {
		return count;
	}
	public V getValue(K key) {
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head=bucket.get(bucketIndex);
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head=head.next;
		}
		return null;
		
	}
	public V removeKey(K key) {
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head=bucket.get(bucketIndex);
		MapNode<K,V> prev=null;
		while(head!=null) {
			if(head.key.equals(key)) {
				if(prev!=null) {
					prev.next=head.next;
				}
				else {
					bucket.set(bucketIndex, head.next);
				}
				count--;
				return head.value;
				
			}
			prev=head;
			head=head.next;
		}
		return null;
	}
	public void insert(K key,V value) {
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head=bucket.get(bucketIndex);
		//element is already there just update
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value=value;
			}
			head=head.next;
		}
		//element is not there just insert at 0th position
		head=bucket.get(bucketIndex);
		MapNode<K,V> node=new MapNode<>(key,value);
		node.next=head;
		bucket.set(bucketIndex, node);
		count++;
	//	double loadFactor=(1.0*bucketNum)/count;
		if(loadFactor()>0.7) {
			//System.out.println("Out of memory"+loadFactor());
			rehash();
		}
		
	}
	private void rehash() {
		// TODO Auto-generated method stub
		ArrayList<MapNode<K,V>> temp;
		temp=bucket;
		bucket=new ArrayList<>();
		for(int i=0;i<2*bucketNum;i++) {
			bucket.add(null);
		}
		count=0;
		bucketNum=2*bucketNum;
		for(int i=0;i<temp.size();i++) {
		     MapNode<K,V> head=temp.get(i);
		     while(head!=null) {
		    	 K key=head.key;
		    	 V value=head.value;
		    	 insert(key, value);
		    	 head=head.next;
		     }
		}
		
		
	}
	public double loadFactor() {
		
		return (1.0*count)/bucketNum;
	}
	private int getBucketIndex(K key) {
		// TODO Auto-generated method stub
		
		return key.hashCode()%bucketNum;
	}
	

}
