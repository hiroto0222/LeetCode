--
-- @lc app=leetcode id=607 lang=mysql
--
-- [607] Sales Person
--

-- @lc code=start
# Write your MySQL query statement below
# report names of all salesperons who did not have any orders related to company with name "RED"
# create temp table with only RED, then NOT IN

SELECT a.name
FROM salesperson a
WHERE a.sales_id NOT IN
    (
        SELECT b.sales_id FROM orders b
        INNER JOIN company c
        ON c.com_id = b.com_id
        WHERE c.name = 'RED'
    );

-- @lc code=end

