## Group By with count
```mongodb
db.[DATABASE_NAME].aggregate(
  [
   { $group: {_id: "$[COLUMN_NAME]" , count: { $sum: 1} } },
   { $match: {count: { $gt: 1} } }
  ]
);
```
