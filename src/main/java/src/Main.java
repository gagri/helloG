package src;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class Main extends Application {


    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance appropriate ServerResource.
        Router router = new Router(getContext());
        router.attach("/audio//storage/sdcard0/{fname}", AudioResource.class);
        router.attach("/utente/{UsernameU}&{PasswordU}", UtenteRest2.class);//GET
        //router.attach("/utenteRegistrato/{UsernameU}&{PasswordU}", UtenteRest.class);//POST


        return router;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            // Create a new Component.
            Component component = new Component();
            // Add a new HTTP server listening on port 8182.
            component.getServers().add(Protocol.HTTP, 8182);
            // Attach the sample application.
            component.getDefaultHost().attach(new Main());

            // Start the component.
            component.start();
        } catch (Exception e) {	  // Something is wrong.
            e.printStackTrace();
        }



    }

}