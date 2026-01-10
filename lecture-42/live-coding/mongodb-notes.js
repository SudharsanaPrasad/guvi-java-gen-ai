/**
========== Topic: inserting "duplicates" in MongoDB ==========
employees collection

Initial state:
[
  {
    _id: ObjectId("123"),
    employeeId: 1,
    email: "s@gmail.com",
    name: "soumyajit"
  }
]

Operation: insertOne
Data:
{
  _id: ObjectId("1234"),
  employeeId: 2,
  email: "so@gmail.com",
  name: "soumyajit"
}

Updated collection:
[
  {
    _id: ObjectId("123"),
    employeeId: 1,
    email: "s@gmail.com",
    name: "soumyajit"
  },
  {
    _id: ObjectId("1234"),
    employeeId: 2,
    email: "so@gmail.com",
    name: "soumyajit"
  }
]

Note:
MongoDB does not prevent inserting another document with the same "name" (soumyajit).
Why?
Because MongoDB only enforces uniqueness on _id by default.

If you want another field (like email / phone / employeeId) to be unique,
you must create a UNIQUE index on that field.

Example:
db.employees.createIndex({ email: 1 }, { unique: true })
*/

/**
========== Question ==========
How do we perform a search if we don't know the _id?

We can search by other fields:
    db.employees.find({ name: "tuvesh" })

In real systems, a non-_id field is often unique (email, phone number, username, employeeId, etc),
and we typically index those fields for fast lookup.
*/

/**
========== Enforcing Consistency ==========
Question:
How do we ensure a minimum set of required fields are present in a collection?

A validator is a set of rules attached to a collection that MongoDB checks whenever you insert or update documents.

Continuing our example, let's say our employees collection needs these required fields:
- name        -> string
- age         -> int
- department  -> string
*/

// 1) Switch to our DB
use company_db;

// 2) Create the collection with a schema validator
// required: fields that MUST be present in every document
// properties: enforces data types (prevents wrong types from being inserted)
db.createCollection("employees", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "age", "department"],
      properties: {
        name: { bsonType: "string" },
        age: { bsonType: "int" },
        department: { bsonType: "string" }
      }
    }
  }
});

// ========== Topic: Aggregation Pipeline ==========

/**
Aggregation Pipeline:
- Think of it like a multi-step data processing pipeline.
- Each stage takes the output of the previous stage and transforms it.
- It’s like: filter -> group -> reshape -> sort -> limit -> etc.

Question:
Find the number of employees who have the skill "MongoDB", grouped by department.
*/

db.employees.aggregate([
  // 1) $match = filtering (like SQL WHERE)
  { $match: { skills: "MongoDB" } },

  // 2) $group = grouping + aggregation (like SQL GROUP BY)
  { $group: { _id: "$department", total: { $sum: 1 } } },

  // 3) $project = select/reshape fields (like SQL SELECT columns / aliases)
  { $project: { _id: 0, department: "$_id", total: 1 } }
]);

/**
References on further stages in the aggregation pipeline:
- The Beginner’s Guide to MongoDB Aggregation (Studio 3T)
  https://studio3t.com/knowledge-base/articles/mongodb-aggregation-framework/
- MongoDB Aggregation Pipelines: A Hands-on Tutorial (Codecademy)
  https://www.codecademy.com/article/mongodb-aggregation-pipeline
*/

// ========== Activity ==========

/**
Requirements:
- Create database library_db and collection members
- Insert 5 member documents with fields:
    - name, age, membershipType, borrowedBooks (array), address (object)
- Update one member by adding a new book to borrowedBooks
- Delete members where age < 18
- Fetch only name and membershipType using projection
- Aggregation: count members per membershipType
*/

// ========== Solution ==========

// 1) Create or switch to the database
use library_db;

// (Optional) create collection explicitly (MongoDB can also auto-create on first insert)
db.createCollection("members");

// 2) Insert 5 member documents
db.members.insertMany([
  {
    name: "Nikhil",
    age: 23,
    membershipType: "Bronze",
    borrowedBooks: ["CS", "Java Programming Language"],
    address: { city: "Bengaluru", state: "Karnataka", country: "India" }
  },
  {
    name: "Thirumalini",
    age: 22,
    membershipType: "Silver",
    borrowedBooks: ["MongoDB Essentials"],
    address: { city: "Mumbai", state: "Maharashtra", country: "India" }
  },
  {
    name: "Malini",
    age: 32,
    membershipType: "Gold",
    borrowedBooks: ["MySQL Essentials"],
    address: { city: "New York City", state: "New York", country: "US" }
  },
  {
    name: "Thirumani",
    age: 25,
    membershipType: "Gold",
    borrowedBooks: ["NoSQL Essentials"],
    address: { city: "Beijing", state: "Hebei Province", country: "China" }
  },
  {
    name: "Sridhar",
    age: 28,
    membershipType: "Silver",
    borrowedBooks: ["Spring Boot Essentials"],
    address: { city: "Tokyo", state: "", country: "Japan" }
  }
]);

// 3) Update one member by adding a new book to borrowedBooks
// $addToSet avoids duplicates in the array.
// If you don't care about duplicates, you can use $push instead.
db.members.updateOne(
  { name: "Nikhil" },
  { $addToSet: { borrowedBooks: "System Design Basics" } }
);

// 4) Delete members where age < 18
db.members.deleteMany({ age: { $lt: 18 } });

// 5) Fetch only name and membershipType using projection
db.members.find(
  {},
  { _id: 0, name: 1, membershipType: 1 }
);

/**
Example Output (format depends on your data):
{ "name": "Nikhil",      "membershipType": "Bronze" }
{ "name": "Thirumalini", "membershipType": "Silver" }
{ "name": "Malini",      "membershipType": "Gold" }
{ "name": "Thirumani",   "membershipType": "Gold" }
{ "name": "Sridhar",     "membershipType": "Silver" }

Aggregation result should show:
Bronze -> 1
Silver -> 2
Gold   -> 2
*/

// 6) Aggregation: count members per membershipType
/**
Recall the stages of the aggregation pipeline:
- $match   : filtering (like SQL WHERE)
- $group   : grouping documents and computing aggregates (like SQL GROUP BY + COUNT/SUM/etc)
- $project : selecting/reshaping fields in the output (like SQL SELECT columns + aliases)
*/

db.members.aggregate([
  { $group: { _id: "$membershipType", total: { $sum: 1 } } },
  { $project: { _id: 0, membershipType: "$_id", total: 1 } }
]);

// ========== Post-lecture discussion ==========

// Aggregation pipeline example (employees)
db.employees.aggregate([
  { $match: { skills: "MongoDB" } },
  { $group: { _id: "$department", total: { $sum: 1 } } }
]);

/*
Explanation:

$match:
  - Filters documents, like a WHERE clause in SQL.
  - Only documents matching this condition move to the next stage.

$group:
  - Groups documents by a key (like SQL GROUP BY).
  - Produces one output document per group.

  _id: "$department"
    - In $group, _id is mandatory (it defines the grouping key).
    - "$department" means: use the value of the department field from each document.
    - The $ means “this is a field reference”.

  total: { $sum: 1 }
    - Adds a computed field in each group output.
    - $sum is an accumulator used inside $group.
    - $sum: 1 means: for every document in the group, add 1.
    - So this becomes: count documents per department.
*/

/**
Question:
What if we need to group by multiple fields?

Example:
We have a sales collection with fields:
  _id, name, year, month, productCategory, price, amount

Objective:
Group by year + month + productCategory, and compute total revenue.
*/

db.sales.aggregate([
  {
    $group: {
      _id: {
        year: "$year",
        month: "$month",
        productCategory: "$productCategory"
      },
      totalRevenue: { $sum: "$amount" }
    }
  }
]);

/*
Sample Output:
{
  "_id": { "year": 2020, "month": 3, "productCategory": "Electronic" },
  "totalRevenue": 5000
}
*/
