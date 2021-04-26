package com.lyrieek.logViewer.core

import java.io.File

import com.lyrieek.logViewer.config.Configuration
import com.lyrieek.logViewer.io.LogFile
import org.slf4j.LoggerFactory

import scala.collection.mutable

/**
  * Filter out the files to be processed
  * @param config Configuration
  */
class FileCentre(config: Configuration) {

	val files = new mutable.HashSet[LogFile]()

	def count: Int = files.size

	def workPath: String = config.setting("workPath")

	def scan(): Unit = {
		config.setting("restrictMode") match {
			case "complete" => files.add(new LogFile(config.setting("file")))
			case "list" => config.setting("file").split(",").foreach(fileItem => files.add(new LogFile(fileItem)))
			case "regex" => new File(workPath).list().foreach(fileItem => fileItem.matches(config.setting("restrict")) && files.add(new LogFile(fileItem)))
		}
	}

	def print(): Unit = files.foreach(item => println(item))

}
