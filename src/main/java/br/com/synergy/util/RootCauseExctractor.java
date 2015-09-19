package br.com.synergy.util;

import org.springframework.security.web.util.ThrowableCauseExtractor;

public class RootCauseExctractor implements ThrowableCauseExtractor{

	@Override
	public Throwable extractCause(Throwable e) {
		boolean continuar = true;
		Throwable rootCause = e.getCause();
		while (continuar) {
			if (rootCause.getCause() == null)
				break;
			rootCause = rootCause.getCause();

		}
		return rootCause;
	}
	
	public static String extractRootCauseMessage(Throwable e) {
		boolean continuar = true;
		Throwable rootCause = e.getCause();
		while (continuar) {
			if (rootCause.getCause() == null)
				break;
			rootCause = rootCause.getCause();

		}
		return rootCause.getLocalizedMessage();
	}
	
	public static Throwable extractRootCause(Throwable e) {
		boolean continuar = true;
		Throwable rootCause = e.getCause();
		while (continuar) {
			if (rootCause.getCause() == null)
				break;
			rootCause = rootCause.getCause();

		}
		return rootCause;
	}

}
