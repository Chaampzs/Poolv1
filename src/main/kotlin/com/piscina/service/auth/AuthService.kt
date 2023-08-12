package com.piscina.service.auth


interface AuthService {

	fun validate(document: String, password: String)


}