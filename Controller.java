
public class Controller {

    private static Window w;

    public static void main (String[] args) {
        w = new Window();
    }

    public static Window getWindowInstance() {
        return w;
    }

    public static boolean attemptLogin (String loginName, String password) {
        //appel a la BD pour verifier credentials

        //Hibernate doit retourner un boolean si ca a marche ou non, et si non un message d'erreur aussi
        return true;
    }


    public static boolean searchMovie (String chaineNomFilm, int anneeMin, int anneeMax,
                                       String[] nomPaysProduction, String[] langueOriginale, String[] genreFilm,
                                       String[] nomActeur, String[] nomRealisateur)
    {
        //appel a la BD pour recherche de films

        /*doit retourner tous les films qui matchent, avec ces infos :
        • Le titre du film ;
        • L’annee de sortie du film ; ´
        • Le nom de tous les pays de production ;
        • La langue originale du film ;
        • La duree du film (en minutes) ; ´
        • La liste de tous les genres du film ;
        • Le nom du realisateur ; ´
        • Le nom de tous les scenaristes ; ´
        • Le nom de tous les acteurs et de leur(s) personnage(s) dans le film ;
        • Le resume du scenario du film
        */
        //ces infos seront utilsees pour creer des objets film


        //ce serait aussi utile de donner le nombre de films en stock
        return true;
        //retourner un false si aucun film n'est trouve
    }

    public static String infosPersonne (String nomPersonne) {
        //appel a la BD pour infos sur une personne (ex. acteur)
        /* doit retourner ces infos
        • Son nom (prenom et nom de famille) ; <-- on l'a deja  mais c'est plus simple pour moi de l'envoyer si possible
        • Sa date de naissance ;
        • Son lieu de naissance ;
        • Une courte biographie sur cette personne.
         */
        return "";
        //cette methode ne devrait pas avoir de cas ou elle ne marche pas
    }

    public static boolean locationFilm (String titreFilm, String loginName) {
        //appel a la BD pour verifier que le  forfait permet la location et qu<un film est disponible

        //si oui, retourner true, si non false
        return true;
    }



}
