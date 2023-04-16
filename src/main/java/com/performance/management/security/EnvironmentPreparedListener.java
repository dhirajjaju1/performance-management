package com.performance.management.security;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

public class EnvironmentPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	private final Logger log = LoggerFactory.getLogger(EnvironmentPreparedListener.class.getName());

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

		String[] profiles = event.getEnvironment().getActiveProfiles();

		Optional<String> profile = Arrays.stream(profiles).filter(x -> ("uat".equals(x) || "prod".equals(x)))
				.findFirst();

		if (profile.isPresent()) {
			/*
			 * try {
			 * 
			 * // implement later as OES //
			 * SSLValidationEnableDisabler.disableSSLValidation(); } catch
			 * (GeneralSecurityException e) { log.error(e.getMessage(), e); }
			 */
		} else {
			log.error("###### SSL Validation is enabled - config");
			// implement later as OES
			// SSLValidationEnableDisabler.enableSSLValidation(event.getEnvironment());
		}
	}
}