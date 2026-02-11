package app;

import dao.EmployeDao;
import entities.Employe;

public class TestEmployeDao {
    public static void main(String[] args) {
        try {
            EmployeDao dao = new EmployeDao();

            // 1️⃣ Test INSERT
            Employe e = new Employe("Sara", "Ingénieur");
            int id = dao.insert(e);

            System.out.println("ID généré = " + id);
            System.out.println("Objet après insert, id = " + e.getId());

            // 2️⃣ Test FIND BY ID
            Employe fromDb = dao.findById(id);
            System.out.println("Employe trouvé = " 
                    + fromDb.getNom() + " - " + fromDb.getPoste());

            // 3️⃣ Test UPDATE
            fromDb.setPoste("Chef Ingénieur");
            boolean up = dao.update(fromDb);
            System.out.println("Update réussi ? " + up);

            // 4️⃣ Test FIND ALL
            System.out.println("---- Liste complète ----");
            for (Employe emp : dao.findAll()) {
                System.out.println(emp.getId() + " | "
                        + emp.getNom() + " | "
                        + emp.getPoste());
            }

            // 5️⃣ Test DELETE
            boolean del = dao.delete(id);
            System.out.println("Delete réussi ? " + del);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
