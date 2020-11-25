package org.edrodev.astronopic.domain.useCase

import io.kotest.matchers.shouldNotBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.asFailure
import org.edrodev.astronopic.core.asSuccess
import org.edrodev.astronopic.core.failureOrThrow
import org.edrodev.astronopic.core.successOrThrow
import org.edrodev.astronopic.domain.model.Apod

class GetApodTest {

    private lateinit var sut: GetApod

    @BeforeTest
    fun setUp() {
        sut = GetApod(
            apodRepository = mockk()
        )
    }

    @Test
    fun `repository returns success`() {
        runBlocking {
            coEvery { sut(any()) } returns mockk<Apod>().asSuccess()

            val result = sut(LocalDate(2020, 11, 25))

            result.successOrThrow() shouldNotBe null
        }
    }

    @Test
    fun `repository returns failure`() {
        runBlocking {
            coEvery { sut(any()) } returns mockk<Failure>().asFailure()

            val result = sut(LocalDate(2020, 11, 25))

            result.failureOrThrow() shouldNotBe null
        }
    }
}