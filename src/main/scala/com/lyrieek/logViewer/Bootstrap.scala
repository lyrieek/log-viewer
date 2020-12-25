package com.lyrieek.logViewer

object Bootstrap extends App {

	val server = WebServiceBuilder.createService(1212, classOf[WebService])
	server.start()

}