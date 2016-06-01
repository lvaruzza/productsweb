package products.web.config;

import com.google.inject.AbstractModule;

import products.db.config.DBModule;
import products.web.server.AppServer;
import products.web.server.ProductsApp;

public class WebModule extends AbstractModule {

	@Override
	protected void configure() {
        install(new DBModule());
        bind(AppServer.class).to(ProductsApp.class);
	}

}
