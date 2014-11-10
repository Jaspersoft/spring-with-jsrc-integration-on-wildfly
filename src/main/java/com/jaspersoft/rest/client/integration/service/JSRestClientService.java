package com.jaspersoft.rest.client.integration.service;

import com.jaspersoft.jasperserver.jaxrs.client.core.JasperserverRestClient;
import com.jaspersoft.jasperserver.jaxrs.client.core.RestClientConfiguration;
import com.jaspersoft.jasperserver.jaxrs.client.core.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Alexander Krasnyanskiy
 */
@Service
public class JSRestClientService {

    @Value("${server.uri}")
    private String serverUri;

    private Session session;

    /**
     * Creates client configuration and returns session.
     *
     * @return {@link Session}
     */
    public Session configure() {
        if (session == null) {
            RestClientConfiguration config = new RestClientConfiguration(serverUri);
            JasperserverRestClient client = new JasperserverRestClient(config);
            session = client.authenticate("superuser", "superuser");
            return session;
        } else {
            return session;
        }
    }
}
