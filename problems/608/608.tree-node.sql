--
-- @lc app=leetcode id=608 lang=mysql
--
-- [608] Tree Node
--

-- @lc code=start
# Write your MySQL query statement below

-- 1. if p_id is NULL then 'Root'
-- 2. if id in p_id then 'Inner'
-- 3. else 'Leaf'

SELECT id,
  CASE
    WHEN p_id IS NULL
      THEN 'Root'
    WHEN id IN (SELECT p_id FROM tree WHERE p_id IS NOT NULL)
      THEN 'Inner'
    ELSE 'Leaf'
  END AS type
FROM tree;

-- @lc code=end

