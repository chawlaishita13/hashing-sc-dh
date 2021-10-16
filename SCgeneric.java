
public class SCgeneric<K,T> implements MyHashTable_<K,T> {
	
	private int size;
	private BSTgeneric<K,T>[] table;
	public SCgeneric(int cap) {
		size=cap;
		createTable();
	}
	
	private void createTable( ) { 
		table=new BSTgeneric[size];
		for(int i=0;i<size;i++) {
			table[i]=new BSTgeneric<K,T>();
		}
	}

	
	public int insert(K key, T obj) {
		long h=hashValue(key);
		int count=table[(int)h].addNode(key,obj);
		   return count;
	}

	public int update(K key, T obj) {
		long h=hashValue(key);
		   int count=table[(int)h ].update(key, obj);
		   return count;
	}

	
	public int delete(K key) {
		long h=hashValue(key);
		   int count=table[(int)h].removeNode(key);
		   return count;
	}

	
	public boolean contains(K key) {
		long h=hashValue(key);
		   return table[(int)h].contains(key);
	}

	public T get(K key) throws NotFoundException {
		long h=hashValue(key);
		   T s=table[(int) h].getNode(key);
		   return s;
	}

	public String address(K key) throws NotFoundException {
		long index=hashValue(key);
		   String bstseq=table[(int)index].address(key);
		   if(table[(int)index].contains(key))
			   return index+"-"+bstseq;
		   else
			   return bstseq;
	}
	
	private long hashValue(K key) 
	{ 	
		return  djb2(key.toString(),size);
	 }
	
	 
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}

	

}
