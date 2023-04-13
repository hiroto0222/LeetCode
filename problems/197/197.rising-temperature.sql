--
-- @lc app=leetcode id=197 lang=mysql
--
-- [197] Rising Temperature
--

-- @lc code=start
# Write your MySQL query statement below
# find all date Id with higher temps compared to prev date

SELECT a.id
FROM weather a
INNER JOIN weather b
ON DATEDIFF(a.recordDate, b.recordDate) = 1
    AND a.temperature > b.temperature;

-- @lc code=end

