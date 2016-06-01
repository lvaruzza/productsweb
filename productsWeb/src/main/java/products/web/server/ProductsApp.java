package products.web.server;

import static spark.Spark.*;

import java.util.Optional;

import javax.inject.Inject;

import products.db.model.Product;
import products.db.services.DBService;
import spark.Response;

public class ProductsApp extends AppServer {

	@Inject
	private DBService dbs;

	private final String API = "/api";

	private long toLong(String x) {
		return Long.parseLong(x);
	}

	@Override
	public void routes() {
		after((req, res) -> {
			res.type("application/json");
		});

		get(API + "/product/:id", (req, res) -> {
			Long id = toLong(req.params(":id"));
			Optional<Product> prod = dbs.getProduct(id);
			if (prod.isPresent())
				return prod.get();
			else {
				res.status(400);
				return new ResponseError("No user with id '%s' found", id);
			}
		},json());

		get("/", (req, res) -> "Hello");
	}

}
