package org.apereo.cas.web.report;

import org.apereo.cas.authentication.handler.support.ProxyAuthenticationHandler;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is {@link RegisteredAuthenticationHandlersEndpointTests}.
 *
 * @author Francesco Chicchiriccò
 * @since 6.3.0
 */
@TestPropertySource(properties = "management.endpoint.authenticationHandlers.access=UNRESTRICTED")
@Tag("ActuatorEndpoint")
class RegisteredAuthenticationHandlersEndpointTests extends AbstractCasEndpointTests {

    @Autowired
    @Qualifier("registeredAuthenticationHandlersEndpoint")
    private RegisteredAuthenticationHandlersEndpoint endpoint;

    @Test
    void verifyOperation() throws Throwable {
        assertFalse(endpoint.handle().isEmpty());
        assertNotNull(endpoint.fetchAuthnHandler(ProxyAuthenticationHandler.class.getSimpleName()));
    }
}
