# TP3 – Service REST Calculatrice (JAX-RS / Jersey / Tomcat 10.1)

## Build
    mvn clean package        # produit target/calculatrice-rest.war

## Déploiement
Copier `target/calculatrice-rest.war` dans `TOMCAT/webapps/` (Tomcat 10.1+, Java 17+, espace de noms `jakarta.*`), puis démarrer Tomcat.

## Endpoints (GET)
| Opération | URL |
|---|---|
| Addition | http://localhost:8080/calculatrice-rest/api/calcul/addition?a=10&b=5 |
| Soustraction | http://localhost:8080/calculatrice-rest/api/calcul/soustraction?a=10&b=5 |
| Multiplication | http://localhost:8080/calculatrice-rest/api/calcul/multiplication?a=10&b=5 |
| Division | http://localhost:8080/calculatrice-rest/api/calcul/division?a=10&b=5 |

Réponse : `{"operation":"addition","a":10.0,"b":5.0,"resultat":15.0}`
Division par 0 ou paramètre manquant : HTTP 400 `{"erreur":"..."}`.

## Schéma d'architecture
Client (Postman/navigateur) → Tomcat (conteneur de servlets) → Jersey (ServletContainer, routage JAX-RS) → CalculRest → Calculatrice → réponse JSON (Operation)
