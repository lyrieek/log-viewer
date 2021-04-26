package com.lyrieek.logViewer.config

import java.io.File

import org.slf4j.LoggerFactory

import scala.collection.mutable

class Configuration {

	val logger = LoggerFactory.getLogger(classOf[Configuration])

	val setting = new mutable.HashMap[String, String]()

	/**
	  * Operation file
	  *
	  * <p>@see read()/store()</p>
	  *
	  * @param path absolute path
	  * @return
	  */
	def file(path: String): Configuration = {
		setting.put("configFile", path)
		this
	}

	/**
	  * Apply the settings of the configuration file
	  */
	def read(): Unit = {
		ConfigReader.readProps(setting("configFile"), (key, value) => key match {
			//Charset
			case "workPath" => setting.put(key, value.toString)
			case "restrict" =>
				setting.put("restrictMode", "regex")
				setting.put(key, value.toString)
			case "file" =>
				if (value.toString.contains(",")) {
					setting.put("restrictMode", "list")
					setting.put(key, value.toString)
				} else {
					setting.put("restrictMode", "complete")
					val index = value.toString.lastIndexOf(File.separator)
					if (index == -1) {
						logger.error("apply 'file' parameter failure! Put it in at least one folder")
						return
					}
					setting.put("workPath", value.toString.substring(0, index))
					setting.put("restrict", value.toString.substring(index + 1))
				}
			case "test" => println("println test parameter:" + value)
			case _ =>
				if (!key.startsWith("custom.")) {
					logger.error(s"'$key' is self-defined parameter!")
					logger.error("If you want to use custom parameters, start with 'custom.'")
					return
				}
				setting.put(key, value.toString)
				logger.info("Receive custom parameters:" + key)
		})
	}

	def getSingleRestrictFile: String = {
		setting("workPath") + File.separator + setting("restrict")
	}

	/**
	  * Storage this configuration file, but does not actually apply it
	  */
	def storage(): Unit = {
		setting.put("storeFile", setting("configFile"))
	}

	/**
	  * Use the Settings for storage
	  */
	def applyStorage(): Unit = {
		setting.put("configFile", setting("storeFile"))
		read()
	}

	/**
	  * Print all setting
	  */
	def print(): Unit = {
		if (setting.isEmpty) {
			println("setting is empty")
			return
		}
		setting.foreachEntry((key, value) => {
			println(s"$key\n\t$value")
		})
	}

}
