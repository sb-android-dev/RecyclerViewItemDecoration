package com.sbdev.project.recyclerviewitemdecoration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sbdev.project.recyclerviewitemdecoration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSpaceLinearList.setOnClickListener {
            Intent(this, SpaceList::class.java).also {
                startActivity(it)
            }
        }

        binding.btnSpaceGridList.setOnClickListener {
            Intent(this, SpaceGrid::class.java).also {
                startActivity(it)
            }
        }

        binding.btnLineLinearList.setOnClickListener {
            Intent(this, LineList::class.java).also {
                startActivity(it)
            }
        }

        binding.btnLineGridList.setOnClickListener {
            Intent(this, LineGrid::class.java).also {
                startActivity(it)
            }
        }

    }
}