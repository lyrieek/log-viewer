package com.lyrieek.logViewer

import com.lyrieek.logViewer.config.Configuration
import com.lyrieek.logViewer.core.FileCentre
import org.scalatest.flatspec.AnyFlatSpec

class FileCentreTest extends AnyFlatSpec {

	it should "list file test" in {
		val config: Configuration = new Configuration()
		config.file("src/test/resources/list-files-setting.properties").read()

		val f = new FileCentre(config)
		f.scan()
		println(f.workPath)
		println(f.count)
	}

}
