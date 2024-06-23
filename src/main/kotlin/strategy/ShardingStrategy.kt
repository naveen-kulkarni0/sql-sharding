package org.example.strategy

interface ShardingStrategy {
    fun getIndex(username:String, totalConnections: Int):Int
}