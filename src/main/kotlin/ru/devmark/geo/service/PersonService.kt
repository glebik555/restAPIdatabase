package ru.devmark.geo.service

import ru.devmark.geo.dto.PersonDto
import ru.devmark.geo.model.person

interface PersonService {
    fun getAllPerson(): List<person>
    fun create(person: PersonDto)
    fun update(id: Int, personDto: PersonDto)
    fun delete(id: Int)
    fun getAllPersonWithName(name:String): ArrayList<person>
    fun getAllPersonWithLastname(lastname: String): ArrayList<person>
    fun getPersonWithId(id: Int): person?
}