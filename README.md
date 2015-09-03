**FileChecker**

FileChecker is a simple utility that can help you in making your life easier, by handling the donkey work in many ways. Couple of them are given under... 
- If you have made copies for backups and wanted to compare them
- If you wanted to see the changed files in multiple backups
 
	FileChecker will only compare the file attributes but not contents.

**Inputs:** Main Directory, Multiple Compare Directories, Depth, Check for comparing file sizes, Check for modified date attribute. Option to ignore files in the directory if the directory do not exist. 

**Output:** Count of files, Files in Main directory and not in Compare directory, File in Compare directory and not in Main directory and attributes for these files like size, absolute paths, relative paths, modified date

Core Application should read the UserInput and traverse the directory structures and build data structures from them. These data structures will then be compared and a result data structure is created. 

**Application Components:**
1. Parser to parse the directory structure and save in a data structure
2. Analyzer to analyze the copies of the data structure and save the results in a report data structure.
3. Reporter can be either console or Swing reporter or web reporter..

&copy; Novicehacks.com 
 
