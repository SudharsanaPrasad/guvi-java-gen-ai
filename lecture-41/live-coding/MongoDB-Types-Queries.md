# MongoDB Data Types

MongoDB stores data as **BSON** (Binary JSON), which is **JSON-like**.  
BSON is designed to be efficient for storage and faster for operations at scale.

Reference: https://www.mongodb.com/docs/mongodb-shell/reference/data-types/

---

## Common BSON Data Types (with examples)

- **String**: `"Nikhil"`
- **Double**: `3.14`
- **Decimal128**: high-precision decimals (useful for finance)
- **Integer**
  - `Int32` (32-bit)
  - `Int64` (64-bit)
- **Boolean**: `true` / `false`
- **Null**: represents “no value”
- **Date**, **Timestamp**
- **ObjectId**
  - used in the `_id` field by default  
  - example: `"695173592c2f920140b2a26a"`
  - MongoDB generates a unique `_id` automatically if you don’t provide one
- **Array**: `["JavaScript", "MongoDB", "Java"]`

---

# Updates: `updateOne`

## Add a value to an array (avoid duplicates)

```js
db.employees.updateOne(
  { name: "Asha" },
  { $addToSet: { skills: "MongoDB" } }
);
```
where,
-  `{ name: "Asha" },` allows us to filter the employees collection
- `{ $addToSet: { skills: "MongoDB" } }` adds `"MongoDB"` to the skills field for the employee named `Asha`

## Update a single field

```js
db.employees.updateOne(
  { name: "Asha" },
  { $set: { age: 25 } }
);
```
where,
-  `{ name: "Asha" },` allows us to filter the employees collection
- `{ $set: { age: 25 } }` is sets the age to 25 for the employee named `Asha`

## What if the filter is empty?

```js
db.employees.updateMany(
  {},
  { $set: { age: 25 } }
);
```
where,
- `updateMany` allows us to update multiple documents in the employee collection
- `{}` allows us to update ALL documents, since there's no filter
- the `age` field is set to 25 for all documents

Consider:
```js
db.employees.updateOne(
  {},
  { $set: { age: 25 } }
);
```

Question: what's the impact of `updateOne`?

---

## Example: `employees` collection

```js
[
  {
    "name": "Tuvesh",
    "age": 25,
    "skills": ["Java", "HTML", "MongoDB"],
    "is_active": true
  },
  {
    "name": "Sudharsana",
    "age": 24,
    "skills": ["HTML", "MongoDB"],
    "is_active": true
  }
]
```

---

# Find Queries (examples)

## Find employees not in Engineering

```js
db.employees.find({
  department: { $ne: "Engineering" }
});
```

## Find employees who are not active

```js
db.employees.find({
  is_active: { $ne: true }
});
```

## Find employees with age = 25

```js
db.employees.find({
  age: { $eq: 25 }
});
