For every new combination of features, you need to create a new subclass:

BoldTextView, ItalicTextView, UnderlineTextView
BoldItalicTextView, BoldUnderlineTextView, ItalicUnderlineTextView
etc.
This doesn’t scale. With just 4 features, you'd already have to manage up to 15 classes for all possible combinations.


2. The Decorator Pattern
   The Decorator Pattern allows you to add responsibilities to objects dynamically, 
without altering their structure or modifying their original code.

Component (e.g., TextView): Declares the common interface (execute()) for all core and decorated objects
ConcreteComponent (e.g., PlainTextView): The base object that can be dynamically decorated
BaseDecorator (abstract): Implements the component interface and stores a reference to the component to be decorated
ConcreteDecorators (BoldDecorator, ItalicDecorator, etc.): Extend the base decorator to add new functionality before/after calling the wrapped component’s method
Client: Creates and composes decorators at runtime to achieve the desired combination of behaviors