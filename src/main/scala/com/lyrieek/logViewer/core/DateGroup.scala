package com.lyrieek.logViewer.core

import java.text.SimpleDateFormat

import scala.collection.mutable

class DateGroup {

	final val DAY_DATE_FORMAT_PATTERN = "YYYY-MM-DD"

	final val dayFormat = new SimpleDateFormat(DAY_DATE_FORMAT_PATTERN)

	final val TIME_DATE_FORMAT_PATTERN = "HH:mm:ss,SSS"

	final val timeFormat = new SimpleDateFormat(TIME_DATE_FORMAT_PATTERN)

	val dateGroup = new mutable.HashSet[String]()

	def take(str: String): String = {
		dateGroup.add(str.substring(0, DAY_DATE_FORMAT_PATTERN.length))
		str.substring(DAY_DATE_FORMAT_PATTERN.length + TIME_DATE_FORMAT_PATTERN.length + 2)
	}

	def size: Int = dateGroup.size

}
