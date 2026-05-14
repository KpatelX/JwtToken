# Spring Boot + MongoDB + JWT Authentication 🔐

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue" />
  <img src="https://img.shields.io/badge/SpringBoot-4.0.2-green" />
  <img src="https://img.shields.io/badge/MongoDB-Database-success" />
  <img src="https://img.shields.io/badge/JWT-Authentication-orange" />
</p>

---

## 🚀 Overview

<p>
This project demonstrates secure user authentication using 
<strong>Spring Boot</strong>, <strong>MongoDB</strong>, and <strong>JWT tokens</strong>. 
It includes CRUD operations, login/logout Get and Add user APIs, and token validation configuration and security.
</p>

---

## ✨ Features

<ul>
  <li>User CRUD with MongoDB</li>
  <li>JWT-based authentication</li>
  <li>Secure endpoints with Spring Security</li>
  <li>Logout with token blacklist Or Expiry</li>
</ul>

---

## 🛠 Tech Stack

<table>
  <tr>
    <td><b>Backend</b></td>
    <td>Java 17, Spring Boot, Spring Security</td>
  </tr>
  <tr>
    <td><b>Database</b></td>
    <td>MongoDB</td>
  </tr>
  <tr>
    <td><b>Authentication</b></td>
    <td>JWT (JSON Web Tokens)</td>
  </tr>
</table>

---

## ⚙️ Setup Instructions

<ol>
  <li>Clone the repo: <code>git clone https://github.com/KpatelX/JwtToken</code></li>
  <li>Configure <code>application-dev-profile.properties</code> with MongoDB & JWT settings</li>
  <li>Run: <code>mvn spring-boot:run</code></li>
  <li>Test APIs with Postman</li>
</ol>

---

## 📡 API Endpoints

<table>
  <tr>
    <th>Endpoint</th>
    <th>Method</th>
    <th>Description</th>
    <th>Postman Example</th>
  </tr>

  <!-- Add User -->
  <tr>
    <td><code>/users/addUser</code></td>
    <td>POST</td>
    <td>Create a new user in MongoDB</td>
    <td>
      <pre>
POST 'localhost:9090/users/addUser'
--header 'Authorization: Bearer &lt;JWT_TOKEN&gt;'
--header 'Content-Type: application/json'
--body '{
  "user_name": "kp12",
  "password": "kp122",
  "first_name": "kartik",
  "middle_name": "r.",
  "last_name": "patel"
}'
      </pre>
    </td>
  </tr>

  <!-- Login -->
  <tr>
    <td><code>/auth/login</code></td>
    <td>POST</td>
    <td>Authenticate user and return JWT</td>
    <td>
      <pre>
POST 'localhost:9090/auth/login'
--header 'Content-Type: application/json'
--body '{
  "user_name":"kp",
  "password":"kp122"
}'
      </pre>
    </td>
  </tr>

  <!-- Logout -->
  <tr>
    <td><code>/auth/logout</code></td>
    <td>POST</td>
    <td>Invalidate JWT token (blacklist)</td>
    <td>
      <pre>
POST 'localhost:9090/auth/logout'
--header 'Content-Type: application/json'
--body '{
  "jwt_token": "&lt;JWT_TOKEN&gt;"
}'
      </pre>
    </td>
  </tr>

  <!-- Get Users -->
  <tr>
    <td><code>/users/getUsers</code></td>
    <td>GET</td>
    <td>Fetch all users</td>
    <td>
      <pre>
GET 'localhost:9090/users/getUsers'
--header 'Authorization: Bearer &lt;JWT_TOKEN&gt;'
      </pre>
    </td>
  </tr>
</table>


---

## 🔮 Future Improvements

<ul>
  <li>Add role-based authorization</li>
  <li>Integrate refresh tokens</li>
  <li>Dockerize the application</li>
</ul>

