JC = javac
JFLAGS = -classpath .
JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm
JR = java

CLASSES = \
		AbstractDevice.java \
		ElectroDeviceShop.java \
		ModulerTesting.java \
		Inventory.java \
		Device.java \
		Headphone.java \
		SmartPhone.java \
		Keyboard.java \
		TV.java \
		Laptop.java

all : ElectroDeviceShop.class

run : 
	$(JR) ElectroDeviceShop

classes : $(CLASSES:.java=.class)

%.class : %.java
	$(JC) $(JFLAGS) $<

doc:
	$(JD) $(JDFLAGS) *.java 

clean:
	$(RM) *.class 

cleandoc:
	$(RM) -r ./javadoc
