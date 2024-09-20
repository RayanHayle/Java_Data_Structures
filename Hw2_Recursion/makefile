JAVAC = javac
JAVA = java
SOURCES = Recursion.java RecursionTestCases.java
CLASSFILES = $(SOURCES: .java=.class)
MAINCLASS = RecursionTestCases

all: compile run

# compile .java files

compile: $(CLASSFILES)

%.class: %.java
	$(JAVAC) $<

# run te class files made now

run: $(CLASSFILES)
	$(JAVA) $(MAINCLASS)

# get rid of .class files, don't add,commit,push these

clean:
	rm -f *.class
