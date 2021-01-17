# LockedMe Project

## Project Description

As a Full Stack Developer, complete the features of the application by planning the development in terms of sprints and then push the source code to the GitHub repository. As this is a prototyped application, the user interaction will be via a command line.

Company Lockers Pvt. Ltd. hired you as a Full Stack Developer. They aim to digitize their products and chose LockedMe.com as their first project to start with. You’re asked to develop a prototype of the application. The prototype of the application will be then presented to the relevant stakeholders for the budget approval.

## Requirements

- The source code should be pushed to your GitHub repository. You need to document the steps and write the algorithms in it.
- The submission of your GitHub repository link is mandatory. In order to track your task, you need to share the link of the repository. You can add a section in your document.
- Document the step-by-step process starting from sprint planning to the product release.
- Application should not close, exit, or throw an exception if the user specifies an invalid input.
- You need to submit the final specification document which includes:
  - Project and developer details
  - Sprints planned and the tasks achieved in them
  - Algorithms and flowcharts of the application
  - Core concepts used in the project
  - Links to the GitHub repository to verify the project completion
  - Your conclusion on enhancing the application and defining the USPs (Unique Selling Points)

## Planning

### Flowchart

![Flowchart](https://user-images.githubusercontent.com/58124052/104653073-aab8b880-567f-11eb-8876-fb503ce1c90e.png)

### Sprints

#### Sprint 1:

- Build welcome screen
- Add app name and developer details
- Show main menu
- Add option to display all files in ascending order
- Implement display function
- Add option to close the application
- Implement closing function

#### Sprint 2:

- Show option to display all file operations
- Show file operations menu
- Add option to add files
- Implement add file function
- Add option to return to main menu

#### Sprint 3:

- Add option to delete files
- Implement delete function
- Add option to search for file
- Implement option to search for file using regex

### Data Structures and Algorithms

#### TreeSet

A TreeSet was chosen as the data structure here because, each file will have a unique name and the names of the files will be sorted into their naturally occurring order.

The set is not thread-safe and will need to be synchronized if multiple threads are accessing the set at the same time and at least one thread is modifying the set. The basic operations of the set, including add, remove, and contains, require a guaranteed time complexity of log(n).

#### ArrayList

An ArrayList was implemented in the searching algorithm because, the total number of files in the directory is unknown. The ArrayList can be resized depending on the need of the search results.

The ArrayList is not thread-safe and would need to be synchronized if multiple threads were accessing the list at the same time. The basic operations of the list require a time complexity of n.

#### Searching Algorithm

Since the data structure implemented is a TreeSet, a simple searching method would be to use the contains operations which would have a time complexity of log(n). However, to include regular expressions or regex for pattern matching I have implemented an ArrayList. For this, I looped over the TreeSet checking for any file name matching the regex and pushed the selected file name to the ArrayList. Finally, I looped over the list and printed out the matching file names.

### Future plans

- Implement option for user to add multiple files at once
- Create a GUI to improve ease of use
- Create a user and admin system to prevent certain files and folders from being copied or altered
- Implement user and admin login
- Allow user to read contents of selected file

## Technologies Used

- Eclipse/IntelliJ: An IDE to code for the application
- Java: A programming language to develop the prototype
- Git: To connect and push files from the local system to GitHub
- GitHub: To store the application code and track its versions
- Scrum: An efficient agile framework to deliver the product incrementally
- Search and Sort techniques: Data structures used for the project
- Specification document: Any open-source document or Google Docs

## Examples

### Welcome page and display all files

![display-files](https://user-images.githubusercontent.com/58124052/104829307-1f365780-5838-11eb-8302-b8582a28713e.png)

### Add files

![add-files](https://user-images.githubusercontent.com/58124052/104829308-22c9de80-5838-11eb-8dfc-83b77d37350f.png)

### Delete files

![remove-file](https://user-images.githubusercontent.com/58124052/104829320-2bbab000-5838-11eb-9df6-e800a6a24af6.png)

### Search files

![file-search](https://user-images.githubusercontent.com/58124052/104829312-25c4cf00-5838-11eb-937c-44a292ee167c.png)

### Exit program

![exit-program](https://user-images.githubusercontent.com/58124052/104829316-29585600-5838-11eb-9618-98d364e768d6.png)
