package com.lyrieek.logViewer.webServer

import java.time.LocalDateTime

import org.scalatra.ScalatraServlet

class WebService extends ScalatraServlet {

	get("/") {
		"1232"
	}

	get("/date") {
		contentType = "text/html"
		val nowDate = LocalDateTime.now()
		<html>
			<head>
				<title>now date</title>
			</head>
			<body>now date:{nowDate}</body>
		</html>
	}

}
