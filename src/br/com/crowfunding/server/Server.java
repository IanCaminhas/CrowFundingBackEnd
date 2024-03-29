package br.com.crowfunding.server;

import java.io.IOException;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class Server {

	public static void main(String[] args) throws IOException {

		HttpServer server = StartServer();
		System.out.println("Rodando");
		System.in.read();
		server.stop();
	}

	public static HttpServer StartServer() {
		ResourceConfig config = new ResourceConfig().packages("br.com.crowfunding");
		CORSFilter corsFilter = new CORSFilter();
		config.register(corsFilter);

		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return server;
	}

	
}
