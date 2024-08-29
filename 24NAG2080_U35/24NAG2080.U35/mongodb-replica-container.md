 1. Create a docker compose file with that name **docker-compose.yml** along with the content below:
```yml
services:
  mongo:
    container_name: mongo
    image: mongo:6.0
    command:  ["--replSet", "konbit-rs", "--bind_ip_all"]
    restart: always
    environment:
      - MONGO_INITDB_ROOT_USERNAME=
      - MONGO_INITDB_ROOT_PASSWORD=
    ports:
      - 27017:27017
    volumes:
      - data_vol:/data/db
      - configdb_vol:/data/configdb
```
2. Run docker compose command to start **mongodb** container in either one of these modes:
    ***Foreground** mode for debugging purpose or  first time glance and live log output*
    ```shell
    #will start the mongodb container in foreground
    docker compose up
    ```
    or 
    Daemon mode for normal and regular operation
    ```shell
    #will start mongodb container in background
    docker compose up -d
    ```
3. Use **mongosh** in order to connect to your local mongodb instance 
   ```shell
   mongosh
   ```
   Setup your replica once and for all with these instructions by typing them on your your mongosh session prompt:
   ```javascript
   rs.initiate()
   ```
   Check your replica status
   ```javascript
   rs.status()
   ```
Now your Mongodb setup is over and is ready to be used

Use this mongodb URI below either in  your application or Mongodb Compass to be able to connect successfuly to this local replica:
```shell
mongodb://127.0.0.1:27017/?directConnection=true
```
    

