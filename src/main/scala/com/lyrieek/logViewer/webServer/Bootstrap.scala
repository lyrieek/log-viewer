package com.lyrieek.logViewer.webServer

object Bootstrap extends App {

	val server = WebServiceBuilder.createService(1212, classOf[WebService])
	server.start()

}