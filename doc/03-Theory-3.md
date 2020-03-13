# Theory class 3

- **Class Date: 13 January 2020**  
- **Topic: Introduction to Clean Code**  
- **Reference: Chapter 1 of *Clean Code***

## The Software Scientists
The following people are some of the pioneers of software engineering processes. I call them software scientists. There are more like them, we will know the people who relate to the topics as the course progresses.
* Robert Martin (AKA Uncle Bob)
* Martin Fowler
* Kent Beck

## School of Thought
When inside a school of thought, we assume that our beliefs are correct. It makes it easy to communicate. However, we do not claim that this correctness is absolute. Also, there might be other schools of thought which have their own beliefs. After we gain sufficient confidence in our school of thought, we should explore others too. Afterall, software engineering is an art and no art is absolute.

For this course, we will mostly follow Uncle Bob’s school of thought. I will also share my own thoughts which may sometimes a bot deviate from what's in the literature.

Anyway, good thing about schools of thoughts is, they all agree on most of the fundamental concepts of the subject matter. Most of the time it's only the very deep details where they differ.

## References Materials for the Course
Refer to the [Google Sheet](https://docs.google.com/spreadsheets/d/1_IWu2E8tXV3a36d1s1kjHVeYEFWUDq5CDzx34PyNmzI/edit#gid=1023390812).

## The 99 Bottles problem
The problem is taken from *99 Bottles of OOP* by Sandy Metz and Katrina Owen. Consider the following song


> **The 99 Bottles Song**

> 99 bottles of milk on the wall, 99 bottles of milk.   
> Take one down and pass it around, 98 bottles of milk on the wall.  

> 98 bottles of milk on the wall, 98 bottles of milk.  
> Take one down and pass it around, 97 bottles of milk on the wall.  

> (…  … … … … …Keep repeating upto 3 bottles… … … … … … )  

> 2 bottles of milk on the wall, 2 bottles of milk.   
> Take one down and pass it around, 1 bottle of milk on the wall.  

> 1 bottle of milk on the wall, 1 bottle of milk.   
> Take it down and pass it around, no more bottles of milk on the wall.  

> No more bottles of milk on the wall, no more bottles of milk.  
> Go to the store and buy some more, 99 bottles of milk on the wall.

Our task is to write a function `verse` that takes an integer as a parameter and returns the verse that starts with that number of bottle. For example, `verse(31)` should return:  

*31 bottles of milk on the wall, 31 bottles of milk.*   
*Take one down and pass it around, 30 bottles of milk on the wall.*  


## A dirty solution of 99 Bottles
Let's consider the following solution:  
*The code will be added here.*  
Try to identify problems in this code?

Try to identify if there is any problem with the code. You may notice the following issues:

* Parameter n is poorly named. Without looking into the code,we are not sure if it represents the bottle number or the verse number.
* Too many nested ifs
* The method is (perhaps) too long
* Same strings are repeated several times
* Same conditions are repeated several times  

If we want to summarize, the code is hard to read.

## 2 facts about software and software development
1. f a software is being used, change request will be there, no matter what the software is.
   1. For client project, clients will be requesting change
   2. For public facing software
      1. users will be requesting new features
      2. The company/developers will analyze use cases and figure out required changes
   3. For your pet-project, you will be the one who will be changing the code every time.
2. Code is read far more times than it is written. And in many cases, code is read by the authors themselves.

Implications of the first fact is that **code should be easy to change**.  
Implication of this is that **code should be easy to read** (to others and to you). Even if writing readable code is hard, we should work hard to make sure reading is easy.

## Code Quality Matters

> I know of one company that, in the late 80s, wrote a killer app. It was very popular, and lots of professionals bought and used it. But then the release cycles began to stretch. Bugs were not repaired from one release to the next. Load times grew and crashes increased. I remember the day I shut the product down in frustration and never used it again. The company went out of business a short time after that.   
> Two decades later I met one of the early employees of that company and asked him what had happened. The answer confirmed my fears. They had rushed the product to market and had made a huge mess in the code. As they added more and more features, the code got worse and worse until they simply could not manage it any longer. It was the bad code that brought the company down.   
> *- Uncle Bob in his book "Clean Code"*

Now answer the following questions:
1. Have you ever suffered because of bad code?
2. Perhaps yes, why did you write it then? - Perhaps you had a rush?  

As we learn more in this course, we will see that writing bad code does not really save time.

## My experience about code quality
When I was in Streams Tech, we got a project that was started by another team (another company too). They worked on it for some years, then could not manage it any longer because the code became a mess. Whenever a new change or bugs took too long for them to implement or fix. Eventually the clients did not want to work with them anymore and somehow found us.  
When the project was handed over to our team, the first thing our CTO told us is to *refactor* it.

## Taking the responsibility of bad code
Now we know that bad code is bad, really bad, so bad that you can lose a project, even your product can run out of business. Therefore, we do not want to write bad code. But the thing is, everyone knows this and no one wants to write bad code. So how do the code become so dirty?  
Most common answers (from professionals) would be - 
1. Requirements change too quickly that we cannot keep the original design
2. Schedule too tight
3. Stupid managers
4. Intolerant customers

Uncle Bob claims that the fault is ours, the developers’. We have to change our attitude.
* We have to be passionate about quality of code
* We are the one who understand the risk of poor code, we must make others understand it, or if they don’t agree, impose it.

## Art and craft of clean code
Every art has a craft related to it. People’s capability of doing a form of art, say painting or playing football comes by born, or we can say it's someone's inherent capability. However, craft can be learned. *[see note below]*  
Programming, OO programming in our context, is no exception. I believe programming’s craft part is larger than its art part. We can most certainly learn the craft of programming, and be hopeful that we will be able to feel more of its art part by learning the crafts. You see, art is to feel, while craft has to learn.

## Recognizing vs Writing Clean Code
Read the refereed book chapter where it says it's easier to identify a bad code that it is to write a good code for it. In this course, we will be learning how to write good code.

## What is Clean Code
Best clean is where nothing exists, but that clean is undesirable.  
Attributes of a clean code, by priority -
* Easy to read
* Easy to change

Note that easy to change is hard to define because we do not know in advance that what changes are coming. Therefore it is prescribed that we do not focus on “easy to change” too early. In fact, if a code is easy to read, it's also easy to “make it easy to change”. Later in the course we will learn about “*opening* a code to a change”.

## Refactoring
Refactoring is the process of improving a code, without changing its original behavior. We will learn more about it later in the course.

---
 Note: I learned about this idea from *The Art and Craft of Problem Solving* by *Paul Zeitz*. It's a book related to mathematical problem solving but covers quite a lot of psychological aspects of problem solving in general.