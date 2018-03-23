import dao.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        CompanyEntity contactEntity = new CompanyEntity();
//        System.out.println(contactEntity.getEmployee());
        Query query = session.createQuery("from CompanyEntity where id = :id");
        query.setParameter("id", 2);
        List<CompanyEntity> list = query.list();
        for (CompanyEntity c:
             list) {
            System.out.println(c.getEmployee());
        }
//        contactEntity.setLastName("VN");
//        session.save(contactEntity);
        session.getTransaction().commit();
        session.close();
        HibernateSessionFactory.shutdown();
    }
}
