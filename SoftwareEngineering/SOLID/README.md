# SOLID

## Acronym:

Acronym of the five principles listed as below : 
- S - Single Responsibility Principle
- O - Open/Closed Principle
- L - Liskov’s Substitution Principle
- I - Interface Segregation Principle
- D - Dependency Inversion Principle

### SRP: 

Class should be having one and only one responsibility 

### OCP:

Classes should be open for extension but closed for modification.

#### Example:
``` bash
 
	public interface Animal {
		public void doSomeBehavior();
	}
	
	public class Context() {
		private Animal animal;
		// we set the animal in the constructor
		public Context(Animal animal) {
			this.animal = animal;
		}
		public void executeAnimal() {
			this.animal.doSomeBehavior();
		}
	}
	
	public class Dog implements Animal {
		public void doSomeBehavior() {
			System.out.println(“Execute Dog”);
		} 
	}
	public class Cat implements Animal {
		public void doSomeBehavior() {
			System.out.println(“Execute Cat”);
		} 
	}
	
	public class Demo() {
		public static void main(String[] args) {
			Context context = new Context(new Dog()); 		// we inject the Dog
			context.executeAnimal();  						// it will print “Execute Dog”;
			context = new Context(new Cat());  				// we inject the Cat
			context.executeAnimal();  						// it will print “Execute Cat”
		}
	}
	
```

If the class Dog is written by the developer AA,
and if the developer BB wants some modification on that
then developer BB should be easily do that by extending class Dog,
but not by modifying class Dog.

### LSP:

Parent classes should be easily substituted with their child classes without blowing up the application.

#### Example:

``` bash

	public class Animal {
		public void makeNoise() {
			System.out.println("I am making noise");
		}
	}
	
	public class Dog extends Animal {
		@Override
		public void makeNoise() {
			System.out.println("bow wow");
		}
	}

	public class Cat extends Animal {
		@Override
		public void makeNoise() {
			System.out.println("meow meow");
		}
	}
	
	class DumbDog extends Animal {
		@Override
		public void makeNoise() {
			throw new RuntimeException("I can't make noise");
		}
	}
```

### ISP: 

Many client specific interfaces are better than one general interface.

### DIP:

Classes should depend on abstraction but not on concretion

