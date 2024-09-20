# Variables
JAVAC = javac
JAVA = java
SOURCES = MyArrayList.java MyLinkedList.java Mylist.java ListTestCases.java
CLASSFILES = $(SOURCES:.java=.class)
MAINCLASS = ListTestCases

# Default target to compile and run
all: compile run

# Compile all .java files
compile: $(CLASSFILES)

%.class: %.java
	$(JAVAC) $<

# Run the main class
run: $(CLASSFILES)
	$(JAVA) $(MAINCLASS)

# Clean up compiled .class files
clean:
	rm -f *.class

