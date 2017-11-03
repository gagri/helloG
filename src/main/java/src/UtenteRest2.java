package src;

import com.google.gson.Gson;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class UtenteRest2 extends ServerResource {
	
	
	public static ArrayList<Utente> utenti;

	@Get
	public String getUtente() throws SQLException, Exception{
		Gson gson=new Gson();
		
		String s1 = null;
	/*	Database db=null;
		db=Database.getDatabase();
		Utente u=db.getUtente(this.getAttribute("UsernameU"), this.getAttribute("PasswordU")); */
		
		
		String username=this.getAttribute("UsernameU");
		String password=this.getAttribute("PasswordU");
		
		 BufferedReader r = new BufferedReader(new FileReader("db.txt"));
		    
		    String s;
		 //   System.out.println(s);
		    while(r.ready()){
		    	s=r.readLine();
			 gson=new Gson();
			 
				 Utente newUtente=gson.fromJson(s, Utente.class);
				 System.out.println(newUtente.toString());
				 utenti=new ArrayList<>();
				 utenti.add(newUtente);
			    }
		    
		   for(int i=0; i<utenti.size();i++){
			   if(utenti.get(i).getUsernameU().equalsIgnoreCase(username) && utenti.get(i).getPasswordU().equalsIgnoreCase(password)){
				 s1= gson.toJson(utenti.get(i), Utente.class);
				 
			   }else{
				  s1=null;
			   }
		   }
		

		return s1;
	}
	
	
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
