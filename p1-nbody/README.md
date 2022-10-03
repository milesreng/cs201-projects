# Project 1: NBody

This is the directions document for Project P1 NBody in CompSci 201 at Duke University, Spring 2022. Please follow the directions carefully while you complete the project. Please refer to the directions at https://coursework.cs.duke.edu/201spring22/p1-nbody/ rather than any forks or local copies in the event that any changes are made to the document.

## Outline
- [Background](#background)
- [Starter Code and Using Git](#starter-code-and-using-git)
- [Developing, Running, Testing Code ](#developing-running-testing-code)
  - [`CelestialBody` Variables, Constructor, and Getter Methods](#celestialbody-variables-constructor-and-getter-methods)
  - [Additional `CelestialBody` Methods](#additional-celestialbody-methods)
  - [The `NBody` Class](#the-nbody-class)
  - [`NBody` Methods](#nbody-methods)
- [Running the Simulation and Analysis](#running-the-simulation-and-analysis)
- [Submitting, Reflect, and Grading](#submitting-reflect-and-grading)

## Background

This assignment heavily borrows from Princeton and Berkeley Computer Science and the work of Robert Sedgewick, Kevin Wayne and Josh Hug.

**Context:** In 1687, Isaac Newton formulated the principles governing the motion of two particles under the influence of their mutual gravitational attraction in his famous Principia. However, Newton was unable to solve the problem for three particles. Indeed, in general, solutions to systems of three or more particles must be approximated via numerical simulations.
For a more complete understanding of the Physics you can reference [this document][Physics].

In this assignment, you will write a program to simulate the motion of _N_ objects in a plane, mutually affected by gravitational forces, and animate the results. Such methods are widely used in cosmology, semiconductors, and fluid dynamics to study complex physical systems. Ultimately, you will be creating a driver program `NBody.java` that draws an animation of bodies moving in space interacting with each other subject to interacting and mutual gravitational forces. These bodies are modeled by the class `CelestialBody.java` that you'll implement and test independently of the simulation.

Below you can expand to see an animation of a completed project running with some planets in our solar system. The animation repeats after one earth year, your program continues until the simulation completes.

<details>
<summary>Example Simulation of Complete Project</summary>

<div align="center">
  <img width="500" height="500" src="p1-figures/planets.gif">
</div>

</details>


## Starter Code and Using Git
You must have installed all software (Java, Git, VS Code) before you can complete the project.You can find the [directions for installation here](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/installingSoftware.md).

We'll be using Git and the installation of GitLab at [coursework.cs.duke.edu](https://coursework.cs.duke.edu). All code for classwork will be kept here. Git is software used for version control, and GitLab is an online repository to store code in the cloud using Git.

**[This document details the workflow](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/projectWorkflow.md) for downloading the starter code for the project, updating your code on coursework using Git, and ultimately submitting to Gradescope for autograding.** We recommend that you read and follow the directions carefully while working on a project! While coding, we recommend that you periodically (perhaps when completing a method or small section) push your changes as explained in Section 5.


## Developing, Running, Testing Code

You're given the outline of a class `CelestialBody` with stub or missing methods and a constructor. You'll add code so that the class `CelestialBody.java` works as described below. This class represents a celestial body such as a planet or a sun. You'll implement [a constructor, methods to get the state of a `CelestialBody` (getters)](#instance-variables-constructors-getters) and [methods that determine the interactions between `CelestialBody` objects due to gravitational forces](#writing-the-methods). 

Finally, you will create a class `NBody.java` that drives a simulation between planets, suns, and celestial bodies interacting. This class will read a file of data that specifies the initial positions and masses of the bodies and then simulates their interaction over a set time period. The simulation will also animate the interactions between the bodies.

There are classes provided that help you test whether your constructor, getters, and interaction methods are correct. Running each `TestX` class will print *PASS* or *FAIL* messages to your terminal/console. You should only proceed to the next step when you've passed the current test. When these tests pass, there's a good chance your code is correct, but you may uncover additional errors when you run the `NBody` simulation.


### `CelestialBody` Variables, Constructor, and Getter Methods

This section introduces the `CelestialBody` class and describes its instance variables, constructor, and getter methods, which you will need to implement.

<details>
<summary>CelestialBody Instance variables</summary>

The outline below shows the constructor, methods, and instance variables (or fields)  of the `CelestialBody` class. All instance variables should be `private`. All methods should be `public` (if you write helper methods they should be `private`).

<div align="center">
  <img width="400" height="400" src="p1-figures/celestialBodyMethods.png">
</div>

You'll have six instance variables: `myXPos`, `myYPos`, `myXVel`, `myYVel`, `myMass`, `myFileName`. The first five have type `double`, the last is a `String`.
</details>

<details>
<summary>CelestialBody Constructor</summary>

You'll have one constructor: it has six parameters, one for each instance variable. The signatures of is shown below. 

<div align="center">
  <img width="576" height="248" src="p1-figures/celestialBodyConst1.png">
</div>

</details>

<details>
<summary>CelestialBody Getter Methods</summary>
You'll also write six so-called getter methods specified in the class. The body of each method is a single return statement, returning the value of the corresponding instance variable. These getter methods allow the values of `private` instance variables to be accessed outside the class. For example, the method `getXVel()` is shown below. These are getter methods because they do not allow client programs to set the values, only to get the values. **You should include a comment for each getter method. Use the one for `getXVel` below as a model.

<div align="center">
  <img width="310" height="115" src="p1-figures/getXVel.png">
</div>

</details>

When you've implemented the constructor and the six getter methods you should be able to run the program in `TestBodyConstructorGetters.java` to see if your code is correct. When it reports that everything works you can proceed to the next step in implementing the `CelestialBody` class. The report from running `TestBodyConstructorGetters` indicates whether each getter method passes.

### Additional `CelestialBody` Methods

Now that you have the constructor and getter methods for the `CelestialBody` class, this section details the additional methods you will need to implement. 

<details>
<summary>The method CelestialBody.calcDistance</summary>

<br>

 <div align="center">
  <img width="420" height="128" src="p1-figures/calcDistance.png">
</div>

<br> 

This method returns the distance between two `CelestialBody` objects. Use the standard distance formula to determine the distance between `this` body (using `myXPos` and `myYPos` or `this.myXPos` and `this.myYPos`) and the `CelestialBody` object specified by the parameter `b`. The distance is the value of $`r`$ in the formula below where

```math
r^2=dx^2 + dy^2
```

where $`dx`$ is delta/difference between $`x`$-coordinates, similarly for $`dy`$.  Use `Math.sqrt` to calculate the return value.

</details>

<details>
<summary>The method CelestialBody.calcForceExertedBy</summary>

<br>

<div align="center">
  <img width="372" height="58" src="p1-figures/calcForceExertedBy.png">
</div>

<br>

This method calculates and returns the force exerted on `this` body by the body specified as the parameter. You should calculate the force using the formula below. You can read about the physics of the formula in the [NBody Physics document][Physics].

```math
F = G\frac{m_1m_2}{r^2}
```
 
Here $`m_1`$ and $`m_2`$ are the masses of the two bodies, $`G`$ is the gravitational constant ($`6.67 \cdot 10^{-11}\frac{N-m^2}{kg^2}`$), and $`r`$ is the distance between the two objects. Call `calcDistance` to determine this distance. You can specify $`G`$ as 6.67*1e-11 using scientific notation in Java. 

When you've implemented this method, test it by running `TestCalcForceExertedBy.java`.


</details>

<details>
<summary>The methods CelestialBody.calcForceExertedByX and calcForceExertedByY</summary>

<br> 

<div align="center">
  <img width="428" height="20" src="p1-figures/calcForceExertedByX.png">
</div>

<br> 

These two methods describe the force exerted in the X and Y directions, respectively. The signature of `calcForceExertedByX` is shown above; `calcForceExertedByY` has a similar signature. 

You can obtain the $`x`$- and $`y`$-components from the total force using the formulas below, where $`F`$ is the value returned by `calcForceExertedBy`, $`r`$ is the distance between two bodies, and $`F_x`$ and $`F_y`$ are the values to be returned by `calcForceExertedByX` and `calcForceExertedByY`, respectively. Note that $`dx`$ that $`dy`$ in the formula are $`\Delta x`$ and $`\Delta y`$, the difference between $`x`$ and $`y`$ coordinates respectively between the original body (`this`, the object on which the method is called) and the exerting body (the argument to the method).

```math
F_x = F\frac{dx}{r}\\~\\
F_y = F\frac{dy}{r}
```

Note: Be careful with the signs! In particular, be aware that $`dx`$ and $`dy`$ are signed (positive or negative). By convention, we define the positive $`x`$-direction as towards the right of the screen, and the positive $`y`$-direction as towards the top.

You can read about the physics for these formulas in the NBody Physics document. You can test them using the program in `TestCalcForceExertedByXY.java`.

_**Mathematically `F/r * dx` is the same as `F*dx/r`. However, because of roundoff error these may not be the same computationally. You should use `F*dx/r` in your method**_. 

</details>

<details>
<summary>The method CelestialBody.calcNetForceExertedByX and calcNetForceExertedByY</summary>

<br>

<div align="center">
  <img width="428" height="20" src="p1-figures/calcNetForceExertedByY.png">
</div>

<br>

This method returns the total/net force exerted on this body by all the bodies in the array parameter. The principle of superposition ([see Physics][Physics]) says that the net force acting on a `CelestialBody` object by many other bodies is the sum of the pairwise forces acting on the `CelestialBody` by each body. So you'll need to sum the forces returned by `calcForceExertedByX` (or `Y`) in calculating the value to return. 

You must make sure _**NOT to include the force exerted by a body on itself!**_ The universe might collapse (Infinite/NaN error) if an object attracted itself. If you loop over each element in array `bodies`, you'll need code like what's shown below to avoid summing the force of an object on itself. In the body of the if statement you'd write code to accumulate the sum of all forces exerted on `this` `CelestialBody` by the `CelestialBody b`.

<br> 

<div align="center">
  <img width="289" height="39" src="p1-figures/forLoop.png">
</div>

<br> 

You can test your code by running the program in `TestCalcNetForceExertedByXY.java`.


</details>

<details>
<summary>The method CelestialBody.update</summary>

<br> 

<div align="center">
  <img width="379" height="39" src="p1-figures/update.png">
</div>

<br> 

This method is a so-called _mutator_. It doesn't return a value, but updates the state/instance variables of the `CelestialBody` object on which it's called. 

This method will be called during the simulation to update the body's position and velocity with small time steps (the value of the first parameter, `deltaT`). The values of parameter `xforce` and `yforce` are the net forces exerted on this body by all other bodies in the simulation. When code calls the update method from `NBody.java`, you will determine the values of the arguments passed as these two parameters by calling `calcNetForceExertedByX` (or `Y`). In the formulas below the parameter `xforce` is $`F_x`$ and `yforce` is $`F_y`$. 

This update method updates the instance variables `myXPos`, `myYPos`, `myXVel`, and `myYVel` in four steps.

1. First, calculate the acceleration using Newton's second law of motion where $`m`$ is the mass of the `CelestialBody`. This creates two variables for acceleration in the $`x`$ and $`y`$ directions.

```math
a_x = \frac{F_x}{m}\\~\\
a_y = \frac{F_y}{m}
```
 
2. You'll then calculate values for new `myXVel` and `myYVel`, we'll call these `nvx` and `nvy` where the $`n`$ is for new, using the relationship between acceleration and velocity, e.g., `nvx = myXVel + deltaT*ax`.

3. You'll use `nvx` (and a corresponding `nvy`) to calculate new values for `myXPos` and `myYPos` using the relationship between position and velocity, e.g., `nx = myXPos + deltaT*nvx`.

4. _**After**_ you've calculated `nx`,`ny`,`nvx`, and `nvy`, you'll assign these to the instance variables `myXPos`, `myYPos`, `myXVel`, and `myYVel`, respectively. 

These steps will update the position and velocity of the body making the simulation possible. You can test this method using `TestUpdate.java`.

</details>

<details>
<summary>The method CelestialBody.draw</summary>

<br>

This **void** method is described below in the section for `NBody` that describes where to call the CelestialBody.draw method. _**This method is already written, you don't need to write it.**_
</details>

After developing, implementing, testing, and debugging these `CelestialBody` methods you're ready to move to the simulation code.

### The `NBody` Class

The `NBody` class will use `CelestialBody` objects to run the simulation.

<details>
<summary>Details on the CelestialBody class</summary>

This class consists only of `static` methods, including the main method that runs the simulation. Your task will be to implement the three `static` methods that have been outlined for you in the starter code. That code has `// TODO` comments indicating the code you need to add in the three `static` methods. These methods are described below.

<div align="center">
  <img src="p1-figures/NBodyMethods.png">
</div>

</details>

<details>
<summary>Details on Data Format</summary>

The data for planets, suns, and celestial bodies in general is in the format shown below. All files in the folder data are in this format. This is the file `planets.txt`:

<div align="center">
  <img src="p1-figures/format.png">
</div>

The first value is an integer _**n**_, the number of bodies for which data is given in the file. The next value is a `double`, the radius of the universe for the simulation. This value is used to set the scale for the animation.

There are _**n**_ lines, one line for each `CelestialBody`. Each line contains six values as shown above. The first five values are `doubles`: the first two are initial x and y coordinates; the next two are initial x and y velocities; the next is the mass of the `CelestialBody`. The last value on a line is a `String` specifying the file in the images folder used for the animation of the simulation.

</details>


### NBody Methods

This section describes the details of each of the three `static` methods you need to implement for the `NBody` class.
<details>
<summary>The method NBody.readRadius</summary>

<br>

Given a file name, this method should return a double corresponding to the radius of the universe in that file, e.g. `readRadius("./data/planets.txt")` should return 2.50e+11. You'll need to read the `int` value that's the number of bodies, then read the `double` value for the radius using the `Scanner` already created in the starter code. Use `s.nextInt()` and `s.nextDouble()` for the `Scanner` variable `s` to read an `int` and `double` value, respectively. Your code in `readRadius` must read both values, but only the radius is returned. The number of bodies (first value in a data file) is ignored.

You can test your method using the provided `TestReadRadius.java` program.

</details>

<details>
<summary>The method NBody.readBodies</summary>

<br>

This method returns an array of `CelestialBody` objects using the data read from the file. For example, `readBodies("./data/planets.txt")` should return an array of 5 `CelestialBody` objects. You will use the number of bodies (first value in data file) to create a `CelestialBody []` array to return. When created, each value in the array will be `null`, but you will read the values on each line and use these as parameters when you call `new` and create a `CelestialBody` object with the parameters on each line of the file.

As you iterate through the information for each of the `CelestialBody` objects in the file, you will find the `nextInt()`, `nextDouble()`, and `next()` methods in the Scanner useful in reading `int`, `double`, and `String` values, respectively. Note that `next()` returns a `String`. Since each line has the same types of values, your for-loop will read data, create a new `CelestialBody` object with this data, then store it in the array you created before the loop.

You can test this method using the supplied `TestReadBodies.java` class. 


</details>

<details>
<summary>The method NBody.main</summary>

<br> 

You'll see four TODO comments in the loop of the `main` method. Completing these will make your simulation run correctly and provide an animation of the simulation. 

Completing the last TODO first will show a non-moving image for each body in the simulation. _**You'll write a for-each loop over each `CelestialBody` object referenced in the array**_ `bodies` in the `main` method. In the loop you'll call the `CelestialBody.draw` method on each `CelestialBody` in the array, the `draw` method is already written and draws an image at the body's location for the body on which it's called.

Most of the other TODOs in the outer, simulation loop require implementing a loop body, just as the drawing TODO used a loop over all the bodies. **You'll need to fill in the loop body**. There are three loops:
1. Fill two arrays with x- and y- forces; the first loop.
2. Call `update` on each body, using `dt` and the corresponding elements of these arrays as parameters.
3. Call `draw` on each body.

- Create an `xForces` array and `yForces` array. Each should have the same size as the number of bodies in the simulation. You'll make new arrays on each iteration of the outer/simulation loop.
- Calculate the net x and y forces for each body, storing these in the `xForces` and `yForces` arrays respectively. You'll need to loop over bodies to do this, updating array entries in your loop. You'll call `calcNetForceExertedByX`, for example, to determine the values stored in the `xForces` array.
- Call update on each of the bodies. This will update each body's position and velocity. Again, you'll write a loop over bodies to do this. A separate loop after the previous one. The empty loops are given to you in the code.

</details>


## Running the Simulation and Analysis

When the simulation is over your code prints out the final state of the universe in the same format as the input, you can expand below for an example.

<details>
<summary>Example Simulation Output</summary>

|             |             |             |           |           |          |
| :---        |    :----:   |       :---: |  :---:    | :---:     | ---:     |
| 5           |             |             |           |           |          |
| 2.50e+11  |            |             |             |           |           |
| 1.4631e+09 | 1.4943e+11 | -2.9831e+04 | 4.0749e+02 | 5.9740e+24 |earth.gif |
|-1.1174e+11 |-1.9803e+11 |  2.0989e+04 | -1.1953e+04 |  6.4190e+23 |   mars.gif |
| 2.4125e+10 | 5.2103e+10 | -4.3685e+04 | 2.0627e+04 | 3.3020e+23 | mercury.gif |
| 5.6664e+05 | 7.0808e+06 | 1.0861e-01 | 1.0639e-01 | 1.9890e+30  |    sun.gif |
| 1.0555e+11 | 2.3363e+10 |-7.5708e+03 | 3.4204e+04 | 4.8690e+24 |   venus.gif |

</details>

The code for printing is given to you in the `NBody.java` you start with. This code isn't all that exciting (which is why we've provided a solution), but we'll need this method to work correctly to autograde your assignment. ***You should NOT print anything other than the final printing shown here***. This printing is done after your simulation completes. If you use debugging print statements, be sure to remove them before testing in Gradescope.

When the simulation finishes, you'll need to close/quit the graphics window to be able to run another simulation. Use the red X button in the upper left of the graphics window to dismiss the window.


### Analysis

This is a section where you gain further understanding of the project by running experiments with your code and drawing conclusions on the resulting behavior. You will need to run the simulation and observe the output to answer the questions. Write your answers in a text file / word processor and then **submit the answers as a PDF to the Analysis assignment on Gradescope.** Teaching assistants will look at your responses and grade them.

1. Copy/paste the output of your simulation when using planets.txt, running the simulation for 1,000,000 (one  million) seconds, and with a time-step/dt value of 25,000.
2. Copy/paste the output of your simulation when using planets.txt, running the simulation for 2,000,000 (two  million) seconds, and with a time-step/dt value of 25,000.
3. Run the simulation for a billion seconds (10^9) and a time-step/dt of a million. You should see behavior inconsistent with what is
expected for celestial bodies. Why do you think increasing the time-step/dt to 1 million caused your simulation to behave this way?
4. Run the simulation with the original time and dt values (`double totalTime = 39447000.0;` and `double dt = 25000.0;`), but use the input data file "data/kaleidoscope.txt". In fewer than 50 words describe the visualization you observe.


## Submitting, Reflect, and Grading
You will submit the assignment on Gradescope. You can access Gradescope through the tab on Sakai. The [project workflow writeup](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/projectWorkflow.md) explains the how to submit your project in detail. In particular, you cannot submit unless all your code has been pushed to your Git repository on coursework. Be sure to push changes often and be sure your final program is in your Git repository before you submit it for autograding on Gradescope. Please take note that changes/commits on GitLab are NOT automatically synced to Gradescope. You are welcome to submit as many times as you like, only the most recent submission will count for a grade.

**After completing the coding portion, fill out the [reflect form here](https://forms.office.com/Pages/ResponsePage.aspx?id=TsVyyzFKnk2xSh6jbfrJTErNjWEU70pGg_ytfEVEPi5UQkZSRUVQR0NXWjhXOTFYTjFRVUUyN0o0Si4u).**

You'll upload a PDF for the analysis part of this assignment. This is a *separate submission* in Gradescope.

### Grading

The autograder will check all your CelestialBody methods and the NBody methods as well. You'll be able to see the results of running the tests when you submit to gradescope.

| Points | Grading Criteria |
| ------ | ------ |
| 16 | Autograded constructor and methods for CelestialBody and code in NBody|
| 6 |  Answers to analysis questions + reflect form |


[Physics]:https://docs.google.com/document/d/1LRRW970ZwgZQtsif1L1SfRBTlB_VUGJAZKYol-DHGWE/edit?usp=sharing




