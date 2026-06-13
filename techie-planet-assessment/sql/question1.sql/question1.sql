SELECT DISTINCT salary
FROM emp
ORDER BY salary DESC
LIMIT 1 OFFSET 1;


SELECT MAX(salary)
FROM emp
WHERE salary < (SELECT MAX(salary) FROM emp);

SELECT salary
FROM (
    SELECT DISTINCT salary
    FROM emp
    ORDER BY salary DESC
    LIMIT 2
) AS top_two_salaries
ORDER BY salary ASC
LIMIT 1;