package com.lyrieek.logViewer.io

import scala.reflect.io.File

case class LogFile(file: File, path: String, lock: Boolean) {

	def this(m: File) = {
		this(m, m.path, false)
	}

}
