# Relating Tables with Foreign Keys

When you have multiple tables (e.g., learners, payments, addresses), you connect them using a **foreign key** so rows in one table can refer to rows in another.

## Sample Tables

### learners
- `id` (Primary Key)
- `name`
- `course`

### payment (for a learner)
- `id`
- `learner_id` (Foreign Key → `learners.id`)
- `type`
- `card_number`

Foreign key relationship:
- `FK payment(learner_id) REFERENCES learners(id)`

### address (for a learner)
- `id`
- `learner_id` (Foreign Key → `learners.id`)
- `city`
- `country`

Similar to the payment table, Foreign key relationship:
- `FK address(learner_id) REFERENCES learners(id)`

# Joining Two Tables: learners + enrollments

Reference slide:
- https://docs.google.com/presentation/d/1Dlv2AjbuGvobI27nKGUZMjWb-npNrHGOxrZ6-7WGYjk/edit?slide=id.g3b468907616_2_367#slide=id.g3b468907616_2_367

## Sample Data

### learners
| id | name  |
|---:|-------|
| 1  | Asha  |
| 2  | Rahul |
| 3  | Meera |

### enrollments
| id  | learner_id | course     |
|----:|-----------:|------------|
| 201 | 1          | SQL        |
| 202 | 2          | Java       |
| 203 | 2          | MySQL      |
| 204 | 5          | Databases  |

## Relationship
- `learners.id` -> `enrollments.learner_id`

## Query (INNER JOIN)

```sql
SELECT learners.name, enrollments.course
FROM learners
INNER JOIN enrollments
  ON learners.id = enrollments.learner_id;
````

## How the matching works (step-by-step)

* `learners.id = 1 (Asha)` matches `enrollments.learner_id = 1` -> `(Asha, SQL)`

* `learners.id = 2 (Rahul)` matches `enrollments.learner_id = 2` (two rows) -> `(Rahul, Java)` and `(Rahul, MySQL)`

* `learners.id = 3 (Meera)` has no matching `enrollments.learner_id = 3` -> excluded in INNER JOIN

Also note:

* `enrollments.learner_id = 5` has no matching learner -> excluded in INNER JOIN

## Output of INNER JOIN

| name  | course |
|-------|--------|
| Asha  | SQL    |
| Rahul | Java   |
| Rahul | MySQL  |


## What is INNER JOIN?

An **INNER JOIN** returns only the rows where the join condition matches in **both** tables.

Math analogy: it’s like an **intersection**.