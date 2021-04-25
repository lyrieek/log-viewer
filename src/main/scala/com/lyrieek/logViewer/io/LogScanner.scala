package com.lyrieek.logViewer.io

import java.io.{FileReader, IOException}
import java.util

import com.lyrieek.logViewer.config.Configuration
import com.lyrieek.logViewer.filter.ScannerFilter
import org.apache.commons.io.IOUtils

import scala.collection.mutable.ArrayBuffer

class LogScanner(config: Configuration) {

	final val filters = new ArrayBuffer[ScannerFilter]()

	private def readLines: util.List[String] = {
		val reader = new FileReader(config.getSignleRestrictFile())
		val res: util.List[String] = IOUtils.readLines(reader)
		reader.close()
		res
	}

	def print(): Unit = {
		try {
			readLines.forEach(e => println(e))
		} catch {
			case ex: IOException => println(ex)
		}
	}

	def each(fn: String => Unit): Unit = {
		try {
			readLines.forEach(e => {
				var item = e
				for (i <- 0 until filters.size)
					item = filters(i).dispose(item)
				fn(item)
			})
		} catch {
			case ex: IOException => println(ex)
		}
	}

}
