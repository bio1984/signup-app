package org.company.config;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.infinispan.manager.EmbeddedCacheManager;

/**
 * This class uses CDI to alias Java EE resources, such as the persistence
 * context, to CDI beans
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 * 
 * 
 */
public class Resources {

	@Produces
	@ApplicationScoped
	@Resource(mappedName = "java:jboss/infinispan/signup-unconfirmed-cache")
	@UnconfirmedCache
	private EmbeddedCacheManager unconfirmedCacheManager;
	
	
	@Produces
	@ApplicationScoped
	@Resource(mappedName = "java:jboss/infinispan/signup-confirmed-cache")
	@ConfirmedCache
	private EmbeddedCacheManager confirmedCacheManager;
	
	
	@Produces
	@ApplicationScoped
	@Resource(mappedName = "java:jboss/infinispan/signup-approved-cache")
	@ApprovedCache
	private EmbeddedCacheManager approvedCacheManager;
	
	
	@Produces
	@ApplicationScoped
	@Resource(mappedName = "java:jboss/infinispan/signup-denied-cache")
	@DeniedCache
	private EmbeddedCacheManager deniedCacheManager;


	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass()
				.getName());
	}
}
