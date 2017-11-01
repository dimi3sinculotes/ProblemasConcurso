# This is the logic behind the problem:

So, you have N different coins, and the machine can handle only M coins, and you need to tell how many different prices can
the mayor set on the machines.

- Well, something what comes in mind pretty quickly is, can the price be 0cents? it seems it can not be.
- You don't need to use ALL the coins at the same time, but this is easier to handle if you think you do, and imagine a 0 cents coin append your N list.
- The order obviously doesn't matter, 1+2 = 2+1.
- So it is, a combinatory, with repetitions (you can insert few coins of the same kind), without permutation, and with the 0 coin jocker. Which is:
| (n + m - 1)! / ((n - 1)! * m!) but ading the 0 coin => (n + m)! / ((n - 1)! * m + 1!)|

But i don't actually do that, since we need to think of the "repeated" cases, i mean for instants 1+1 = 2, but if you already have a 2cents coin, this makes no new case, so we need to have controll over this. Try it yourself and check out my code! :D

