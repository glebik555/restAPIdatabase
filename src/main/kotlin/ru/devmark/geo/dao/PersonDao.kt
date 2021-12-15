package ru.devmark.geo.dao

import org.springframework.data.repository.CrudRepository
import ru.devmark.geo.model.person

interface PersonDao: CrudRepository<person, Int> {
}