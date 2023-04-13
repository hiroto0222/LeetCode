--
-- @lc app=leetcode id=596 lang=mysql
--
-- [596] Classes More Than 5 Students
--

-- @lc code=start
# Write your MySQL query statement below
# Write your MySQL query statement below

SELECT class
FROM courses
GROUP BY class
HAVING COUNT(student) > 4;

-- @lc code=end

