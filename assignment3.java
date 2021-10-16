import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class assignment3 {
	public static void main(String[] args) throws IOException, NotFoundException {
		BufferedReader br=new BufferedReader(new FileReader(args[2]));
        String line = br.readLine();
        
        if(args[1].equals("DH")) {
        	DHgeneric<Pair,Student> map=new DHgeneric<>(Integer.valueOf(args[0]));	
        while(line!=null) {
        	  String[] words = line.split(" ");
        	  Pair p=new Pair(words[1],words[2]);
        	  if(words[0].equals("insert")) {
        		  Student stu = new Student(words[1],words[2],words[3],words[4],words[5]);
        		  System.out.println(map.insert(p, stu));
        		  
        	  }
        	  if(words[0].equals("update")) {
        		  Student stu = new Student(words[1],words[2],words[3],words[4],words[5]);
        		  int a=map.update(p, stu);
        		  if(a!=0)
        			  System.out.println(a);
        		  else
        			  System.out.println("E");
        		  
        	  }
        	  if(words[0].equals("delete")) {
        		  int a=map.delete(p);
        		  if(a!=0)
        			  System.out.println(a);
        		  else
        			  System.out.println("E");
        	  }
        	  if(words[0].equals("get")) {
        		  if ((map.get(p))!=null) {
        		  Student stu = map.get(p);
        		  System.out.println(stu.fname()+" "+stu.lname()+" "+stu.hostel()+ " "+ stu.department()+" "+stu.cgpa());
        		  }
        	  }       	  
        	  if(words[0].equals("address")) {
        		  if (map.address(p)!=null)
        			  System.out.println(map.address(p));
        	  }
        	  if(words[0].equals("contains")) {
        		  boolean b = map.contains(p);
        		  if(b==true)
        			  System.out.println("T");
        		  else
        			  System.out.println("F");
        	  }        	  
        	  line=br.readLine();
        }
        }
		
        
        
        else if(args[1].equals("SCBST")) {
        	SCgeneric<Pair,Student> map = new SCgeneric(Integer.valueOf(args[0]));
        
        	while(line!=null) {
          	  String[] words = line.split(" ");
          	  Pair p=new Pair(words[1],words[2]);
          	  if(words[0].equals("insert")) {
          		  Student stu = new Student(words[1],words[2],words[3],words[4],words[5]);
          		  System.out.println(map.insert(p, stu));
          		  
          	  }
          	  if(words[0].equals("update")) {
          		  Student stu = new Student(words[1],words[2],words[3],words[4],words[5]);
          		  int a=map.update(p, stu);
          		  if(a!=0)
          			  System.out.println(a);
          		  else
          			  System.out.println("E");
          		  
          	  }
          	  if(words[0].equals("delete")) {
          		  int a=map.delete(p);
          		  if(a!=0)
          			  System.out.println(a);
          		  else
          			  System.out.println("E");
          	  }
          	  if(words[0].equals("get")) {
          		  Student s=map.get(p);
          		  if (s!=null) {
          		  
          			  System.out.println(s.fname()+" "+s.lname()+" "+s.hostel()+ " "+ s.department()+" "+s.cgpa());
          		  }
          		  else
          			  System.out.println("E");
          	  }       	  
          	  if(words[0].equals("address")) {
          		  if (map.address(p)!=null)
          			  System.out.println(map.address(p));
          	  }
          	  if(words[0].equals("contains")) {
          		  boolean b = map.contains(p);
          		  if(b==true)
          			  System.out.println("T");
          		  else
          			  System.out.println("F");
          	  }        	  
          	  line=br.readLine();
        	
        }
        }
	}
	
}
