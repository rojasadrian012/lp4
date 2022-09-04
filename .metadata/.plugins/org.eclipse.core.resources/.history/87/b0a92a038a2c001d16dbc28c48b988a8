package org.biblioteca.rest;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.biblioteca.abm.rest.AutorNormalizadoRestService;
import org.biblioteca.abm.rest.CiudadNormalizadoRestService;
import org.biblioteca.abm.rest.CiudadRestService;
import org.biblioteca.abm.rest.ClienteNormalizadoRestService;
import org.biblioteca.abm.rest.LibroNormalizadoRestService;
import org.biblioteca.abm.rest.UsuarioNormalizadoRestService;
import org.biblioteca.mov.rest.PrestamoLibroRestService;
import org.biblioteca.mov.rest.PrestamoRestService;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;
@ApplicationPath("rest")
public class BibliotecaRestApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
    private HashSet<Class<?>> classes = new HashSet<Class<?>>();
    
	public BibliotecaRestApplication() {
		CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("*");
        corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
        singletons.add(corsFilter);

        classes.add(CiudadRestService.class);
        classes.add(CiudadNormalizadoRestService.class);
        classes.add(ClienteNormalizadoRestService.class);
        classes.add(LibroNormalizadoRestService.class);
        classes.add(AutorNormalizadoRestService.class);
        classes.add(UsuarioNormalizadoRestService.class);

        classes.add(PrestamoLibroRestService.class);
        classes.add(PrestamoRestService.class);
	}
	
	@Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public HashSet<Class<?>> getClasses(){
      return classes;
    }
}