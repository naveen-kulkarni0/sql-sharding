package org.example.repository

import org.example.config.ConnectionConfig
import java.sql.Connection
import java.sql.DriverManager.getConnection

private val connectionConfigs = listOf(
    ConnectionConfig( "jdbc:mysql://localhost:3306/demo","root","example"),
    ConnectionConfig( "jdbc:mysql://localhost:3307/demo","root","example")
)

private val connections: List<Connection> = connectionConfigs.map { openConnection(it) }

val totalDBs = connections.size

private fun openConnection(connectionConfig: ConnectionConfig): Connection {
    val connection: Connection
    try {
        // Get connection using helper function
        return getConnection(connectionConfig.url, connectionConfig.username, connectionConfig.password)

    } catch (e: Exception) {
        e.printStackTrace()
        throw e;
    }
}

fun insert(index:Int, username:String){
    val query = "INSERT INTO demo.users(username) values (?)"
    val prepareStatement = connections[index].prepareStatement(query)
    prepareStatement.setString(1,username)
    prepareStatement.execute()
}