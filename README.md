## BookStore
### Overview
This application serve as demonstration of use __Spring Framework__ and __Hibernate__ for building application with web interface. For deploying was used __Tomcat Server__ and for building used __Maven__. Front-end view presented __Bootstrap__ framework, behavior of pages controled by custom written __JavaScript__ file [store-script.js](https://github.com/N0tSure/BookStore/blob/master/web/WEB-INF/views/js/store-script.js).

>__Database properties__: database: Postgresql, database name: book_store, user: root, password: root.

>For more see [hibernate.properties](https://github.com/N0tSure/BookStore/blob/master/src/main/resources/hibernate.properties)

### Books viewing
Basic page presented by [home.jsp](https://github.com/N0tSure/BookStore/blob/master/web/WEB-INF/views/home.jsp), it's allows view all available books, also allows remove them. After remove each book page dinamically change, this behavior provided by script presented below. Messaging between client and server performed by __REST__, message format: __JSON__.

![Home page](https://s23.postimg.org/bjipyxl3v/book_store.png)

### New book saving
Page for addition of new element mapped at `/new`, presented by file [addBook.jsp](https://github.com/N0tSure/BookStore/blob/master/web/WEB-INF/views/addBook.jsp). Inserted in form, that presented on page, data validate, then converted in __JSON__ format, and finally send to server by script. Received message from client, on back end convert into entity, and save. There below presented attributes of element, their format, and side, where this format validate. 

| Attribute | Validation side | Required format |
|----|----|----|
| Title | Server side | VARCHAR(255) |
|Description| Server side | LONGVARCHAR |
| Pages | Client side | Integer |
| ISBN | Server side | VARCHAR(255) |
| Price | Client side | Float |

### Update of book
Interface for updating provides [updateBook.jsp](https://github.com/N0tSure/BookStore/blob/master/web/WEB-INF/views/updateBook.jsp) mapped at `/update`. That page demonstrate JSP technology.
