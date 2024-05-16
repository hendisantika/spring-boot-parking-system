# spring-boot-parking-system

# Parking System Backend

### Class Diagram

![class diagram](https://github.com/deeppatel23/parking-system/blob/main/Class_Diagram.png?raw=true)

### User Authentication

- SignUp: http://localhost:5001/api/auth/signup
  ```
  "username":"test2",
  "email":"test2@gmail.com",
  "password":"12345678",
  "mobile":"1234567890",
  "drivingLisence":"GJ12345",
  "role":["user"]
- SignIn: http://localhost:5001/api/auth/signin
  ```
  "username":"test2",
  "password":"12345678"
- SignOut: http://localhost:5001/api/auth/signout
- Details of user: http://localhost:5001/api/auth/details/test2
- Insert into roles tables
  ```
    INSERT INTO roles(name) VALUES('ROLE_USER');
    INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
    INSERT INTO roles(name) VALUES('ROLE_ADMIN');
- Email verification with Gmail SMTP server

### Vehicle

- Add: http://localhost:5001/api/vehicle/add
  ```
  "color":"red",
  "username":"test2",
  "registerationNumber":"GJ26M2020",
  "model":"Activa 5G",
  "size":"SIZE_SMALL"
- Search by username: http://localhost:5001/api/vehicle/user/test
- Search by Registration Number: http://localhost:5001/api/vehicle/regnum/GJ26M2018

### Parking

- Add: http://localhost:5001/api/parking/add
  ```
  "name":"A104",
  "floor":"1",
  "username":null,
  "vehicleRegisterationNumber":null,
  "size":"SIZE_MEDIUM"
- Park: http://localhost:5001/api/parking/park (here id is parkingSlotId)
   ```
    "id": 1,
    "floor":"1",
    "username":"test",
    "vehicleRegisterationNumber":"GJ26M2014"
- Unpark: http://localhost:5001/api/parking/unpark/{userId}
- List of Empty parking slots: http://localhost:5001/api/parking/empty
- Find parking slot by name: http://localhost:5001/api/parking/name/A101
- Find parking slot by floor: http://localhost:5001/api/parking/floor/1
