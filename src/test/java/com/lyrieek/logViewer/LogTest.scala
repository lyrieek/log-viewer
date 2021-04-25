package com.lyrieek.logViewer

import com.lyrieek.logViewer.config.Configuration
import com.lyrieek.logViewer.core.DateGroup
import com.lyrieek.logViewer.io.LogScanner
import org.scalatest.flatspec.AnyFlatSpec

/**
  * Single LOG file test
  */
class LogTest extends AnyFlatSpec {

	val config: Configuration = new Configuration()
	config.file("src/test/resources/single-file-setting.properties").read()
	val logScan: LogScanner = new LogScanner(config)

	it should "test print" in {
		logScan.print()
	}

	it should "test filter" in {
		val dateGroup = new DateGroup()
		logScan.filters += ((e: String) => {
			if (!e.matches("[1000-9999].+")) {
				""
			} else {
				dateGroup.take(e)
			}
		})
		logScan.each(item => if (!item.isEmpty) println(item))
		println(dateGroup.dateGroup)
	}

}
