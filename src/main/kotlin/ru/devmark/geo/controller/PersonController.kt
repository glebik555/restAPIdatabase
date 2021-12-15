package ru.devmark.geo.controller

import org.springframework.web.bind.annotation.*
import ru.devmark.geo.dto.PersonDto
import ru.devmark.geo.model.person
import ru.devmark.geo.service.PersonService

@RestController
@RequestMapping("/person")
class PersonController(
    private val personService: PersonService,
) {
    @GetMapping()
    fun getAllCountries(): List<person> = personService.getAllPerson()

    @GetMapping("/name/{name}")
    fun findPersonsWithName(@PathVariable name:String): ArrayList<person> = personService.getAllPersonWithName(name)

    @GetMapping("/lastname/{lastname}")
    fun findPersonsWithLastname(@PathVariable lastname:String): ArrayList<person> = personService.getAllPersonWithLastname(lastname)

    @GetMapping("/id/{id}")
    fun findPersonWithId(@PathVariable id:Int): person? = personService.getPersonWithId(id)

    @PostMapping()
    fun create(@RequestBody dto: PersonDto){
        personService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id:Int, @RequestBody dto: PersonDto){
        personService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Int){
        personService.delete(id)
    }
}