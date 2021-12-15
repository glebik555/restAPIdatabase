package ru.devmark.geo

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import ru.devmark.geo.dto.PersonDto
import ru.devmark.geo.model.person
import ru.devmark.geo.service.PersonService
import ru.devmark.geo.service.PersonServiceImpl

@SpringBootTest
class GeoSpringDataApplicationTests {

	@Test
	fun addAndFindByName(
		@Autowired
		personService: PersonServiceImpl,
	) {
		if(personService.getAllPersonWithName("Alex").size > 0){
			for(man in personService.getAllPersonWithName("Alex")){
				personService.delete(man.id)
			}
		}
		personService.create(PersonDto("Alex", "Tiger"))
		val response: ArrayList<person> = personService.getAllPersonWithName("Alex")
		assertTrue(response.size > 0)
	}

	@Test
	fun delete(
		@Autowired
		personService: PersonServiceImpl,
	){
		if(personService.getAllPersonWithName("Alex").size > 0){
			for(man in personService.getAllPersonWithName("Alex")){
				personService.delete(man.id)
			}
		}

		val response: ArrayList<person> = personService.getAllPersonWithName("Alex")
		assertTrue(response.size == 0)
	}

	@Test
	fun findById(
		@Autowired
		personService: PersonServiceImpl,
	){
		val man: person? = personService.getPersonWithId(1)
		if (man != null) {
			assertTrue(man.name == "Gleb")
		}

	}

	@Test
	fun findByLastname(
		@Autowired
		personService: PersonServiceImpl,
	){
		val response: ArrayList<person> = personService.getAllPersonWithLastname("Bogoyavlensky")
		assertTrue(response.size > 0)
	}
}
