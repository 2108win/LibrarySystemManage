#LibrarySystemManage
[![Image LSM](https://raw.githubusercontent.com/2108win/WinLax-Portfolio/main/public/images/projects/LSM.jpeg "Image LSM")](https://raw.githubusercontent.com/2108win/WinLax-Portfolio/main/public/images/projects/LSM.jpeg "Image LSM")
# Step 1: Download the project
- Method 1: Clone project from github, command:
     `git clone https://github.com/2108win/LibrarySystemManage.git`
- Method 2: Access the GG Drive link:
 - [Download here](https://drive.google.com/drive/folders/1d6iM0bLhE0J7LGBJDkrRK4DyDVVYVxEA?usp=sharing "folder")
 - Download `LibrarySystemManage.rar` folder
 - Unzip the folder and open with NetBeans

# Step 2: Add necessary Packages if missing
- If you see an error, it means that all the libraries have not been installed. Install the library by right-clicking on the **Libraries folder → Add JAR/Folder...**
- Add all .Jar files in the folder with the path in the downloaded file with the path `"LibrarySystemManage\src\JarLibrary"`

# Step 3: Add a database, using MySQL
- Create a new database named `library_ms`.
- Import the existing database file into the downloaded file named "library_ms.sql".
- Adjust database configuration:
 - Port `8111`, User `root` password is blank.
 - If you cannot adjust the port to 8111, go to the DBConnection.java file at the path `"LibrarySystemManage\src\dao"` and adjust the port according to the computer's configuration. (Default is 3306).
 - After importing the database file, see if there are all 4 tables including `"users"`, `"book_details"`, `"student_details"`, `"issue_book_details"`.
- If so, the database connection is **successful**.

# Step 4: Run the program
- Account: 1234
- Password: 1234
- Can create a new user.
