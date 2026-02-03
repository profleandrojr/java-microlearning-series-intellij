## Try It — String Immutability (Output)

**Goal:** Change the program output from  
`Hello, World`  
to  
`Hello... Duke! Not a Dog! But a Codecepticon`

---

### What to do
1. Run the program and observe the initial output.
2. Modify the code so the final printed message is exactly:

Hello... Duke! Not a Dog! But a Codecepticon

---

### Important rules
- Do **not** mutate the original `String` object.
- Use the value returned by `substring()` and string concatenation.
- The change must happen by **reassigning the reference**.
- Do **not** print anything other than the final message.

---

### Key idea
In Java, `String` objects are immutable.

Methods like `substring()` and the `+` operator **create new String objects**.
What changes is **where the variable points**, not the original object.