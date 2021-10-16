

public class BSTgeneric<K,T> {
	class Node {
		T data;
		Node left;
		Node right;
		K datakey;
	}

	private Node root;
	public T getNode(K key) {
		return getNode(key,root);
	}
	
	private T getNode(K key,Node node) {
		try {
			if(contains(key)) {
		if((key.toString().equals(node.datakey.toString()))){
			return node.data;
		}
		else if(key.toString().compareTo(node.data.toString())>0) {
			return getNode(key,node.right);
		}
		else
			return getNode(key,node.left);
	}
			else {
				throw new NotFoundException();
			}
		}
		catch(NotFoundException e){
			return null;
		}
	}
	
	public boolean contains(K key) {
		return contains(key,root);
	}
	
	private boolean contains(K key,Node node) {
		if(node==null) {
			return false;
		}
		
		if(key.toString().equals(node.datakey.toString()))
			return true;
		
		else if(key.toString().compareTo(node.data.toString())>0) {
			return contains(key,node.right);}
		
		else {
			return contains(key,node.left);}
		
		
	}
	
	public int addNode(K key ,T item) {
		if(root==null) {
			Node nn=new Node();
			nn.data=item;
			nn.datakey=key;
			root=nn;
			return 1;
		}
		else
			return 1+addNode(key,item, root);
		
	}

	private int addNode(K key,T item, Node node) {
		if (node == null) {
			return 1;
		}
		
		else if (item.toString().compareTo(node.data.toString()) > 0) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				nn.datakey=key;
				node.right = nn;
				return 1;
			} else
				return 1+addNode(key,item, node.right);
			
		}
		
		else if(item.toString().compareTo(node.data.toString()) < 0) {
			
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				nn.datakey=key;
				node.left = nn;
				return 1;
			} else
				return 1+addNode(key,item, node.left);
		}
		
		else {
			if(key.toString().compareTo(node.datakey.toString()) < 0) {
				if (node.left == null) {
					Node nn = new Node();
					nn.data = item;
					nn.datakey=key;
					node.left = nn;
					return 1;
				} else
					return 1+addNode(key,item, node.left);
			}
			else {
				if (node.right == null) {
					Node nn = new Node();
					nn.data = item;
					nn.datakey=key;
					node.right = nn;
					return 1;
				} else
					return 1+addNode(key,item, node.right);
				
			}
		}
		
		}
	
	class p{
		Node pnode;
		int count;
	}
	private p max(Node node,p pair) {
		if (node.right == null) {
			pair.pnode=node;
			return pair;
			
		}
		pair.count++;
		pair = max(node.right,pair);
		return pair;

	}
	
	
	
	public int removeNode(K item) {
		if(!contains(item))
			return 0;
		return removeNode(item,root,root);
	}
	
	private int removeNode(K item,Node node,Node parent) {
		if(node==null)
			return 0;
		
		
		if(item.toString().equals(node.datakey.toString())) {
			
			if(node.left==null&&node.right==null)
			{
				if(node==parent) {
					root=null;
				}
				else if(node==parent.left)
					parent.left=null;
				else
					parent.right=null;
				return 1;
			}
			
			else if(node.left==null && node.right!=null) {
				
				if(node==parent)
					root=node.right;
				
				else if(node==parent.left)
					parent.left=node.right;
				else
					parent.right=node.right;
				return 2;
	
				}
			
			else if(node.left!=null && node.right==null) {
				if(node==parent)
					root=node.left;
				else if(node==parent.left)
					parent.left=node.left;
				else
					parent.right=node.left;
				return 2;
			}
			
			else {
				
				p pair=new p();
				pair.count=1;
				pair=max(node.left,pair);
				K p1=pair.pnode.datakey;
				int a=removeNode(p1,node.left,node);
				node.data=pair.pnode.data;
				node.datakey=pair.pnode.datakey;
				return pair.count+a;
				
				
			}
			
		}
		

		else if(item.toString().compareTo(node.data.toString()) > 0)
			return 1+removeNode(item,node.right,node);
		
		else 
			return 1+removeNode(item,node.left,node);
		
	}
	
	public int update(K key,T obj) {
		if(!contains(key))
			return 0;
		else
			return update(key,obj,root);
	}
	
	private int update(K key,T obj,Node node) {
		if(key.toString().equals(node.datakey.toString())) {
			node.data=obj;
			return 1;
		}
		else if(key.toString().compareTo(node.data.toString()) > 0) {
			return 1+update(key,obj,node.right);
		}
		else
			return 1+update(key,obj,node.left);
	}
	
	public String address(K key) throws NotFoundException {
		return address(key,root);
	}
	
	private String address(K key,Node node) throws NotFoundException {
		try {
			if(contains(key)) {
		
		if((key.toString().equals(node.datakey.toString()))) {
			return " ";
		}
		else if(key.toString().compareTo(node.data.toString()) > 0) {
			return "R"+address(key,node.right);
		}
		else {
			return "L"+address(key,node.left);
		}
			}
			else {
				throw new NotFoundException();
			}
		}
			catch(NotFoundException e) {
				return "E";
			}
	
	
}
}
