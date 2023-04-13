--
-- @lc app=leetcode id=196 lang=mysql
--
-- [196] Delete Duplicate Emails
--

-- @lc code=start
# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below

DELETE a
FROM person a, person b
WHERE a.email = b.email AND a.id > b.id;

-- @lc code=end

