package com.piscina.service.auth

//import jdk.nashorn.internal.runtime.logging.Logger
import com.piscina.lib.yes
import com.piscina.entites.auth.AuthUnauthorizedException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

//import org.springframework.stereotype.Service


@Service
//@Logger
class AuthServiceImpl() : AuthService {

	val LOG = LoggerFactory.getLogger(AuthServiceImpl::class.java)

	override fun validate(document: String, password: String) {

		(password != "1234").yes {
			throw AuthUnauthorizedException()
		}
	}
}