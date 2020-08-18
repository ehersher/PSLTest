# PSLTest

1. Download and install Java SE 13 here https://www.oracle.com/java/technologies/javase/jdk13-archive-downloads.html.

2. Download IntelliJ Ultimate IDE here https://www.jetbrains.com/idea/download/#section=windows. There is a free 30 day trial

3. For this particular repository, I find it easiest to clone through the Intellij welcome page although traditional command-line should work as well.

4. Click on "Get from Version Control"

5. In the URL field, enter the link to the repository: https://github.com/ehersher/PSLTest. Then click "clone"

6. With Intellij open, click 'File', then 'Project Structure' then click on 'add dependency' as shown in this screenshot https://imgur.com/a/XObDK0V

7. In the drop down, click on option 1: "JARS or directories"

8. Navigate to this file directory as shown in the screenshot https://imgur.com/a/TJmURTl

9. Add the highlighted jar file in the screenshot https://imgur.com/a/f5wGSED and then hit "Ok"

10. Repeat steps 8 and 9 for another JAR file (you'll choose the one in the screenshot here) https://imgur.com/a/lC9NByM

11. Finally, hit "Ok"

12. At https://chromedriver.chromium.org/downloads download a suitable chrome driver for your OS. At the time, the current version is 84

13. Navigate to C:\Users\(Your user)\IdeaProjects\PSLTest\resources and replace the driver there with the .exe you just installed

14. The JUnit tests should now be able to be built from the IDE
