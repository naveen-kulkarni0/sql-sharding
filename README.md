# sql-sharding-demo
This is a demo project of sharding sql database. The sharding strategy is a simple hash based sharding.
This project uses strategy design pattern, and it is easier to add and use another sharding strategy.

# Running the code
This project uses two mysql instances one running on 3306 and another on 3307. This mysql can be started using
`$ docker-compose up` . Once the docker is up, you can run this project by changing and passing the right strategy.