# Theory class 4

- **Class Date: 20 January 2020**  

## Review
1. What are the two facts of software/program/code?
2. What were two attributes of good code we discussed?
3. Which of the two attributes should we focus from the very beginning? Which one we can ignore to start with?
4. What is the process of changing a bad code to good?

## Rules of code quality at Streams Tech Ltd
Because code quality is so important, at Streams Tech, we had 4 rules to maintain code quality. Anyone breaking any of the rules will have to give 20 Taka to a pizza fund. And of course, s/he will have to refactor it so that the rule is obliged.

1. A function cannot have more than 10 lines: The number 10 does not come from any study or anything, the point is, the functions should be short. Because the number of lines is easy to measure, we used this metric and thought 10 is a quite flexible limit.
2. The use of keyword “static” is banned except for main method: You could write static of course, but to do so you will have to submit an application to the CTO mentioning your problem and the solution where you are requiring “static”. If the CTO approves, you are good to go.
3. Cannot use conditional based on type of something. Example, `user.Role == “employee”`, `shape.Type == “triangle”`.
4. Duplicate code cannot exist.

## What is a readable code
A code that correctly reflects the problem it is solving.

## Identifying Code Smells
1. Meaningless names
2. Blacksheep - some of the conditionals does not align with others.
3. Duplicate code - sometimes caused by unnamed concepts

## Introduction to Refactoring

> _“Refactoring is the process of changing a software system in such a way that it does not alter the external behavior of the code yet improves its internal structure.”_ - Martin Fowler

Based on the definition above, can you identify which of the following are incorrect use of the term refactoring?  
1. Let's refactor the code to so that these bugs are fixed.
2. Because of refactoring, that feature was automatically implemented.
3. I refactored the code so that the new feature can easily be implemented.

## Unit Testing
How do we ensure that our code’s external behavior has not altered? Of course, by testing it. But how do we test it? Normally you might have always tested by running the app and going to the feature that changed code is related to and doing this and that to see if its still ok. But that is very tedious, slow and error prone. Developers has an automated test at their end called “Unit Test”.  
As the name suggests, this test is about testing “units”. Let's skip the formal definition of unit, for now, this is sufficient to assume that a unit is a public method. So we will be testing methods using Unit Test.

## Baby Step
This is suggested that refactoring steps are very small. After every small change, we will run the unit tests and see if its still green (meaning everything is OK). If some tests are red (meaning something has been broken because of the change), we will have to revert that change. This concept of small steps of refactoring is often called “baby step”.

