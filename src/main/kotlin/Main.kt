package org.example

import com.github.javafaker.Faker
import org.example.repository.insert
import org.example.repository.totalDBs
import org.example.strategy.HashBasedSharding
import org.example.strategy.ShardingStrategy

fun main() {
    val shardingStrategy: ShardingStrategy = HashBasedSharding()
    val faker = Faker();

    for(i in 1..100){
        val username:String = faker.name().name()
        val index:Int = shardingStrategy.getIndex(username, totalDBs)
        insert(index, username)
    }
}