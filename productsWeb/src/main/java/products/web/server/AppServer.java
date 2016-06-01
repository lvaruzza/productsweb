package products.web.server;

import static spark.SparkBase.port;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.ResponseTransformer;

public abstract class AppServer {
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String toJson(Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}
	
	public static ResponseTransformer json() {
		return AppServer::toJson;
	}

	
	protected int serverPort = 8888;

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public void run() {
		port(serverPort);
		routes();
	}


	public abstract void routes();
}
