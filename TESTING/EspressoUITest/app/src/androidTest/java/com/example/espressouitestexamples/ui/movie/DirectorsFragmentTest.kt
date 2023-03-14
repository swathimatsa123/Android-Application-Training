package com.example.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espressouitestexamples.R
import com.example.espressouitestexamples.factory.MovieFragmentFactory
import com.example.espressouitestexamples.ui.movie.DirectorsFragment.Companion.stringBuilderForDirectors
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest{

    @Test
    fun test_isDirectorsListVisible() {

        // GIVEN
        val directors = arrayListOf("R.J. Stewart", "James Vanderbilt")
        val verifyDirectorsValue = stringBuilderForDirectors(directors)
        val fragmentFactory = MovieFragmentFactory(null, null)
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", directors)
        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        // VERIFY
        onView(withId(R.id.directors_text))
            .check(matches(withText(verifyDirectorsValue.toString())))
    }
}





















