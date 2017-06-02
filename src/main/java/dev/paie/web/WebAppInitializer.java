package dev.paie.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import dev.paie.spring.WebAppConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	/************ ICI ON CREE LE COEUR DE LA MAGIE DE SPRING *************/
	/*
	 * On declare le context de spring en mettant comme point de depart la
	 * classe WebAppConfig Une fois qu'on va dans WebAppConfig il va lire tout
	 * le fichier du haut vers le bas et suivant les chemin et creant les bean
	 * qu'on lui a demandé dans les différentes classe du chemin
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Initialisation du contexte Spring
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebAppConfig.class);
		/*
		 * <servlet> <servle-name>dispatcher</servlet-name> <servlet
		 * class>org.springframework.web.servlet.DispatcherServlet</servlet-
		 * class> <load-on-startup>1</load-on-startup> </servlet>
		 */
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		/*
		 * <servlet-mapping> <servlet-name>dispatcher</servlet-name>
		 * <url-pattern>/mvc/*</url-pattern> </servlet-mapping>
		 */
		dispatcher.addMapping("/mvc/*");
		/*
		 * <listener> <listener
		 * class>org.springframework.web.context.ContextLoaderListener</listener
		 * -class> </listener>
		 */
		servletContext.addListener(new ContextLoaderListener(webContext));
	}
}