# RESTful-webservice-course-organisation

#Technologies used:Springboot, hibernate/JPA, Maven

This is a springboot applictaion that implements the RESFul API. 

It is the organisation of courses in a university and the assignment of professors to these courses.
When this springboot application is run, it automatically creates 6 tables in the postgres database
namely; instructor, instructor_details, course, course_review, student, course_student(many to many)

The relationships are as follows
instructor - instructor_details  mapped by one to one.
instructor - student mapped by one to many
instructor - course  mapped by one to many
course - student mapped by many to many
course - review mapped by one to many

As simple Controller package(containing controllers) in created to handle all http Requests from the client.






