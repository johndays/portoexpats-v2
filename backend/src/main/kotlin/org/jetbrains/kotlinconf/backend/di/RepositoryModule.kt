package org.jetbrains.kotlinconf.backend.di

import org.jetbrains.kotlinconf.backend.repositories.PortoExpatsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::PortoExpatsRepository)
}