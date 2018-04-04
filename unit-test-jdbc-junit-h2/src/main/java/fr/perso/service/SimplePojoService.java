/**
 *
 */
package fr.perso.service;

import org.apache.commons.configuration.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author cnoiray
 */
@Service
public class SimplePojoService {

    private final transient String createTableTest;

    public SimplePojoService(final Configuration pConfiguration) {
        createTableTest = pConfiguration.getString("test.createtable");
    }

    public String createTableRequest() {
        return createTableTest;
    }
}
