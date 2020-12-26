package com.lyrieek.logViewer

import com.lyrieek.logViewer.config.Configuration
import org.scalatest.flatspec.AnyFlatSpec

class ConfigTest extends AnyFlatSpec {


	it should "test configuration" in {
		val config: Configuration = new Configuration()
		config.file("src/test/resources/setting.properties").read()
		config.print()
	}

	"config file" should "storage" in {
		val config: Configuration = new Configuration()
		config.file("test").storage()
		assert(config.setting("storeFile").eq("test"))
	}

	it should "configuration file does not exist" in {
		val config: Configuration = new Configuration()
		assertThrows[RuntimeException] {
			config.file("test").read()
		}
	}
}
