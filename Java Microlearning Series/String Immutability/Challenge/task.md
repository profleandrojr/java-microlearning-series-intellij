## Challenge — Immutability in Practice

**Goal:** Fix the code so the final output matches the expected message.

The program currently tries to change a `String`, but the change does **not** work.

---

### What to do
- Make the code print:

Hello... Duke! Not a Dog! But a Codecepticon!!!

---

### Rules
- You must respect String immutability.
- Do **not** change the print statement.
- Do **not** create a new variable just to store the final message.
- Use the value returned by String methods correctly.

---

### Hint
Some `String` methods return a **new object**.  
If you ignore the return value, nothing changes.