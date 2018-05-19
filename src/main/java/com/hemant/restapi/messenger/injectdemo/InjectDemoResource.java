package com.hemant.restapi.messenger.injectdemo;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("/annotations")
	public String injectParamDemo(@MatrixParam("name") String name,
									@HeaderParam("customHeaderValue") String header,
									@CookieParam("name") String cookie) {
		return "The matrix param is: " + name + "\n" + " The header value is : " + header
				+ " The cookie is: " + cookie;
	}
	
	@GET
	@Path("/context")
	public String contextDemo(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "The path is: " + path + " And cookies is: " + cookies;
	}
}
