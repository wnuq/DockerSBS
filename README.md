# Docker Spring Boot Sample

## Documentation

* [How  run image](#how-run-image) 
* [Other options](#other-options) 

## How run image

To build Docker image from Dockerfile use below command. Option -t allow adding own tag name from the image. Dot at the end of command means that Docker will try find Dockerfile in a current folder.

```
    docker build -t springsbs .
``` 

Then we can check that image was created. We use image command to display all created images.

```
    docker image ls
```

To run create image on port 8080 we use below command. Parameter -p means port, value before ':' is a target host port. If we skip this parameter, then we lose possibility to get access to application by http. We must map container port to host port, even if they are the same.

```
    docker run -p 8080:8080 springsbs
```

## How stop container

If we want stop container we must use second terminal and use there stop command.

```
    docker ps
    docker stop <few first chas from CONTAINER ID>
```

## Remove container

If we want remove stopped container we must display all containers (first command) and then use rm parameter.

```
    docker ps -a
    docker rm <few first chas from CONTAINER ID>
```

## Other options

Parameter -it run container in an interactive mode, is possible use ctrl+c to stop container.

```
    docker run -it -p 8080:8080 springsbs
```

Parameter -d (must be before 'p' responsible for port binding), detach logs from terminal and create possibility to do some other actions after run container in one terminal. 

```
    docker run -dp 8080:8080 springsbs
```

If we detach from running container, and we want see logs from there we can use below command. If we add -f parameter then we will stay connected, and we will see all new logs.

```
    docker logs <CONTAINER ID>
    docker logs <CONTAINER ID> -f
```

Below command works only for an image where we have linux system. We can use this when we want connect to system and do some actions in the container.

```
    docker exec -it <CONTAINER ID> /bin/bash
```

