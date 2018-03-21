/**
 *
 */
package fr.perso.hibernate;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class JPAHibernateSimplePOJOTest extends JPAHibernateTest {

    @Test
    public void testGetObjectById_success() {
        final SimplePOJO pojo = em.find(SimplePOJO.class, 1);
        assertNotNull(pojo);
    }

    @Test
    public void testGetAll_success() {
        final List<SimplePOJO> pojos = em.createNamedQuery("SimplePOJO.getAll", SimplePOJO.class).getResultList();
        assertEquals(1, pojos.size());

        assertTrue(1 == pojos.get(0).getId());
        assertEquals("Test 1 simple pojo", pojos.get(0).getTitle());
    }

    @Test
    public void testPersist_success() {
        em.getTransaction().begin();
        em.persist(new SimplePOJO(2, "Test 2 simple pojo persist"));
        em.getTransaction().commit();

        final List<SimplePOJO> pojos = em.createNamedQuery("SimplePOJO.getAll", SimplePOJO.class).getResultList();

        assertNotNull(pojos);
        assertEquals(2, pojos.size());

        assertTrue(1 == pojos.get(0).getId());
        assertEquals("Test 1 simple pojo", pojos.get(0).getTitle());

        assertTrue(2 == pojos.get(1).getId());
        assertEquals("Test 2 simple pojo persist", pojos.get(1).getTitle());
    }

    @Test
    public void testDelete_success() {
        final SimplePOJO pojo = em.find(SimplePOJO.class, 1);

        em.getTransaction().begin();
        em.remove(pojo);
        em.getTransaction().commit();

        final List<SimplePOJO> pojos = em.createNamedQuery("SimplePOJO.getAll", SimplePOJO.class).getResultList();

        assertEquals(0, pojos.size());
    }
}