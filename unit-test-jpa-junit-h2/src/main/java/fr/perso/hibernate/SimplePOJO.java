/**
 *
 */
package fr.perso.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author cnoiray
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = "SimplePOJO.getAll", query = "SELECT b FROM SimplePOJO b") })
public class SimplePOJO {

    @Id
    private Integer id;
    private String title;

    public SimplePOJO() {
    }

    public SimplePOJO(final Integer id, final String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + '}';
    }
}
