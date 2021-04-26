package com.lyrieek.logViewer.io

import java.io.File

case class LogFile(file: File, path: String, lock: Boolean) {

	def this(file: File) = {
		this(file, file.getAbsolutePath, false)
	}

	def this(path: String) = {
		this(new File(path))
	}

}
