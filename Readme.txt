Spring Boot Building Blocks application created with help of Udemy
Last URL visited Step#61: is https://wipro.udemy.com/course/master-restful-apis-with-spring-boot/learn/lecture/15778254#labs

example urls:
http://localhost:8897
http://localhost:8897/users
http://localhost:8897/users/122
http://localhost:8897/users/122/orders

http://localhost:8897/hateoas/users
http://localhost:8897/hateoas/users/122
http://localhost:8897/hateoas/users/122/orders


http://localhost:8897/employees
http://localhost:8897/employees/1001
http://localhost:8897/jsonview/employees/empview/1001
http://localhost:8897/jsonview/employees/managerview/1001
http://localhost:8897/jsonview/employees/hrview/1001

##### Observations #####
1. In case you are using HATEOAS v1.0 and above (Spring boot >= 2.2.0), do note that the classnames have changed. Notably the below classes have been renamed:
I did not specify version and it took 2.2.5 version automatically so, I have to change methods while working on step 61
ResourceSupport is now RepresentationModel which you will use to extend your custom entity
Resource is now EntityModel
Resources is now CollectionModel
PagedResources is now PagedModel