package ru.devmark.geo.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import ru.devmark.geo.dao.PersonDao
import ru.devmark.geo.dto.PersonDto
import ru.devmark.geo.model.person

@Service
@Component("personServiceImpl")
class PersonServiceImpl(
    private val personDao: PersonDao,
) : PersonService {

    override fun getAllPerson(): List<person> = personDao.findAll().toList()
    override fun create(personIn: PersonDto) {
        val newPerson = ru.devmark.geo.model.person(
            name = personIn.name,
            lastname = personIn.lastname,
        )
        println(newPerson.name)
        personDao.save(newPerson)
    }

    override fun update(id: Int, personIn:PersonDto) {
        val oldPerson = personDao.findByIdOrNull(id)
        val newPerson = oldPerson!!.copy(
            name = personIn.name,
            lastname = personIn.lastname,
        )
        personDao.save(newPerson)
    }

    override fun delete(id: Int) {
        personDao.deleteById(id)
    }

    override fun getAllPersonWithName(name: String): ArrayList<person> {
        val allPerson:ArrayList<person>  = getAllPerson() as ArrayList<person>
        val result:ArrayList<person> = arrayListOf()
        for (i in allPerson){
            if (i.name != name){
                continue
            }else{
                result.add(i)
            }
        }
        return result
    }

    override fun getAllPersonWithLastname(lastname: String): ArrayList<person> {
        val allPerson:ArrayList<person>  = getAllPerson() as ArrayList<person>
        val result:ArrayList<person> = arrayListOf()
        for (i in allPerson){
            if (i.lastname != lastname){
                continue
            }else{
                result.add(i)
            }
        }
        return result
    }

    override fun getPersonWithId(id: Int): person? = personDao.findByIdOrNull(id)
}