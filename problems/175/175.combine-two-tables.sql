--
-- @lc app=leetcode id=175 lang=mysql
--
-- [175] Combine Two Tables
--

-- @lc code=start
# Write your MySQL query statement below
SELECT firstName, lastName, city, state
FROM Person P
LEFT JOIN Address A
    ON P.personId = A.personId
;

-- @lc code=end

