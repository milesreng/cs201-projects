# Project 0: Person201

## Outline
- [Goals](#goals)
- [Starter Code and Using Git](#starter-code-and-using-git)
- [Developing and Running the classes in Project P0: Person201](#developing-and-running-the-classes-in-project-p0-person201)
- [Submission and Grading](#submission-and-grading)


## Goals

* To practice the workflow of a project in CompSci201
* To see, edit, and run a multi-file Java program
* To create a Java class from scratch that is used by other Java classes
* To read data from a file in Java
* To practice introductory object-oriented programming
* To learn about using Git for project management.


## Starter Code and Using Git
**_You must have installed all software (Java, Git, VS Code) before you can complete the project._** You can find the [directions for installation here](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/installingSoftware.md).

We'll be using Git and the installation of GitLab at [coursework.cs.duke.edu](https://coursework.cs.duke.edu). All code for classwork will be kept here. Git is software used for version control, and GitLab is an online repository to store code in the cloud using Git.

**[This document details the workflow](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/projectWorkflow.md) for downloading the starter code for the project, updating your code on coursework using Git, and ultimately submitting to Gradescope for autograding.** We recommend that you read and follow the directions carefully this first time working on a project! While coding, we recommend that you periodically (perhaps when completing a method or small section) push your changes as explained in Section 5.


## Developing and Running the classes in Project P0: Person201

When you fork and clone the project, you'll be working primarily within the `src` folder with `.java` files beginning with `Person201`. Your goal is to modify three programs/classes (`Person201.java`, `Person201Driver.java`, and `Person201Scanner.java`) and create a new program (`Person201Solo.java`) to generate the desired output. You will need some information from the output to complete the reflect document linked at the end of this document.

The following subsections sections detail the specific action items you should take while completing this project. To see the details for a section, just click the small arrow to expand the information, or click the small arrow again to collapse those details.

### Run `Person201Driver.java` and change `Person201.java`
<details>
<summary>Initial Runs and Changes</summary>

First run the main method in `Person201Driver.` The output of the program should be:

```
no-name woto @ 35.9312N 79.0058W
Ricardo harambee @ 34.6037S 58.3816W
Gelareh affective @ 33.89S 151.2E
name woto
name woto
```

Next, open `Person201.java` in the VS Code editor, and look at each of the three `//TODO: change here` comments in the `Person201.java` class. Fix the code so that when the same `Person201Driver` main program is run the output is as shown below:

```
Owen woto @ 35.9312N 79.0058W
Ricardo harambee @ 34.6037S 58.3816W
Gelareh affective @ 33.89S 151.2E
Ricardo harambe
Gelareh affective
```

You can accomplish the above in three steps:
1. Changing the value assigned to instance variable `myName` in the default constructor
2. Changing the body of the method `getPhrase` to return the person's phrase (use an instance variable).
3. Changing the body of the method `getName` to return the person's name (use an instance variable).

Now that you've done this, change the `main` method in class `Person201Driver` by creating a new `Person201` variable named s (short for Sam) with the value shown:

`Person201 s = new Person201("Sam", 44.9978, -93.2650, "hello");`

Add one `System.out.println` statement to print the value of this variable `s` so the output of running the program is as follows:

```
Owen woto @ 35.9312N 79.0058W
Ricardo harambee @ 34.6037S 58.3816W
Gelareh affective @ 33.89S 151.2E
Sam hello @ 44.9978N 93.265W
Ricardo harambee
Gelareh affective
```
</details>

### Running Person201Scanner and changing Data Source
<details>
<summary>Scanning from Another File</summary>

Once the `Person201` class has been updated so that `Person201Driver` generates output as shown above, you should run `Person201Scanner` to see the output below -- running the program is described after the output.

```
Owen woto @ 35.9312N 79.0058W
Ricardo harambee @ 34.6037S 58.3816W
Gelareh affective @ 33.89S 151.2E
total # 3
```

You'll then need to Run `Person201Scanner`.

You should edit the `main` method of `Person201Scanner.java` so that the file `data/large.txt` is used as the source of data. This data file includes a random set of names, locations, and words from several sources. You should see 97 different names, phrases and latitude/longitude locations.
</details>

### Running Person201Scanner from a Web Source
<details>
<summary>Scanning from a Web source</summary>

In the `main` method of `Person201Scanner` create a new `String` variable after the first line, as shown below (you can copy/paste):
```bash
String url = "https://courses.cs.duke.edu/compsci201/current/data/medium.txt";
```
Then change the assignment to variable list so that it is:
```bash
Person201[] list = readURL(url);
```
Run the program and note the last name and the number of names printed to answer the questions in the reflect form linked at the end of this document. Refer to [this guide](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/APTWorkflow.md#running-your-code) for more on running programs.
</details>

### Create and Run a New Java Class: **Person201Solo.java**
<details>
<summary>Creating and running a new class</summary>


In the `src` folder create a new Java class named `Person201Solo` that has only a `public static void main(String[] args) method` that allows the program to run (the `main` method is the launch point for all Java programs when they are executed). See `Person201Driver` for details and an example of a `main` method. In the new `main` method, you should define a `Person201` object as shown below and print using `System.out.println(person)` so that the main method has two statements.

```
Person201 person = new Person201("Sam", -77.846, 166.668, "cold");
System.out.println(person);
```
</details>


## Submission and Grading
You will submit the assignment on Gradescope. You can access Gradescope through the tab on Sakai. The [project workflow writeup](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/projectWorkflow.md) explains the how to submit your project in detail. In particular, you cannot submit unless all your code has been pushed to your Git repository on coursework. Be sure to push changes often and be sure your final program is in your Git repository before you submit it for autograding on Gradescope. Please take note that changes/commits on GitLab are NOT automatically synced to Gradescope. You are welcome to submit as many times as you like, only the most recent submission will count for a grade.

After completing the coding portion, fill out the [reflect form here](https://forms.office.com/Pages/ResponsePage.aspx?id=TsVyyzFKnk2xSh6jbfrJTErNjWEU70pGg_ytfEVEPi5UQkhYTkVGMVROUFdWR1VPOE5DRk5FRkowRC4u).


### Grading
Your submission will be graded by the following rubric:

| Class Modified | Points |
| ------ | ------ |
| Person201 | 4 |
| Person201Driver | 4 |
| Person201Solo | 4 |
| Reflect form | 4 |

The first four categories will be autograded on Gradescope, the reflect form will be graded by teaching assistants.
