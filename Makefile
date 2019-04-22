JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=Barrier.class BThread.class BarrierTest.class 

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm bin/BarrierS/*.class
run:
	java -cp bin BarrierS.BarrierTest 5 5

run1:
	java -cp bin BarrierS.BarrierTest 5 8

run2:
	java -cp bin BarrierS.BarrierTest 4 5

