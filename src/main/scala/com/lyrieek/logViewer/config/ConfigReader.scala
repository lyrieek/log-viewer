package com.lyrieek.logViewer.config

import java.io.{File, FileReader}
import java.util.Properties

object ConfigReader {

	def readProps(filePath: String, fun: (String, Object) => Unit): Unit = {
		val file: File = new File(filePath)
		if (!file.exists()) {
			throw new RuntimeException("The configuration file was not read:" + file.getAbsolutePath)
		}
		val fr = new FileReader(file)
		val prop: Properties = new Properties()
		prop.load(fr)
		val entrySet = prop.entrySet()
		if (entrySet == null) {
			return
		}

		entrySet.forEach(e => fun(e.getKey.toString, e.getValue))
		fr.close()
	}

}