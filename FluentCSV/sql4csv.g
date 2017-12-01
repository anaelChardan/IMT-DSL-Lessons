query: "select" columns "from" tables "where" conditions;
columns: COLUMN ("," COLUMN)*;
tables: TABLE ("," TABLE)*;
conditions: condition ("and" condition)*;
condition: equality;
equality: (COLUMN "=" VALUE) | (COLUMN "=" VALUE);

COLUMN: (a..zA..Z_) (a..zA..Z0..9)*;
TABLE: (a..zA..Z_) (a..zA..Z0..9)*;
VALUE: "'" (a..zA..Z0..9)* "'";