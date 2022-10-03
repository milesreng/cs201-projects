# Project 4: DNA LinkStrand

## Outline
- [Background and Introduction](#project-background-and-introduction)
- [Part 1: Running DNABenchmark, Profiling, Analysis](#part-1-running-dnabenchmark-profiling-analysis)
- [Part 2: Programming](#part-2-programming-linkstrand)
- [Part 3: More Benchmarking and Analysis](#part-3-more-benchmarking-and-analysis)
- [Submitting, Reflect, and Grading](#submitting-reflect-and-grading)

## Project Background and Introduction

In this assignment you'll experiment with different implementations of a simulated [restriction enzyme cutting](https://en.wikipedia.org/wiki/Restriction_enzyme) (or cleaving) of a DNA molecule. In this context, you will study the application of the linked list data structure toward a real world problem in scientific computing.

Specifically, you will develop a `LinkStrand` class, an implementation of the `IDnaStrand` interface that uses an internal linked list to model recombinant DNA. Your implementation will be much more efficient for modeling DNA splicing operations than using a String or StringBuilder (as in the provided `StringStrand` and `StringBuilderStrand` classes respectively, which provide correct but less efficient implementations of the `IDnaStrand` interface). You will benchmark and analyze the efficiency improvements of the `LinkStrand` implementation over those provided in the starter code when conducting simulations of gene splicing experiments.

<details>
<summary>Optional Historical Details</summary>

[Three scientists shared the Nobel Prize](http://nobelprize.org/nobel_prizes/medicine/laureates/1978/press.html) in 1978 for the discovery of restriction enzymes. They're also an essential part of the process called [PCR polymerase chain reaction](http://en.wikipedia.org/wiki/Polymerase_chain_reaction) which is one of the most significant discoveries/inventions in chemistry and for which Kary Mullis won the Nobel Prize in 1993.

Kary Mullis, the inventor of PCR, is an interesting character. To see more about him see this archived copy of a [1992 interview in Omni Magazine](http://web.archive.org/web/20010121194200/http://omnimag.com/archives/interviews/mullis.html) or his [personal website](http://karymullis.com/) which includes information about his autobiography Dancing Naked in the Mind Field, though you can read this free [Nobel autobiography](https://www.nobelprize.org/prizes/chemistry/1993/mullis/biographical/) as well.

The simulation coded here is a simplification of the chemical process, but provides an example of the utility of linked lists as a data structure for certain algorithmic processes. 
</details>

### DNA strands and the Starter Code

For the purposes of this project, DNA is represented as a sequence of characters, specifically `a`, `c`, `g`, and `t` for the four chemical bases of DNA. There can be a *lot* of these bases in a DNA sequence, so efficiency matters when dealing with DNA data computationally. This project includes a `data/` folder containing two data files: `ecoli.txt` and `ecoli_small.txt`, which represent the genetic information of ecoli - there are over 4.6 million bases in the full sequence in `ecoli.txt`. The `DNABenchmark` program provided in the starter code simulates a gene splicing experiment on a DNA sequence, and we will use the `ecoli.txt` data for our simulations.

You should read the comments in the `IDnaStrand` interface to understand what functionality implementations of that interface should provide with respect to manipulating DNA data. You will note that some methods in the interface have a `default` implementation provided, but most do not -- these are the methods you will be implementing. 

Two relatively straightforward implementations of the `IDnaStrand` interface are provided in the starter code. `StringStrand` represents a DNA sequence as a simple String. `StringBuilderStrand` represents a DNA sequence as a  [`StringBuilder`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html). You can look at these two classese to see simple and correct (but not necessarily efficient) implementations of the functionality specified in the `IDnaStrand` interface.

### Overview: What to Do

Here's a high-level view of the assignment if you would like a general roadmap. This is enough information to know what to do, but not necessarily how to do it. For details, you can refer to sections later in this write-up. 

<details>
<summary>High-level overview of the project</summary>

1. In [Part 1](#part-1-running-dnabenchmark-profiling-analysis) you will run the benchmarking program using the provided starter `StringStrand` and `StringBuilderStrand` implementations of the `IDnaStrand` interface.
2. In [Part 2](#part-2-programming) You will create a new class `LinkStrand` that implements the `IDnaStrand` interface. It will utilize a singly linked-list to store the strand information. There are two constructors and several methods to implement. You should read the comments in the `IDnaStrand` interface and use the existing implementations `StringStrand` and `StringBuilderStrand` to understand what these methods should do.
3. In [Part 3](#part-3-more-benchmarking-and-analysis) You will again the benchmarking program `DNABenchmark` but now using the newly coded `LinkStrand` class - note the efficiency and memory of the program compared to when you ran the program with `StringStrand` and `StringBuilderStrand`. You will answer analysis questions about the runtime performance and memory use.

</details>

### Git and Partners, and Submitting for P4

<details>
<summary>Details on Standard Project Workflow</summary>
You must have installed all software (Java, Git, VS Code) before you can complete the project.You can find the [directions for installation here](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/installingSoftware.md). We'll be using Git and the installation of GitLab at [coursework.cs.duke.edu](https://coursework.cs.duke.edu). All code for classwork will be kept here. Git is software used for version control, and GitLab is an online repository to store code in the cloud using Git.

**[This document details the workflow](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/projectWorkflow.md) for downloading the starter code for the project, updating your code on coursework using Git, and ultimately submitting to Gradescope for autograding.** We recommend that you read and follow the directions carefully while working on a project! While coding, we recommend that you periodically (perhaps when completing a method or small section) push your changes as explained in Section 5.
</details>

For this project (P4 DNA LinkStrand), **you are allowed to work with a partner** (that is, in a group of two). If you are working with a partner, read the details in the expandable section below on how to collaborate using Git. 

<details>
<summary>Details on Git with a Partner for P4</summary>

You may find it helpful to begin by reading the Working Together section of the [Git tutorial](https://gitlab.oit.duke.edu/academic-technology/cct/-/tree/master/git) from the Duke Colab.

One person should fork the starter code and then add their partner as a collaborator on the project. Choose Settings>Members>Invite Members. Then use the autocomplete feature to invite your partner to the project as a *maintainer*. Both of you can now clone and push to this project. See the [gitlab documentation here](https://docs.gitlab.com/ee/user/project/members/).

Now you should be ready to clone the code to your local machines.

1. Both students should clone the same repository and import it into VS Code just like previous projects.  
2. After both students have cloned and imported, one person should create the `LinkStrand.java` class and add a comment to it with their name in a comment at the start of the file. Commit and push this change. 
3. The other partner will then issue a git pull request. Simply use the command-line (in the same project directory where you cloned the starter code for the project) and type:
```bash
git pull
```
4. If the other partner now opens the project in VS Code again, they should see the modified `LinkStrand.java` file created by the first partner. 
5. You can continue this workflow: Whenever one person finishes work on the project, they commit and push. Whenever anyone starts work on the project, they begin by downloading the current version from the shared online repository using a git pull command.

This process works as long as only one person is editing at a time, and **you always pulls before editing** and **commit/push when finished**. If you forget to pull before editing your local code, you might end up working from an old version of the code different than what is in the shared online gitlab repository. If that happens, you may experience an error when you attempt to push your code back to the shared online repository. 

There are many ways to resolve these conflicts. See the [working together Git tutorial](https://gitlab.oit.duke.edu/academic-technology/cct/-/blob/master/git/working_together.md) [branching and merging Git tutorial](https://gitlab.oit.duke.edu/academic-technology/cct/-/blob/master/git/branching_merging.md) from the Duke Colab for more information. You can also refer to our [Git troubleshooting document](https://coursework.cs.duke.edu/201-public-documentation/resources-201/-/blob/main/troubleshooting.md#git-faq). 

Additional resources: if you have any concerns about using Git with a partner, please consult the [Git troubleshooting guide](https://coursework.cs.duke.edu/cs201projects/resources-201/-/blob/main/gitTroubleshooting.md) or watch [this extended tutorial from spring 2021](https://duke.zoom.us/rec/play/SaYwuDmE_e1ktnTdXyZFlUB4Je0jAp90JJsYpv6nGO_6xgn2eTFqcR9poqNQpKOqlswpyR54w5lkpw.jhA1Dob-5DIFNjdB?continueMode=true&_x_zm_rtaid=WRHafTqZSU-Bw07DppwXJg.1614437909258.5f6f5e1afb9e427d7e1e52e2574318f9&_x_zm_rhtaid=958) on setting up Git with a partner.

</details>



## Part 1: Running DNABenchmark, Profiling, Analysis

You can do this Part 1 without writing any linked list code. We strongly suggest you do this before starting on Part 2 of the assignment where you will program a linked list.

### `cutAndSplice` Simulation Complexity with `StringStrand` an `StringBuilderStrand`

The `main` method of `DNABenchmark` simulates a DNA splicing experiment represented by the `cutAndSplice` method (implemented in `IDnaStrand` with complexity that depends on which implementation of the interface is being used). The expandable section below describes what this method simulates and how to reason about its complexity using the provided starter implementations `StringStrand` and `StringBuilderStrand`.

<details>
<summary>Complexity of cutAndSplice</summary>

The method `cutAndSplice` is not a mutator. It starts with a strand of DNA and creates a new strand by finding each and every occurrence of a restriction enzyme like `“gaattc”` and replacing this enzyme by a specified splicee -- another strand of DNA. If `dna` represents the strand `"cgatcctagatcgg"` then the call 

```java
dna.cutAndSplice("gat", "gggtttaaa")
```

would result in returning a new strand of DNA in which each occurrence of the enzyme/strand `"gat"` in the object `dna` is replaced by the splice, `"gggtttaaa"` -- as shown in the diagram below where the original strand is shown first, with the enzyme `"gat"` shaded in blue. A new strand of DNA is created and returned in which each occurrence of the enzyme `"gat"` is replaced by the splicee `"gggtttaaa"` as shown below. This diagram illustrates how `cutAndSplice` works with both `StringStrand` and `StringBuilderStrand`. Each is a strand of 14 characters in which the restriction enzyme `"gat"` occurs twice, is replaced by `"gggtttaaa"`, resulting in creating and returning a new strand that contains 26 characters.

<div align="center">
  <img src="p4-figures/splice.png">
</div>

If the original strand has length N, then the new strand has N + b(S-E) characters where b is the number of breaks, or occurrences of the enzyme, S is the length of the splicee and E is the length of the enzyme. In the diagram above we have 14 + 2(9-3) which is 26. If we assume the splicee is large, as it will be when benchmarking, we can ignore E and this becomes N + bS. 

This expression represents the memory used for the last strand created, not the total memory used (see below). The runtime will depend on how long it takes to concatenate two character-sequences. Concatenating two String objects requires creating a new String, so the time to concatenate two strings of length A and B is A + B. For `StringBuilder` objects, the time to append a String of length B to a `StringBuilder` of length A is just B, since the `StringBuilder` is altered so it has length A + B by simply appending B characters. If we append a character sequence of length S and we do this b times, then if we start with an empty strand (which isn't the case, because the original strand of DNA is added to via the `cutAndSplice` method) then we'd have the following sequence of b string concatenations using `StringStrand`.

S

S + S

S + S + S

…

S + … + S (b times) for the last concatenation

This is (1 + 2 + .. + b)S which is O(b<sup>2</sup>S). Note that if we use `StringBuilderStrand` objects we'd simply append S a total of b times for an O(bS) runtime for creating the new strand.  Of course, searching for the b breaks requires O(N) time for an N-character strand.

</details>

### Benchmarking `StringStrand` and `StringBuilderStrand`

You'll need to run the `main` method of the `DNABenchmark` four times in total, once for each implementation of the `IDnaStrand` interface you're given in the starter code: `StringStrand` and `StringBuilderStrand`, and once using each of the two provided benchmarking methods `standardBenchmark` and `newBenchmark`. Running the program will open a graphical file selector interface: Select the `ecoli.txt` file inside of the `data` folder. Make sure to save your results for answering analysis questions later.

You select which implementation to use changing the value of the static instance variable `strandType` at the top of the class file; you can change which benchmark to run by changing the method called in the `main` method. Note that the **`StringStrand` class will take a very, very, very long time (several minutes) to run!** If you wish, you can terminate those runs early (after you have several rows of results) by pressing the red stop square in VS Code. Expand below for the details and example output. 

<details>
<summary>Details on Benchmarking with standardBenchmark</summary>

By default, the `main` method of `DNABenchmark` uses the `standardBenchmark` method, also provided in `DNABenchmark`. The method simulates a DNA splicing experiment with a DNA strand with a constant number `b` of breaks (occurrences of restriction enzymes) but with an increasingly larger `splicee` (the DNA sequence copied at each restriction enzyme). 

The `standardBenchmark` runs until memory is exhausted.  Example results are shown below from an instructor/TA laptop; your results will likely differ slightly and may run out of memory at a different point, but should show a similar overall trend. The benchmark code runs two experiments to average the results, so it will take longer than the reported averages.

<details>
<summary>StringStrand standardBenchmark Example Results</summary>

```
dna length = 4,639,221
cutting at enzyme gaattc
-----
Class	                splicee	      recomb	time	appends
-----
StringStra:	            256	      4,800,471	0.429	1290
StringStra:	            512	      4,965,591	0.446	1290
StringStra:	          1,024	      5,295,831	0.481	1290
StringStra:	          2,048	      5,956,311	0.535	1290
StringStra:	          4,096	      7,277,271	0.659	1290
StringStra:	          8,192	      9,919,191	1.080	1290
StringStra:	         16,384	     15,203,031	1.603	1290
StringStra:	         32,768	     25,770,711	2.636	1290
StringStra:	         65,536	     46,906,071	4.707	1290
StringStra:	        131,072	     89,176,791	9.468	1290
StringStra:	        262,144	    173,718,231	17.172	1290
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.base/java.util.Arrays.copyOf(Arrays.java:3537)
	at java.base/java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:228)
	at java.base/java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:582)
	at java.base/java.lang.StringBuilder.append(StringBuilder.java:175)
	at StringStrand.append(StringStrand.java:70)
	at IDnaStrand.cutAndSplice(IDnaStrand.java:38)
	at DNABenchmark.strandSpliceBenchmark(DNABenchmark.java:72)
	at DNABenchmark.standardBenchmark(DNABenchmark.java:116)
	at DNABenchmark.main(DNABenchmark.java:163)
```

</details>

<details>
<summary>StringStrand newBenchmark Example Results</summary>

```
dna length = 4,639,221
cutting at enzyme gaattc
-----
Class	                splicee	      recomb	time	appends
-----
StringStra:	          4,096	      7,277,271	0.647	1290
StringStra:	          4,096	     14,554,542	2.757	2580
StringStra:	          4,096	     21,831,813	6.293	3870
StringStra:	          4,096	     29,109,084	11.742	5160
StringStra:	          4,096	     36,386,355	18.227	6450
StringStra:	          4,096	     43,663,626	26.720	7740
StringStra:	          4,096	     50,940,897	39.016	9030
StringStra:	          4,096	     58,218,168	46.087	10320
StringStra:	          4,096	     65,495,439	58.608	11610
StringStra:	          4,096	     72,772,710	77.266	12900
```

</details>


<details>
<summary>StringBuilderStrand standardBenchmark Example Results</summary>

```
dna length = 4,639,221
cutting at enzyme gaattc
-----
Class	                splicee	      recomb	time	appends
-----
StringBuil:	            256	      4,800,471	0.016	1290
StringBuil:	            512	      4,965,591	0.015	1290
StringBuil:	          1,024	      5,295,831	0.013	1290
StringBuil:	          2,048	      5,956,311	0.013	1290
StringBuil:	          4,096	      7,277,271	0.012	1290
StringBuil:	          8,192	      9,919,191	0.013	1290
StringBuil:	         16,384	     15,203,031	0.014	1290
StringBuil:	         32,768	     25,770,711	0.017	1290
StringBuil:	         65,536	     46,906,071	0.023	1290
StringBuil:	        131,072	     89,176,791	0.040	1290
StringBuil:	        262,144	    173,718,231	0.067	1290
StringBuil:	        524,288	    342,801,111	0.173	1290
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.base/java.util.Arrays.copyOf(Arrays.java:3537)
	at java.base/java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:228)
	at java.base/java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:582)
	at java.base/java.lang.StringBuilder.append(StringBuilder.java:175)
	at StringBuilderStrand.append(StringBuilderStrand.java:70)
	at IDnaStrand.cutAndSplice(IDnaStrand.java:42)
	at DNABenchmark.strandSpliceBenchmark(DNABenchmark.java:72)
	at DNABenchmark.standardBenchmark(DNABenchmark.java:116)
	at DNABenchmark.main(DNABenchmark.java:163)
```

</details>

<details>
<summary>StringBuilderStrand newBenchmark Example Results</summary>

```
cutting at enzyme gaattc
-----
Class	                splicee	      recomb	time	appends
-----
StringBuil:	          4,096	      7,277,271	0.017	1290
StringBuil:	          4,096	     14,554,542	0.032	2580
StringBuil:	          4,096	     21,831,813	0.040	3870
StringBuil:	          4,096	     29,109,084	0.052	5160
StringBuil:	          4,096	     36,386,355	0.079	6450
StringBuil:	          4,096	     43,663,626	0.077	7740
StringBuil:	          4,096	     50,940,897	0.092	9030
StringBuil:	          4,096	     58,218,168	0.102	10320
StringBuil:	          4,096	     65,495,439	0.113	11610
StringBuil:	          4,096	     72,772,710	0.141	12900
```

</details>

</details>

<details>
<summary>Details on benchmarking with newBenchmark</summary>

The `main` method in `DNABenchmark` calls the method `standardBenchmark`. Replace that call with a call to the provided method `newBenchmark`. The method `newBenchmark` simulates a splicing experiment with a strand of DNA whose number of breaks (occurrences of restriction enzyme) increases linearly, **so that 10 runs are made and timed in a single run of `newBenchmark`**. In the method `standardBenchmark`, the size of the splicee changes. In this method the splicee-size is a constant, and the number of breaks changes. 

Again run the `main` method of `DNABenchmark` twice using `newBenchmark`, once with `StringStrand` and once with `StringBuilderStrand` as before. Again make sure to save your results for answering analysis questions later.
</details>

## Part 2: Programming LinkStrand

This section details how to implement the `LinkStrand` class.

### LinkStrand implements IDnaStrand

You will create a new class named `LinkStrand` from scratch. Start by creating a `LinkStrand.java` file in the `src` folder of the project. This class must implement the `IDnaStrand` interface as shown in the class header below:

```java 
public class LinkStrand implements IDnaStrand
```

VS Code will then indicate that the code will not compile. If you select the light bulb / suggestion button as indicated in the figure below, it should give you as the first suggestion to "add unimplemented methods." This will automatically generate method stubs for all of the methods in the `IDnaStrand` interface that any implementing class must provide.

<div align="center">
  <img src="p4-figures/vscode_stubs.png" width="300", height="150">
</div>
 
In addition, you need to implement two constructors as described below. The constructors and methods don't need to be implemented in the order shown, but the simpler methods are listed first. These methods are tested in the `TestStrand` class. In descriptions below `N` is the number of nucleotides/basepairs/characters in a strand.

You should test each method as you implement it using the `TestStrand` JUnit test class. You'll need to change the type of strand returned in that JUnit class method `getNewStrand` to test your class. It's unlikely that any tests will work until you've implemented `LinkStrand.toString()`.

You should run the JUnit tests in `TestStrand`. Verify that these work for `StringStrand` and `StringBuilderStrand` and then use these classes to test your `LinkStrand` implementation. 


#### 1. `LinkStrand` State, Constructors and `initialize` Method
Implement two constructors: one with no parameters (the default constructor) and one with a `String` parameter. The constructors work by calling the required initialize method. Refer to `StringStrand.java` for an example to adapt. Implement the initialize method that initializes the `LinkStrand` object with a `String`.

<details>
<summary>Details on LinkStrand State, Constructors and initialize Method</summary>

You should start with the following definitions for a private inner class and instance variables to use a linked-list internally as part of the LinkStrand class. Note that all are private.

```java
private class Node {
     String info;
     Node next;

     public Node(String s, Node n) {
          info = s;
          next = n;
     }
}

private Node myFirst, myLast;
private long mySize;
private int myAppends;
private int myIndex;
private Node myCurrent;
private int myLocalIndex;
```

**All constructors and methods must maintain the following class invariants:**
1. `myFirst` references the first node in a linked list of nodes.
2. `myLast` references the last node in a linked list of nodes.
3. `mySize` represents the total number of characters stored in all nodes together.
4. `myAppends` is the number of times that the append method has been called. It would be useful to think of this as one less than the number of nodes in the linked list.

The following instance variables will be updated in `charAt()`:
1. `myIndex` tracks the last character we accessed with the `charAt()` method. Initialize this as `0`.
2. `myCurrent` tracks the last node holding the character at position `myIndex`. Initialize this as `myFirst`.
3. `myLocalIndex` tracks the last character we accessed within the `Node`. Initialize `this` as `0`.

Initially, when the `LinkStrand("cgatt...")` constructor is called  (though the `String` parameter can be any string) there will be a single `Node` in the linked list that represents the DNA strand `"cgatt…"`. (The only way to have more than one node in a `LinkStrand` internal linked-list is by calling `.append`.)

<div align="center">
  <img src="p4-figures/initialize.png">
</div>

As described above, you'll create two constructors. The string constructor should consist of one call to initialize which establishes the class invariant with a single node representing the entire strand of DNA as illustrated. The no-argument constructor, also called the default constructor, should have one line: `this("")` which calls the other constructor with a String parameter of `""`. 

The `initialize` method will maintain the class invariants when it's called. There will be a single node created after `initialize` is called.

</details>

#### 2. Implementing the `getInstance` and `size` Methods
Implement the `getInstance` method that works similarly to what you see in `StringStrand` and `StringBuilder` strand. This must return a `LinkStrand` object. Implement `size`. This should be a single line and must run in `O(1)` time.

<details>
<summary>Details on Implementing the getInstance and size Methods</summary>

The `getInstance` method works similarly to what you see in `StringStrand` and `StringBuilder` strand. This must return a `LinkStrand` object. 

The `size` method returns the total number of string characters in the `LinkStrand`. 

</details>

#### 3. Implementing the `append` and `getAppendCount` Methods 
Implement `append` which creates one new node and updates instance variables to maintain class invariants as described in the details below. Implement `getAppendCount`. This should be a single line and must run in `O(1)` time.

<details>
<summary>Details on Implementing the append and getAppendCount Methods</summary>

The `append` method should add one new node to the end of the internal linked list and update state to maintain the invariant. For example, suppose that these two statements are both executed:

```java
LinkStrand dna = new LinkStrand("cgatt");
dna.append("aattcc");
```
<div align="center">
  <img src="p4-figures/append.png">
</div>

The internal linked list maintained by `LinkStrand` after the first call is diagrammed above. After the call to append we have the following picture:

Note that maintaining the class invariant after this call to append would require:
1. `myFirst` doesn't change
2. `myLast` changes to point to the new node added
3. `mySize` is incremented by six
4. `myAppends` is incremented by one (because a new node is added).

Note that `.append` returns an `IDnaStrand` object. This is the object that was just modified/appended to. However, the method append does not create a new `IDnaStrand` object. The `.append` method is a mutator -- it changes the internal state of the `IDnaStrand` object on which it's invoked, and then returns this `LinkStrand` object itself. Look carefully at both `StringStrand` and `StringBuilderStand` strand to see what to return.

Note that after implementing `append`, the method `getAppendCount` should return the correct result, the value of instance variable `myAppends` that's maintained by the class invariants and initialized/updated in `initialize` and `append`.
</details>


#### 4. Implementing the `toString` Method
Implement `toString`. This returns the `String` representation of the `LinkStrand` by looping over nodes and appending their values to a `StringBuilder` object. The method should run in `O(N)` time.

<details>
<summary>Details on Implementing the toString Method</summary>

The `toString` method returns the `String` representation of the entire DNA strand. Conceptually this is a concatenation of the `String` stored in each node.

This method should use a standard `while` loop to visit each node in the internal linked list. The method creates and updates a single `StringBuilder` object by appending each `node.info` field to a `StringBuilder` object that's initially empty. The final return from `LinkStrand.toString` will simply be returning the result of calling `.toString()` on the `StringBuilder` object. See the `DNABenchmark.dnaFromScanner` implementation for guidance on the `StringBuilder` strand class.

For more guidance on `StringBuilder`, see the [Java Documentation here](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html). 

You should be able to test all the methods implemented to this point using the class `TestStrand`. The testing methods in `TestStrand` rely on `.toString` being correct, so after implementing `.toString` you may find errors in your other methods as a result of testing.

</details>

#### 5. Implementing the `reverse` Method
Implement `reverse` to return a new `LinkStrand` object that's the reverse of the object on which it's called. *This method is not a mutator, it creates a new `LinkStrand`.*

<details>
<summary>Details on Implementing the reverse Method</summary>

This method creates a new `LinkStrand` object that is the reverse of the object on which it's called. The reverse of `"cgatccgg"` is `"ggcctagc"`. This method returns a new strand; it does not alter the strand on which it's called, i.e., it's not a mutator. 

Note: you must create `N` new nodes in reversing a `LinkStrand` object with `N` nodes. If you do not, you are likely mutating/changing the `LinkStrand` being reversed.

You'll need to reverse the linked list, and reverse each string in each node of the linked list. Specifically, the reversed `LinkStrand` should have the same number of nodes as the original `LinkStrand`, but in reverse order; each internal node should also contain the reversed `String` of the corresponding node in the original `LinkStrand`.

To reverse a `String` use a `StringBuilder` appropriately --- see `StringStrand.reverse` for details on using the `StringBuilder.reverse` method. 

Note that in creating a new linked list that's the reverse of the list of nodes being traversed it's easiest to simply add a new node to the front of the reversed list being constructed. So in reversing a->b->c->d and traversing in order a,b,c,d; your code should have created the list c->b->a after traversing the first three nodes: a,b,c. When reaching the next or 'd' node your code adds 'd' to the front of this list creating d->c->b->a.

To do so, we suggest making a helper method (for example, `private void addFirst(String s)` that will prepend a new node containing the reversed version of s to the front of the linked list, changing the value of `myFirst`. This method should create a new node whose next field points to `myFirst` and modifies `myFirst` to reference this newly created node. You will *not* call `addFirst` directly from the `reverse` method, but will call `rev.addFirst` as described below (if you choose to write `addFirst`).

With this helper method, in writing `reverse` you might first create a new `LinkStrand` object storing a reference to the this new `LinkStrand` in a local variable, say `LinkStrand rev`.  Then as you traverse the linked-list being reversed, you'll make repeated calls of  `rev.addFirst(xx)` with the `xx` parameter being a String obtained by reversing the String in the node you're traversing, perhaps using a temporary `StringBuilder` object to easily reverse a String, e.g., using `StringBuilder.reverse`. 

Remember that you must be sure to update all instance variables of the local `LinkStrand rev` if they're not changed by `addFirst`, e.g., 
updating  `myFirst, myLast, mySize, myAppends, myIndex, myCurrent, myLocalIndex` for the local variable `rev` that will be returned, as well as the instance variable tracking the value of `rev.size`. This could be done automatically depending on your constructor implementation, but it may need to be done explicitly in the body of `reverse` depending on how you write your code.

</details>

#### Implementing the `charAt` method
Implement `charAt` which returns the character at a specific index. This method requires new instance variables *to meet performance characteristics.*

<details>
<summary>Details on Implementing the charAt method</summary>

This method returns the character at the specified index if that's a valid index, and throws an `IndexOutOfBoundsException` otherwise. A naive implementation of this method would start at the beginning of the linked list, the node referenced by `myFirst` and count characters until the index-th character is found. 

For full credit you'll need to maintain state so that after a call of `charAt(k)` the call of `charAt(k+1)` is an $O(1)$ operation. This will make the loop below $O(N)$ for an `N` character strand.

##### Basic, Correct but Inefficient Implementation of charAt
First we'll show an inefficient implementation of the charAt method --- a method to find a character at a specific index in a linked list of strings. Your code will need to traverse the linked list counting characters. The code below illustrates how to do this. It doesn't check to see if parameter index is valid, but it passes the JUnit tests for correctness.

```java
public int charAt(int index) {
     int count = 0;
	int dex = 0;
	Node list = myFirst;
	while (count != index) {
		count++;
		dex++;
		if (dex >= list.info.length()) {
			dex = 0;
			list = list.next;
		}
	}
     return list.info.charAt(dex);
}
```

This code will get the correct character. However, it's not efficient since it starts at the beginning of the linked list for each call. You should be sure you understand how local variables `count` and `dex` are used in the code above before trying to make the code more efficient for a sequence of calls as explained in the next section.

##### Efficient Implementation of charAt
You should create instance variables in the class `LinkStrand` so that after a call of `charAt(k)`, calling `charAt(k+1)` is an `O(1)` operation. 

To do this, you should appropriately update the following  instance variables: one for the current node in a sequence of calls of charAt, one for the current index into that node, and one for the overall count; these are explained below. 

- `myIndex` is the value of the parameter in the last call to `charAt`. This means that if a call to `s.charAt(100)` is followed by `s.charAt(101)` the value of `myIndex` will be 100 after `s.charAt(100)` executes and 101 after `s.charAt(101)` executes.
- `myLocalIndex` is the value of the index within the string stored in the node last-referenced by `charAt` when the method finishes. For example, suppose a strand consists of three nodes: the first has 60 characters; followed by a node of 30 characters; followed by a node of 40 characters. The call `s.charAt(40)` will mean that `myIndex` is 40 and `myLocalIndex` is also 40 since that's the index within the first node of the list, where the character whose index is 40 is found.  Suppose this is followed by `s.charAt(70).` The character at index 60 of the entire strand will be the character with index zero of the second node -- since the first node holds characters with indexes 0-59 since its info field is a string of 60 characters. The character at index 70 of the entire strand will be the character with index 10 of the second node. This means that after the call `charAt(70)` the value of `myIndex` will be 70, the value of `myLocalIndex` will be 10, and the value of `myCurrent` (see just below) is a pointer to the second node of a three-node list.

<div align="center">
  <img src="p4-figures/charAt.png">
</div>

- `myCurrent` is the node of the internal list referenced in the last call to `charAt`. In the example above the value of `myCurrent` would be the first node after the call `s.charAt(40)`, would be the second node after the call `s.charAt(70)` or `s.charAt(89)`, and would be the third node after the call `s.charAt(90)` since the first two nodes only contain a total of 90 characters, with indexes 0 to 89.


##### Why do we need charAt to be efficient?
If the `charAt` method is not efficient, the loop below will be `O(N^2)` since the `charAt` method will be `O(k)` to access the kth character.

```java
LinkStrand dna = new LinkStrand(".....");
StringBuilder s = new StringBuilder("");
for(int k=0; k < dna.size(); k++) {
    s.append(dna.charAt(k));
}
```

This `charAt` method is called by the code in the `CharDnaIterator` class. So iterating over an `IDnaStrand` object will ultimately use the `charAt` method as shown in the code below. 

```java
LinkStrand dna = new LinkStrand(".....");
Iterator<Character> iter= dna.iterator();
for(char ch : iter) {
    System.out.print(ch);
}
System.out.println();
```

The `Iterator` object in the code above is constructed as a result of calling the default `IDnaStrand.iterator` method, the body is shown here: 

```java
return new CharDnaIterator(this);
```

Note that the `IDnaStrand` object referenced by this is then stored in the `CharDnaIterator` object being created. 

You only need to implement `charAt`, then all the code described and shown above will work correctly! You will need to initialize the instance variables too.

##### Order of Calls Matters
However, *you'll need to write code to deal with calls that aren't "in order".* If the call `.charAt(100)` is followed by the call `.charAt(30)` you'll need to start at the beginning of the internal linked list to find the character with index 30. If `.charAt(100)` is followed by `.charAt(350)` you won't start at the first node, but continue with the values stored in the instance variables.

</details>


## Part 3: More Benchmarking and Analysis

In [Part 1](#part-1-running-dnabenchmark-profiling-analysis) you benchmarked the `StringStrand` and `StringBuilderStrand` implementations of the `IDnaStrand` interface using the `standardBenchmark` and `newBenchmark` methods within the `main` method of `DNABenchmark`. Review the details there for how to run these benchmarks and what they mean.

Now that you have completed your implementation of `LinkStrand`, you will need to run the `main` method of `DNABenchmark` two additional times: once using `standardBenchmark` and once using `newBenchmark`. Again use the `ecoli.txt` file. Remember to save your results. Once you finish, you should have a total of 6 benchmark results: one for each combination of the implementations (`StringStrand`, `StringBuilderStrand`, and `LinkStrand`) and benchmarks (`standardBenchmark` and `newBenchmark`).

Recall that `DNABenchmark` simulates a splicing experiment with DNA data. The complexity of the `StringStrand` and `StringBuilderStrand` implementations was discussed earlier in [Part 1](#part-1-running-dnabenchmark-profiling-analysis). Expand below for some discussion of the complexity using the `LinkStrand` implementation.

<details>
<summary> Complexity of cutAndSplice with LinkStrand</summary>

Recall our earlier example: If `dna` represents the strand `"cgatcctagatcgg"` then the call 

```java
dna.cutAndSplice("gat", "gggtttaaa")
```

would result in returning a new strand of DNA in which each occurrence of the enzyme/strand `"gat"` in the object `dna` is replaced by the splice, `"gggtttaaa"`. 

For this example, the `LinkStrand` result is diagrammed below.

<div align="center">
  <img src="p4-figures/link-cutsplice.png">
</div>

Each time the original strand, a single string, is cut/spliced a new node is created. The nodes pointing to the splicee can point to the same splicee as shown in the diagram for the second and fourth nodes. These represent the first and second occurrences of `"gat"`, respectively. Note that this means `LinkStrand` only creates a new String once when splicing.

This diagram represents the final `LinkStrand` object after a cut-and-splice operation. That strand is created by the `default cutAndSplice` implementation that calls `toString`, `getInstance`, and `append` which in `LinkStrand` ultimately result in a sequence of nodes as shown here --- mostly because of how `append` works.

</details>

### Analysis Questions

Once you have completed benchmarking, answer the following analysis questions. **Include your answers in the PDF you submit to the analysis assignment for P4 in Gradescope.** The first two questions only use `StringStrand` and `StringBuilderStrand` as provided in the starter code, so you can answer these even if you are unable to complete the `LinkStrand` implementation.

For all of the following questions, b is the number of breaks, or occurrences of the restriction enzyme, and S is the length of the splicee replacing each restriction enzyme. b is half the number of calls to append (shown in the benchmark results) since each cut (except the first) is modeled by two calls of `append` in the method `cutAndSplice` -- see the code. S is shown directly in the splicee column of the benchmark results. Keep in mind that timings with larger values of b and S may be more reliable indicators of the asymptotic big O complexity of the code.

**Question 1:** Report your `standardBenchmark` and `newBenchmark` results using the `StringStrand` implementation. Do the benchmark timings support the hypothesis that the runtime complexity of `cutAndSplice` when using `StringStrand` is O(b^2 S)? Explain your answer. Be specific and refer to your data.

**Question 2:** Report your `standardBenchmark` and `newBenchmark` results using the `StringStrand` implementation. Do the benchmark timings support the hypothesis that the runtime complexity of `cutAndSplice` when using `StringBuilderStrand` is O(bS)? Explain your answer. Be specific and refer to your data.

**Question 3:** Based on the discussion of complexity in this writeup and the implementations of `cutAndSplice` and `LinkStrand`, what should the big O runtime complexity of `cutAndSplice` using `LinkStrand` be in terms of b and S? Explain your answer, referencing the implementation of `LinkStrand`.

**Question 4:** Report your `standardBenchmark` and `newBenchmark` results using the `LinkStrand` implementation. Do the benchmark timings support your hypothesis about the runtime complexity of `cutAndSplice` when using `LinkStrand` from the previous question? Explain your answer. Be specific and refer to your data.

**Question 5:** The `standardBenchmark` runs until it runs out of memory. Which of the three implementations (`StringStrand`, `StringBuilderStrand`, or `LinkStrand`) was able to scale to the largest size splicee (the value of S) before running out of memory in the `standardBenchmark`? Explain why this class was more memory efficient, referencing the implementation. 


## Submitting, Reflect, and Grading 

Push your code to Git. Do this often. Once you have run and tested your completed program locally:

1. Submit your code on gradescope to the autograder.
2. Submit a PDF to Gradescope in the separate P3: Analysis assignment. Be sure to mark pages for the questions as explained in the [gradescope documentation here](https://help.gradescope.com/article/ccbpppziu9-student-submit-work#submitting_a_pdf).
3. Complete the [reflect form linked here](TODO).

If you worked with a partner, you and your partner will submit **together for the code and analysis** but **separately for the reflect.** Refer to [this document](https://docs.google.com/document/d/e/2PACX-1vREK5ajnfEAk3FKjkoKR1wFtVAAEN3hGYwNipZbcbBCnWodkY2UI1lp856fz0ZFbxQ3yLPkotZ0U1U1/pub) for submitting to Gradescope with a partner. 

For this project, the grading will be:

| Points | Grading Criteria |
| ------ | ------ |
| 16 | Code for LinkStrand. Correctness, efficiency of `.charAt`, specification conformance. Autograded. |
| 6 | Analysis and reflect. Teaching assistants will grade and comment on this.  |
