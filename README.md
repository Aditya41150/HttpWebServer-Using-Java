# Simple Java HTTP Server

A lightweight HTTP server written in Java that serves static HTML files.

## Features
- Serves an `index.html` file from a `public/` directory
- Basic 404 error handling
- Lightweight and minimal dependencies

## Project Structure
```
/YourProjectFolder
├── /public
│   ├── index.html  # Main HTML file
├── /src
│   ├── HttpServer.java  # Java HTTP Server
├── README.md
```

## Prerequisites
- Java Development Kit (JDK) installed (Java 8+ recommended)

## Setup & Running the Server
1. Clone the repository:
   ```sh
   git clone https://github.com/Aditya41150/HttpWebServer-Using-Java.git
   cd HttpWebServer-Using-Java
   ```
2. Compile the Java server:
   ```sh
   javac src/HttpServer.java
   ```
3. Run the server:
   ```sh
   java -cp bin HttpServer
   ```
4. Open your browser and visit:
   ```
   http://localhost:8080/
   ```
