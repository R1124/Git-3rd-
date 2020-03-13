# Theory class 1 and 2

### Things may seem different
While the basic principles remain the same, you may notice some change in some of  the concepts you learned in OOC-I. The change is due to the way we practically implement the concepts, relative importance of the concepts and some other factors.

### The story of Toobaa
> When Toobaa, my daughter, was 2 years old, she could tell names of some of the toy’s she had. One day I was picking toys from her toy-basket one by one and asking their names.  
"Toobaa, what is it?” - “Pengu”  
“And this?” - “Car”  
“This one?” - “Ball”  
“This?” - “Toy”  
Wow! I was amazed! I picked a stove but she did not know its name. What she knew is, these all are her toys! 

Can you link this with any OO concepts?  
This idea, understood by a two year old kid, happens to be the fundamental concept of OO design. This is polymorphism. This says that Stove is a Toy. Anything that can be used to play is a toy.

### Let's agree on some unambiguous vocabularies
- General term for interface, class, abstract class and enum is **type**.
- General term for inheriting a class or implementing an interface will be **subtyping**.
  - If `A` extend `B`, `A` is subtype of `B`
  - If `P` implements `Q`, `P` is subtype of `Q`  
- We will not normally distinguish among composition, aggregation and delegation. We will commonly call them **composition**.  

## Revisiting the fundamentals
### Objects and Types
In OO, non-physical entities are represented by objects
* The date 8 January 2019 is an object
* Numbers 3, 9, 2.67 are objects
* Concepts can be object - 
  * 2018 Summer Final Exam of IUT is an object of Exam type
  * CSE department of IUT is an object of Department type

### Relationship between classes
Answer the followings
* Are *Mosque*, *Engine* Type or Object?
* Is *IUT* has a *Mosque* a correct example of has-a relation?
* Is *IUT* is a *Place* a correct example of is-a relation?

Mosque and Engine are both classes. Mosque may seem to be an object of type Place, however, Mosque is a better candidate to be a subtype of a Place in most cases. Note that *IUT Mosque* is an object, *the engine of the bus you recently travelled* in is an object.

*has-a* and *is-a* both are relations between two types. Since IUT is an object, not a type, *IUT has a mosque* and *IUT is a place* are both wrong examples, although they seem just fine in common language.

### Cohesion
Do you find anything wrong with this code?
```java
class Food {
    private int foodValue = 10;

    public void eat() {
        foodValue--;
    }

    public void replenish() {
        foodValue++;
    }

    public void discharge() {
        System.out.println("Nnnnngggghhhh!");
    }
}
```

This class is not cohesive. The `discharge()` method is totally irrelevant to the other part of the class.

### Coupling
Coupling is between two or more classes. When two or more classes are too dependent on each other, we say that the classes are coupled. 

### Interface and Abstract Class
It is easy to figure out that abstract class is something in between class and interface. Is it closer to class or closer to interface?  
Abstract class is actually a class. Just like classes, abstract class has constructor. That means they can be constructed like classes. Although it cannot be constructed directly, when a child concrete class’s object is constructed, the abstract class is also constructed.
More on this topic - [What is the difference between an interface and abstract class](https://stackoverflow.com/q/1913098/887149)?

Interface has a different purpose than classes. As the course progresses, we will learn
* Interfaces acts as contract between different parts of the code
* Interfaces work as a protocol 
* Interfaces are special types of function pointers
* Interfaces are used to pass “message” without requiring to know the “method”

### Methods
Known as *behavior* of a class.

### Properties
* Known as *data* of a class.
* Combination of a field (instance variable),  its getter and its setter is properties
  * One or both of the getter and setter may exist
Some languages have special syntax for properties. Example, C#, JavaScript
* Properties are extensively used by libraries, frameworks and reusable components therefore the distinction from normal fields is important.

### Polymorphism
Which of the two polymorphisms seems more useful for OO design? Static or dynamic?

Although you learned the two types of polymorphism in previous course, we will no longer talk about static polymorphism. In fact, when we say polymorphism is a fundamental feature of OO, we refer just to dynamic polymorphism. Static polymorphism has nothing to do with OOP. We will discuss quite a lot about dynamic polymorphism later in the course.

### Encapsulation
Access modifiers (public, private) are quite useful for encapsulation, however, they do not essentially imply encapsulation. Encapsulation means exposing the features that are useful to the other part of the code.

**Food for thought**: why would we want to use a private field with a public getter setter instead of just a public field? Does it really imply encapsulation?

### Inheritance
Inheriting interface? - Implementing interface is generally referred to as inheritance, however, if we want to be very precise, this becomes technically incorrect. Inheritance is extending a concrete or abstract class. The correct general term for implementing interface and extending class is “subtyping”.

A note of caution about inheritance - Because inheriting class seems extremely useful, inheritance is possibly the most (over+mis+ab)used OO feature. Misuse of inheritance can severely damage the quality of code. We will discuss it later in the course.




