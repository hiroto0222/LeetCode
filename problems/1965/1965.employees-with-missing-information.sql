--
-- @lc app=leetcode id=1965 lang=mysql
--
-- [1965] Employees With Missing Information
--

-- @lc code=start
# Write your MySQL query statement below

-- 1. return employee_id
-- 2. where employees.name is NULL or salaries.salary is NULL
-- need to full outer join

SELECT T.employee_id
FROM
  (SELECT * FROM employees LEFT JOIN salaries USING(employee_id)
   UNION
   SELECT * FROM employees RIGHT JOIN salaries USING(employee_id)
  ) AS T
WHERE T.name IS NULL OR T.salary IS NULL
ORDER BY T.employee_id;

-- @lc code=end

