package org.jetbrains.kotlinconf.backend.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import org.jetbrains.kotlinconf.backend.plugins.PortoExpatsPrincipal
import org.jetbrains.kotlinconf.backend.repositories.PortoExpatsRepository
import org.jetbrains.kotlinconf.backend.utils.Unauthorized

internal fun ApplicationCall.checkAdminKey(adminSecret: String) {
    val principal = principal<PortoExpatsPrincipal>()
    if (principal?.token != adminSecret) {
        throw Unauthorized()
    }
}

internal suspend fun ApplicationCall.validatePrincipal(database: PortoExpatsRepository): PortoExpatsPrincipal? {
    val principal = principal<PortoExpatsPrincipal>() ?: return null
    if (!database.validateUser(principal.token)) return null
    return principal
}
