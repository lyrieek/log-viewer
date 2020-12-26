package com.lyrieek.logViewer.io

import java.io.{FileReader, IOException}

import com.lyrieek.logViewer.config.Configuration
import org.apache.commons.io.IOUtils

class LogScanner(config: Configuration) extends App {

	def read(): Unit = {
		try {
			val lines: java.util.List[String] = IOUtils.readLines(new FileReader(config.getSignleRestrictFile()))
			lines.forEach(e => {
				println(e)
			})
		} catch {
			case ex: IOException => println(ex)
		}
	}

}
