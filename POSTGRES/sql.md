# All foreign keys
```sql
select kcu.table_schema || '.' ||kcu.table_name as foreign_table,
       '>-' as rel,
       rel_tco.table_schema || '.' || rel_tco.table_name as primary_table,
       string_agg(kcu.column_name, ', ') as fk_columns,
       kcu.constraint_name
from information_schema.table_constraints tco
join information_schema.key_column_usage kcu
          on tco.constraint_schema = kcu.constraint_schema
          and tco.constraint_name = kcu.constraint_name
join information_schema.referential_constraints rco
          on tco.constraint_schema = rco.constraint_schema
          and tco.constraint_name = rco.constraint_name
join information_schema.table_constraints rel_tco
          on rco.unique_constraint_schema = rel_tco.constraint_schema
          and rco.unique_constraint_name = rel_tco.constraint_name
where tco.constraint_type = 'FOREIGN KEY'
group by kcu.table_schema,
         kcu.table_name,
         rel_tco.table_name,
         rel_tco.table_schema,
         kcu.constraint_name
order by kcu.table_schema,
         kcu.table_name;
```

# Add day 
```
select current_timestamp + ( 2 || ' days')::interval;
```

#  All tables' all table columns
```sql
select
    t.table_name,
    array_agg(c.column_name::text) as columns
from
    information_schema.tables t
inner join information_schema.columns c on
    t.table_name = c.table_name
where
    t.table_schema = [SCHEMA]
    and t.table_type= 'BASE TABLE'
    and c.table_schema = [SCHEMA]
group by t.table_name;
```
#  max_connections
```sql
ALTER SYSTEM SET max_connections ='1000';
```

## Show tables
```bash
\dt
```
