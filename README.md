# Routes

| METHOD    | URI           | Description | Request Body |
| --------- | ------------- | ------------- | ------------- |
| GET       | rest/cities   | Returns a list of all cities stored on the system  |
| GET       | rest/cities?country=foo  | Look for cities that belongs to the country foo or that the country's name contains with foo  |
| GET       | rest/countries  | Returns a list of all countries on the system  |
| POST      | rest/cities   | Store a list of cities |  `[ {"name" : "Foo"}, {"name" : "Bar"}]` |
| POST      | rest/countries   | Store a list of cities |  `[ {"name" : "Foo", "country": { "id" : 1 } }, {"name" : "Bar", "country" : {"id": 2}}]` |

## Execute the project

Run the following command into your terminal:

`java -jar target/spring-jpa-rest-0.0.1-SNAPSHOT.jar`

After that, you'll have a process running on port 8090. Open a client and access the following address:

`http://localhost:8090/rest/cities?country=Braz`