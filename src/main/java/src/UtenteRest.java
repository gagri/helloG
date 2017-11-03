package src;

import com.google.gson.Gson;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.*;
import java.util.ArrayList;


public class UtenteRest extends ServerResource{
	
	public static ArrayList<Utente> utenti;

	

	 @Post
	    public String upload(String u) throws ResourceException, IOException {
		 
		 String verifica = null;
			String username=this.getAttribute("UsernameU");

		  BufferedReader br = new BufferedReader(new FileReader("db.txt"));
		  BufferedReader br2 = new BufferedReader(new FileReader("db.txt"));
          PrintWriter w = new PrintWriter(new FileOutputStream("db.txt", true));

		    
		    String s;
		 //   System.out.println(s);
		    while(br.ready()){
		    	s=br.readLine();
			 Gson gson=new Gson();
			 
			 
			 
				 Utente newUtente=gson.fromJson(s, Utente.class);
				 System.out.println(newUtente.toString());
				 utenti=new ArrayList<>();
				 utenti.add(newUtente);
			    }
		    
		   for(int i=0; i<utenti.size();i++){
			   if(utenti.get(i).getUsernameU().equalsIgnoreCase(username)){
				   verifica="no";
			   }else{
				   verifica="ok";
			   }
		   }
		   
		   
		   
		   if(verifica.equalsIgnoreCase("ok")){
			   
			   if(br2.readLine()!=null){
			   String s1=br2.readLine();
	          	
	          	// Utente ut=gson.fromJson(r.readLine(),Utente.class);
	          	// if(!(ut.getUsernameU().equalsIgnoreCase(username))){
	          	      w.write(u);
	                    w.println();
	                    System.out.println(u);}
	                          br2.close();
	                        w.close();
	                        
	     	        return "si";
		   }
		   else return null;
	 }
		 
          
}
	
/*
	 @Post
	    public String upload(String u) throws ResourceException, IOException {
		 
		 Gson gson=new Gson();
		 Gson gson2=new Gson();
		 Utente newUtente=gson.fromJson(u, Utente.class);
	
		 String username=newUtente.getUsernameU();
		 System.out.println(username);
		    BufferedReader r = new BufferedReader(new FileReader("db.txt"));
           PrintWriter w = new PrintWriter(new FileOutputStream("db.txt", true));
           
            if(r.readLine()!=null ){
           	 String s1=r.readLine();
           	
           	// Utente ut=gson.fromJson(r.readLine(),Utente.class);
           	// if(!(ut.getUsernameU().equalsIgnoreCase(username))){
           	      w.write(u);
                     w.println();
                     System.out.println(u);}
                           r.close();
                         w.close();
                         
      	        return "ok";
           	 }
           	*/


   
