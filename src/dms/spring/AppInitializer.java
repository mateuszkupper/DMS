package dms.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import dms.services.security.*;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, WebSecurityConfig.class };
	}

	@Override
	protected Class[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}