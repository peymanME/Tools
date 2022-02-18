# Hibernate 


## SessionFactory from EntityManager
```java 
    org.hibernate.Session session = em.unwrap(org.hibernate.Session.class);
    org.hibernate.SessionFactory sessionFactory = session.getSessionFactory();
```
