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
import com.example.espressouitestexamples.ui.movie.StarActorsFragment.Companion.stringBuilderForStarActors
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{

    @Test
    fun test_isActorsListVisible() {

        // GIVEN
        val actors = arrayListOf(
            "Dwayne Johnson",
            "Seann William Scott",
            "Rosario Dawson",
            "Christopher Walken"
        )
        val verifyActorsValue = stringBuilderForStarActors(actors)
        val fragmentFactory = MovieFragmentFactory(null, null)
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", actors)
        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        // VERIFY
        onView(withId(R.id.star_actors_text))
            .check(matches(withText(verifyActorsValue)))
    }
}





















