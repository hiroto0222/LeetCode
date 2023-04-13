--
-- @lc app=leetcode id=176 lang=mysql
--
-- [176] Second Highest Salary
--

-- @lc code=start
# Write your MySQL query statement below

SELECT MAX(salary) AS SecondHighestSalary
FROM employee
WHERE salary NOT IN (SELECT MAX(salary) FROM employee);

-- @lc code=end

