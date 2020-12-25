package com.lyrieek.logViewer

import javax.servlet.Servlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext

object WebServiceBuilder {

	def createService(port: Integer, webServlet: Class[_ <: Servlet]): Server = {
		val server = new Server(port)
		val content = new WebAppContext()
		content.setContextPath("/")
		content.setResourceBase("/tmp")
		content.addServlet(webServlet, "/*")
		server.setHandler(content)
		server
	}

}
