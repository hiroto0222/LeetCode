--
-- @lc app=leetcode id=175 lang=mysql
--
-- [175] Combine Two Tables
--

-- @lc code=start
# Write your MySQL query statement below

-- first name, last name, city, and state
-- left join

SELECT a.firstName, a.lastName, b.city, b.state
FROM person a
LEFT JOIN address b
ON b.personId = a.personId;

-- @lc code=end

