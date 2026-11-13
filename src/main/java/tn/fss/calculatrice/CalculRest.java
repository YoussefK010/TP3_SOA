package tn.fss.calculatrice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Map;

/** Ressource REST : /api/calcul/... */
@Path("/calcul")
@Produces(MediaType.APPLICATION_JSON)
public class CalculRest {

    private final Calculatrice calc = new Calculatrice();

    @GET
    @Path("/addition")
    public Response addition(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        return executer("addition", a, b);
    }

    @GET
    @Path("/soustraction")
    public Response soustraction(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        return executer("soustraction", a, b);
    }

    @GET
    @Path("/multiplication")
    public Response multiplication(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        return executer("multiplication", a, b);
    }

    @GET
    @Path("/division")
    public Response division(@QueryParam("a") Double a, @QueryParam("b") Double b) {
        return executer("division", a, b);
    }

    private Response executer(String op, Double a, Double b) {
        if (a == null || b == null) {
            return erreur("Paramètres a et b obligatoires");
        }
        try {
            double r;
            switch (op) {
                case "addition":       r = calc.addition(a, b); break;
                case "soustraction":   r = calc.soustraction(a, b); break;
                case "multiplication": r = calc.multiplication(a, b); break;
                default:               r = calc.division(a, b);
            }
            return Response.ok(new Operation(op, a, b, r)).build();
        } catch (IllegalArgumentException e) {
            return erreur(e.getMessage());
        }
    }

    private Response erreur(String message) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(Map.of("erreur", message)).build();
    }
}
