# String Immutability (But… something does change)

In Java, **Strings are immutable**: once a `String` object is created, its content **never changes**.

So why does it *look* like we can “change a String”?

Because what changes is usually the **reference** (the variable), not the **object**.

---

## The mental model

- A **String object** is a value stored somewhere in memory.
- A **variable** (like `greeting`) is a *reference* that points to an object.
- Methods like `substring()`, `concat()`, and the `+` operator **create new String objects**.
- When you assign the result back to the variable, you are making the variable **point to a new object**.

> **Reference change ≠ Object change**

---

## Why Java designed Strings this way

Immutability gives you:

- **Predictability** (no hidden side effects)
- **Thread-safety** (safe sharing between threads)
- Better support for **caching** and **string pooling**
- More secure handling for data like passwords and keys (the object can’t be altered)

---

## What about garbage collection?

After you reassign a variable to a new String, the old object may become **unreachable**.

If there are **no references** pointing to it anymore, it becomes **eligible for garbage collection**.

*(Eligible ≠ collected immediately — the GC decides when.)*

---

## Next
In the next tasks, you will:
1) observe this behavior in code
2) fix common beginner mistakes
3) validate your understanding with a short quiz

--- 

### 📘 Want to go deeper?

This microlecture is part of a broader learning experience.

If you want access to:
- complementary explanations
- visual summaries
- additional exercises
- discussion and updates for this series

👉 Join the **Google Classroom** for this project:

🔗 https://classroom.google.com/c/NzkyMjk0NjAxNTk0?cjc=c43zrwbo

    Classroom Code (Codecepticons):

        c43zrwbo

Participation is optional and completely free.