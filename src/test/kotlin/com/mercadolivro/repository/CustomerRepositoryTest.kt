package com.mercadolivro.repository

import com.mercadolivro.helper.buildCustomer
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerRepositoryTest {
    @Autowired
    private lateinit var customerRepository: CustomerRepository
    @BeforeEach
    fun setup()= customerRepository.deleteAll()
    @Test
    fun retornaNomeContendo(){
        val marcos=customerRepository.save(buildCustomer(name = "marcos"))
        //val matheus=customerRepository.save(buildCustomer(name = "Matheus"))
        val alex=customerRepository.save(buildCustomer(name = "Alex"))

       var customers= customerRepository.findByNameContaining("Ma")

        assertEquals(listOf(marcos), customers)
    }

    @Nested
    inner class findByEmail{
        @Test
        fun retornaSeVerdadeiraSeExisteEmail(){
            val email = "email@teste.com"
            val customer= customerRepository.save(buildCustomer(email = email))
            val result = customerRepository.findByEmail(email)
            assertNotNull(result)
            assertEquals(customer, result)
        }

        @Test
        fun retornaSeFalsoSeExisteEmail(){
            val email = "emasdaasdasdasdaail@teste.com"
            val result = customerRepository.findByEmail(email)
            assertNull(result)
        }
    }

    @Nested
    inner class existByEmail{
        @Test
        fun retornaSeVerdadeiraSeExisteEmail(){
            val email = "email@teste.com"
            customerRepository.save(buildCustomer(email = email))
            val exist= customerRepository.existsByEmail(email)
            assertTrue(exist)
        }

        @Test
        fun retornaSeFalsoSeExisteEmail(){
            val email = "emasdasdaail@teste.com"
            val exist= customerRepository.existsByEmail(email)
            assertFalse(exist)
        }
    }
}
