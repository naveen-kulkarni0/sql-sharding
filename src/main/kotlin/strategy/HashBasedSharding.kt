package org.example.strategy

import java.math.BigInteger
import java.security.MessageDigest

class HashBasedSharding: ShardingStrategy {
    override fun getIndex(username: String, totalConnections: Int): Int {
        val bytes = MessageDigest.getInstance("SHA-256").digest(username.toByteArray())
        val hexString = bytes.joinToString("") { "%02x".format(it) }
        val bigInt = BigInteger(hexString, 16) // Parse hexString as a base-16 integer
        return bigInt.mod(BigInteger.valueOf(totalConnections.toLong())).toInt()
    }
}