package org.example.repo;

public class productRepo {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(Product product) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    public List<Product> findAll() {
        Session session = factory.openSession();
        List<Product> list = session.createQuery("from Product", Product.class).list();
        session.close();
        return list;
    }
}
