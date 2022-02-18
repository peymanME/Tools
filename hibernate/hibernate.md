# Hibernate 
* [SessionFactory from EntityManager](https://github.com/peymanME/Tools/blob/master/hibernate/hibernate.md#sessionfactory-from-entitymanager)

## SessionFactory from EntityManager

* EntityManager’s unwrap() method returns an object of Session type to allow access to database.

em is instance of EntityManager class
```java 
    org.hibernate.Session session = em.unwrap(org.hibernate.Session.class);
    org.hibernate.SessionFactory sessionFactory = session.getSessionFactory();
```
