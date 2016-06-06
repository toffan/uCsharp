#--------------------------------------------------------
# la grammaire (voir src)
XLANG=MCS
ALANG=ASM
#--------------------------------------------------------
# repertoires contenant egg
EDIR=.
# les jars associes
GJAR=$(EDIR)/eggc-5.3.1.jar:.
#--------------------------------------------------------
# java, javac, jar
#JDIR=/usr/local/jdk1.6/bin
JDIR=/usr/bin
#--------------------------------------------------------
all : src att class

src :
	(cd mcs ; $(JDIR)/java -cp ../$(GJAR) mg.egg.eggc.compiler.EGGC $(XLANG).egg)
	(cd mcs ; $(JDIR)/java -cp ../$(GJAR) mg.egg.eggc.compiler.EGGC $(ALANG).egg)

att :
	$(JDIR)/javac -classpath $(GJAR) mcs/tds/*.java
	$(JDIR)/javac -classpath $(GJAR) mcs/gc/*.java
	$(JDIR)/javac -classpath $(GJAR) mcs/gc/general/*.java
	$(JDIR)/javac -classpath $(GJAR) mcs/gc/tam/*.java
	$(JDIR)/javac -classpath $(GJAR) mcs/compiler/*.java

class :
	$(JDIR)/javac -classpath $(GJAR) mcs/egg/*.java

test:
	python tests.py utests/*.mcs

clean :
	rm -rf $(PACKAGE)
	rm -f mcs/tds/*.class
	rm -f mcs/gc/*.class
	rm -f mcs/gc/tam/*.class
	rm -f mcs/gc/general/*.class
	rm -f mcs/compiler/*.class
	rm -rf mcs/egg/*
	rm -rf tests/*.tam

