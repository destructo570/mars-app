package com.destructo.mars.app.data.domainModel

interface DomainMapper<T: Any> {
    fun mapToDomainModel(): T
}