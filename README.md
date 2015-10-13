Computer Society
=======

Overview
-----
GMIT - Java - Lecturer: Naomi Hurley  
Computer Society Member Application  - December 2013 (Semester 3)  

Showcasing: 
-Polymorphism  
-Inheritance  


About
-----
I had just created the GMIT Computer society and I had to come up with an idea for a Java application that would showcase Object Orientated software development with a strong emphasis on Polymorphism.

This application lets users view information about the society, fill out a questionnaire, view the current members (by type) and of course sign up to be a member.

The idea behind it was that during society sign up day, pen and paper sign ups were took too much time to transcript afterwards. So I wanted to have an automated way to sign up members.

Class Hierarchy:
-----

test runner:
-ComputerSociety

exception:
-FeeException

interface:
-Questionnaire

core classes:
-Person

--Student
---PartTimeStudent
---FullTimeStudent

--Guest
---Speaker (implements Questionnaire)
---Lecturer

Tools used
-----
This application was developed using Java in the Eclipse IDE
