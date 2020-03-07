import entities.Book;
import hibernateSessionFactory.HibernateSessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.Random;


/**
 * @author Capistrano Prestes
 * @date 3/6/2020
 * This a client class invoking a hibernate instance.
 * It sends Database requests to hibernate which handles it in different methods.
 *
 * Database Operations performed:
 * Insert (single entity)
 * Insert (list of entities)
 * Update
 * Delete
 * Select
 *
 *
 * sources:
 * https://www.baeldung.com/hibernate-criteria-queries
 * https://docs.jboss.org/hibernate/stable/entitymanager/reference/en/html/querycriteria.html#querycriteria-typedquery-entity
 *
 */
public class Main {


    /**
     * Main method to execute all database operations
     * @param args
     */
    public static void main(String[] args) {
        try {
            //Create a random book for Tests
            Book testBook = createNewBook("Author 1", "How to program Java " + new Random().nextInt());

            //INSERT OPERATION
            insertSingleBookWithHibernate(testBook);

            //SELECT OPERATION
            testBook = selectSingleBookWithHibernate(testBook);

            //UPDATE OPERATION
            updateBookWithHibernate(testBook.getBookId(), "New Author Updated");
            testBook = selectSingleBookWithHibernate(testBook);

            //DELETE OPERATION
            deleteBookWithHibernate(testBook);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 1) Creates a db session with hibernate
     * 2) Create a hibernate criteria and criteria query
     * 3) adds Book entity as a reference for the criteria
     * 4) Selects the book title (adding the title as a criteria)
     * 5) adds query to session
     * 6) selects single result
     * 7) prints result into the console
     * @param book
     * @return Book entity
     */
    public static Book selectSingleBookWithHibernate(Book book){
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root).where(builder.equal(root.get("bookTitle"), book.getBookTitle()));
        Query q = session.createQuery(query);
        Book selectedBook = (Book) q.getSingleResult();
        System.out.println( String.format("\n Select Single Book With Hibernate bookId: %d, bookAuthor: %s, bookTitle: %s \n",
                                           selectedBook.getBookId(), selectedBook.getBookAuthor(), selectedBook.getBookTitle()));
        session.close();
        return selectedBook;
    }

    /**
     * 1) Creates a db session with hibernate
     * 2) Create a hibernate criteria and criteria update
     * 3) adds Book entity as a reference for the criteria update
     * 4) Set the new field value
     * 5) adds Where clausule to criteria
     * 6) selects single result
     * 7) prints result into console
     * @param bookIdToUpdate
     * @param newAuthor
     */
    public static void updateBookWithHibernate(int bookIdToUpdate, String newAuthor){
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<Book> criteriaUpdate = builder.createCriteriaUpdate(Book.class);
        Root<Book> root = criteriaUpdate.from(Book.class);
        criteriaUpdate.set("bookAuthor", newAuthor);
        criteriaUpdate.where(builder.equal(root.get("bookId"), bookIdToUpdate));
        session.beginTransaction();
        session.createQuery(criteriaUpdate).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * 1) Creates a db session with hibernate
     * 2) Create a hibernate criteria and delete criteria
     * 3) adds Book entity as a reference for the criteria update
     * 4) adds Where clause to delete criteria
     * 5) execute transaction
     * @param bookToDelete
     */
    public static void deleteBookWithHibernate(Book bookToDelete){
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaDelete<Book> criteriaDelete = builder.createCriteriaDelete(Book.class);
        Root<Book> root = criteriaDelete.from(Book.class);
        criteriaDelete.where(builder.equal(root.get("bookId"), bookToDelete.getBookId()));
        session.beginTransaction();
        session.createQuery(criteriaDelete).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * 1) Creates a db session with hibernate
     * 2) persist the entity to the database
     * @param book
     */
    public static  void insertSingleBookWithHibernate(Book book){
            Session session = HibernateSessionUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();
            session.close();
    }

    /**
     * Just a simple method to create an entity
     * @param author
     * @param title
     * @return
     */
    private static Book createNewBook(String author, String title){
        Book book = new Book();
        book.setBookAuthor(author);
        book.setBookTile(title);
        return book;
    }


}
