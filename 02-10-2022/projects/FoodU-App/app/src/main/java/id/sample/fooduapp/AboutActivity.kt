package id.sample.fooduapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AboutActivity : AppCompatActivity() {
    private lateinit var btnGithubLink: ImageView
    private lateinit var btnInstagramLink: ImageView
    private lateinit var btnLinkedInLink: ImageView
    private lateinit var ivCreatorPhoto: ImageView
    private lateinit var fabLikes: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initUI()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initUI() {
        btnGithubLink = findViewById(R.id.iv_about_github)
        btnInstagramLink = findViewById(R.id.iv_about_instagram)
        btnLinkedInLink = findViewById(R.id.iv_about_linkedin)
        ivCreatorPhoto = findViewById(R.id.iv_about_photo)
        fabLikes = findViewById(R.id.fab_likes)

        Glide.with(this)
            .load(getDrawable(R.drawable.creator_photo))
            .into(ivCreatorPhoto)

        btnGithubLink.setOnClickListener {
            openLink(resources.getString(R.string.github_link))
        }

        btnInstagramLink.setOnClickListener {
            openLink(resources.getString(R.string.instagram_link))
        }

        btnLinkedInLink.setOnClickListener {
            openLink(resources.getString(R.string.linkedin_link))
        }

        fabLikes.setOnClickListener {
            Toast.makeText(
                applicationContext,
                getString(R.string.appreciation_text),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun openLink(link: String) {
        val uri: Uri = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}