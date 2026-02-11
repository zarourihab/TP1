package app;

import util.Connexion;
import java.sql.Connection;

public class TestConnexion {
    public static void main(String[] args) {

        try {
            Connection con = Connexion.getInstance().getConnection();

            System.out.println("✅ Checkpoint réussi : connexion établie !");
            System.out.println("Base : " + con.getCatalog());

        } catch (Exception e) {
            System.out.println("❌ Checkpoint échoué !");
            e.printStackTrace();
        }

    }
}

