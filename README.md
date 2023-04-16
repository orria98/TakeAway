# HBV202G Software Construction

A take away project constructed using JavaFX, tests using JUnit4.

This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE hopefully understands
when you `git clone` it. The provided Maven POM includes the JUnit4 dependency and supports to execute the main method
in the class: `vidmot.takeaway.TakeAwayApplication`.

Both the implementation and the tests are in Java package `TakeAway`, but in the usual separate Maven `src`
directories:

- `src/main/java/vidmot.takeaway`:
    - `GreidslaController`: Controls the user interface logic for the payment screen.
    - `LoginDialog`: Dialog box for user login.
    - `MatsedillView`: Extends a ListView component.
    - `PontunController`: Controls the user interface logic for the order screen.
    - `VidskiptavinurDialog`: Dialog box for new users.
    - `View`: Enumeration class representing views.
    - `ViewSwitcher`: Contains methods to switch between different views.
- `src/main/java/vinnsla`: (each package contains an `Alltests` class that collects all the test cases for the respective
  package in one test suite)
    - `Karfa`: Extends `Matsedill` 
    - `KarfaTest`: Contains three test methods: __setjaGognTest__, __hreinsaKorfuTest__, and __takaUrKorfuTest__.
    - `Matsedill`: Contains an ObservableList of `Veitingar` objects and methods for adding data to the list.
    - `Veitingar`: Has instance variables for food and prices.
    - `Vidskiptavinur`: Defines a customer object with name and address.

Maven:

- `mvn compile` compiles all implementation classes.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends with `Test`
  , `Tests`, or `TestCase`).

License:

- `LICENSE` License file. Link: [LICENSE](LICENSE)

Documentation:

- `documentation` Markdown file. Link: [documentation](src/site/markdown/documentation.md)
