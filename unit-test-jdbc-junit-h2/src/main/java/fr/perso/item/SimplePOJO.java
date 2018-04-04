/**
 *
 */
package fr.perso.item;

/**
 * @author cnoiray
 */
public class SimplePOJO {

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
        return "SimplePOJO{" + "id=" + id + ", title='" + title + '\'' + '}';
    }
}