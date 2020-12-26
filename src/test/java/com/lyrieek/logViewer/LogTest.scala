package com.lyrieek.logViewer

import com.lyrieek.logViewer.config.Configuration
import com.lyrieek.logViewer.io.LogScanner
import org.scalatest.flatspec.AnyFlatSpec

class LogTest extends AnyFlatSpec {


	it should "test configuration" in {
		val config: Configuration = new Configuration()
		config.file("src/test/resources/setting.properties").read()
		val logScan: LogScanner = new LogScanner(config)
		logScan.read()
	}

}
