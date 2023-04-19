--
-- @lc app=leetcode id=185 lang=mysql
--
-- [185] Department Top Three Salaries
--

-- @lc code=start
# top 3 salary
# -> there is no more than 3 distinct salary bigger than itself < 3

SELECT
    d.name AS 'Department',
    e1.name AS 'Employee',
    e1.salary
FROM Employee e1
    INNER JOIN Department d
    ON d.id = e1.departmentId
WHERE 3 > (
    SELECT COUNT(DISTINCT e2.salary)
    FROM Employee e2
    WHERE e2.salary > e1.salary AND e1.departmentId = e2.departmentId
)
-- @lc code=end

