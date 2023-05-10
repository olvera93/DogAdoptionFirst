package com.olvera.dogadoptionfirst.util

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Patterns
import java.util.regex.Pattern
import kotlin.random.Random

private const val MIN_PASS_LENTH = 6
private const val PASS_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$"

fun String.isValidEmail(): Boolean {
    return this.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return this.isNotBlank() &&
            this.length >= MIN_PASS_LENTH &&
            Pattern.compile(PASS_PATTERN).matcher(this).matches()
}

fun String.passwordMatches(repeated: String): Boolean {
    return this == repeated
}

fun String.isEmptyTextEdit(): Boolean {
    return this.isEmpty()
}

fun randomBackground(view: Drawable, random: Boolean) {
    if (random) {
        val color = Color.argb(
            255,
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        view.setTint(color)
    } else {
        view.setTint(Color.WHITE)
    }
}