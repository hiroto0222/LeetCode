--
-- @lc app=leetcode id=182 lang=mysql
--
-- [182] Duplicate Emails
--

-- @lc code=start
# Write your MySQL query statement below
SELECT Email
FROM Person
group by Email
HAVING count(Email) > 1
;

-- @lc code=end

