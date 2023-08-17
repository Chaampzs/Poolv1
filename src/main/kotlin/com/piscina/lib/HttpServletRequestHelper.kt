package com.piscina.lib

import org.springframework.util.LinkedCaseInsensitiveMap
import java.lang.IllegalArgumentException
import java.util.*
import javax.servlet.http.HttpServletRequest


fun HttpServletRequest.getHeaders() : Map<String, List<String>> {
	val headers = LinkedCaseInsensitiveMap<List<String>>(Locale.ENGLISH)
	val names = this.headerNames

	while (names.hasMoreElements()){
		val name = names.nextElement();
		headers[name] = Collections.list(this.getHeaders(name))
	}

	return headers;
}

fun Map<String, List<String>>.getAuthorization(required: Boolean) : String? {

	return when {
		this.containsKey("Authorization") -> {
			return this.getValue("Authorization")[0]
		}
		required -> {
			throw IllegalArgumentException("Authorization obrigatório")
		}
		else -> null
	}

}


fun Map<String, List<String>>.getId(required: Boolean) : Long? {

	return when {
		this.containsKey("id") -> {
			return this.getValue("id")[0].toLong()
		}
		required -> {
			throw IllegalArgumentException("id obrigatório")
		}
		else -> null
	}

}

fun Map<String, List<String>>.getIdPool(required: Boolean) : Long? {

	return when {
		this.containsKey("idPool") -> {
			return this.getValue("idPool")[0].toLong()
		}
		required -> {
			throw IllegalArgumentException("idAsset obrigatório")
		}
		else -> null
	}

}



inline fun Boolean.yes(block: () -> Unit) = also {if (it) block()}
inline fun Boolean.no(block: () -> Unit) = also {if (!it) block()}