package com.zenika.data.state

import javax.inject.Singleton

@Singleton
class GameState(
    val chestState: Boolean = false,
    val mapState: Boolean = false
)