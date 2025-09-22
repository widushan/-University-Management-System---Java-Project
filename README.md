
# University Management System

An all-in-one Java application for managing students, lecturers, payments, results, and more in a university environment. Centralizes data and streamlines administrative tasks.

---

## Features
- Add, view, and update student and lecturer information
- Manage payments and fee structures
- Enter and view exam results
- Student leave management
- Secure login system
- Modern UI with images and icons

## Technologies Used
- Java (Swing for GUI)
- MySQL (database)
- JDBC (database connectivity)
- External libraries: jcalendar, rs2xml

## Getting Started
1. **Clone the repository**
	```
	git clone https://github.com/widushan/-University-Management-System---Java-Project.git
	```
2. **Set up MySQL database**
	- Import SQL files from `SQL queries/` into your MySQL server
	- Update database credentials in `Conn.java` if needed
3. **Add required JARs**
	- Place `mysql-connector-java-8.0.28.jar`, `jcalendar-1.4.jar`, and `rs2xml.jar` in your project
4. **Compile and run**
	- Use your IDE or run from command line:
	  ```
	  javac *.java
	  java Splash
	  ```

## Usage
- Start with the login screen
- Navigate through modules to manage students, lecturers, payments, and results
- Refer to screenshots in the `icons/` folder for UI previews

## Folder Structure
- `SQL queries/` - Database scripts
- `icons/` - Images for UI
- `com/toedter/calendar/` - Calendar library
- `.java` files - Source code

## Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License
This project is for educational purposes.

## Contact
- Author: widushan
- GitHub: [widushan](https://github.com/widushan)
