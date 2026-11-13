package tn.fss.calculatrice;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/** Active JAX-RS : toutes les ressources sont accessibles sous /api */
@ApplicationPath("/api")
public class RestApplication extends Application {
}
