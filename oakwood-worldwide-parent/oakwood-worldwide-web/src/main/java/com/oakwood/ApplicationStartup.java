package com.oakwood;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.oakwood.service.startup.StartupService;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartup.class);
	private static boolean isStartupInitialized = false;

	private final StartupService startupService;

	public ApplicationStartup(StartupService startupService) {
		super();
		this.startupService = startupService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (!isStartupInitialized) {
			isStartupInitialized = true;
			startupService.createDefaultAdminIfNotFound();
			LOGGER.info("System Startup successfully!");
		}
	}

}
