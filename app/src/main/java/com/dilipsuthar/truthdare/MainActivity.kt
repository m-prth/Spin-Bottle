package com.parthmistry.truthdare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var bottle: ImageView
    private var random = Random
    private var lastDirection: Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn)
        bottle = findViewById(R.id.imageView)

        button.setOnClickListener {
            spin()
        }
    }

    private fun spin() {
        val newDirection = random.nextInt(3600).toFloat()
        val pivotX = (bottle.width / 2).toFloat()
        val pivotY = (bottle.height / 2).toFloat()

        val rotate = RotateAnimation(lastDirection, newDirection, pivotX, pivotY)
        rotate.duration = 2000
        rotate.fillAfter = true

        rotate.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                button.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animation?) {
                button.isEnabled = true
            }

            override fun onAnimationRepeat(animation: Animation?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        lastDirection = newDirection

        bottle.startAnimation(rotate)
    }
}
