# Theory class 5 to 10

## LSP - a violation

There is a Rectangle class for which we can set height and width, and calculate area. Now we need a Square class. Since we know Square is a Rectangle. We simply create Square by extending Rectangle. To make sure the height and width of Square remains the same, we override setHeight and setWidth methods. We also write some unit tests to see if Rectangle and Square works properly. The tests pass.

```java
public class Rectangle {
    private double height, width;
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }

    public double area() {
        return height * width;
    }

    public double perimeter(){
        return 2 * (height + width);
    }
}
```

```java
class SquareWithInheritance extends Rectangle {
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}
```

```java
class RectangleTest {
    @Test
    void testRectangle(){
        Rectangle r = new Rectangle();
        r.setWidth(3);
        r.setHeight(4);

        Assertions.assertEquals(12, r.area());
    }

    @Test
    void testSquare(){
        Square s = new Square();
        s.setLength(6);
        Assertions.assertEquals(25, s.area());
    }
}
```
Now, there is a piece of code elsewhere, a growDouble(Rectangle) function. It takes a Rectangle and sets its height and width double of its original value. This code was originally targeted to Rectangles, however, now the client wants it for Square too.   
Fortunately, Square is a Rectangle, therefore we can simply pass a Square object in growDouble(Rectangle) function. We do so, and “oh no, the square’s length has been set 4 times as original!”. 

```java
public void growDouble(Rectangle rectangle){
    rectangle.setHeight(rectangle.getHeight() * 2);
    rectangle.setWidth(rectangle.getWidth() * 2);
}
```

Although the Square and Rectangle were working fine in isolation, there are some issues when some other code makes use of them. This is a violation of Liskov's Substitution Principle.

So, what went wrong with Rectangle and Square? The problem was the assumption that Square is a Rectangle. While this seems true in general sense, however, the problem arises because our rectangle was mutable. Mutable Rectangle might not be a Mutable Rectangle.

## Solving LSP violation with Composition
We solved the issues using composition instead of inheritance between Square and Rectangle.

```java
class Square {
    private Rectangle r = new Rectangle();

    public double getLength() {
        return r.getWidth();
    }

    public void setLength(double length) {
        r.setWidth(length);
        r.setHeight(length);
    }

    public double area() {
        return r.area();
    }

    public double perimeter(){
        return r.perimeter();
    }
}
```

## Inheritance vs Composition
**Reading**: [Composition vs. Inheritance: How to Choose?](https://www.thoughtworks.com/insights/blog/composition-vs-inheritance-how-choose) By Steven Lowe. Read the whole article, including the comments.

There is a phrase popular among many programmers - “Favor composition over inheritance”. While this phrase seems very convincing, in reality, composition and inheritance are two essential tools, one cannot just replace another.  
In this class, we will demonstrate some misuses of inheritance which normally lead to the conclusion that composition must be “better” than inheritance. But again, these are “misuse” and cannot help decide anything.  

### Terminologies
In this doc, we will be using the following terms
* Composition
  * Component - in a composition scenario, the type that is used by another one
  * Container - in a composition scenario, a type that uses another type
* Inheritance
  * Child type - in a inheritance scenario, a type that inherits another type
  * Parent type - in a inheritance scenario, a type which has been inherited by another type

### Inheritance and Composition both are fundamental concepts
Inheritance is a well-established fundamental concept of OOP. Without inheritance, normally a programming language would not be called an OO one.  
Composition is also fundamental, whenever we try to model something in OO, composition automatically comes in.  
Now that we understand both are fundamental, we cannot just assume that one may replace another!  

### Usage of composition and inheritance overlaps
Composition is fairly easy to understand - we can see composition in everyday life: a chair has legs, a wall is composed of bricks and mortar, and so on. We use composition to model things granular, abstract away details that are not required by the container class, and above all for **code reuse**.  
Now as of inheritance, it has two purposes.  
* Classification (Semantics): Inheritance creates a classification. The top of the classification is a very general concept while as we go bottom, more specializations are there.
* Reuse (Mechanics): A child type automatically gets all the methods and properties of its parent type.  

This dual purpose of inheritance is the root cause of most confusion. Also, because one of the purposes is the same as composition (Reuse), people tend to think that inheritance might be replaced by composition. However, overemphasis on reuse using inheritance is actually the cause of flawed design.

### Another Example of inheritance misuse
```
class Stack extends ArrayList {
}
```
1. Semantically, the statement “a Stack is an ArrayList” is not true; Stack is not a proper subtype of ArrayList. A stack is supposed to enforce last-in-first-out, a constraint easily satisfied by the push/pop interface, but not enforced by ArrayList’s interface.
2. Mechanically, inheriting from ArrayList violates encapsulation; using ArrayList to hold the stack’s object collection is an implementation choice that should be hidden from consumers.


