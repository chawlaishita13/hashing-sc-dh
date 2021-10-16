import java.lang.Math;
class HashEntry<K,T>
{
    K key;
    T value;    
 
}

public class DHgeneric<K,T> implements MyHashTable_<K,T> {
	private int size;
	private HashEntry<K,T>[] table;
	public DHgeneric(int cap) {
		size=cap;
		createTable();
	}
	
	private void createTable( ) { 
		table=new HashEntry[size];
		for(int i=0;i<size;i++) {
			table[i]=new HashEntry<K,T>();
		}
		
	}
	
	public int insert(K key, T obj) {
		int i=0;
		
		while(i<size) {
			 long h=hashValue(i,key);
			if(table[(int)h].key==null) {
				
				table[(int)h].key=key;
				table[(int)h].value=obj;
				return i+1;
			}
			else {
				i++;
			}
		}
		
		return i;

	}
	
	
	public int update(K key, T obj) {
		int i=0;
		boolean flag=false;;
		while(i<size) {
			long h=hashValue(i,key);
			
			if(table[(int )h].key!= null && table[(int)h].key.toString().equals(key.toString())) {
				table[(int)h].value=obj;
				flag=true;
				break;
			}
			else {
				i++;
			}
		}
		if(flag==true)
			return i+1;
		else
			return 0;

	}
	

	public int delete(K key) {
		int i=0;
		boolean flag=false;
		while(i<size) {
			long h=hashValue(i,key);
			if(table[(int )h].key!= null && table[(int)h].key.toString().equals(key.toString())) {
				table[(int)h].key=null;
				table[(int)h].value=null;
				flag=true;
				break;
				}
			else {
				i++;
				}
			}
		if(flag==true)
			return i+1;
		else
			return 0;
	}
	
	
	
	public boolean contains(K key) {
		int i=0;
		while(i<size) {
			long h=hashValue(i,key);
			if(table[(int )h].key!= null && table[(int)h].key.toString().equals(key.toString())) {
				return true;
				}
			else {
				i++;
				}
			}
		return false;
	}
	
	public T get(K key) throws NotFoundException {
		try {
		if(contains(key)) {
		int i=0;
		while(i<size) {
			long h=hashValue(i,key);
			if(table[(int)h].key!=null && table[(int)h].key.toString().equals(key.toString())) {
				return table[(int)h].value;
				}
			else {
				i++;
				}
			}
		return null;
		}
		else {
			throw new NotFoundException();
		}
		}
		catch(NotFoundException e) {
			System.out.println("E");
			return null;
		}
		//return e;
		
	}
	
	public String address(K key) throws NotFoundException{
		try {
			if(contains(key)) {
		int i=0;
		while(i<size) {
			long h=hashValue(i,key);
			if(table[(int)h].key!=null && table[(int)h].key.toString().equals(key.toString())) {
				return String.valueOf(h);
				}
			else {
				i++;
				}
			}
		return null;
			}
			else {
				throw new NotFoundException();
			}
			}
			catch(NotFoundException e) {
				System.out.println("E");
				return null;
			}
		//return e;
	}

	
	private long hashValue(int i,K key) 
	{ 	
		return  (djb2(key.toString(),size)+i*sdbm(key.toString(),size))%size;
	 }
	
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
	
	public static long sdbm(String str, int hashtableSize) { 
	    long hash = 0; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
	    } 
	    return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}
}



