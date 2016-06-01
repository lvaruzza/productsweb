package products.web.standalone;

import com.google.inject.Guice;
import com.google.inject.Injector;

import products.web.config.WebModule;
import products.web.server.AppServer;

public class RunApp {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new WebModule());
		AppServer server = injector.getInstance(AppServer.class);
		server.run();
	}
}
