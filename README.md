# Java Behavioral Design Patterns

- **Mediator pattern** : Used to permit object interactions without using explicit object
  references. The Mediator design pattern enables the centralized communication between related objects (Colleagues).
  All communication is handled by a Mediator Object & the Colleagues don't need to know anything about each other to work together.
  
  - When to use :
    
    - when the communication logic between objects is complex, we can have a central point of communication using Mediator object.
    - JMS- Java Message Service uses mediator pattern underneath.
  
  - Rules of thumb :
    
    - Mediator and Observer are competing patterns. The difference between them is that Observer distributes communication 
      by introducing "observer" and "subject" objects, whereas a Mediator object encapsulates the communication between other objects. 
      We've found it easier to make reusable Observers and Subjects than to make reusable Mediators.
    
    - On the other hand, Mediator can leverage Observer for dynamically registering colleagues and communicating with them.
    
    - Mediator is similar to Facade in that it abstracts functionality of existing classes. Mediator abstracts/centralizes 
      arbitrary communication between colleague objects, it routinely "adds value", and it is known/referenced by the colleague 
      objects (i.e., it defines a multidimensional protocol). In contrast, Facade defines a simpler interface to a subsystem, it doesn't add new functionality, 
      and it is not known by the subsystem classes (i.e., it defines a unidirectional protocol where it makes requests of the subsystem classes but not vice versa).
  
  - Check List:
    
    - Identify a collection of interacting objects that would benefit from mutual decoupling.
    - Encapsulate those interactions in the abstraction of a new class.
    - Create an instance of that new class and rework all "peer" objects to interact with the Mediator only.
    - Balance the principle of decoupling with the principle of distributing responsibility evenly.
    - Be careful not to create a "controller" or "god" object.

- **Memento pattern** : Saves an object's current internal state as a memento so that it can be referred to and restored to.
  The memento pattern is a Behavioral design pattern that provides the ability to restore an object to its previous state 
  (undo via rollback)
  
  - Rules of thumb :
    - Memento is often used in conjunction with Iterator. An Iterator can use a Memento to capture the state of an iteration. The Iterator stores the Memento internally.
  - Check List :
    1. Identify the roles of “caretaker” and “originator”.
    2. Create a Memento class and declare the originator a friend.
    3. Caretaker knows when to "check point" the originator.
    4. Originator creates a Memento and copies its state to that Memento.
    5. Caretaker holds on to (but cannot peek into) the Memento.
    6. Caretaker knows when to "roll back" the originator.
    7. Originator reinstates itself using the saved state in the Memento.

- **Interpreter pattern** : Used to establish a grammatical representation & an interpreter that interprets language. 
  Interpreter pattern provides a way to evaluate language grammar or expression.
  
  - When to use :
    - Specialized database query languages such as SQL.
    - Specialized computer languages that are often used to describe communication protocols. Voice command based apps.
  - Rules of thumb :
    - Considered in its most general form (i.e. an operation distributed over a class hierarchy based on the Composite pattern), nearly every use of the Composite pattern will also contain the Interpreter pattern. But the Interpreter pattern should be reserved for those cases in which you want to think of this class hierarchy as defining a language.
    - Interpreter can use State to define parsing contexts.
    - The abstract syntax tree of Interpreter is a Composite (therefore Iterator and Visitor are also applicable).
    - Terminal symbols within Interpreter's abstract syntax tree can be shared with Flyweight.
    - The pattern doesn't address parsing. When the grammar is very complex, other techniques (such as a parser) are more appropriate.
  - Check List:
    1. Decide if a "little language" offers a justifiable return on investment.
    2. Define a grammar for the language.
    3. Map each production in the grammar to a class.
    4. Organize the suite of classes into the structure of the Composite pattern.
    5. Define an interpret(Context) method in the Composite hierarchy.
    6. The Context object encapsulates the current state of the input and output as the former is parsed and the latter is accumulated. It is manipulated by each grammar class as the "interpreting" process transforms the input into the output.

- **Iterator pattern** : Grants access to an object's members without sharing the  encapsulated data structures
  Iterator Design Pattern enables to get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation.
  
  - When to use :
    - When there is a need to take the responsibility for access and traversal out of the aggregate / collection object and define a standard traversal protocol.
    - Iterator pattern is widely used in Java Collection Framework.
  - Rules of thumb :
    - The abstract syntax tree of Interpreter is a Composite (therefore Iterator and Visitor are also applicable).
    - Iterator can traverse a Composite. Visitor can apply an operation over a Composite.
    - Polymorphic Iterators rely on Factory Methods to instantiate the appropriate Iterator subclass.
    - Memento is often used in conjunction with Iterator. An Iterator can use a Memento to capture the state of an iteration. The Iterator stores the Memento internally.
  - Check List :
    1. Add a `create_iterator()` method to the "collection" class, and grant the "iterator" class privileged access.
    2. Design an "iterator" class that can encapsulate traversal of the "collection" class.
    3. Clients ask the collection object to create an iterator object.
    4. Clients use the `first()`, `is_done()`, `next()`, and `current_item()` protocol to access the elements of the collection class.

- **Chain of responsibility pattern** : An object submits a request to multiple objects without knowing which object will handle the request
  Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.
  
  - When to use:
    - Launch-and-leave requests with a single processing pipeline that contains many possible handlers.
    - An object-oriented linked list with recursive traversal.
  - Rules of thumb :
    - Chain of Responsibility, Command, Mediator, and Observer, address how you can decouple senders and 
      receivers, but with different trade-offs. Chain of Responsibility passes a sender request along a chain of potential receivers.
    - Chain of Responsibility can use Command to represent requests as objects.
    - Chain of Responsibility is often applied in conjunction with Composite. There, a component’s parent can act as its successor.
  - Check List :
    1. The base class maintains a "next" pointer.
    2. Each derived class implements its contribution for handling the request.
    3. If the request needs to be "passed on", then the derived class "calls back" to the base class, which delegates to the "next" pointer.
    4. The client (or some third party) creates and links the chain (which may include a link from the last node to the root node).
    5. The client "launches and leaves" each request with the root of the chain.
    6. Recursive delegation produces the illusion of magic.

- **Command pattern:** Permits the sending of requests without knowing details
  about the receiver or even about what is being requested.
  Command encapsulate all information needed to perform an action. It allows the requester of a particular action to be decoupled from the object that performs the action.
  
  - When to use :
    - The invoker should be decoupled from the object handling the invocation.
  - Rules of thumb :
    - Command and Memento act as magic tokens to be passed around and invoked at a later time.
      in Command, the token represents a request. In memento, it represents the internal state of an object at 
      particular time. polymorphism is important to command, but not to memento because its interface is so narrow that a 
      memento can only be passed as a value.
    - Command can use Memento to maintain the state required for undo operation.
    - MacroCommands can be implemented with Composite
    - A Command that must be copied before being placed on a history list acts as a Prototype.
    - Two important aspects of the Command pattern: interface separation (the invoker is isolated from the receiver), time separation (stores a ready-to-go processing request that's to be stated later).
  - Check List :
    1. Define a Command interface with a method signature like `execute()`.
    2. Create one or more derived classes that encapsulate some subset of the following: a "receiver" object, the method to invoke, the arguments to pass.
    3. Instantiate a Command object for each deferred execution request.
    4. Pass the Command object from the creator (aka sender) to the invoker (aka receiver).
    5. The invoker decides when to `execute()`.

- **State pattern** : Allows an object to change its behavior based on internal state
  changes. State pattern allows an object to behave differently depending on its internal state.
  
  - When to use :
    - When the behaviour of an object should be influenced by it's state, and when complex conditions tie object behaviour to it's state.
  - Rules of thumb :
    - State objects are often Singletons.
    - Flyweight explains when and how State objects can be shared.
    - Interpreter can use State to define parsing contexts.
    - Strategy has 2 different implementations, the first is similar to State. The difference is in binding times (Strategy is a bind-once pattern, whereas State is more dynamic).
    - The structure of State and Bridge are identical (except that Bridge admits hierarchies of envelope classes, whereas State allows only one). The two patterns use the same structure to solve different problems: State allows an object's behavior to change along with its state, while Bridge's intent is to decouple an abstraction from its implementation so that the two can vary independently.
    - The implementation of the State pattern builds on the Strategy pattern. The difference between State and Strategy is in the intent. With Strategy, the choice of algorithm is fairly stable. With State, a change in the state of the "context" object causes it to select from its "palette" of Strategy objects.
  - Check List :
    1. Identify an existing class, or create a new class, that will serve as the "state machine" from the client's perspective. That class is the "wrapper" class.
    2. Create a State base class that replicates the methods of the state machine interface. Each method takes one additional parameter: an instance of the wrapper class. The State base class specifies any useful "default" behavior.
    3. Create a State derived class for each domain state. These derived classes only override the methods they need to override.
    4. The wrapper class maintains a "current" State object.
    5. All client requests to the wrapper class are simply delegated to the current State object, and the wrapper object's `this` pointer is passed.
    6. The State methods change the "current" state in the wrapper object as appropriate.

- **Strategy pattern** : Allows us to individually encapsulate a set of interchangeable
  algorithms. Strategy pattern is a behavioral software design pattern that enables selecting an algorithm at runtime. The strategy pattern
  
  1. Defines a family of algorithms,
  2. Encapsulates each algorithm, and
  3. Makes the algorithms interchangeable within that family.
  - When to use :
    - Strategy pattern is useful when we have multiple algorithms for specific task and we want our application to be flexible to chose any of the algorithm at runtime for specific task.
  - Check List :
    1. Identify an algorithm (i.e. a behavior) that the client would prefer to access through a "flex point".
    2. Specify the signature for that algorithm in an interface.
    3. Bury the alternative implementation details in derived classes.
    4. Clients of the algorithm couple themselves to the interface.

- **Observer pattern** : Updates subscriber objects when a change is made to the
  publisher object's state. The observer pattern is a Behavioral design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes or updates.
  
  - When to use :
    - Heavy used in "event driven" application
    - It is suitable for any scenario that requires push-based notification.
  - Check List :
    1. Differentiate between the core (or independent) functionality and the optional (or dependent) functionality.
    2. Model the independent functionality with a "subject" abstraction.
    3. Model the dependent functionality with an "observer" hierarchy.
    4. The Subject is coupled only to the Observer base class.
    5. The client configures the number and type of Observers.
    6. Observers register themselves with the Subject.
    7. The Subject broadcasts events to all registered Observers.
    8. The Subject may "push" information at the Observers, or, the Observers may "pull" the information they need from the Subject.

- **Null object pattern** : Negates the need to search for the null condition.
  The intent of a Null Object is to encapsulate the absence of an object by providing a substitutable alternative that offers suitable default do nothing behavior. In short, a design where "nothing will come of nothing"

  - When to use:
    - an object requires a collaborator. The Null Object pattern does not introduce this collaboration--it makes use of a collaboration that already exists
    - some collaborator instances should do nothing
    - you want to abstract the handling of null away from the client
  - Rules of thumb :
    - The Null Object class is often implemented as a Singleton. Since a null object usually does not have any state, its state can't change, so multiple instances are identical. Rather than use multiple identical instances, the system can just use a single instance repeatedly.
    - If some clients expect the null object to do nothing one way and some another, multiple NullObject classes will be required. If the do nothing behavior must be customized at run time, the NullObject class will require pluggable variables so that the client can specify how the null object should do nothing (see the discussion of pluggable adaptors in the Adapter pattern). This may generally be a symptom of the AbstractObject not having a well defined (semantic) interface.
    - A Null Object does not transform to become a Real Object. If the object may decide to stop providing do nothing behavior and start providing real behavior, it is not a null object. It may be a real object with a do nothing mode, such as a controller which can switch in and out of read-only mode. If it is a single object which must mutate from a do nothing object to a real one, it should be implemented with the State pattern or perhaps the Proxy pattern. In this case a Null State may be used or the proxy may hold a Null Object.
    - The use of a null object can be similar to that of a Proxy, but the two patterns have different purposes. A proxy provides a level of indirection when accessing a real subject, thus controlling access to the subject. A null collaborator does not hide a real object and control access to it, it replaces the real object. A proxy may eventually mutate to start acting like a real subject. A null object will not mutate to start providing real behavior, it will always provide do nothing behavior.
    - A Null Object can be a special case of the Strategy pattern. Strategy specifies several ConcreteStrategy classes as different approaches for accomplishing a task. If one of those approaches is to consistently do nothing, that ConcreteStrategy is a NullObject. For example, a Controller is a View's Strategy for handling input, and NoController is the Strategy that ignores all input.
    - A Null Object can be a special case of the State pattern. Normally, each ConcreteState has some do nothing methods because they're not appropriate for that state. In fact, a given method is often implemented to do something useful in most states but to do nothing in at least one state. If a particular ConcreteState implements most of its methods to do nothing or at least give null results, it becomes a do nothing state and as such is a null state.
    - A Null Object can be used to allow a Visitor to safely visit a hierarchy and handle the null situation.
    - Null Object is a concrete collaborator class that acts as the collaborator for a client which needs one. The null behavior is not designed to be mixed into an object that needs some do nothing behavior. It is designed for a class which delegates to a collaborator all of the behavior that may or may not be do nothing behavior.

- **Template method pattern**: Involves creating an algorithm template with
  processing steps relegated to child classes. Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithms structure and sequence of execution.

  - When to use :
    - The template method is used in frameworks, where each implements the invariant parts of a domain's architecture, leaving "placeholders" for customization options.
  - Rules of thumb :
    - Strategy is like Template Method except in its granularity.
    - Template Method uses inheritance to vary part of an algorithm. Strategy uses delegation to vary the entire algorithm.
    - Strategy modifies the logic of individual objects. Template Method modifies the logic of an entire class.
    - Factory Method is a specialization of Template Method.
  - Check List :
    1. Examine the algorithm, and decide which steps are standard and which steps are peculiar to each of the current classes.
    2. Define a new abstract base class to host the "don't call us, we'll call you" framework.
    3. Move the shell of the algorithm (now called the "template method") and the definition of all standard steps to the new base class.
    4. Define a placeholder or "hook" method in the base class for each step that requires many different implementations. This method can host a default implementation – or – it can be defined as abstract (Java) or pure virtual (C++).
    5. Invoke the hook method(s) from the template method.
    6. Each of the existing classes declares an "is-a" relationship to the new abstract base class.
    7. Remove from the existing classes all the implementation details that have been moved to the base class.
    8. The only details that will remain in the existing classes will be the implementation details peculiar to each derived class.

- **Visitor pattern**: Performs operations on an object without altering its structure.
  Visitor design pattern uses a visitor class which changes the executing algorithm of an element class. By this way, execution algorithm of element can vary as and when visitor varies.

  - When to use :
    - Visitor pattern used when we have to perform an operation on a group of similar kind of Objects. With the help of visitor pattern, we can move the operational logic from the objects(Elements) to another class (Visitor class).
  - Rules of thumb :
    - The abstract syntax tree of Interpreter is a Composite (therefore Iterator and Visitor are also applicable).
    - Iterator can traverse a Composite. Visitor can apply an operation over a Composite.
    - The Visitor pattern is like a more powerful Command pattern because the visitor may initiate whatever is appropriate for the kind of object it encounters.
    - The Visitor pattern is the classic technique for recovering lost type information without resorting to dynamic casts.
  - Check List :
    1. Confirm that the current hierarchy (known as the Element hierarchy) will be fairly stable and that the public interface of these classes is sufficient for the access the Visitor classes will require. If these conditions are not met, then the Visitor pattern is not a good match.
    2. Create a Visitor base class with a `visit(ElementXxx)` method for each Element derived type.
    3. Add an `accept(Visitor)` method to the Element hierarchy. The implementation in each Element derived class is always the same – `accept( Visitor v ) { v.visit( this ); }`. Because of cyclic dependencies, the declaration of the Element and Visitor classes will need to be interleaved.
    4. The Element hierarchy is coupled only to the Visitor base class, but the Visitor hierarchy is coupled to each Element derived class. If the stability of the Element hierarchy is low, and the stability of the Visitor hierarchy is high; consider swapping the 'roles' of the two hierarchies.
    5. Create a Visitor derived class for each "operation" to be performed on Element objects. `visit()` implementations will rely on the Element's public interface.
    6. The client creates Visitor objects and passes each to Element objects by calling `accept()`.

---

| Object Scope                    | Class Scope             |
|:-------------------------------:|:-----------------------:|
| Chain of responsibility pattern | Interpreter pattern     |
| Command pattern                 | Template method pattern |
| Iterator pattern                |                         |
| Mediator pattern                |                         |
| Memento pattern                 |                         |
| Null Object pattern             |                         |
| Observer pattern                |                         |
| State pattern                   |                         |
| Strategy pattern                |                         |
| Visitor pattern                 |                         |



Reference : 

- ​	https://sourcemaking.com/design_patterns
- ​	https://refactoring.guru/design-patterns 
