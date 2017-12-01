module ExprShallow where

type Expr = Int

(+!) :: Expr -> Expr -> Expr
a +! b = a + b -- replace 0 with correct expression

(*!) :: Expr -> Expr -> Expr
a *! b = a * b

inc :: Expr -> Expr
inc a = a + 1

-- add the missing functions to correctly execute the main

-- main::IO()
-- main = do
--   print ((inc 3)*!(3+!4))
